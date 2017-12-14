
package model.ogs.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "handicap",
    "disable_analysis",
    "private",
    "height",
    "time_control",
    "ranked",
    "meta_groups",
    "komi",
    "game_id",
    "width",
    "rules",
    "black_player_id",
    "pause_on_weekends",
    "white_player_id",
    "players",
    "game_name",
    "phase",
    "history",
    "initial_player",
    "moves",
    "allow_self_capture",
    "automatic_stone_removal",
    "free_handicap_placement",
    "aga_handicap_scoring",
    "allow_ko",
    "allow_superko",
    "superko_algorithm",
    "score_territory",
    "score_territory_in_seki",
    "score_stones",
    "score_prisoners",
    "score_passes",
    "white_must_pass_last",
    "opponent_plays_first_after_resume",
    "strict_seki_mode",
    "initial_state",
    "start_time",
    "original_disable_analysis",
    "auto_score",
    "clock"
})
public class OGSGame {

    @JsonProperty("handicap")
    private long handicap;
    @JsonProperty("disable_analysis")
    private boolean disableAnalysis;
    @JsonProperty("private")
    private boolean _private;
    @JsonProperty("height")
    private long height;
    @JsonProperty("time_control")
    private TimeControl timeControl;
    @JsonProperty("ranked")
    private boolean ranked;
    @JsonProperty("meta_groups")
    private List<Object> metaGroups = null;
    @JsonProperty("komi")
    private double komi;
    @JsonProperty("game_id")
    private long gameId;
    @JsonProperty("width")
    private long width;
    @JsonProperty("rules")
    private String rules;
    @JsonProperty("black_player_id")
    private long blackPlayerId;
    @JsonProperty("pause_on_weekends")
    private boolean pauseOnWeekends;
    @JsonProperty("white_player_id")
    private long whitePlayerId;
    @JsonProperty("players")
    private Players players;
    @JsonProperty("game_name")
    private String gameName;
    @JsonProperty("phase")
    private String phase;
    @JsonProperty("history")
    private List<Object> history = null;
    @JsonProperty("initial_player")
    private String initialPlayer;
    @JsonProperty("moves")
    private List<List<Long>> moves = null;
    @JsonProperty("allow_self_capture")
    private boolean allowSelfCapture;
    @JsonProperty("automatic_stone_removal")
    private boolean automaticStoneRemoval;
    @JsonProperty("free_handicap_placement")
    private boolean freeHandicapPlacement;
    @JsonProperty("aga_handicap_scoring")
    private boolean agaHandicapScoring;
    @JsonProperty("allow_ko")
    private boolean allowKo;
    @JsonProperty("allow_superko")
    private boolean allowSuperko;
    @JsonProperty("superko_algorithm")
    private String superkoAlgorithm;
    @JsonProperty("score_territory")
    private boolean scoreTerritory;
    @JsonProperty("score_territory_in_seki")
    private boolean scoreTerritoryInSeki;
    @JsonProperty("score_stones")
    private boolean scoreStones;
    @JsonProperty("score_prisoners")
    private boolean scorePrisoners;
    @JsonProperty("score_passes")
    private boolean scorePasses;
    @JsonProperty("white_must_pass_last")
    private boolean whiteMustPassLast;
    @JsonProperty("opponent_plays_first_after_resume")
    private boolean opponentPlaysFirstAfterResume;
    @JsonProperty("strict_seki_mode")
    private boolean strictSekiMode;
    @JsonProperty("initial_state")
    private InitialState initialState;
    @JsonProperty("start_time")
    private long startTime;
    @JsonProperty("original_disable_analysis")
    private boolean originalDisableAnalysis;
    @JsonProperty("auto_score")
    private boolean autoScore;
    @JsonProperty("clock")
    private Clock clock;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("handicap")
    public long getHandicap() {
        return handicap;
    }

    @JsonProperty("handicap")
    public void setHandicap(long handicap) {
        this.handicap = handicap;
    }

    @JsonProperty("disable_analysis")
    public boolean isDisableAnalysis() {
        return disableAnalysis;
    }

    @JsonProperty("disable_analysis")
    public void setDisableAnalysis(boolean disableAnalysis) {
        this.disableAnalysis = disableAnalysis;
    }

    @JsonProperty("private")
    public boolean isPrivate() {
        return _private;
    }

    @JsonProperty("private")
    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    @JsonProperty("height")
    public long getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(long height) {
        this.height = height;
    }

