
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "deviation",
    "rating",
    "volatility"
})
public class Overall___ {

    @JsonProperty("deviation")
    private Long deviation;
    @JsonProperty("rating")
    private Long rating;
    @JsonProperty("volatility")
    private Float volatility;

    @JsonProperty("deviation")
    public Long getDeviation() {
        return deviation;
    }

    @JsonProperty("deviation")
    public void setDeviation(Long deviation) {
        this.deviation = deviation;
    }

    @JsonProperty("rating")
    public Long getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(Long rating) {
        this.rating = rating;
    }

    @JsonProperty("volatility")
    public Float getVolatility() {
        return volatility;
    }

    @JsonProperty("volatility")
    public void setVolatility(Float volatility) {
        this.volatility = volatility;
    }

}
