
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
    "white",
    "black"
})
public class Players {

    @JsonProperty("white")
    private White white;
    @JsonProperty("black")
    private Black black;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
