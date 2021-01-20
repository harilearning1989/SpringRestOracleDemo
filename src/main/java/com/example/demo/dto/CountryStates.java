package com.example.demo.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"countryName",
	"countryShortCode",
	"regions"
})
public class CountryStates {

	@JsonProperty("countryName")
	private String countryName;
	@JsonProperty("countryShortCode")
	private String countryShortCode;
	@JsonProperty("regions")
	private List<Region> regions = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("countryName")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("countryName")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@JsonProperty("countryShortCode")
	public String getCountryShortCode() {
		return countryShortCode;
	}

	@JsonProperty("countryShortCode")
	public void setCountryShortCode(String countryShortCode) {
		this.countryShortCode = countryShortCode;
	}

	@JsonProperty("regions")
	public List<Region> getRegions() {
		return regions;
	}

	@JsonProperty("regions")
	public void setRegions(List<Region> regions) {
		this.regions = regions;
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"name",
	"shortCode"
})
class Region {

	@JsonProperty("name")
	private String name;
	@JsonProperty("shortCode")
	private String shortCode;
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

	@JsonProperty("shortCode")
	public String getShortCode() {
		return shortCode;
	}

	@JsonProperty("shortCode")
	public void setShortCode(String shortCode) {
		this.shortCode = shortCode;
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