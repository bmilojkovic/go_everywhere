function logMeIn(fb_id, name, email) {
				$.ajax({
					type: 'POST',
					url: 'https://localhost/ge_backend/user/user_login.php',
					data: {
					fb_id : fb_id,
					provided_name : name,
					provided_email : email
					},
					success: function(data) {
						console.log('Logged in ' + data);
						printProfile();
					},
					error: function(jqXHR, text, error) {
						console.log('error in ajax: ' + text + " " + error);
					} 
				});
				
			}
			
function printProfile() {
	$.ajax({
		type: 'GET',
		url: 'https://localhost/ge_backend/user/get_my_profile.php',
		success: function(data) {
			$("#fb-welcome").html(data);
		},
		error: function(jqXHR, text, error) {
			console.log('error in ajax: ' + text + " " + error);
		} 
	});
}
			
function sendChat() {
	chatText = $("#chat-line").val();
	//console.log(chatText);
	if (chatText !== "") {
		$.ajax({
			type: "POST",
			url: "https://localhost/ge_backend/chat/chat_action.php",
			data: {
				action: 'add',
				chat_name: 'lobby',
				text: chatText
			},
			success: function(data) {
				console.log('Added line');
			},
			error: function(jqXHR, text, error) {
				console.log('error in ajax: ' + text + " " + error);
			} 
		
		});
	}
} 			
			
function getChat() {
	//time = Math.floor(Date.now()) - 1000;
	
	$.ajax({
		type: "POST",
		url: "https://localhost/ge_backend/chat/chat_action.php",
		data: {
			action: 'get_chat',
			chat_name: 'lobby'
		},
		success: function(data){
			if (data !== "null") {						
				$(".chatWrapper").append("<div class='friendMsg'>"+ data +"</div>");  
			}
			//console.log(data);
		},
		error: function(jqXHR, text, error) {
			console.log('error in ajax: ' + text + " " + error);
		} 
	})
}

setInterval(getChat, 1000);


function acceptGame(game_id,acceptor_id) {
				$.ajax({
					type: 'POST',
					url: 'https://localhost/ge_backend/game/game_starter.php',
					data: {
					game_id : game_id,
					acceptor_id : acceptor_id
					},
					success: function(data) {
						$("#"+game_id).parent().parent().remove();
						alert("game accepted "+data)
					},
					error: function(jqXHR, text, error) {
						alert('error in ajax: ' + text + " " + error);
					} 
				});
				
			}
	
function createGame(){
	gameName=$("#name").val();
	boardSize=$("#size").val();
	challengeType=$("input[name='optradio']:checked").val();
	if(challengeType=="friend")
	{
		challengedFriend=$("#challengeFriendList").val();
	}
	time=$("#time").val();
	periodTime=$("#periodTime").val();
	periods=$("#periods").val();
	if($('#rank').prop('checked'))
	{
		rank=$("#rank").val();
	}
	else{
		rank="";
	}
	rules=$("#rules").val();
	handicap=$("#handicap").val();
	komi=$("#komi").val();
	color=$("#color").val();
	if($('#restrict').prop('checked'))
	{
		minRestrict=$("#rank-min").val();
		maxRestrict=$("#rank-max").val();
	}
	else
	{
		minRestrict="";
		maxRestrict="";
	}
	if(time != "" && periodTime != "" && periods != "" && size != "" && komi !="")
	{
		$.ajax({
			type: "POST",
			url: "https://localhost/ge_backend/game/game_maker.php",
			data: {
				chat_room_id: 1,
				room_id: 1,
				player_black_id: 1,//fb_id
				name: gameName,
				type: rank,
				status: "n",
				time: time,
				periodTime: periodTime,
				periods: periods,
				board_width:boardSize,
				board_height:boardSize,
				handicap:handicap,
				komi:komi
			},
			success: function(data) {
				alert('New game created' + data );
			},
			error: function(jqXHR, text, error) {
				console.log('error in ajax: ' + text + " " + error);
			} 
		});
	}
	else
	{
		alert("All fields must be filled.");
	}
}

 $(document).ready(showGames(0));
function showGames(max_id) {

	$.ajax({
		type: 'POST',
		url: 'https://localhost/ge_backend/game/showNewGame.php',
		data: {
		fb_id : 2, 
		max_id:max_id
		},
		success: function(data) {
			//$("#rank_tbody").html(data);
			var obj = JSON.parse(data);
			for(i=0; i<obj.results.length; i++)
			{
				
			
				var tr = $('<tr></tr>');
				tr.append("<td><button id='"+obj.results[i].id+"' onclick = 'acceptGame(this.id, 2)'class='acceptGameBtn'>Accept</button></td>");
				tr.append("<td>"+obj.results[i].name+"</td>");
				tr.append("<td>"+obj.results[i].player_name+"("+obj.results[i].go_rank+")"+"</td>");
			
				tr.append("<td>"+obj.results[i].type+"</td>");
				tr.append("<td>"+obj.results[i].board_width+"x"+obj.results[i].board_height+"</td>");
				
				tr.append("<td>"+obj.results[i].time_rules+"</td>");
				tr.append("<td>"+obj.results[i].handicap+"</td>");
				$("#rank_tbody").append(tr);
			}
			setTimeout(function (){showGames(obj.max_id);},1000);
		},
		error: function(jqXHR, text, error) {
			alert('error in ajax: ' + text + " " + error);
		} 
	});
	
}


