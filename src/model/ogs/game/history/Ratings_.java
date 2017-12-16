
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overall"
})
public class Ratings_ {

    @JsonProperty("overall")
    private Overall_ overall;

    @JsonProperty("overall")
    public Overall_ getOverall() {
        return overall;
    }

    @JsonProperty("overall")
    public void setOverall(Overall_ overall) {
        this.overall = overall;
    }

}
