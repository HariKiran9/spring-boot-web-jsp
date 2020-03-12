package com.hk.dojo;

import java.io.Serializable;

public class Country implements Serializable {

	private static final long serialVersionUID = 1L;

	private String code;
	private String name;
	private String continent;
	private String region;
	private float surfaceArea;
	private int indepYear;
	private long population;
	private float lifeExpectancy;
	private float gnp;
	private float gnpold;
	private String localName;
	private String governemntForm;
	private String headOfState;
	private long capital;
	private String code2;

	private int countryId;
	private String country;
	private String lastUpdate;

	public Country() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", region=" + region
				+ ", surfaceArea=" + surfaceArea + ", indepYear=" + indepYear + ", population=" + population
				+ ", lifeExpectancy=" + lifeExpectancy + ", gnp=" + gnp + ", gnpold=" + gnpold + ", localName="
				+ localName + ", governemntForm=" + governemntForm + ", headOfState=" + headOfState + ", capital="
				+ capital + ", code2=" + code2 + ", countryId=" + countryId + ",country=" + country + ", lastUpdate="
				+ lastUpdate + "]";
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the continent
	 */
	public String getContinent() {
		return continent;
	}

	/**
	 * @param continent the continent to set
	 */
	public void setContinent(String continent) {
		this.continent = continent;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the surfaceArea
	 */
	public float getSurfaceArea() {
		return surfaceArea;
	}

	/**
	 * @param surfaceArea the surfaceArea to set
	 */
	public void setSurfaceArea(float surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	/**
	 * @return the indepYea
	 */
	public int getIndepYear() {
		return indepYear;
	}

	/**
	 * @param indepYea the indepYea to set
	 */
	public void setIndepYear(int indepYear) {
		this.indepYear = indepYear;
	}

	/**
	 * @return the population
	 */
	public long getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(long population) {
		this.population = population;
	}

	/**
	 * @return the lifeExpectancy
	 */
	public float getLifeExpectancy() {
		return lifeExpectancy;
	}

	/**
	 * @param lifeExpectancy the lifeExpectancy to set
	 */
	public void setLifeExpectancy(float lifeExpectancy) {
		this.lifeExpectancy = lifeExpectancy;
	}

	/**
	 * @return the gnp
	 */
	public float getGnp() {
		return gnp;
	}

	/**
	 * @param gnp the gnp to set
	 */
	public void setGnp(float gnp) {
		this.gnp = gnp;
	}

	/**
	 * @return the gnpold
	 */
	public float getGnpold() {
		return gnpold;
	}

	/**
	 * @param gnpold the gnpold to set
	 */
	public void setGnpold(float gnpold) {
		this.gnpold = gnpold;
	}

	/**
	 * @return the localName
	 */
	public String getLocalName() {
		return localName;
	}

	/**
	 * @param localName the localName to set
	 */
	public void setLocalName(String localName) {
		this.localName = localName;
	}

	/**
	 * @return the governemntFirm
	 */
	public String getGovernemntForm() {
		return governemntForm;
	}

	/**
	 * @param governemntFirm the governemntFirm to set
	 */
	public void setGovernemntForm(String governemntForm) {
		this.governemntForm = governemntForm;
	}

	/**
	 * @return the headOfState
	 */
	public String getHeadOfState() {
		return headOfState;
	}

	/**
	 * @param headOfState the headOfState to set
	 */
	public void setHeadOfState(String headOfState) {
		this.headOfState = headOfState;
	}

	/**
	 * @return the capital
	 */
	public long getCapital() {
		return capital;
	}

	/**
	 * @param capital the capital to set
	 */
	public void setCapital(long capital) {
		this.capital = capital;
	}

	/**
	 * @return the code2
	 */
	public String getCode2() {
		return code2;
	}

	/**
	 * @param code2 the code2 to set
	 */
	public void setCode2(String code2) {
		this.code2 = code2;
	}

	/**
	 * @return the countryId
	 */
	public int getCountryId() {
		return countryId;
	}

	/**
	 * @param countryId the countryId to set
	 */
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the lastUpdate
	 */
	public String getLastUpdate() {
		return lastUpdate;
	}

	/**
	 * @param lastUpdate the lastUpdate to set
	 */
	public void setLastUpdate(String lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

}
