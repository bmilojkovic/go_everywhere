<?php
	if (!isset($ge_db_link)) {	
		$db_server = "localhost";
		$db_user = "bane";
		$db_pass = "bane123";	
		$db_name = "go_everywhere_site";
		
		$ge_db_link = mysqli_connect($db_server, $db_user, $db_pass, $db_name);
		
		if ($ge_db_link->connect_error) {
			die('Connection to DB failed. Aborting. ' . $ge_db_link->connect_error);
		}
	}
?>