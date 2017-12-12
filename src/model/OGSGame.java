package model;

import org.json.JSONObject;

import model.game.Game;

public class OGSGame extends AbstractGame{

	private boolean initialized;
	private int min_ranking;
	private int max_ranking;
	private String challenger_color;
	private OGSGameInfo game; //field "game" in OGS game object
	
	
	public OGSGame(JSONObject gameObject){
		initialized = gameObject.getBoolean("initialized");
		min_ranking = gameObject.getInt("min_ranking");
		max_ranking = gameObject.getInt("max_ranking");
		challenger_color = gameObject.getString("challenger_color");
		
		JSONObject gameInfo = new JSONObject(gameObject.getJSONObject("game"));
		
		game.setHandicap(gameInfo.getInt("handicap"));
		game.setTime_control(gameInfo.getString("time_control"));
		game.setChallenger_color(gameInfo.getString("challenger_color"));
		game.setRules(gameInfo.getString("rules"));
		game.setRanked(gameInfo.getBoolean("ranked"));
		game.setWidth(gameInfo.getInt("width"));
		game.setHeight(gameInfo.getInt("height"));
		game.setKomi_auto(gameInfo.getString("komi_auto"));
		game.setKomi(gameInfo.getInt("komi"));
		game.setDisable_analysis(gameInfo.getBoolean("disable_analysis"));
		game.setPause_on_weekends(gameInfo.getBoolean("pause_on_weekends"));
		game.setInitial_state(gameInfo.getString("initial_state"));
		game.setPriv(gameInfo.getBoolean("private"));
		game.setName(gameInfo.getString("name"));
		
		JSONObject time_control_parametersObject = new JSONObject(gameInfo.getJSONObject("time_control_parameters"));
		
		game.getTime_control_parameters().setSystem(time_control_parametersObject.getString("system"));
		game.getTime_control_parameters().setSpeed(time_control_parametersObject.getString("speed"));
		game.getTime_control_parameters().setInitial_time(time_control_parametersObject.getInt("initial_time"));
		game.getTime_control_parameters().setTime_increment(time_control_parametersObject.getInt("time_increment"));
		game.getTime_control_parameters().setMax_time(time_control_parametersObject.getInt("max_time"));
		game.getTime_control_parameters().setPause_on_weekends(time_control_parametersObject.getBoolean("pause_on_weekends"));
		game.getTime_control_parameters().setTime_control(time_control_parametersObject.getString("time_control"));
		
	}
	
	public OGSGame(Game game){
		//TODO implement this shit!!!
		
		try{
			throw new Exception("Implement this !!");
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public OGSGame() {
		super();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "OGS";
	}


	public boolean isInitialized() {
		return initialized;
	}


	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}


	public int getMin_ranking() {
		return min_ranking;
	}


	public void setMin_ranking(int min_ranking) {
		this.min_ranking = min_ranking;
	}


	public int getMax_ranking() {
		return max_ranking;
	}


	public void setMax_ranking(int max_ranking) {
		this.max_ranking = max_ranking;
	}


	public String getChallenger_color() {
		return challenger_color;
	}


	public void setChallenger_color(String challenger_color) {
		this.challenger_color = challenger_color;
	}


	public OGSGameInfo getGame() {
		return game;
	}


	public void setGame(OGSGameInfo game) {
		this.game = game;
	}

	@Override
	public Game toGame() {
		// TODO Implement this !!!
		Game g = new Game();
		
		try{
			
			throw new Exception("IMPLEMENT THIS SHIT");
			
		}catch(Exception e){
			System.out.println("Implement this!!!");
		}
		
		return g;
	}

	@Override
	public JSONObject toJson() {
		// TODO Auto-generated method stub
		
		JSONObject thisGame = new JSONObject();
		
		return thisGame;
	}

	

	
	
	
	
}
