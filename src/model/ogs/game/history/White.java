
package model.ogs.game.history;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "username",
    "country",
    "icon",
    "ranking",
    "ranking_blitz",
    "ranking_live",
    "ranking_correspondence",
    "ratings",
    "rating",
    "rating_blitz",
    "rating_live",
    "rating_correspondence",
    "professional",
    "ui_class",
    "aga_valid"
})
public class White {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("username")
    private String username;
    @JsonProperty("country")
    private String country;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("ranking")
    private Long ranking;
    @JsonProperty("ranking_blitz")
    private Long rankingBlitz;
    @JsonProperty("ranking_live")
    private Long rankingLive;
    @JsonProperty("ranking_correspondence")
    private Long rankingCorrespondence;
    @JsonProperty("ratings")
    private Ratings ratings;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("rating_blitz")
    private String ratingBlitz;
    @JsonProperty("rating_live")
    private String ratingLive;
    @JsonProperty("rating_correspondence")
    private String ratingCorrespondence;
    @JsonProperty("professional")
    private Boolean professional;
    @JsonProperty("ui_class")
    private String uiClass;
    @JsonProperty("aga_valid")
    private Object agaValid;

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("icon")
    public String getIcon() {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @JsonProperty("ranking")
    public Long getRanking() {
        return ranking;
    }

    @JsonProperty("ranking")
    public void setRanking(Long ranking) {
        this.ranking = ranking;
    }

    @JsonProperty("ranking_blitz")
    public Long getRankingBlitz() {
        return rankingBlitz;
    }

    @JsonProperty("ranking_blitz")
    public void setRankingBlitz(Long rankingBlitz) {
        this.rankingBlitz = rankingBlitz;
    }

    @JsonProperty("ranking_live")
    public Long getRankingLive() {
        return rankingLive;
    }

    @JsonProperty("ranking_live")
    public void setRankingLive(Long rankingLive) {
        this.rankingLive = rankingLive;
    }

    @JsonProperty("ranking_correspondence")
    public Long getRankingCorrespondence() {
        return rankingCorrespondence;
    }

    @JsonProperty("ranking_correspondence")
    public void setRankingCorrespondence(Long rankingCorrespondence) {
        this.rankingCorrespondence = rankingCorrespondence;
    }

    @JsonProperty("ratings")
    public Ratings getRatings() {
        return ratings;
    }

    @JsonProperty("ratings")
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("rating_blitz")
    public String getRatingBlitz() {
        return ratingBlitz;
    }

    @JsonProperty("rating_blitz")
    public void setRatingBlitz(String ratingBlitz) {
        this.ratingBlitz = ratingBlitz;
    }

    @JsonProperty("rating_live")
    public String getRatingLive() {
        return ratingLive;
    }

    @JsonProperty("rating_live")
    public void setRatingLive(String ratingLive) {
        this.ratingLive = ratingLive;
    }

    @JsonProperty("rating_correspondence")
    public String getRatingCorrespondence() {
        return ratingCorrespondence;
    }

    @JsonProperty("rating_correspondence")
    public void setRatingCorrespondence(String ratingCorrespondence) {
        this.ratingCorrespondence = ratingCorrespondence;
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

    @JsonProperty("aga_valid")
    public Object getAgaValid() {
        return agaValid;
    }

    @JsonProperty("aga_valid")
    public void setAgaValid(Object agaValid) {
        this.agaValid = agaValid;
    }

}
