package org.fkit.hrm.dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import org.fkit.hrm.domain.Job;

import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;


public class JobDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(final Map<String, Object> params){	
		System.out.println(params);
		final String sql =  new SQL(){	
				{
				SELECT("J.*,ROWNUM RN") ;
				FROM(JOBTABLE+" J");
				if(params.get("job") != null){
					Job job= (Job)params.get("job");
					if(job.getName() != null && !job.getName().equals(""))
					{
						  WHERE("  name LIKE CONCAT(CONCAT('%',#{job.name}),'%') ");	
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
	
	
	// 动态查询总数量
	public String count(final Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(JOBTABLE);
				if(params.get("job") != null){
					Job job = (Job) params.get("job");
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT(CONCAT('%',#{job.name}),'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertJob(final Job job){
		
		return new SQL(){
			{
				INSERT_INTO(JOBTABLE);
			    VALUES("id","seq_tb_user.nextval");
				if(job.getName() != null && !job.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(job.getRemark() != null && !job.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updateJob(final Job job){
		
		return new SQL(){
			{
				UPDATE(JOBTABLE);
				if(job.getName() != null){
					SET(" name = #{name} ");
				}
				if(job.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}


}
