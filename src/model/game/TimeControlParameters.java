package model.game;

public class TimeControlParameters {

	private String time_control;
	private int initial_time;
	private int max_time;
	private int time_increment;
	
	
	
	public TimeControlParameters() {
		super();
	}
	public TimeControlParameters(String time_control, int initial_time, int max_time, int time_increment) {
		super();
		this.time_control = time_control;
		this.initial_time = initial_time;
		this.max_time = max_time;
		this.time_increment = time_increment;
	}
	public String getTime_control() {
		return time_control;
	}
	public void setTime_control(String time_control) {
		this.time_control = time_control;
	}
	public int getInitial_time() {
		return initial_time;
	}
	public void setInitial_time(int initial_time) {
		this.initial_time = initial_time;
	}
	public int getMax_time() {
		return max_time;
	}
	public void setMax_time(int max_time) {
		this.max_time = max_time;
	}
	public int getTime_increment() {
		return time_increment;
	}
	public void setTime_increment(int time_increment) {
		this.time_increment = time_increment;
	}
	
	
	
}
