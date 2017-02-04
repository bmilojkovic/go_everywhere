<?php

include 'player.inc';

class GE_User implements JsonSerializable {

	private $id;
	private $display_name;
	
	private $fb_id;
	private $email;
	
	private $players;
	
	public function __construct($fb_id, $provided_name, $provided_email, $db_link) {
		$this->fb_id = $fb_id;
		
		$get_user_q = "SELECT id,display_name,email FROM user WHERE facebook_id=?";
		($statement = $db_link->prepare($get_user_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$statement->bind_param("i", $fb_id);
		$statement->execute() or die("Execute SELECT failed: " . $db_link->error);
		
		$statement->bind_result($my_id, $my_display_name, $my_email);
		
		$get_players = false;
		if ($statement->fetch()) { //found user in DB -> populate with values from there
			$this->id = $my_id;
			$this->display_name = $my_display_name;
			$this->email = $my_email;
			
			$get_players = true;
			
		} else { //user was not in DB -> add him, and use provided values
			$statement->close();		
				
			$add_user_q = "INSERT INTO user (facebook_id, display_name, email) VALUES (?,?,?)";
			($statement = $db_link->prepare($add_user_q)) or die("Prepare INSERT failed: " . $db_link->error);
			$statement->bind_param("iss", $fb_id, $provided_name, $provided_email);
			
			$statement->execute() or die("Execute INSERT failed:" . $ge_db_link->error);
			
			$this->id = $db_link->insert_id;
			$this->display_name = $provided_name;
			$this->email = $provided_email;
			
			//make new player profile for our domain
			$new_player = GE_Player::make_new_player($provided_name, null, "GOE", $this, $db_link);
			$this->players[$new_player->get_domain()] = $new_player;
		}
		
		$statement->close();
		if ($get_players) {
			$get_players_q = "SELECT p.id, p.name, p.go_rank, p.domain
									FROM player AS p 
									JOIN user AS u
									ON p.user_id=u.id
									WHERE u.id=?";
			
			($players_statement = $db_link->prepare($get_players_q)) or die("Prepare JOIN failed: " . $db_link->error);
			$players_statement->bind_param("i", $my_id);
			
			$players_statement->execute() or die("Execute JOIN failed: " . $db_link->error);
			$players_statement->bind_result($player_id, $player_name, $player_rank, $player_domain);
						
			while($players_statement->fetch()) {
				
				$new_player = GE_Player::make_player($player_id, $player_name, $player_rank, $player_domain, $this);
				$this->players[$player_domain] = $new_player;
			}
			
			//make new GOE profile if it is missing
		}
	}
	
	public function get_id() {
		return $this->id;
	}
	
	public function jsonSerialize() {
		$vars = get_object_vars($this);
		return $vars;
	}
	
}

?>