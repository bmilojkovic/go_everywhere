<?php
	session_start();

	include '../db.inc';
	include 'game.inc';
	
	$id = isset($_REQUEST['game_id']) && $_REQUEST['game_id'] != "" ? $_REQUEST['game_id'] : null;
	$player_white_id = isset($_REQUEST['acceptor_id']) && $_REQUEST['acceptor_id'] != "" ? $_REQUEST['acceptor_id'] : null;
	
	if($id != null && $player_white_id != null)
	{
		$game = new GE_new_game();		
		$game->startNewGame($id, $player_white_id, $db_link);
		
		echo "success!";
	}
		
?>