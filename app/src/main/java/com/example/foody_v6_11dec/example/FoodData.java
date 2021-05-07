
package com.example.foody_v6_11dec.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.example.Recommended;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "popular",
    "recommended",
    "allmenu"
})
public class FoodData {

    @JsonProperty("popular")
    private List<Popular> popular = null;
    @JsonProperty("recommended")
    private List<Recommended> recommended = null;
    @JsonProperty("allmenu")
    private List<Allmenu> allmenu = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("popular")
    public List<Popular> getPopular() {
        return popular;
    }

    @JsonProperty("popular")
    public void setPopular(List<Popular> popular) {
        this.popular = popular;
    }

    @JsonProperty("recommended")
    public List<Recommended> getRecommended() {
        return recommended;
    }

    @JsonProperty("recommended")
    public void setRecommended(List<Recommended> recommended) {
        this.recommended = recommended;
    }

    @JsonProperty("allmenu")
    public List<Allmenu> getAllmenu() {
        return allmenu;
    }

    @JsonProperty("allmenu")
    public void setAllmenu(List<Allmenu> allmenu) {
        this.allmenu = allmenu;
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
