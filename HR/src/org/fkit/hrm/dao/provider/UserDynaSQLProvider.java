package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.util.tag.PageModel;
import org.springframework.transaction.annotation.Isolation;

import com.google.common.base.FinalizablePhantomReference;

import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

public class UserDynaSQLProvider {

	/*动态添加数据*/
	public String insertUser(final User user)
	{
		return new SQL(){
			{
			INSERT_INTO(USERTABLE);
			VALUES("id", "seq_tb_user.nextval");
			if(user.getLoginname()!=null)
			{
				VALUES("loginname","#{loginname}");	
			}
			if(user.getPassword()!=null)
			{
				VALUES("password","#{password}");
			}
			if(user.getUsername()!=null)
			{
				VALUES("username","#{username}");
			}
			if(user.getStatus()!=null)
			{
				VALUES("status","#{status}");
			}
		  }
		}.toString();
	}
	
	
	// 动态查询总数量
	public String count(final Map<String, Object> params){
        System.out.println("DAO层，动态SQL语句："+params);
		String sql= new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getLoginname() != null && !user.getLoginname().equals("")){
						WHERE(" loginname like CONCAT(CONCAT('%',#{user.loginname}),'%')");
					
					}
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username like CONCAT(CONCAT('%',#{user.username}),'%')");
					
					}
				}
				
				
				
			}
		}.toString();
		System.out.println("in count!");
		System.out.println(sql);
		return sql;
	}	
	
	
	// 分页动态查询
	public String selectWhitParam(final Map<String, Object> params){
	
		
		System.out.println(params);
		final String sql =  new SQL(){	
				{
				SELECT("U.*,ROWNUM RN") ;
				FROM(USERTABLE+" U");
				if(params.get("user") != null){
					User user = (User)params.get("user");
					if(user.getLoginname() != null && !user.getLoginname().equals("")){
						WHERE(" loginname like CONCAT(CONCAT('%',#{user.loginname}),'%')");
					
					}
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username like CONCAT(CONCAT('%',#{user.username}),'%')");
					
					}
				
					/*******************************************************/
					if(params.get("pageModel")!=null)
					{
						WHERE("ROWNUM<=(#{pageModel.pageSize}*#{pageModel.pageIndex})");
					}
					/*******************************************************/
				}
			
		   }
		}.toString();

		
		String pageSql=new SQL()
		{
			{
				SELECT("*");
				FROM("("+sql+")");
				WHERE("RN>#{pageModel.firstLimitParam}");
			}
		}.toString();
		
		System.out.println("in page!");
		System.out.println(pageSql);
		return pageSql;
	}	
	
	
	public String updateUser(final User user)
	{
		return new SQL()
		{
			{
				UPDATE(USERTABLE);
				if(user.getUsername()!=null)
				{
				    SET(" username=#{username}");
				}
				if(user.getLoginname()!=null)
				{
				    SET(" loginname=#{loginname}");
				}
				if(user.getStatus()!=null)
				{
					SET(" status=#{status}");
				}
				if(user.getPassword()!=null)
				{
					SET(" password=#{password}");
				}
				WHERE("id=#{id}");
		    }
		}.toString();
	}
}