    @JsonProperty("time_control")
    public TimeControl getTimeControl() {
        return timeControl;
    }

    @JsonProperty("time_control")
    public void setTimeControl(TimeControl timeControl) {
        this.timeControl = timeControl;
    }

    @JsonProperty("ranked")
    public boolean isRanked() {
        return ranked;
    }

    @JsonProperty("ranked")
    public void setRanked(boolean ranked) {
        this.ranked = ranked;
    }

    @JsonProperty("meta_groups")
    public List<Object> getMetaGroups() {
        return metaGroups;
    }

    @JsonProperty("meta_groups")
    public void setMetaGroups(List<Object> metaGroups) {
        this.metaGroups = metaGroups;
    }

    @JsonProperty("komi")
    public double getKomi() {
        return komi;
    }

    @JsonProperty("komi")
    public void setKomi(double komi) {
        this.komi = komi;
    }

    @JsonProperty("game_id")
    public long getGameId() {
        return gameId;
    }

    @JsonProperty("game_id")
    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    @JsonProperty("width")
    public long getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(long width) {
        this.width = width;
    }

    @JsonProperty("rules")
    public String getRules() {
        return rules;
    }

    @JsonProperty("rules")
    public void setRules(String rules) {
        this.rules = rules;
    }

    @JsonProperty("black_player_id")
    public long getBlackPlayerId() {
        return blackPlayerId;
    }

    @JsonProperty("black_player_id")
    public void setBlackPlayerId(long blackPlayerId) {
        this.blackPlayerId = blackPlayerId;
    }

    @JsonProperty("pause_on_weekends")
    public boolean isPauseOnWeekends() {
        return pauseOnWeekends;
    }

    @JsonProperty("pause_on_weekends")
    public void setPauseOnWeekends(boolean pauseOnWeekends) {
        this.pauseOnWeekends = pauseOnWeekends;
    }

    @JsonProperty("white_player_id")
    public long getWhitePlayerId() {
        return whitePlayerId;
    }

    @JsonProperty("white_player_id")
    public void setWhitePlayerId(long whitePlayerId) {
        this.whitePlayerId = whitePlayerId;
    }

    @JsonProperty("players")
    public Players getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(Players players) {
        this.players = players;
    }

    @JsonProperty("game_name")
    public String getGameName() {
        return gameName;
    }

    @JsonProperty("game_name")
    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    @JsonProperty("history")
    public List<Object> getHistory() {
        return history;
    }

    @JsonProperty("history")
    public void setHistory(List<Object> history) {
        this.history = history;
    }

    @JsonProperty("initial_player")
    public String getInitialPlayer() {
        return initialPlayer;
    }

    @JsonProperty("initial_player")
    public void setInitialPlayer(String initialPlayer) {
        this.initialPlayer = initialPlayer;
    }

    @JsonProperty("moves")
    public List<List<Long>> getMoves() {
        return moves;
    }

    @JsonProperty("moves")
    public void setMoves(List<List<Long>> moves) {
        this.moves = moves;
    }

    @JsonProperty("allow_self_capture")
    public boolean isAllowSelfCapture() {
        return allowSelfCapture;
    }

    @JsonProperty("allow_self_capture")
    public void setAllowSelfCapture(boolean allowSelfCapture) {
        this.allowSelfCapture = allowSelfCapture;
    }

    @JsonProperty("automatic_stone_removal")
    public boolean isAutomaticStoneRemoval() {
        return automaticStoneRemoval;
    }

    @JsonProperty("automatic_stone_removal")
    public void setAutomaticStoneRemoval(boolean automaticStoneRemoval) {
        this.automaticStoneRemoval = automaticStoneRemoval;
    }

    @JsonProperty("free_handicap_placement")
    public boolean isFreeHandicapPlacement() {
        return freeHandicapPlacement;
    }

    @JsonProperty("free_handicap_placement")
    public void setFreeHandicapPlacement(boolean freeHandicapPlacement) {
        this.freeHandicapPlacement = freeHandicapPlacement;
    }

    @JsonProperty("aga_handicap_scoring")
    public boolean isAgaHandicapScoring() {
        return agaHandicapScoring;
    }

    @JsonProperty("aga_handicap_scoring")
    public void setAgaHandicapScoring(boolean agaHandicapScoring) {
        this.agaHandicapScoring = agaHandicapScoring;
    }

