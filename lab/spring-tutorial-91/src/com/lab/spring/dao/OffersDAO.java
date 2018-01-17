package com.lab.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("offersDao")
public class OffersDAO {
	private NamedParameterJdbcTemplate jdbc;
	
	public OffersDAO() {
		System.out.println("========= OffersDAO is loaded ================");
	}
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
		System.out.println("============ init data source =============");
	}

	public List<Offer> getOffers() {
		
		//MapSqlParameterSource params = new MapSqlParameterSource("name","Sue");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", "Sue");
		
		return jdbc.query("select * from offers", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				
				return offer;
			}
			
		});
	}
	
	@Transactional
	public int[] create(List<Offer> offer) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offer.toArray());
		
		return jdbc.batchUpdate("insert into offers (id, name, text, email) values(:id, :name, :text, :email)", params);
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offers set name=:name, text=:text, email=:email where id=:id",params) == 1;
	}
	
	public boolean create(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offers (name, text, email) values(:name, :text, :email)",params) == 1;
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
		
		//jdbc.getJdbcOperations()
		return jdbc.update("delete from offers where id = :id", params) == 1;
	}
	
	public Offer getOffer(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);
	
		return jdbc.queryForObject("select * from offers where id = :id", params, new RowMapper<Offer>() {

			public Offer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Offer offer = new Offer();
				
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));
				
				return offer;
			}
			
		});
	}

}