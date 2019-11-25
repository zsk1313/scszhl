package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.RoleDynaSqlProvider;
import org.zhl.scs.domain.Role;

/**
 * 角色Dao接口
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
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
		@Result(column="id",property="users",many=@Many(select="org.zhl.scs.dao.UserDao.selectByRoleId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="menus",many=@Many(select="org.zhl.scs.dao.MenuDao.selectByRoleId",fetchType=FetchType.LAZY))
	})
	Role selectById(Integer id);

	@SelectProvider(type=RoleDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="description",property="description"),
		@Result(column="id",property="users",many=@Many(select="org.zhl.scs.dao.UserDao.selectByRoleId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="menus",many=@Many(select="org.zhl.scs.dao.MenuDao.selectByRoleId",fetchType=FetchType.LAZY))
	})
	List<Role> selectByPage(Map<String, Object> params);

	@Select("select * from tb_role where id in (select role_id from user_role where user_id = #{id} )")
	List<Role> selectByUserId(Integer id);

	@Select("select * from tb_role where id in (select role_id from menu_role where menu_id = #{id} )")
	List<Role> selectByMenuId(Integer id);

	/**
	 * 批量插入用有该角色的用户
	 * @param entity 角色实例
	 */
	@InsertProvider(type=RoleDynaSqlProvider.class,method="insertUsers")
	void insertUsers(Role entity);

	/**
	 * 批量搜索角色
	 * @param params (key:roleIds,value:角色id集合)
	 * @return 符合该角色id集合的角色类集合
	 */
	@SelectProvider(type = RoleDynaSqlProvider.class,method = "selectByIds")
	List<Role> selectByIds(Map<String, Object> params);

	/**
	 * 批量插入该角色可访问的资源
	 * @param entity 角色实例
	 */
	@InsertProvider(type=RoleDynaSqlProvider.class,method="insertMenus")
	void insertMenus(Role entity);

	/**
	 * 删除该角色与资源的关联消息
	 * @param entity 角色实例
	 */
	@Delete("delete from menu_role where role_id = #{id}")
	void deleteMenus(Role entity);

	/**
	 * 删除该角色与用户的关联消息
	 * @param entity 角色实例
	 */
	@Delete("delete from user_role where role_id = #{id}")
	void deleteUsers(Role entity);
}