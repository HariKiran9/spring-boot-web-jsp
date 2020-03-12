/**
 * 
 */
package com.hk.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.hk.dojo.Address;
import com.hk.dojo.City;
import com.hk.dojo.Country;
import com.hk.dojo.CountryLanguage;

/**
 * @author bc887d
 *
 */
public class CityDAO {

	private static final Logger log = Logger.getLogger(ActorDAO.class);

	public List<City> getAllCities() {
		List<City> list = new ArrayList<>();
		Connection con = null;
		try {
			con = MysqlCon.getConnection("world");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from city");

			while (rs.next()) {
				City city = new City();
				city.setId(rs.getInt(1));
				city.setName(rs.getString(2));
				String countryCode = rs.getString(3);
				city.setCountryCode(countryCode);
				city.setDistrict(rs.getString(4));
				city.setPopulation(rs.getLong(5));

				PreparedStatement clptstmt = con
						.prepareStatement("select * from countrylanguage where countrycode = ? ");
				clptstmt.setString(1, countryCode);
				ResultSet clrs = clptstmt.executeQuery();
				while (clrs.next()) {
					CountryLanguage cLanguage = new CountryLanguage();
					cLanguage.setCountryCode(clrs.getString("countrycode"));
					cLanguage.setLanguage(clrs.getString("language"));
					cLanguage.setIfOfficial(clrs.getString("isofficial"));
					cLanguage.setPercentage(clrs.getFloat("percentage"));
					city.setCountryLanguage(cLanguage);
				} // while

				PreparedStatement ptstmt = con.prepareStatement("select * from country where code = ? ");
				ptstmt.setString(1, countryCode);
				ResultSet crs = ptstmt.executeQuery();
				while (crs.next()) {
					Country country = new Country();
					country.setCode(crs.getString("code"));
					country.setName(crs.getString("name"));
					country.setContinent(crs.getString("continent"));
					country.setRegion(crs.getString("region"));
					country.setSurfaceArea(crs.getFloat("surfacearea"));
					country.setIndepYear(crs.getInt("indepyear"));
					country.setPopulation(crs.getInt("population"));
					country.setLifeExpectancy(crs.getFloat("lifeexpectancy"));
					country.setGnp(crs.getFloat("gnp"));
					country.setGnpold(crs.getFloat("gnpold"));
					country.setLocalName(crs.getString("localname"));
					country.setGovernemntForm(crs.getString("governmentform"));
					country.setHeadOfState(crs.getString("headofstate"));
					country.setCapital(crs.getInt("capital"));
					country.setCode2(crs.getString("code2"));
					city.setCountry(country);
				} // while

				list.add(city);
			} // while

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlCon.closeConnection(con);
		} // finally
		log.info("List Size : " + list.size());
		return list;
	}

	private static final int BUFFER_SIZE = 4096;

	public List<City> getSakilaAddress() {
		List<City> list = new ArrayList<>();
		Connection con = null;
		try {
			con = MysqlCon.getConnection("sakila");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from city c, address a where c.city_id = a.city_id");

			while (rs.next()) {
				City city = new City();
				city.setCityId(rs.getInt("city_id"));
				city.setCity(rs.getString("city"));

				Address address = new Address();
				address.setAddressId(rs.getInt("address_id"));
				try {
					InputStream is = rs.getBinaryStream("location");
					if (is != null) {
						File image = new File(
								"C:\\HK\\Waste\\" + address.getAddressId() + "\\" + address.getAddressId() + ".jpg");
						FileOutputStream fos = new FileOutputStream(image);

						byte[] buffer = new byte[1];

						while (is.read(buffer) > 0) {
							fos.write(buffer);
						}
						fos.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					Blob blob = rs.getBlob("location");
					if (blob != null) {
						File image2 = new File(
								"C:\\HK\\Waste2\\" + address.getAddressId() + "\\" + address.getAddressId() + ".jpg");
						InputStream inputStream = blob.getBinaryStream();
						OutputStream outputStream = new FileOutputStream(image2);

						int bytesRead = -1;
						byte[] buffer2 = new byte[BUFFER_SIZE];
						while ((bytesRead = inputStream.read(buffer2)) != -1) {
							outputStream.write(buffer2, 0, bytesRead);
						}

						inputStream.close();
						outputStream.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				address.setAddress(rs.getString("address"));
				address.setAddress2(rs.getString("address2"));
				address.setDistrict(rs.getString("district"));
				address.setPostalCode(rs.getInt("postal_code"));
				address.setPhone(rs.getLong("phone"));

				city.setAddress(address);
				list.add(city);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			MysqlCon.closeConnection(con);
		} // finally
		log.info("List Size : " + list.size());
		return list;
	}

}
