<?php
session_start();
//session_destroy(); use this to test user registration

include 'db.inc';
include 'user.inc';

$fb_id = $_POST['fb_id'];
$provided_name = $_POST['provided_name'];
$provided_email = $_POST['provided_email'];

if (!isset($_SESSION['user'])) {
	$_SESSION['user'] = new GE_User($fb_id, $provided_name, $provided_email, $ge_db_link);	
}

echo $_SESSION['user']->get_ge_id();

?>