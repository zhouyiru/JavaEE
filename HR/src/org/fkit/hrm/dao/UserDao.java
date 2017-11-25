package org.fkit.hrm.dao;

import static org.fkit.hrm.util.common.HrmConstants.USERTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.scripting.xmltags.WhereSqlNode;
import org.fkit.hrm.domain.User;
import org.fkit.hrm.dao.provider.UserDynaSQLProvider;
public interface UserDao {

	// 根据登录名和密码查询员工
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	User selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password);
	//动态插入
	@InsertProvider(type=UserDynaSQLProvider.class,method="insertUser")
	int insertUser(User user);

	//查询所有数据
	@Select("select * from "+USERTABLE)
	List<User> selectAll();
	
	
	
	// 动态查询
	@SelectProvider(type=UserDynaSQLProvider.class,method="selectWhitParam")
	List<User> selectByPage(Map<String, Object> params);
	
	// 根据参数查询用户总数
	@SelectProvider(type=UserDynaSQLProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	
	//根据ID选择用户
	@Select("select * from "+USERTABLE+" where id=#{id}")
	User selectById(@Param("id") int id);
	
	//动态更新用户
	@UpdateProvider(type=UserDynaSQLProvider.class,method="updateUser")
    int updateUser(User user);	

    //删除用户
	@Delete("delete from "+USERTABLE+" where id=#{id}")
	int deleteUserById(@Param("id") int id);
	
	
}
