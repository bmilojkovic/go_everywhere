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
	
	public static function start_new_game($id, $player_white_id, $db_link)
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
	
	public static function create_new_game($chat_room_id,$room_id,$player_black_id,$name,$type,$status,$time_rules, $board_width, $board_height, $handicap, $komi,$db_link)
	{
		$check_q='INSERT INTO game (chat_room_id,room_id,player_black_id,name,type,status,time_rules, board_width, board_height, handicap, komi) values (?,?,?,?,?,?,?,?,?,?,?)';
		
		($check_st = $db_link->prepare($check_q)) or die("Prepare INSERT failed: " . $db_link->error);
		
		$check_st->bind_param("iiissssiiid",$chat_room_id,$room_id,$player_black_id,$name,$type,$status,$time_rules, $board_width, $board_height, $handicap, $komi );
		$check_st->execute() or die("Execute INSERT failed: " . $db_link->error);
		
		return true;
	}
	
	public static function show_new_game($fb_id, $db_link,$max_id)
	{
		
		$num_rows_zero=false;
		$check_q='SELECT g.id,g.player_black_id,g.name,g.type,g.board_width, g.board_height,g.time_rules,g.handicap, p.go_rank, p.name FROM game g, player p WHERE g.status="n" and g.player_black_id=p.id and g.id > ? order by g.id asc ';	
		($check_st = $db_link->prepare($check_q)) or die("Prepare SELECT failed: " . $db_link->error);

		$check_st->bind_param("i", $max_id);
		
		$check_st->execute() or die("Execute SELECT failed: " . $db_link->error);

		$check_st->store_result();
		$check_st->bind_result($id,$player_black_id,$name,$type,$board_width, $board_height,$time_rules,$handicap,$go_rank,$player_name);
		
		$results=array();
		if($check_st->num_rows==0)
		{
			$num_rows_zero=true;
		}
		while($check_st->fetch())
		{
			$results[]=array("id"=>$id,"name"=>$name,"player_name"=>$player_name,"go_rank"=>$go_rank,"type"=>$type,"board_width"=>$board_width, "board_height"=>$board_height, "time_rules"=>$time_rules,"handicap"=>$handicap);

		}
		$wrapper=array();
		$wrapper["results"]=$results;
		
		if($num_rows_zero)
		{
			$wrapper['max_id']=$max_id;
		}
		else
		{
			$wrapper["max_id"]=$id;
		}
		echo json_encode($wrapper);
	}
}
	