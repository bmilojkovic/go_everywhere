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
					url: 'https://localhost/ge_backend/game/game_maker.php',
					data: {
					game_id : game_id,
					acceptor_id : acceptor_id
					},
					success: function(data) {
						alert('Game accepted'+data);
						
					},
					error: function(jqXHR, text, error) {
						alert('error in ajax: ' + text + " " + error);
					} 
				});
				
			}
			