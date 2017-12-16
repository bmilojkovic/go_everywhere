
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "white",
    "black"
})
public class Players {

    @JsonProperty("white")
    private White white;
    @JsonProperty("black")
    private Black black;

    @JsonProperty("white")
    public White getWhite() {
        return white;
    }

    @JsonProperty("white")
    public void setWhite(White white) {
        this.white = white;
    }

    @JsonProperty("black")
    public Black getBlack() {
        return black;
    }

    @JsonProperty("black")
    public void setBlack(Black black) {
        this.black = black;
    }

}
