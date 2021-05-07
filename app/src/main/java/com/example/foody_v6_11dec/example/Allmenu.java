
package com.example.foody_v6_11dec.example;

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
    "name",
    "imageUrl",
    "rating",
    "deliveryTime",
    "deliveryCharges",
    "price",
    "note"
})
public class Allmenu {

    @JsonProperty("name")
    private String name;
    @JsonProperty("imageUrl")
    private String imageUrl;
    @JsonProperty("rating")
    private String rating;
    @JsonProperty("deliveryTime")
    private String deliveryTime;
    @JsonProperty("deliveryCharges")
    private String deliveryCharges;
    @JsonProperty("price")
    private String price;
    @JsonProperty("note")
    private String note;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("imageUrl")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("imageUrl")
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @JsonProperty("rating")
    public String getRating() {
        return rating;
    }

    @JsonProperty("rating")
    public void setRating(String rating) {
        this.rating = rating;
    }

    @JsonProperty("deliveryTime")
    public String getDeliveryTime() {
        return deliveryTime;
    }

    @JsonProperty("deliveryTime")
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @JsonProperty("deliveryCharges")
    public String getDeliveryCharges() {
        return deliveryCharges;
    }

    @JsonProperty("deliveryCharges")
    public void setDeliveryCharges(String deliveryCharges) {
        this.deliveryCharges = deliveryCharges;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("note")
    public String getNote() {
        return note;
    }

    @JsonProperty("note")
    public void setNote(String note) {
        this.note = note;
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
