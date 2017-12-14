
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
    "thinking_time",
    "skip_bonus"
})
public class BlackTime {

    @JsonProperty("thinking_time")
    private long thinkingTime;
    @JsonProperty("skip_bonus")
    private boolean skipBonus;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thinking_time")
    public long getThinkingTime() {
        return thinkingTime;
    }

    @JsonProperty("thinking_time")
    public void setThinkingTime(long thinkingTime) {
        this.thinkingTime = thinkingTime;
    }

    @JsonProperty("skip_bonus")
    public boolean isSkipBonus() {
        return skipBonus;
    }

    @JsonProperty("skip_bonus")
    public void setSkipBonus(boolean skipBonus) {
        this.skipBonus = skipBonus;
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
