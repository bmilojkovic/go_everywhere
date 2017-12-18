
package model.ogs.game.challenges;

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
    "username",
    "time_per_move",
    "user_id",
    "name",
    "width",
    "handicap",
    "challenge_id",
    "pro",
    "max_rank",
    "disable_analysis",
    "rank",
    "height",
    "rules",
    "time_control",
    "ranked",
    "min_rank",
    "komi",
    "game_id",
    "time_control_parameters",
    "challenger_color"
})
public class OGSChallenge {

    @JsonProperty("username")
    private String username;
    @JsonProperty("time_per_move")
    private Integer timePerMove;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("width")
    private Integer width;
    @JsonProperty("handicap")
    private Integer handicap;
    @JsonProperty("challenge_id")
    private Integer challengeId;
    @JsonProperty("pro")
    private Integer pro;
    @JsonProperty("max_rank")
    private Integer maxRank;
    @JsonProperty("disable_analysis")
    private Boolean disableAnalysis;
    @JsonProperty("rank")
    private Double rank;
    @JsonProperty("height")
    private Integer height;
    @JsonProperty("rules")
    private String rules;
    @JsonProperty("time_control")
    private String timeControl;
    @JsonProperty("ranked")
    private Boolean ranked;
    @JsonProperty("min_rank")
    private Integer minRank;
    @JsonProperty("komi")
    private String komi;
    @JsonProperty("game_id")
    private Integer gameId;
    @JsonProperty("time_control_parameters")
    private TimeControlParameters timeControlParameters;
    @JsonProperty("challenger_color")
    private String challengerColor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("time_per_move")
    public Integer getTimePerMove() {
        return timePerMove;
    }

    @JsonProperty("time_per_move")
    public void setTimePerMove(Integer timePerMove) {
        this.timePerMove = timePerMove;
    }

    @JsonProperty("user_id")
    public Integer getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Integer width) {
        this.width = width;
    }

    @JsonProperty("handicap")
    public Integer getHandicap() {
        return handicap;
    }

    @JsonProperty("handicap")
    public void setHandicap(Integer handicap) {
        this.handicap = handicap;
    }

    @JsonProperty("challenge_id")
    public Integer getChallengeId() {
        return challengeId;
    }

    @JsonProperty("challenge_id")
    public void setChallengeId(Integer challengeId) {
        this.challengeId = challengeId;
    }

    @JsonProperty("pro")
    public Integer getPro() {
        return pro;
    }

    @JsonProperty("pro")
    public void setPro(Integer pro) {
        this.pro = pro;
    }

    @JsonProperty("max_rank")
    public Integer getMaxRank() {
        return maxRank;
    }

    @JsonProperty("max_rank")
    public void setMaxRank(Integer maxRank) {
        this.maxRank = maxRank;
    }

    @JsonProperty("disable_analysis")
    public Boolean getDisableAnalysis() {
        return disableAnalysis;
    }

    @JsonProperty("disable_analysis")
    public void setDisableAnalysis(Boolean disableAnalysis) {
        this.disableAnalysis = disableAnalysis;
    }

    @JsonProperty("rank")
    public Double getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Double rank) {
        this.rank = rank;
    }

    @JsonProperty("height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("rules")
    public String getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(String rules) {
        this.rules = rules;
    }

    @JsonProperty("time_control")
    public String getTimeControl() {
        return timeControl;
    }

    @JsonProperty("time_control")
    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    @JsonProperty("ranked")
    public Boolean getRanked() {
        return ranked;
    }

    @JsonProperty("ranked")
    public void setRanked(Boolean ranked) {
        this.ranked = ranked;
    }

    @JsonProperty("min_rank")
    public Integer getMinRank() {
        return minRank;
    }

    @JsonProperty("min_rank")
    public void setMinRank(Integer minRank) {
        this.minRank = minRank;
    }

    @JsonProperty("komi")
    public String getKomi() {
        return komi;
    }

    @JsonProperty("komi")
    public void setKomi(String komi) {
        this.komi = komi;
    }

    @JsonProperty("game_id")
    public Integer getGameId() {
        return gameId;
    }

    @JsonProperty("game_id")
    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("time_control_parameters")
    public TimeControlParameters getTimeControlParameters() {
        return timeControlParameters;
    }

    @JsonProperty("time_control_parameters")
    public void setTimeControlParameters(TimeControlParameters timeControlParameters) {
        this.timeControlParameters = timeControlParameters;
    }

    @JsonProperty("challenger_color")
    public String getChallengerColor() {
        return challengerColor;
    }

    @JsonProperty("challenger_color")
    public void setChallengerColor(String challengerColor) {
        this.challengerColor = challengerColor;
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
