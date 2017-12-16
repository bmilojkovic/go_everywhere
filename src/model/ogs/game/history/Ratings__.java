
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "overall"
})
public class Ratings__ {

    @JsonProperty("overall")
    private Overall__ overall;

    @JsonProperty("overall")
    public Overall__ getOverall() {
        return overall;
    }

    @JsonProperty("overall")
    public void setOverall(Overall__ overall) {
        this.overall = overall;
    }

}
