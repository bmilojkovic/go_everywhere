<?php

include 'db.inc';

class GE_User {

	private $ge_id;
	private $display_name;
	
	private $fb_id;
	private $email;
	
	public function __construct($fb_id, $provided_name, $provided_email, $ge_db_link) {
		$this->fb_id = $fb_id;
		
		$get_user_q = "SELECT id,display_name,email FROM user WHERE facebook_id=?";
		if (!($statement = $ge_db_link->prepare($get_user_q))) {
			echo "SELECT failed: " . $ge_db_link->error;
		}
		$statement->bind_param("i", $fb_id);
		if (!$statement->execute()) {
			echo "Failed in execute SELECT: " . $ge_db_link->error;
		}
		$statement->bind_result($my_id, $my_display_name, $my_email);
		
		if ($statement->fetch()) { //found user in DB -> populate with values from there
			$this->ge_id = $my_id;
			$this->display_name = $my_display_name;
			$this->email = $my_email;
		} else { //user was not in DB -> add him, and use provided values
			$add_user_q = "INSERT INTO user (facebook_id, display_name, email) VALUES (?,?,?)";
			if (!($statement = $ge_db_link->prepare($add_user_q))) {
				echo "INSERT failed: " . $ge_db_link->error;
			}
			$statement->bind_param("iss", $fb_id, $provided_name, $provided_email);
			
			if (!$statement->execute()) {
				die("Could not add user to DB. Aborting.");
			}
			
			$this->ge_id = $ge_db_link->insert_id;
			$this->display_name = $provided_name;
			$this->email = $provided_email;
		}
	}
	
	public function get_ge_id() {
		return $this->ge_id;
	}
	
	public function to_json() {
		return json_encode(get_object_vars($this));
	}
	
}

?>