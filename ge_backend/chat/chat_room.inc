<?php

class GE_Chat_Room {
	
	private $id;
	private $name;
	
	private function __construct() {
	}
	
	public static function get_by_id($id, $db_link) { //use a cache here
		$check_q = "SELECT name FROM chat_room WHERE id=?";
		($check_st = $db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$check_st->bind_param("s", $id);
		$check_st->execute() or die("Execute SELECT failed: " . $db_link->error);	
		
		$check_st->bind_result($got_name);
		if ($check_st->fetch()) {
			$instance->id = $id;
			$instance->name = $got_name;
			
			return $instance;
		}
		
		return NULL;
	}
	
	public static function get_by_name($name, $db_link) { //use a cache here
		$check_q = "SELECT id FROM chat_room WHERE name=?";
		($check_st = $db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$check_st->bind_param("s", $name);
		$check_st->execute() or die("Execute SELECT failed: " . $db_link->error);	
		
		$check_st->bind_result($got_id);
		if ($check_st->fetch()) {
			$instance = new GE_Chat_Room();			
			
			$instance->id = $got_id;
			$instance->name = $name;
			
			return $instance;
		}
		
		return NULL;
	}
	
	public static function register_chat_room($name, $db_link) {
		$check_q = "SELECT id FROM chat_room WHERE name=?";
		($check_st = $db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$check_st->bind_param("s", $name);
		$check_st->execute() or die("Execute SELECT failed: " . $db_link->error);	
		
		if ($check_st->fetch()) {
			echo "There already is a chat room with this name. Abort.";
			return false;
		}		
		
		$this->name = $name;
		
		$check_st->close();		
		
		//first add chattable entity
		$add_room_q = "INSERT INTO chat_room (name) VALUES(?)";
		($add_st = $db_link->prepare($add_room_q)) or die("Prepare INSERT failed: " . $db_link->error);
		$add_st->bind_param("s", $name);
		
		$add_st->execute() or die("Execute INSERT failed: " . $db_link->error);
		
		$add_st->close();
		
		return true;
	}
	
	public function add_line($text, $db_link) {
		$add_line_q = "INSERT INTO chat_line (chat_room_id, line_datetime, text) VALUES(?,?,?)";
		($add_st = $db_link->prepare($add_line_q)) or die("Prepare INSERT failed: " . $db_link->error);
		$mysql_now = date("Y-m-d H:i:s", time());
		$add_st->bind_param("iss", $this->id, $mysql_now, $text);
		$add_st->execute() or die("Execute INSERT failed: " . $db_link->error);
		
		$add_st->close();
	}
	
	/* deprecated
	public function get_chat($start_ts, $db_link) {
		$mysql_ts = date("Y-m-d H:i:s", $start_ts);
		
		$get_lines_q = "SELECT line_datetime,text FROM chat_line WHERE chat_room_id=? AND line_datetime > ?";
		($get_lines_st = $db_link->prepare($get_lines_q)) or die("Prepare SELECT failed: " . $db_link->error);
		$get_lines_st->bind_param("is", $this->id, $mysql_ts);
		
		$get_lines_st->execute() or die("Execute SELECT failed: " . $db_link->error);
		
		$get_lines_st->bind_result($timestamp,$line);
		
		$result = NULL;
		while ($get_lines_st->fetch()) {
			$result[$timestamp] = $line;
		}
		
		return $result;
	} */
	
	public function get_from_to($start_ts, $end_ts, $db_link) {
		$get_lines_q = "SELECT line_datetime,text FROM chat_line WHERE chat_room_id=? AND line_datetime > ? AND line_datetime <= ?";
		($get_lines_st = $db_link->prepare($get_lines_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$mysql_start_ts = date("Y-m-d H:i:s", $start_ts);
		$mysql_end_ts = date("Y-m-d H:i:s", $end_ts);
		
		$get_lines_st->bind_param("iss", $this->id, $mysql_start_ts, $mysql_end_ts);
		
		$get_lines_st->execute() or die("Execute SELECT failed: " . $db_link->error);
		
		$get_lines_st->bind_result($timestamp,$line);
		
		$result = NULL;
		while ($get_lines_st->fetch()) {
			$result[$timestamp] = $line;
		}
		
		return $result;
	}
}

?>