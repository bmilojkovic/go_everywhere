
package model.ogs.game;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "game_id",
    "current_player",
    "black_player_id",
    "white_player_id",
    "title",
    "last_move",
    "expiration",
    "black_time",
    "white_time"
})
public class Clock {

    @JsonProperty("game_id")
    private long gameId;
    @JsonProperty("current_player")
    private long currentPlayer;
    @JsonProperty("black_player_id")
    private long blackPlayerId;
    @JsonProperty("white_player_id")
    private long whitePlayerId;
    @JsonProperty("title")
    private String title;
    @JsonProperty("last_move")
    private long lastMove;
    @JsonProperty("expiration")
    private long expiration;
    @JsonProperty("black_time")
    private BlackTime blackTime;
    @JsonProperty("white_time")
    private WhiteTime whiteTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("game_id")
    public long getGameId() {
        return gameId;
    }

    @JsonProperty("game_id")
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("current_player")
    public long getCurrentPlayer() {
        return currentPlayer;
    }

    @JsonProperty("current_player")
    public void setCurrentPlayer(long currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @JsonProperty("black_player_id")
    public long getBlackPlayerId() {
        return blackPlayerId;
    }

    @JsonProperty("black_player_id")
    public void setBlackPlayerId(long blackPlayerId) {
        this.blackPlayerId = blackPlayerId;
    }

    @JsonProperty("white_player_id")
    public long getWhitePlayerId() {
        return whitePlayerId;
    }

    @JsonProperty("white_player_id")
    public void setWhitePlayerId(long whitePlayerId) {
        this.whitePlayerId = whitePlayerId;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("last_move")
    public long getLastMove() {
        return lastMove;
    }

    @JsonProperty("last_move")
    public void setLastMove(long lastMove) {
        this.lastMove = lastMove;
    }

    @JsonProperty("expiration")
    public long getExpiration() {
        return expiration;
    }

    @JsonProperty("expiration")
    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    @JsonProperty("black_time")
    public BlackTime getBlackTime() {
        return blackTime;
    }

    @JsonProperty("black_time")
    public void setBlackTime(BlackTime blackTime) {
        this.blackTime = blackTime;
    }

    @JsonProperty("white_time")
    public WhiteTime getWhiteTime() {
        return whiteTime;
    }

    @JsonProperty("white_time")
    public void setWhiteTime(WhiteTime whiteTime) {
        this.whiteTime = whiteTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
