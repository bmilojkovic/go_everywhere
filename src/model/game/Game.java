package model.game;

import org.json.JSONObject;

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
	private String width;
	private String height;
	private String rules;
	private String ranked;
	private int handicap;
	private String komi; //TODO: documentation says string ?
	private String time_control;
	private String time_per_move;
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
	
	
	public Game(JSONObject game){
		//TODO IMPLEMENT THIS! U get a json object of Game (actording to specification)
		
		
		try{
			throw new Exception("Implement me !!");
		}catch(Exception e){
			
		}
	}
	
	public Game() {
		super();
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
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getRanked() {
		return ranked;
	}
	public void setRanked(String ranked) {
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
	public String getTime_per_move() {
		return time_per_move;
	}
	public void setTime_per_move(String time_per_move) {
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
