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

	// ���ݵ�¼���������ѯԱ��
	@Select("select * from "+USERTABLE+" where loginname = #{loginname} and password = #{password}")
	User selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password);
	//��̬����
	@InsertProvider(type=UserDynaSQLProvider.class,method="insertUser")
	int insertUser(User user);

	//��ѯ��������
	@Select("select * from "+USERTABLE)
	List<User> selectAll();
	
	
	
	// ��̬��ѯ
	@SelectProvider(type=UserDynaSQLProvider.class,method="selectWhitParam")
	List<User> selectByPage(Map<String, Object> params);
	
	// ���ݲ�����ѯ�û�����
	@SelectProvider(type=UserDynaSQLProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	
	//����IDѡ���û�
	@Select("select * from "+USERTABLE+" where id=#{id}")
	User selectById(@Param("id") int id);
	
	//��̬�����û�
	@UpdateProvider(type=UserDynaSQLProvider.class,method="updateUser")
    int updateUser(User user);	

    //ɾ���û�
	@Delete("delete from "+USERTABLE+" where id=#{id}")
	int deleteUserById(@Param("id") int id);
	
	
}
