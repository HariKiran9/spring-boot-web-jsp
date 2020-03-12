package com.hk.dojo;

import java.io.Serializable;

import org.apache.log4j.Logger;

public class CountryLanguage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private static final Logger log = Logger.getLogger(City.class);
	private String countryCode;
	private String language;
	private String ifOfficial;
	private float percentage;

	public CountryLanguage() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		log.info("CountryLanguage [countryCode=" + countryCode + ", language=" + language + ", ifOfficial=" + ifOfficial
				+ ", percentage=" + percentage + "]");
		return "CountryLanguage [countryCode=" + countryCode + ", language=" + language + ", ifOfficial=" + ifOfficial
				+ ", percentage=" + percentage + "]";
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the ifOfficial
	 */
	public String getIfOfficial() {
		return ifOfficial;
	}

	/**
	 * @param ifOfficial the ifOfficial to set
	 */
	public void setIfOfficial(String ifOfficial) {
		this.ifOfficial = ifOfficial;
	}

	/**
	 * @return the percentage
	 */
	public float getPercentage() {
		return percentage;
	}

	/**
	 * @param percentage the percentage to set
	 */
	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

}
