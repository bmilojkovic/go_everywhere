
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
    "system",
    "pause_on_weekends",
    "time_control",
    "initial_time",
    "max_time",
    "time_increment",
    "speed"
})
public class TimeControl {

    @JsonProperty("system")
    private String system;
    @JsonProperty("pause_on_weekends")
    private boolean pauseOnWeekends;
    @JsonProperty("time_control")
    private String timeControl;
    @JsonProperty("initial_time")
    private long initialTime;
    @JsonProperty("max_time")
    private long maxTime;
    @JsonProperty("time_increment")
    private long timeIncrement;
    @JsonProperty("speed")
    private String speed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("pause_on_weekends")
    public boolean isPauseOnWeekends() {
        return pauseOnWeekends;
    }

    @JsonProperty("pause_on_weekends")
    public void setPauseOnWeekends(boolean pauseOnWeekends) {
        this.pauseOnWeekends = pauseOnWeekends;
    }

    @JsonProperty("time_control")
    public String getTimeControl() {
        return timeControl;
    }

    @JsonProperty("time_control")
    public void setTimeControl(String timeControl) {
        this.timeControl = timeControl;
    }

    @JsonProperty("initial_time")
    public long getInitialTime() {
        return initialTime;
    }

    @JsonProperty("initial_time")
    public void setInitialTime(long initialTime) {
        this.initialTime = initialTime;
    }

    @JsonProperty("max_time")
    public long getMaxTime() {
        return maxTime;
    }

    @JsonProperty("max_time")
    public void setMaxTime(long maxTime) {
        this.maxTime = maxTime;
    }

    @JsonProperty("time_increment")
    public long getTimeIncrement() {
        return timeIncrement;
    }

    @JsonProperty("time_increment")
    public void setTimeIncrement(long timeIncrement) {
        this.timeIncrement = timeIncrement;
    }

    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
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
