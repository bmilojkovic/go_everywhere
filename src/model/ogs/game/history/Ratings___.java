
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overall"
})
public class Ratings___ {

    @JsonProperty("overall")
    private Overall___ overall;

    @JsonProperty("overall")
    public Overall___ getOverall() {
        return overall;
    }

    @JsonProperty("overall")
    public void setOverall(Overall___ overall) {
        this.overall = overall;
    }

}
