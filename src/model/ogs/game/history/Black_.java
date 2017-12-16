
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "username",
    "ratings",
    "ranking",
    "country",
    "professional",
    "ui_class",
    "id",
    "icon"
})
public class Black_ {

    @JsonProperty("username")
    private String username;
    @JsonProperty("ratings")
    private Ratings___ ratings;
    @JsonProperty("ranking")
    private Long ranking;
    @JsonProperty("country")
    private String country;
    @JsonProperty("professional")
    private Boolean professional;
    @JsonProperty("ui_class")
    private String uiClass;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("icon")
    private String icon;

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("ratings")
    public Ratings___ getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings___ ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("ranking")
    public Long getRanking() {
        return ranking;
    }

    @JsonProperty("ranking")
    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("professional")
    public Boolean getProfessional() {
        return professional;
    }

    @JsonProperty("professional")
    public void setProfessional(Boolean professional) {
        this.professional = professional;
    }

    @JsonProperty("ui_class")
    public String getUiClass() {
        return uiClass;
    }

    @JsonProperty("ui_class")
    public void setUiClass(String uiClass) {
        this.uiClass = uiClass;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

}
