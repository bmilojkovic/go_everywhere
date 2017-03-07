<?php
	session_start();

	include '../db.inc';
	include 'game.inc';
	include '../chat/chat_room.inc';
	
	$time = isset($_REQUEST['time']) && $_REQUEST['time'] !='' ? $_REQUEST['time'] : null;
	$periodTime = isset($_REQUEST['periodTime']) && $_REQUEST['periodTime'] !='' ? $_REQUEST['periodTime'] : null;
	$periods = isset($_REQUEST['periods']) && $_REQUEST['periods'] !='' ? $_REQUEST['periods'] : null;
	if($time != null && $periodTime != null && $periods != null)
	{
		$time_rules = "BY | " . $time . " | " . $periods . " X " . $periodTime;
	}
	else{
		$time_rules= null;
	}
	
	
	$room_id=isset($_REQUEST['room_id']) && $_REQUEST['room_id'] !='' ? $_REQUEST['room_id'] : null;

	$player_black_id=isset($_REQUEST['player_black_id']) && $_REQUEST['player_black_id'] !='' ? $_REQUEST['player_black_id'] : null;

	$name=isset($_REQUEST['name']) && $_REQUEST['name'] !='' ? $_REQUEST['name'] : null;
	$type=isset($_REQUEST['type']) && $_REQUEST['type'] !='' ? $_REQUEST['type'] : null;
	$status=isset($_REQUEST['status']) && $_REQUEST['status'] !='' ? $_REQUEST['status'] : null;
	

	$board_width=isset($_REQUEST['board_width']) && $_REQUEST['board_width'] !='' ? $_REQUEST['board_width'] : null;
	$board_height=isset($_REQUEST['board_height']) && $_REQUEST['board_height'] !='' ? $_REQUEST['board_height'] : null;

	$handicap=isset($_REQUEST['handicap']) && $_REQUEST['handicap'] !='' ? $_REQUEST['handicap'] : null;
	$komi=isset($_REQUEST['komi']) && $_REQUEST['komi'] !='' ? $_REQUEST['komi'] : null;
	
	var_dump($time,$periodTime,$periods,$room_id,$player_black_id,$name,$type,$status,$board_width,$handicap,$komi);

	if( $room_id != null && $player_black_id != null && $type != null && $status != null && $time_rules != null && $board_height != null && $board_width != null && $komi != null)
	{
		$game= new GE_new_game();
		
		//$chat_room= GE_Chat_Room::get_by_room_id($room_id,$db_link);
		$chat_room=GE_Chat_Room::register_chat_room($player_black_id.$name,$db_link);
		$chat_room_id=$chat_room;
		
		
		if($game->create_new_game($chat_room_id,$room_id,$player_black_id,$name,$type,$status,$time_rules, $board_width, $board_height, $handicap, $komi,$db_link))
		{
			echo "success";
		}
		else
		{
			echo "error!";
		}
		
		
	}
	
?>