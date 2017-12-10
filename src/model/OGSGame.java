package model;


public class OGSGame extends AbstractGame{

	private boolean initialized;
	private int min_ranking;
	private int max_ranking;
	private String challenger_color;
	private OGSGameInfo game; //field "game" in OGS game object
	
	
	
	
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
	
	
	
	
}
