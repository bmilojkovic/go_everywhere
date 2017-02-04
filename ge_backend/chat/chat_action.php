<?php
session_start();

include '../db.inc';
include 'chat_room.inc';

if (!isset($_SESSION['last_chat_get'])) {
	$_SESSION['last_chat_get'] = time();
}
$chat_name = $_REQUEST['chat_name'];
$chat_room = GE_Chat_Room::get_by_name($chat_name, $db_link);

$chat_action = $_REQUEST['action'];

switch ($chat_action) {
	/*case "register":
		GE_Chat_Room::register_chat_room($chat_name, $db_link);
		
		break;*/
	case "add":
		$text = $_REQUEST['text'];
		
		$chat_room->add_line($text, $db_link);
		
		break;
	case "get_chat":
		$start_ts = $_SESSION['last_chat_get'];	
		
		$now = time();
		
		$lines = $chat_room->get_from_to($start_ts, $now, $db_link);
		
		if ($lines != NULL) {
			$_SESSION['last_chat_get'] = time();
		}
		echo json_encode($lines);
		
		break;
	
}

?>