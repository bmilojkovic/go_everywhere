
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "related",
    "players",
    "id",
    "name",
    "creator",
    "mode",
    "source",
    "black",
    "white",
    "width",
    "height",
    "rules",
    "ranked",
    "handicap",
    "komi",
    "time_control",
    "black_player_rank",
    "black_player_rating",
    "white_player_rank",
    "white_player_rating",
    "time_per_move",
    "time_control_parameters",
    "disable_analysis",
    "tournament",
    "tournament_round",
    "ladder",
    "pause_on_weekends",
    "outcome",
    "black_lost",
    "white_lost",
    "annulled",
    "started",
    "ended",
    "sgf_filename",
    "historical_ratings"
})
public class OGSGameHistory {

    @JsonProperty("related")
    private Related related;
    @JsonProperty("players")
    private Players players;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("creator")
    private Long creator;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("source")
    private String source;
    @JsonProperty("black")
    private Long black;
    @JsonProperty("white")
    private Long white;
    @JsonProperty("width")
    private Long width;
    @JsonProperty("height")
    private Long height;
    @JsonProperty("rules")
    private String rules;
    @JsonProperty("ranked")
    private Boolean ranked;
    @JsonProperty("handicap")
    private Long handicap;
    @JsonProperty("komi")
    private String komi;
    @JsonProperty("time_control")
    private String timeControl;
    @JsonProperty("black_player_rank")
    private Long blackPlayerRank;
    @JsonProperty("black_player_rating")
    private String blackPlayerRating;
    @JsonProperty("white_player_rank")
    private Long whitePlayerRank;
    @JsonProperty("white_player_rating")
    private String whitePlayerRating;
    @JsonProperty("time_per_move")
    private Long timePerMove;
    @JsonProperty("time_control_parameters")
    private String timeControlParameters;
    @JsonProperty("disable_analysis")
    private Boolean disableAnalysis;
    @JsonProperty("tournament")
    private Object tournament;
    @JsonProperty("tournament_round")
    private Long tournamentRound;
    @JsonProperty("ladder")
    private Object ladder;
    @JsonProperty("pause_on_weekends")
    private Boolean pauseOnWeekends;
    @JsonProperty("outcome")
    private String outcome;
    @JsonProperty("black_lost")
    private Boolean blackLost;
    @JsonProperty("white_lost")
    private Boolean whiteLost;
    @JsonProperty("annulled")
    private Boolean annulled;
    @JsonProperty("started")
    private String started;
    @JsonProperty("ended")
    private String ended;
    @JsonProperty("sgf_filename")
    private Object sgfFilename;
    @JsonProperty("historical_ratings")
    private HistoricalRatings historicalRatings;

    @JsonProperty("related")
    public Related getRelated() {
        return related;
    }

    @JsonProperty("related")
    public void setRelated(Related related) {
        this.related = related;
    }

    @JsonProperty("players")
    public Players getPlayers() {
        return players;
    }

