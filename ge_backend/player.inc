<?php

class GE_Player implements JsonSerializable {
	
	private $ge_player_id;
	private $name;
	private $rank;
	private $domain;
	private $user;
	
	public function __construct() {
		
	}
	
	public static function make_player($ge_player_id, $name, $rank, $domain, $user) {
		$instance = new self();		
		
		$instance->make($ge_player_id, $name, $rank, $domain, $user);
		
		return $instance;
	} 	
	
	public static function make_new_player($name, $rank, $domain, $user, $ge_db_link) {
		$instance = new self();
		
		$instance->make_new($name, $rank, $domain, $user, $ge_db_link);
		
		return $instance;
	}
	
	private function make($ge_player_id, $name, $rank, $domain, $user) {
		$this->ge_player_id = $ge_player_id;
		$this->name = $name;
		$this->rank = $rank;
		$this->domain = $domain;
		$this->user = $user;
	}
	
	private function make_new($name, $rank, $domain, $user, $ge_db_link) {
		$check_q = "SELECT id FROM player WHERE domain=? AND user_id=?";
		($check_st = $ge_db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $ge_db_link->error);
		$user_id = $user->get_ge_user_id();
		$check_st->bind_param("si", $domain, $user_id);
		$check_st->execute() or die("Execute SELECT failed: " . $ge_db_link->error);	
		
		if ($check_st->fetch()) {
			die("There already is a player for this user in this domain. Abort.");
		}		
		
		$this->name = $name;
		$this->rank = $rank;
		$this->domain = $domain;
		$this->user = $user;
		
		$check_st->close();		
		
		$add_player_q = "INSERT INTO player (user_id,name,go_rank,domain) VALUES(?,?,?,?)";
		($add_st = $ge_db_link->prepare($add_player_q)) or die("Prepare INSERT failed: " . $ge_db_link->error);
		$add_st->bind_param("isss", $user_id, $name, $rank, $domain);
		
		$add_st->execute() or die("Execute INSERT failed: " . $ge_db_link->error);
		
		$add_st->close();
	}
	
	public function get_domain() {
		return $this->domain;
	}
	
	public function get_name() {
		return $this->name;
	}
	
	public function jsonSerialize() {
		//gotta do this manually to avoid recursion :(
		return [
			'player' => [
				'ge_player_id' => $this->ge_player_id,
				'name' => $this->name,
				'rank' => $this->rank,
				'domain' => $this->domain
			]
		];
	}
}

?>