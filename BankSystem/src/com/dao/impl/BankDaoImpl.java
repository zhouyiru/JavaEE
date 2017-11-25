package com.dao.impl;

import java.util.jar.Attributes.Name;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.dao.BankDao;

public class BankDaoImpl implements BankDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void outMoney(int money, int userid) {
	     //count = count - money
			String sql = "update bank set count=count-:money where userid=:userid";
			MapSqlParameterSource sps = new MapSqlParameterSource();//创建存放sql集合
			sps.addValue("money",money);
			sps.addValue("userid", userid);
			namedParameterJdbcTemplate.update(sql, sps);
			//System.out.println(userid+" out "+money);	
	}

	@Override
	public void inMoney(int money, int userid) {
     //count = count + money
		String sql = "update bank set count=count+:money where userid=:userid";
		MapSqlParameterSource sps = new MapSqlParameterSource();//创建存放sql集合
		sps.addValue("money",money);
		sps.addValue("userid", userid);
		namedParameterJdbcTemplate.update(sql, sps);
		//System.out.println(userid+" in "+money);
	}

}
