<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <link
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
            rel="stylesheet">
        <link href="style.css" rel="stylesheet" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.0/bootstrap-table.min.js"></script>
		<script src="../js/jquery-ui.min.js"></script>
		<script src="functions.js"></script>
		<script src="functionsJquery.js"></script>
   

    </head>
    <body>
		<script>
			logMeIn(1, "Name", "email@site.com");
		</script>
		
        <nav class="navbar navbar-inverse" id="ge_nav">
		<?php
			include '../profile/navbar.php';
		?>
		</nav>
        <!--CHATTTT-->
        <div class="container-fluid text-center">
            <div class="row content">
                <div class="col-xs-12 col-sm-4 sidenav" id="chat">
                    <div class="chatWrapper">
                     
					 
                    </div>
                    <div class="form-inline">
                    
                            <input
                                autocomplete="off"
                                class="form-control"
                                id="chat-line"
                                placeholder="Say something.."
                                type="text">

                            <button class="btn btn-default" onclick="sendChat();" type="submit">Send!</button>
                        
                    </div>
                </div>
                <div class="col-xs-12 col-sm-8 text-left meta_div">
			
				
                    <table
                        class="rank_table"
                        data-sort-name="stargazers_count"
                        data-sort-order="desc"
                        data-toggle="table"
                        data-url="x"
                        width="400px">
                        <thead>
                            <tr>
                                <th data-field="Accept" data-sortable="false"></th>
                                <th data-field="Name" data-sortable="false">
                                    Name
                                </th>
                                <th data-field="Player" data-sortable="false">
                                    Player(rank)
                                </th>
                                <th data-field="Ranked" data-sortable="true">
                                    Ranked
                                    <span class="caret"></span>
                                </th>
                                <th data-field="Size" data-sortable="true">
                                    Size<span class="caret"></span>
                                </th>
                                <th data-field="Time" data-sortable="true">
                                    Time
                                </th>
                                <th data-field="Handicap" data-sortable="true">
                                    Handicap
                                </th>
                            </tr>
                        </thead>
                        <tbody id="rank_tbody">
              

                          
                        </tbody>
                    </table>
                    <input class="playbtn" type="button" value="Create a game!">
					<!-- FRIEND SLIDER -->
					
                    <div class="row friendlist_row">
                        <div class="col-sm-12" id="friendlist">
                            <div class="carousel slide" data-interval="false" id="myCarousel">

                                <!-- Wrapper for slides -->
                                <div class="carousel-inner" role="listbox">
                                    <div class="item active">
                                        <!--POCETNI ISPIS PRIJATELJA-->
                                        <div class="friendlist">

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika2.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <button class="inviteBtn" onclick="invite()" style="vertical-align:middle">
                                                <span>Invite!</span>
                                            </button>

                                        </div>
                                    </div>

                                    <div class="item">
                                        <!-- NAKON SLAJDA ISPIS, UZIMACE SE NOVI PODACI IZ BAZE IDT.-->
                                        <div class="friendlist">

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika2.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <div class="friend">
                                                <p id="friendName">Martina J</p>
                                                <img id="friendPic" src="slika.jpg">
                                                <div class="ch">
                                                    <p id="friendXP">360xp</p>
                                                    <input
                                                        id="challengeBtn"
                                                        onclick="friendChallenge()"
                                                        type="button"
                                                        value="Challenge!">
                                                </div>
                                            </div>

                                            <button class="inviteBtn" onclick="invite()" style="vertical-align:middle">
                                                <span>Invite!</span>
                                            </button>

                                        </div>
                                    </div>

                                    <!--ispisivace se ovakvi div-ovi preko javascript funkcije
	 
											<div class="item"> 
											</div>
    
									-->

                                    <!-- Left and right controls -->
                                    <a
                                        class="left carousel-control"
                                        data-slide="prev"
                                        href="#myCarousel"
                                        role="button">
                                        <span aria-hidden="true" class="glyphicon glyphicon-chevron-left"></span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                    <a
                                        class="right carousel-control"
                                        data-slide="next"
                                        href="#myCarousel"
                                        role="button">
                                        <span aria-hidden="true" class="glyphicon glyphicon-chevron-right"></span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </div>

                            </div>
                        </div>

                    </div>
                </div>
				<!-- MODAL FOR CREATING GAME -->
                <div class="createGame">
                    <div class="modal-header">
                        <button class="close" id="modal-closeX" type="button">&times;</button>
                        <h4 class="modal-title">New game</h4>
                    </div>
					<!-- left pane -->
                    <div class="modal-left-pane">
					
                            <div class="form-inline">
                                <label for="name">Name:</label>
                                <input
                                    class="form-control"
                                    id="name"
                                    placeholder="Name your game..."
                                    type="name">
                            </div>
                            <div class="form-inline">
                                <label for="size">Size:</label>
                                <select class="form-control" id="size">
                                    <option value='9' >9x9</option>
                                    <option value= '13'>13x13</option>
                                    <option value='19'>19x19</option>
                                </select>
                            </div>
                            <br>
                            <div class="radio">
                                <label><input name="optradio" value="open" id="openChallengeRadio" type="radio">Open challenge</label>
                            </div>
                            <div class="radio">
                                <label><input name="optradio" value="friend" id="challengeFriendRadio" type="radio">Challenge friend</label>
							
                            </div>
							
								<input type="text" class="form-control" id="challengeFriendList" size="10">

                        </div>
                        <!--RIGHT-pane-->
                        <div class="modal-right-pane">
                            <h4>Time</h4>
                            <div class="form-inline">
                                <label for="maintime">Main time:</label>
                                <input
                                    class="form-control"
                                    id="time"
                                    placeholder="Choose game time..."
                                    type="time">
                            </div>

                            <div class="form-inline">
                                <label for="periodtime">Time per period:</label>
                                <input
                                    class="form-control"
                                    id="periodTime"
                                    placeholder="Choose period time.."
                                    type="time">
                            </div>

                            <div class="form-inline">
                                <label for="periods">Periods:</label>
                                <input class="form-control" id="periods" type="text">
                            </div>
                            <div class="checkbox">
                                <label><input type="checkbox" id="rank" value="r">Rank</label>
                            </div>
                        
                    </div>
					<!-- ADVANCED MODAL -->
					
                    <button data-target="#demo" data-toggle="collapse">Advanced</button>
                    <div class="collapse" id="demo">
                        <div class="modal-left-pane">
                           

                                <div class="form-inline">
                                    <label for="rules">Rules:</label>
                                    <select class="form-control" id="rules">
                                        <option value="aga">AGA</option>
                                        <option value="chinese">Chinese</option>
                                        <option value="ingSst">Ing SST</option>
                                        <option value="newZealand">New Zealand</option>
                                        <option value="korean">Korean</option>
                                    </select>
                                </div>
                                <div class="form-inline">
                                    <label for="handicap">Handicap</label>
                                    <input class="form-control" id="handicap" type="number">
                                </div>
                                <div class="form-inline">
                                    <label for="komi">Komi</label>
                                    <input class="form-control" id="komi" type="number">
                                </div>

                            </div>
                            <!--RIGHT pane -->
                            <div class="modal-right-pane">
                                <div class="form-inline">
                                    <label for="color">Color:</label>
                                    <select class="form-control" id="color">

                                        <option value="black">Black</option>
                                        <option value="white">White</option>
                                       

                                    </select>
                                </div>

                                
								<div class="checkbox">
									<label><input type="checkbox" id="restrict" value="restrict" onchange="showRankRestrict()">Rank restrict</label>
								</div>
                                <div class="form-inline">
                                    <label for="rank-min" id="min-label">Minimum ranking:</label>
                                    <select class="form-control" id="rank-min">

                                        <option value="">30 Kya</option>

                                    </select>
                                </div>
                                <div class="form-inline">
                                    <label for="rank-max" id="max-label">Maximum ranking:</label>
                                    <select class="form-control" id="rank-max">

                                        <option value="">30 Kya</option>

                                    </select>
                                </div>

                          

                        </div>
                    </div>

                    <div class="modal-footer">
                        <button class="btn btn-default" id="close-modal"  type="button">Close</button>

                        <button class="btn btn-default" onclick="createGame();" type="submit">New game!</button>
                    </div>

                </div>

            </body>
        </html>