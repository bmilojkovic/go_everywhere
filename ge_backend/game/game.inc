<?php

class GE_new_game
{
	private $id;
	private $chat_room_id;
	private $room_id;
	
	private	$player_white_id;
	private $player_black_id;
	
	private $name;
	private $type;
	private $status;
	private $time_rules;
	
	private $board_width;
	private $board_height;
	
	private $handicap;
	private $komi;
	private $result;
	private $moves;
	
	public function __construct() 
	{
	}
	
	public static function startNewGame($id, $player_white_id, $db_link)
	{
		$check_q = "SELECT status FROM game WHERE id=?";
		($check_st = $db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $db_link->error);
		
		$check_st->bind_param("i", $id);
		$check_st->execute() or die("Execute SELECT failed: " . $db_link->error);
		
		
		$check_st->store_result();
		$check_st->bind_result($status);
		if($check_st->num_rows == 1)
		{
			if($check_st->fetch())
			{
				if($status == "n")
				{
					$check_q = "UPDATE game SET status = ?, player_white_id = ? WHERE id = ?";
					($check_st = $db_link->prepare($check_q)) or die("Prepare UPDATE failed: " . $db_link->error);
					
					$check_st->bind_param("sii", $status = "s", $player_white_id, $id);
					$check_st->execute() or die("Execute UPDATE failed: " . $db_link->error);
					
					return true;
				}
			}
		}
		
		return false;
	}
}