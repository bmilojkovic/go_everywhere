package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OGSGameInfo {

	private int handicap;
	private String time_control;
	private String challenger_color;
	private String rules;
	private boolean ranked;
	private int width;
	private int height;
	private String komi_auto;
	private int komi;
	private boolean disable_analysis;
	private boolean pause_on_weekends;
	private String initial_state; //TODO: unknown type (Guessing it's String, must be something that can be null)
	
	@JsonProperty("private")
	private boolean priv; //stupid OGS
	private String name;
	private OgsTimeControlParameters time_control_parameters;
	
	
	
	public OGSGameInfo() {
		super();
	}
	public int getHandicap() {
		return handicap;
	}
	public void setHandicap(int handicap) {
		this.handicap = handicap;
	}
	public String getTime_control() {
		return time_control;
	}
	public void setTime_control(String time_control) {
		this.time_control = time_control;
	}
	public String getChallenger_color() {
		return challenger_color;
	}
	public void setChallenger_color(String challenger_color) {
		this.challenger_color = challenger_color;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public boolean isRanked() {
		return ranked;
	}
	public void setRanked(boolean ranked) {
		this.ranked = ranked;
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
	public String getKomi_auto() {
		return komi_auto;
	}
	public void setKomi_auto(String komi_auto) {
		this.komi_auto = komi_auto;
	}
	public int getKomi() {
		return komi;
	}
	public void setKomi(int komi) {
		this.komi = komi;
	}
	public boolean isDisable_analysis() {
		return disable_analysis;
	}
	public void setDisable_analysis(boolean disable_analysis) {
		this.disable_analysis = disable_analysis;
	}
	public boolean isPause_on_weekends() {
		return pause_on_weekends;
	}
	public void setPause_on_weekends(boolean pause_on_weekends) {
		this.pause_on_weekends = pause_on_weekends;
	}
	public String getInitial_state() {
		return initial_state;
	}
	public void setInitial_state(String initial_state) {
		this.initial_state = initial_state;
	}
	public boolean isPriv() {
		return priv;
	}
	public void setPriv(boolean priv) {
		this.priv = priv;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public OgsTimeControlParameters getTime_control_parameters() {
		return time_control_parameters;
	}
	public void setTime_control_parameters(OgsTimeControlParameters time_control_parameters) {
		this.time_control_parameters = time_control_parameters;
	}
	
	
	
	
}
