package org.fkit.hrm.dao;

import static org.fkit.hrm.util.common.HrmConstants.JOBTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.fkit.hrm.dao.provider.JobDynaSqlProvider;
import org.fkit.hrm.domain.Job;


public interface JobDao {

	// 动态查询
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	List<Job> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	@Select("select * from "+JOBTABLE+" ")
	List<Job> selectAllJob();
	
	@Select("select * from "+JOBTABLE+" where ID = #{id}")
	Job selectById(int id);

	// 根据id删除部门
	@Delete(" delete from "+JOBTABLE+" where id = #{id} ")
	void deleteById(Integer id);
	
	// 动态插入部门
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	void save(Job job);
	
	// 动态修改部门
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	void update(Job job);
}