    @JsonProperty("allow_ko")
    public boolean isAllowKo() {
        return allowKo;
    }

    @JsonProperty("allow_ko")
    public void setAllowKo(boolean allowKo) {
        this.allowKo = allowKo;
    }

    @JsonProperty("allow_superko")
    public boolean isAllowSuperko() {
        return allowSuperko;
    }

    @JsonProperty("allow_superko")
    public void setAllowSuperko(boolean allowSuperko) {
        this.allowSuperko = allowSuperko;
    }

    @JsonProperty("superko_algorithm")
    public String getSuperkoAlgorithm() {
        return superkoAlgorithm;
    }

    @JsonProperty("superko_algorithm")
    public void setSuperkoAlgorithm(String superkoAlgorithm) {
        this.superkoAlgorithm = superkoAlgorithm;
    }

    @JsonProperty("score_territory")
    public boolean isScoreTerritory() {
        return scoreTerritory;
    }

    @JsonProperty("score_territory")
    public void setScoreTerritory(boolean scoreTerritory) {
        this.scoreTerritory = scoreTerritory;
    }

    @JsonProperty("score_territory_in_seki")
    public boolean isScoreTerritoryInSeki() {
        return scoreTerritoryInSeki;
    }

    @JsonProperty("score_territory_in_seki")
    public void setScoreTerritoryInSeki(boolean scoreTerritoryInSeki) {
        this.scoreTerritoryInSeki = scoreTerritoryInSeki;
    }

    @JsonProperty("score_stones")
    public boolean isScoreStones() {
        return scoreStones;
    }

    @JsonProperty("score_stones")
    public void setScoreStones(boolean scoreStones) {
        this.scoreStones = scoreStones;
    }

    @JsonProperty("score_prisoners")
    public boolean isScorePrisoners() {
        return scorePrisoners;
    }

    @JsonProperty("score_prisoners")
    public void setScorePrisoners(boolean scorePrisoners) {
        this.scorePrisoners = scorePrisoners;
    }

    @JsonProperty("score_passes")
    public boolean isScorePasses() {
        return scorePasses;
    }

    @JsonProperty("score_passes")
    public void setScorePasses(boolean scorePasses) {
        this.scorePasses = scorePasses;
    }

    @JsonProperty("white_must_pass_last")
    public boolean isWhiteMustPassLast() {
        return whiteMustPassLast;
    }

    @JsonProperty("white_must_pass_last")
    public void setWhiteMustPassLast(boolean whiteMustPassLast) {
        this.whiteMustPassLast = whiteMustPassLast;
    }

    @JsonProperty("opponent_plays_first_after_resume")
    public boolean isOpponentPlaysFirstAfterResume() {
        return opponentPlaysFirstAfterResume;
    }

    @JsonProperty("opponent_plays_first_after_resume")
    public void setOpponentPlaysFirstAfterResume(boolean opponentPlaysFirstAfterResume) {
        this.opponentPlaysFirstAfterResume = opponentPlaysFirstAfterResume;
    }

    @JsonProperty("strict_seki_mode")
    public boolean isStrictSekiMode() {
        return strictSekiMode;
    }

    @JsonProperty("strict_seki_mode")
    public void setStrictSekiMode(boolean strictSekiMode) {
        this.strictSekiMode = strictSekiMode;
    }

    @JsonProperty("initial_state")
    public InitialState getInitialState() {
        return initialState;
    }

    @JsonProperty("initial_state")
    public void setInitialState(InitialState initialState) {
        this.initialState = initialState;
    }

    @JsonProperty("start_time")
    public long getStartTime() {
        return startTime;
    }

    @JsonProperty("start_time")
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    @JsonProperty("original_disable_analysis")
    public boolean isOriginalDisableAnalysis() {
        return originalDisableAnalysis;
    }

    @JsonProperty("original_disable_analysis")
    public void setOriginalDisableAnalysis(boolean originalDisableAnalysis) {
        this.originalDisableAnalysis = originalDisableAnalysis;
    }

    @JsonProperty("auto_score")
    public boolean isAutoScore() {
        return autoScore;
    }

    @JsonProperty("auto_score")
    public void setAutoScore(boolean autoScore) {
        this.autoScore = autoScore;
    }

    @JsonProperty("clock")
    public Clock getClock() {
        return clock;
    }

    @JsonProperty("clock")
    public void setClock(Clock clock) {
        this.clock = clock;
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
