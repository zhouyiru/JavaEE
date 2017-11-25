package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Dept;
import static org.fkit.hrm.util.common.HrmConstants.DEPTTABLE;


public class DeptDynaSqlProvider {
	// ��ҳ��̬��ѯ
	public String selectWhitParam(final Map<String, Object> params){	
		System.out.println(params);
		final String sql =  new SQL(){	
				{
				SELECT("D.*,ROWNUM RN") ;
				FROM(DEPTTABLE+" D");
				if(params.get("dept") != null){
					Dept dept= (Dept)params.get("dept");
					if(dept.getName() != null && !dept.getName().equals(""))
					{
						  WHERE("  name LIKE CONCAT(CONCAT('%',#{dept.name}),'%') ");	
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
	
	
	// ��̬��ѯ������
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(DEPTTABLE);
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() != null && !dept.getName().equals("")){
						WHERE("  name LIKE CONCAT(CONCAT('%',#{dept.name}),'%') ");
					}
				}
			}
		}.toString();
	}	
	// ��̬����
	public String insertDept(final Dept dept){
		
		return new SQL(){
			{
				INSERT_INTO(DEPTTABLE);
			    VALUES("id","seq_tb_user.nextval");
				if(dept.getName() != null && !dept.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(dept.getRemark() != null && !dept.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}
	
	// ��̬����
	public String updateDept(final Dept dept){
		
		return new SQL(){
			{
				UPDATE(DEPTTABLE);
				if(dept.getName() != null){
					SET(" name = #{name} ");
				}
				if(dept.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}
