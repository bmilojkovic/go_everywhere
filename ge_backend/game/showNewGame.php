<?php
	session_start();

	include '../db.inc';
	include 'game.inc';
	
	$max_id=isset($_REQUEST['max_id']) && $_REQUEST['max_id'] != "" ? $_REQUEST['max_id'] : null;
	$fb_id=isset($_REQUEST['fb_id']) && $_REQUEST['fb_id'] != "" ? $_REQUEST['fb_id'] : null;
	
	if($fb_id != null)
	{
		$game= new GE_new_game();
		$game->show_new_game($fb_id,$db_link,$max_id);
		
		
	}




?>