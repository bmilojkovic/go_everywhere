<?php
session_start();

if (!isset($_SESSION['user'])) {
	die("User is not logged in? Aborting.");
}

echo $_SESSION['user']->to_json();

?>