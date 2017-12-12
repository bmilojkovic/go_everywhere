package model;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import model.game.Game;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY, property = "@class")
public abstract class AbstractGame{
	
	
	public AbstractGame() {
		super();
	}

	public abstract Game toGame();
	public abstract JSONObject toJson();
	
}
