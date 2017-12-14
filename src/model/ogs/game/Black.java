
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
    "username",
    "professional",
    "egf",
    "rank",
    "id"
})
public class Black {

    @JsonProperty("username")
    private String username;
    @JsonProperty("professional")
    private boolean professional;
    @JsonProperty("egf")
    private double egf;
    @JsonProperty("rank")
    private long rank;
    @JsonProperty("id")
    private long id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("professional")
    public boolean isProfessional() {
        return professional;
    }

    @JsonProperty("professional")
    public void setProfessional(boolean professional) {
        this.professional = professional;
    }

    @JsonProperty("egf")
    public double getEgf() {
        return egf;
    }

    @JsonProperty("egf")
    public void setEgf(double egf) {
        this.egf = egf;
    }

    @JsonProperty("rank")
    public long getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(long rank) {
        this.rank = rank;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(long id) {
        this.id = id;
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
