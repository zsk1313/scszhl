package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.UserDynaSqlProvider;
import org.zhl.scs.domain.User;

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
		@Result(column="role_id",property="role",one=@One(select="org.zhl.scs.dao.RoleDao.selectByIdWithRoleId",fetchType= FetchType.EAGER)),
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
		@Result(column="role_id",property="role",one=@One(select="org.zhl.scs.dao.RoleDao.selectByIdWithRoleId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByUserId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="userscurity",one=@One(select="org.zhl.scs.dao.UserscurityDao.selectByUserId",fetchType=FetchType.EAGER))
	})
	List<User> selectByPage(Map<String, Object> params);

	@Select("select * from tb_user where role_id = #{id}")
	List<User> selectByRoleId(Integer id);

	@Select("select * from tb_user where id = #{user_id}")
	User selectByIdWithUserId(@Param("user_id") Integer id);

}