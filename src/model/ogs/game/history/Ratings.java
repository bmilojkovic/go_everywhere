
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overall"
})
public class Ratings {

    @JsonProperty("overall")
    private Overall overall;

    @JsonProperty("overall")
    public Overall getOverall() {
        return overall;
    }

    @JsonProperty("overall")
    public void setOverall(Overall overall) {
        this.overall = overall;
    }

}
