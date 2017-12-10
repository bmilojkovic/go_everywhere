package model;

public class OgsTimeControlParameters {

	private String system;
	private String speed;
	private int initial_time;
	private int time_increment;
	private int max_time;
	private boolean pause_on_weekends;
	private String time_control;
	
	
	
	public OgsTimeControlParameters() {
		super();
	}
	public OgsTimeControlParameters(String system, String speed, int initial_time, int time_increment, int max_time,
			boolean pause_on_weekends, String time_control) {
		super();
		this.system = system;
		this.speed = speed;
		this.initial_time = initial_time;
		this.time_increment = time_increment;
		this.max_time = max_time;
		this.pause_on_weekends = pause_on_weekends;
		this.time_control = time_control;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public int getInitial_time() {
		return initial_time;
	}
	public void setInitial_time(int initial_time) {
		this.initial_time = initial_time;
	}
	public int getTime_increment() {
		return time_increment;
	}
	public void setTime_increment(int time_increment) {
		this.time_increment = time_increment;
	}
	public int getMax_time() {
		return max_time;
	}
	public void setMax_time(int max_time) {
		this.max_time = max_time;
	}
	public boolean isPause_on_weekends() {
		return pause_on_weekends;
	}
	public void setPause_on_weekends(boolean pause_on_weekends) {
		this.pause_on_weekends = pause_on_weekends;
	}
	public String getTime_control() {
		return time_control;
	}
	public void setTime_control(String time_control) {
		this.time_control = time_control;
	}
	
	
	
}
