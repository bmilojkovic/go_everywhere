
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
    "period_time",
    "main_time",
    "system",
    "pause_on_weekends",
    "time_control",
    "periods",
    "speed"
})
public class TimeControlParameters {

    @JsonProperty("period_time")
    private Integer periodTime;
    @JsonProperty("main_time")
    private Integer mainTime;
    @JsonProperty("system")
    private String system;
    @JsonProperty("pause_on_weekends")
    private Boolean pauseOnWeekends;
    @JsonProperty("time_control")
    private String timeControl;
    @JsonProperty("periods")
    private Integer periods;
    @JsonProperty("speed")
    private String speed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("period_time")
    public Integer getPeriodTime() {
        return periodTime;
    }

    @JsonProperty("period_time")
    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }

    @JsonProperty("main_time")
    public Integer getMainTime() {
        return mainTime;
    }

    @JsonProperty("main_time")
    public void setMainTime(Integer mainTime) {
        this.mainTime = mainTime;
    }

    @JsonProperty("system")
    public String getSystem() {
        return system;
    }

    @JsonProperty("system")
    public void setSystem(String system) {
        this.system = system;
    }

    @JsonProperty("pause_on_weekends")
    public Boolean getPauseOnWeekends() {
        return pauseOnWeekends;
    }

    @JsonProperty("pause_on_weekends")
    public void setPauseOnWeekends(Boolean pauseOnWeekends) {
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

    @JsonProperty("periods")
    public Integer getPeriods() {
        return periods;
    }

    @JsonProperty("periods")
    public void setPeriods(Integer periods) {
        this.periods = periods;
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
