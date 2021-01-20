package com.example.demo.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "countryCode",
        "countryName",
        "currencyCode",
        "population",
        "capital",
        "continentName"
})
public class CountryCurrency {

    @JsonProperty("countryCode")
    private String countryCode;
    @JsonProperty("countryName")
    private String countryName;
    @JsonProperty("currencyCode")
    private String currencyCode;
    @JsonProperty("population")
    private String population;
    @JsonProperty("capital")
    private String capital;
    @JsonProperty("continentName")
    private String continentName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("countryCode")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("countryCode")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("countryName")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("countryName")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("currencyCode")
    public String getCurrencyCode() {
        return currencyCode;
    }

    @JsonProperty("currencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @JsonProperty("population")
    public String getPopulation() {
        return population;
    }

    @JsonProperty("population")
    public void setPopulation(String population) {
        this.population = population;
    }

    @JsonProperty("capital")
    public String getCapital() {
        return capital;
    }

    @JsonProperty("capital")
    public void setCapital(String capital) {
        this.capital = capital;
    }

    @JsonProperty("continentName")
    public String getContinentName() {
        return continentName;
    }

    @JsonProperty("continentName")
    public void setContinentName(String continentName) {
        this.continentName = continentName;
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
