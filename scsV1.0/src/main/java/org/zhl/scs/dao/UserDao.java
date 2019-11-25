package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.UserDynaSqlProvider;
import org.zhl.scs.domain.User;

/**
 * 用户Dao接口
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
@Mapper
public interface UserDao{

	@InsertProvider(type=UserDynaSqlProvider.class,method="insertUser")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(User entity);

	@UpdateProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(User entity);

	@Delete(" delete from tb_user where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_user where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="id",property="roles",many=@Many(select="org.zhl.scs.dao.RoleDao.selectByUserId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="userscurity",one=@One(select="org.zhl.scs.dao.UserscurityDao.selectByUserId",fetchType=FetchType.EAGER))
	})
	User selectById(Integer id);

	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="username",property="username"),
		@Result(column="password",property="password"),
		@Result(column="id",property="roles",many=@Many(select="org.zhl.scs.dao.RoleDao.selectByUserId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="userscurity",one=@One(select="org.zhl.scs.dao.UserscurityDao.selectByUserId",fetchType=FetchType.EAGER))
	})
	List<User> selectByPage(Map<String, Object> params);

	@Select("select * from tb_user where id = #{user_id}")
	User selectByIdWithUserId(@Param("user_id") Integer id);

	@Select("select * from tb_user where id in (select user_id from user_role where role_id = #{id} )")
	List<User> selectByRoleId(Integer id);

	@InsertProvider(type=UserDynaSqlProvider.class,method="insertRoles")
	void insertRoles(User entity);

	@Delete("delete from user_role where user_id = #{id}")
	void deleteRoles(User entity);

	@Select("select * from tb_user where username=#{username}")
	User loadUserByUsername(String username);
}