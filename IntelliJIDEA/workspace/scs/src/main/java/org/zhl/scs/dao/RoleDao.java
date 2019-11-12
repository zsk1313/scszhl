package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.RoleDynaSqlProvider;
import org.zhl.scs.domain.Role;

@Mapper
public interface RoleDao{

	@InsertProvider(type=RoleDynaSqlProvider.class,method="insertRole")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Role entity);

	@UpdateProvider(type=RoleDynaSqlProvider.class,method="updateRole")
	void update(Role entity);

	@Delete(" delete from tb_role where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=RoleDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_role where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="description",property="description"),
		@Result(column="id",property="users",many=@Many(select="org.zhl.scs.dao.UserDao.selectByRoleId",fetchType=FetchType.LAZY))
	})
	Role selectById(Integer id);

	@SelectProvider(type=RoleDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="description",property="description"),
		@Result(column="id",property="users",many=@Many(select="org.zhl.scs.dao.UserDao.selectByRoleId",fetchType=FetchType.LAZY))
	})
	List<Role> selectByPage(Map<String, Object> params);

	@Select("select * from tb_role where id = #{role_id}")
	Role selectByIdWithRoleId(@Param("role_id") Integer id);

}