
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

 $(document).ready(function () {
	$("#challengeFriendList").autocomplete({
		//source: "friendList.php"
		source: [
				"maca",
				"martina"
		]
	});
	
 });
 
function showRankRestrict() {
	if($("#restrict").prop("checked"))
	{
		$("#min-label").show();
		$("#max-label").show();
		$("#rank-min").show();
		$("#rank-max").show();
	}
	else
	{
		
		$("#min-label").hide();
		$("#max-label").hide();
		$("#rank-min").hide();
		$("#rank-max").hide();
	}
}
