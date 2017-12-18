package model.game;

import org.json.JSONObject;

import model.ogs.game.OGSGame;
import model.ogs.game.challenges.OGSChallenge;
import model.ogs.game.history.OGSGameHistory;

public class Game {

	private Related related;
	private GamePlayers players;
	private String id;
	private String name;
	private String creator;
	private String mode;
	private String source;
	private String black;
	private String white;
	private int width;
	private int height;
	private String rules;
	private boolean ranked;
	private int handicap;
	private String komi; //TODO: documentation says string ?
	private String time_control;
	private long time_per_move;
	private TimeControlParameters time_control_parameters;
	private boolean disable_analysis;
	private String tournament; //TODO: string or number ?
	private int tournament_round;
	private String ladder;//TODO: string or number ?
	private boolean pause_on_weekends;
	private String outcome;
	private boolean black_lost;
	private boolean white_lost;
	private boolean annulled;
	private String started;
	private String ended;
	
	
	public Game(OGSChallenge challenge){
		
		time_per_move = challenge.getTimePerMove().longValue();
		creator = challenge.getUsername();
		id = challenge.getGameId().toString();
		width = challenge.getWidth();
		handicap = challenge.getHandicap();
		name = challenge.getName();
		disable_analysis = challenge.getDisableAnalysis();
		height = challenge.getHeight();
		rules = challenge.getRules();
		time_control = challenge.getTimeControl();
		ranked = challenge.getRanked();
		komi = challenge.getKomi();
		time_control_parameters.setTime_control(challenge.getTimeControlParameters().getTimeControl());
		this.pause_on_weekends = challenge.getTimeControlParameters().getPauseOnWeekends();
		
	}
	
	public Game(OGSGameHistory gameHistory){
		

		this.related = new Related();
		this.players = new GamePlayers();
		this.time_control_parameters = new TimeControlParameters();
		
		
		this.related.setDetali(gameHistory.getRelated().getDetail());
		this.players.setWhite(gameHistory.getPlayers().getWhite().getUsername());
		this.players.setBlack(gameHistory.getPlayers().getBlack().getUsername());
		this.id = ""+gameHistory.getId();
		this.name = gameHistory.getName();
		this.creator = ""+gameHistory.getCreator();
		this.mode = gameHistory.getMode();
		this.source = gameHistory.getSource();
		this.black = ""+gameHistory.getPlayers().getBlack().getId();
		this.white = ""+gameHistory.getPlayers().getWhite().getId();
		this.width = gameHistory.getWidth().intValue();
		this.height = gameHistory.getHeight().intValue();
		this.rules = gameHistory.getRules();
		this.ranked = gameHistory.getRanked();
		this.handicap = gameHistory.getHandicap().intValue();
		this.komi = gameHistory.getKomi();
		this.time_control = gameHistory.getTimeControl();
		this.time_per_move = gameHistory.getTimePerMove();
		
		JSONObject timeControl = new JSONObject(gameHistory.getTimeControlParameters());
		
		this.time_control_parameters.setTime_control(timeControl.getString("time_control"));
		this.time_control_parameters.setInitial_time(-1);// unavailable from OGS rest api call
		this.time_control_parameters.setMax_time(-1);// unavailable from OGS rest api call
		this.time_control_parameters.setTime_increment(-1);// unavailable from OGS rest api call
		this.disable_analysis = gameHistory.getDisableAnalysis();
		this.tournament = null; //specification doesent specify what type this is
		this.tournament_round = gameHistory.getTournamentRound().intValue();
		this.ladder = null;//specification doesent specify what type this is
		this.pause_on_weekends = gameHistory.getPauseOnWeekends();
		this.outcome = gameHistory.getOutcome();
		this.black_lost = gameHistory.getBlackLost();
		this.white_lost = gameHistory.getWhiteLost();
		this.annulled = gameHistory.getAnnulled();
		this.started = gameHistory.getStarted();
		this.ended = gameHistory.getStarted();
		
	}
	
