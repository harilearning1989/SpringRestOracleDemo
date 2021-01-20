package com.example.demo.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"id",
	"countries"
})
public class AllCountriesRegion {

	@JsonProperty("id")
	private String id;
	@JsonProperty("countries")
	private List<Country> countries = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("id")
	public String getId() {
		return id;
	}

	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("countries")
	public List<Country> getCountries() {
		return countries;
	}

	@JsonProperty("countries")
	public void setCountries(List<Country> countries) {
		this.countries = countries;
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
	"alpha2",
	"alpha3",
	"countrycode",
	"iso_31662",
	"region",
	"subregion",
	"intermediateregion",
	"regioncode",
	"subregioncode",
	"intermediateregioncode"
})
class Country {

	@JsonProperty("name")
	private String name;
	@JsonProperty("alpha2")
	private String alpha2;
	@JsonProperty("alpha3")
	private String alpha3;
	@JsonProperty("countrycode")
	private String countrycode;
	@JsonProperty("iso_31662")
	private String iso31662;
	@JsonProperty("region")
	private String region;
	@JsonProperty("subregion")
	private String subregion;
	@JsonProperty("intermediateregion")
	private String intermediateregion;
	@JsonProperty("regioncode")
	private String regioncode;
	@JsonProperty("subregioncode")
	private String subregioncode;
	@JsonProperty("intermediateregioncode")
	private String intermediateregioncode;
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

	@JsonProperty("alpha2")
	public String getAlpha2() {
		return alpha2;
	}

	@JsonProperty("alpha2")
	public void setAlpha2(String alpha2) {
		this.alpha2 = alpha2;
	}

	@JsonProperty("alpha3")
	public String getAlpha3() {
		return alpha3;
	}

	@JsonProperty("alpha3")
	public void setAlpha3(String alpha3) {
		this.alpha3 = alpha3;
	}

	@JsonProperty("countrycode")
	public String getCountrycode() {
		return countrycode;
	}

	@JsonProperty("countrycode")
	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	@JsonProperty("iso_31662")
	public String getIso31662() {
		return iso31662;
	}

	@JsonProperty("iso_31662")
	public void setIso31662(String iso31662) {
		this.iso31662 = iso31662;
	}

	@JsonProperty("region")
	public String getRegion() {
		return region;
	}

	@JsonProperty("region")
	public void setRegion(String region) {
		this.region = region;
	}

	@JsonProperty("subregion")
	public String getSubregion() {
		return subregion;
	}

	@JsonProperty("subregion")
	public void setSubregion(String subregion) {
		this.subregion = subregion;
	}

	@JsonProperty("intermediateregion")
	public String getIntermediateregion() {
		return intermediateregion;
	}

	@JsonProperty("intermediateregion")
	public void setIntermediateregion(String intermediateregion) {
		this.intermediateregion = intermediateregion;
	}

	@JsonProperty("regioncode")
	public String getRegioncode() {
		return regioncode;
	}

	@JsonProperty("regioncode")
	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}

	@JsonProperty("subregioncode")
	public String getSubregioncode() {
		return subregioncode;
	}

	@JsonProperty("subregioncode")
	public void setSubregioncode(String subregioncode) {
		this.subregioncode = subregioncode;
	}

	@JsonProperty("intermediateregioncode")
	public String getIntermediateregioncode() {
		return intermediateregioncode;
	}

	@JsonProperty("intermediateregioncode")
	public void setIntermediateregioncode(String intermediateregioncode) {
		this.intermediateregioncode = intermediateregioncode;
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
