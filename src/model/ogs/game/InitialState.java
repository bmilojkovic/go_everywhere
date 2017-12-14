
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
    "black",
    "white"
})
public class InitialState {

    @JsonProperty("black")
    private String black;
    @JsonProperty("white")
    private String white;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("black")
    public String getBlack() {
        return black;
    }

    @JsonProperty("black")
    public void setBlack(String black) {
        this.black = black;
    }

    @JsonProperty("white")
    public String getWhite() {
        return white;
    }

    @JsonProperty("white")
    public void setWhite(String white) {
        this.white = white;
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