	public Game(OGSGame game){
		
		this.related = new Related();
		this.players = new GamePlayers();
		this.time_control_parameters = new TimeControlParameters();
		
		this.id =""+game.getGameId();
		this.related = new Related("/api/v1/games/"+this.id);
		this.players.setBlack(game.getPlayers().getBlack().getUsername());
		this.players.setWhite(game.getPlayers().getWhite().getUsername());
		this.name = game.getGameName();
		this.creator = game.getInitialPlayer();//Starting player ???
		this.mode = "game";// default ???
		this.source = game.getPhase();
		this.black = ""+game.getPlayers().getBlack().getId(); //Until furthure notice we are treating this as ID field
		this.white = ""+game.getPlayers().getWhite().getId();
		this.width = (int)game.getWidth();
		this.height = (int)game.getHeight();
		this.rules = game.getRules();
		this.ranked = game.isRanked();
		this.handicap = (int)game.getHandicap();
		this.komi = ""+game.getKomi();
		this.time_control = game.getTimeControl().getTimeControl();
		this.time_per_move = game.getTimeControl().getTimeIncrement(); //TODO what is time per move ?? 
		
		this.time_control_parameters.setTime_control(game.getTimeControl().getTimeControl());
		this.time_control_parameters.setInitial_time((int)game.getTimeControl().getInitialTime()); //TODO risk of overflowing integer
		this.time_control_parameters.setMax_time((int)game.getTimeControl().getMaxTime()); //TODO risk of integer overflow
		this.time_control_parameters.setTime_increment((int)game.getTimeControl().getTimeIncrement());
		this.disable_analysis = game.isDisableAnalysis();
		this.tournament = "none"; //TODO for the time being
		this.tournament_round = -1; //TODO for the time being
		this.ladder = "none"; //TODO for the time being
		this.pause_on_weekends = game.isPauseOnWeekends();
		this.outcome = null; //TODO this ????
		this.black_lost = false;//TODO this ???
		this.white_lost = false;// TODO this??
		this.annulled = false; //TODO ????
		this.started = ""; //TODO ????
		this.ended = ""; //TODO ?????
		
		try{
			throw new Exception("Implement me");
		}catch(Exception e){
			
		}
	}
	
	
	public Game() {
		super();
	}
	
	
	
	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getEnded() {
		return ended;
	}

	public void setEnded(String ended) {
		this.ended = ended;
	}

	public Related getRelated() {
		return related;
	}
	public void setRelated(Related related) {
		this.related = related;
	}
	public GamePlayers getPlayers() {
		return players;
	}
	public void setPlayers(GamePlayers players) {
		this.players = players;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getBlack() {
		return black;
	}
	public void setBlack(String black) {
		this.black = black;
	}
	public String getWhite() {
		return white;
	}
	public void setWhite(String white) {
		this.white = white;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public boolean getRanked() {
		return ranked;
	}
	public void setRanked(boolean ranked) {
		this.ranked = ranked;
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	public String getKomi() {
		return komi;
	}
	public void setKomi(String komi) {
		this.komi = komi;
	}
	public String getTime_control() {
		return time_control;
	}
	public void setTime_control(String time_control) {
		this.time_control = time_control;
	}
	public long getTime_per_move() {
		return time_per_move;
	}
	public void setTime_per_move(long time_per_move) {
		this.time_per_move = time_per_move;
	}
	public TimeControlParameters getTime_control_parameters() {
		return time_control_parameters;
	}
	public void setTime_control_parameters(TimeControlParameters time_control_parameters) {
		this.time_control_parameters = time_control_parameters;
	}
	public boolean isDisable_analysis() {
		return disable_analysis;
	}
	public void setDisable_analysis(boolean disable_analysis) {
		this.disable_analysis = disable_analysis;
	}
	public String getTournament() {
		return tournament;
	}
	public void setTournament(String tournament) {
		this.tournament = tournament;
	}
	public int getTournament_round() {
		return tournament_round;
	}
	public void setTournament_round(int tournament_round) {
		this.tournament_round = tournament_round;
	}
	public String getLadder() {
		return ladder;
	}
	public void setLadder(String ladder) {
		this.ladder = ladder;
	}
	public boolean isPause_on_weekends() {
		return pause_on_weekends;
	}
	public void setPause_on_weekends(boolean pause_on_weekends) {
		this.pause_on_weekends = pause_on_weekends;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public boolean isBlack_lost() {
		return black_lost;
	}
	public void setBlack_lost(boolean black_lost) {
		this.black_lost = black_lost;
	}
	public boolean isWhite_lost() {
		return white_lost;
	}
	public void setWhite_lost(boolean white_lost) {
		this.white_lost = white_lost;
	}
	public boolean isAnnulled() {
		return annulled;
	}
	public void setAnnulled(boolean annulled) {
		this.annulled = annulled;
	}
	
	
	
	
}