    @JsonProperty("players")
    public void setPlayers(Players players) {
        this.players = players;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("creator")
    public Long getCreator() {
        return creator;
    }

    @JsonProperty("creator")
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode) {
        this.mode = mode;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("black")
    public Long getBlack() {
        return black;
    }

    @JsonProperty("black")
    public void setBlack(Long black) {
        this.black = black;
    }

    @JsonProperty("white")
    public Long getWhite() {
        return white;
    }

    @JsonProperty("white")
    public void setWhite(Long white) {
        this.white = white;
    }

    @JsonProperty("width")
    public Long getWidth() {
        return width;
    }

    @JsonProperty("width")
    public void setWidth(Long width) {
        this.width = width;
    }

    @JsonProperty("height")
    public Long getHeight() {
        return height;
    }

    @JsonProperty("height")
    public void setHeight(Long height) {
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

    @JsonProperty("ranked")
    public Boolean getRanked() {
        return ranked;
    }

    @JsonProperty("ranked")
    public void setRanked(Boolean ranked) {
        this.ranked = ranked;
    }

    @JsonProperty("handicap")
    public Long getHandicap() {
        return handicap;
    }

    @JsonProperty("handicap")
    public void setHandicap(Long handicap) {
        this.handicap = handicap;
    }

    @JsonProperty("komi")
    public String getKomi() {
        return komi;
    }

    @JsonProperty("komi")
    public void setKomi(String komi) {
        this.komi = komi;
    }

    @JsonProperty("time_control")
    public String getTimeControl() {
        return timeControl;
    }

    @JsonProperty("time_control")
    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    @JsonProperty("black_player_rank")
    public Long getBlackPlayerRank() {
        return blackPlayerRank;
    }

    @JsonProperty("black_player_rank")
    public void setBlackPlayerRank(Long blackPlayerRank) {
        this.blackPlayerRank = blackPlayerRank;
    }

    @JsonProperty("black_player_rating")
    public String getBlackPlayerRating() {
        return blackPlayerRating;
    }

    @JsonProperty("black_player_rating")
    public void setBlackPlayerRating(String blackPlayerRating) {
        this.blackPlayerRating = blackPlayerRating;
    }

    @JsonProperty("white_player_rank")
    public Long getWhitePlayerRank() {
        return whitePlayerRank;
    }

    @JsonProperty("white_player_rank")
    public void setWhitePlayerRank(Long whitePlayerRank) {
        this.whitePlayerRank = whitePlayerRank;
    }

    @JsonProperty("white_player_rating")
    public String getWhitePlayerRating() {
        return whitePlayerRating;
    }

    @JsonProperty("white_player_rating")
    public void setWhitePlayerRating(String whitePlayerRating) {
        this.whitePlayerRating = whitePlayerRating;
    }

    @JsonProperty("time_per_move")
    public Long getTimePerMove() {
        return timePerMove;
    }

    @JsonProperty("time_per_move")
    public void setTimePerMove(Long timePerMove) {
        this.timePerMove = timePerMove;
    }

    @JsonProperty("time_control_parameters")
    public String getTimeControlParameters() {
        return timeControlParameters;
    }

    @JsonProperty("time_control_parameters")
    public void setTimeControlParameters(String timeControlParameters) {
        this.timeControlParameters = timeControlParameters;
    }

    @JsonProperty("disable_analysis")
    public Boolean getDisableAnalysis() {
        return disableAnalysis;
    }

    @JsonProperty("disable_analysis")
    public void setDisableAnalysis(Boolean disableAnalysis) {
        this.disableAnalysis = disableAnalysis;
    }

    @JsonProperty("tournament")
    public Object getTournament() {
        return tournament;
    }

    @JsonProperty("tournament")
    public void setTournament(Object tournament) {
        this.tournament = tournament;
    }

    @JsonProperty("tournament_round")
    public Long getTournamentRound() {
        return tournamentRound;
    }

    @JsonProperty("tournament_round")
    public void setTournamentRound(Long tournamentRound) {
        this.tournamentRound = tournamentRound;
    }

    @JsonProperty("ladder")
    public Object getLadder() {
        return ladder;
    }

    @JsonProperty("ladder")
    public void setLadder(Object ladder) {
        this.ladder = ladder;
    }

    @JsonProperty("pause_on_weekends")
    public Boolean getPauseOnWeekends() {
        return pauseOnWeekends;
    }

    @JsonProperty("pause_on_weekends")
    public void setPauseOnWeekends(Boolean pauseOnWeekends) {
        this.pauseOnWeekends = pauseOnWeekends;
    }

    @JsonProperty("outcome")
    public String getOutcome() {
        return outcome;
    }

    @JsonProperty("outcome")
    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @JsonProperty("black_lost")
    public Boolean getBlackLost() {
        return blackLost;
    }

    @JsonProperty("black_lost")
    public void setBlackLost(Boolean blackLost) {
        this.blackLost = blackLost;
    }

    @JsonProperty("white_lost")
    public Boolean getWhiteLost() {
        return whiteLost;
    }

    @JsonProperty("white_lost")
    public void setWhiteLost(Boolean whiteLost) {
        this.whiteLost = whiteLost;
    }

    @JsonProperty("annulled")
    public Boolean getAnnulled() {
        return annulled;
    }

    @JsonProperty("annulled")
    public void setAnnulled(Boolean annulled) {
        this.annulled = annulled;
    }

    @JsonProperty("started")
    public String getStarted() {
        return started;
    }

    @JsonProperty("started")
    public void setStarted(String started) {
        this.started = started;
    }

    @JsonProperty("ended")
    public String getEnded() {
        return ended;
    }

    @JsonProperty("ended")
    public void setEnded(String ended) {
        this.ended = ended;
    }

    @JsonProperty("sgf_filename")
    public Object getSgfFilename() {
        return sgfFilename;
    }

    @JsonProperty("sgf_filename")
    public void setSgfFilename(Object sgfFilename) {
        this.sgfFilename = sgfFilename;
    }

    @JsonProperty("historical_ratings")
    public HistoricalRatings getHistoricalRatings() {
        return historicalRatings;
    }

    @JsonProperty("historical_ratings")
    public void setHistoricalRatings(HistoricalRatings historicalRatings) {
        this.historicalRatings = historicalRatings;
    }

}
