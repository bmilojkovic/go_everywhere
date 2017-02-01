<?php
session_start();

include 'user.inc';

if (!isset($_SESSION['user'])) {
	die("User is not logged in? Aborting.");
}

$my_profile = unserialize($_SESSION['user']);
echo json_encode($my_profile);

?>