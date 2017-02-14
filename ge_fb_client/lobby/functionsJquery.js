
$(document).ready(function () {
    $(".playbtn").click(function () {
         $(".createGame").show();
    });
});
			
$(document).ready(function () {
	$("#close-modal").click(function () {
		$(".createGame").hide();
	});
 });
			 
 $(document).ready(function () {
	$("#modal-closeX").click(function () {
		$(".createGame").hide();
	});
 });
 
 $(document).ready(function () {
	$("#challengeFriendRadio").click(function () {
		$("#challengeFriendList").show();
	});
 });
 
  $(document).ready(function () {
	$("#openChallengeRadio").click(function () {
		$("#challengeFriendList").hide();
	});
 });
 
 $(document).ready(function () {
	 $("#openChallengeRadio").click(function (){
		 $("#challengeFriendList").hide();
	 });	 
 });
//not working
 $(document).ready(function () {
	$("#challengeFriendList").autocomplete({
		//source: "friendList.php"
		source: [
				"maca",
				"martina"
		]
	});
	
 });
 
$(function () {
	$("#ge_nav").load("navbar.html");
});

