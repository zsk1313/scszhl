package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.zhl.scs.dao.provider.ControllerNodeDynaSqlProvider;
import org.zhl.scs.domain.ControllerNode;

@Repository
@Mapper
public interface ControllerNodeDao{

	@InsertProvider(type=ControllerNodeDynaSqlProvider.class,method="insertControllerNode")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(ControllerNode entity);

	@UpdateProvider(type=ControllerNodeDynaSqlProvider.class,method="updateControllerNode")
	void update(ControllerNode entity);

	@Delete(" delete from tb_controller_node where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=ControllerNodeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_controller_node where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="time",property="time",javaType=java.util.Date.class),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		@Result(column="value",property="value"),
		@Result(column="address",property="address"),
		@Result(column="flag",property="flag"),
		@Result(column="client_id",property="client",one=@One(select="org.zhl.scs.dao.ClientDao.selectByIdWithClientId",fetchType=FetchType.EAGER))
	})
	ControllerNode selectById(Integer id);

	@SelectProvider(type=ControllerNodeDynaSqlProvider.class,method="selectWithParam")
	@Results(id = "full_controller", value = {
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="time",property="time",javaType=java.util.Date.class),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		@Result(column="value",property="value"),
		@Result(column="address",property="address"),
		@Result(column="flag",property="flag"),
		@Result(column="client_id",property="client",one=@One(select="org.zhl.scs.dao.ClientDao.selectByIdWithClientId",fetchType=FetchType.EAGER))
	})
	List<ControllerNode> selectByPage(Map<String, Object> params);

	@Select("select * from tb_controller_node where client_id = #{id}")
	List<ControllerNode> selectByClientId(Integer id);

	@Select("select * from tb_controller_node")
	@ResultMap(value = "full_controller")
	List<ControllerNode> selectAll();

}