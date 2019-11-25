package org.zhl.scs.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.MenuDynaSqlProvider;
import org.zhl.scs.domain.Menu;

import java.util.List;
import java.util.Map;

/**
 * 资源Dao接口
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
@Mapper
public interface MenuDao {
    @InsertProvider(type=MenuDynaSqlProvider.class,method="insertMenu")
    @Options(useGeneratedKeys=true,keyProperty="id")
    void save(Menu entity);

    @UpdateProvider(type=MenuDynaSqlProvider.class,method="updateMenu")
    void update(Menu entity);

    @Delete(" delete from tb_menu where id = #{id} ")
    void deleteById(Integer id);

    @SelectProvider(type=MenuDynaSqlProvider.class,method="count")
    Integer count(Map<String, Object> params);

    @Select("select * from tb_menu where ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="pattern",property="pattern"),
            @Result(column="id",property="roles",many=@Many(select="org.zhl.scs.dao.RoleDao.selectByMenuId",fetchType=FetchType.LAZY))
    })
    Menu selectById(Integer id);

    @SelectProvider(type=MenuDynaSqlProvider.class,method="selectWithParam")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="pattern",property="pattern"),
            @Result(column="id",property="roles",many=@Many(select="org.zhl.scs.dao.RoleDao.selectByMenuId"))
    })
    List<Menu> selectByPage(Map<String, Object> params);

    @Select("select * from tb_menu where id in (select menu_id from menu_role where role_id = #{id} )")
    List<Menu> selectByRoleId(Integer id);

    /**
     * 批量插入该资源所需角色
     * @param entity 资源实例
     */
    @InsertProvider(type=MenuDynaSqlProvider.class,method="insertRoles")
    void insertRoles(Menu entity);

    @Select("select * from tb_menu")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="pattern",property="pattern"),
            @Result(column="id",property="roles",many=@Many(select="org.zhl.scs.dao.RoleDao.selectByMenuId",fetchType= FetchType.LAZY))
    })
    List<Menu> getAllMenus();

    /**
     * 批量搜索资源
     * @param params (key:menuIds,value:资源id集合)
     * @return 符合该资源id集合的资源类集合
     */
    @SelectProvider(type = MenuDynaSqlProvider.class,method = "selectByIds")
    List<Menu> selectByIds(Map<String, Object> params);

    /**
     * 删除该资源与角色的关联消息
     * @param entity 资源实例
     */
    @Delete("delete from menu_role where menu_id = #{id}")
    void deleteRoles(Menu entity);
}
