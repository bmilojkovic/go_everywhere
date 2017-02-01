<?php
session_start();

include 'db.inc';
include 'user.inc';

$fb_id = $_REQUEST['fb_id'];
$provided_name = $_REQUEST['provided_name'];
$provided_email = $_REQUEST['provided_email'];

if (!isset($_SESSION['user'])) {
	$_SESSION['user'] = serialize(new GE_User($fb_id, $provided_name, $provided_email, $ge_db_link));	
}

?>