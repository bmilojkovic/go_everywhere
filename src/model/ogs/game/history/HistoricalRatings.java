
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "white",
    "black"
})
public class HistoricalRatings {

    @JsonProperty("white")
    private White_ white;
    @JsonProperty("black")
    private Black_ black;

    @JsonProperty("white")
    public White_ getWhite() {
        return white;
    }

    @JsonProperty("white")
    public void setWhite(White_ white) {
        this.white = white;
    }

    @JsonProperty("black")
    public Black_ getBlack() {
        return black;
    }

    @JsonProperty("black")
    public void setBlack(Black_ black) {
        this.black = black;
    }

}
