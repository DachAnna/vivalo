package com.annadach.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Class {

    @JsonProperty("gid")
    private String gid;
    @JsonProperty("name")
    private String name;
    @JsonProperty("organization")
    private String organization;

  /* @JsonIgnore
    private String description;
    private String price;
    @JsonProperty("price_trial")
    private String priceTrial;
    private String trial;
    @JsonProperty("min_age")
    private String minAge;
    @JsonProperty("max_age")
    private String maxAge;
    private String duration;
    @JsonProperty("max_age")
    private String maxAge;
    private String description;
    private String description;*/
}
