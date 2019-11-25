package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;
import org.zhl.scs.dao.provider.SensorNodeDynaSqlProvider;
import org.zhl.scs.domain.SensorNode;

@Repository
@Mapper
public interface SensorNodeDao{

	@InsertProvider(type=SensorNodeDynaSqlProvider.class,method="insertSensorNode")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(SensorNode entity);

	@UpdateProvider(type=SensorNodeDynaSqlProvider.class,method="updateSensorNode")
	void update(SensorNode entity);

	@Delete(" delete from tb_sensor_node where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=SensorNodeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_sensor_node where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="time",property="time",javaType=java.util.Date.class),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		@Result(column="fundescription",property="fundescription"),
		@Result(column="address",property="address"),
		@Result(column="flag",property="flag"),
		@Result(column="client_id",property="client",one=@One(select="org.zhl.scs.dao.ClientDao.selectByIdWithClientId",fetchType=FetchType.EAGER))
	})
	SensorNode selectById(Integer id);

	@SelectProvider(type=SensorNodeDynaSqlProvider.class,method="selectWithParam")
	@Results(id = "full_sensor", value = {
		@Result(id=true,column="id",property="id"),
		@Result(column="code",property="code"),
		@Result(column="time",property="time",javaType=java.util.Date.class),
		@Result(column="type",property="type"),
		@Result(column="status",property="status"),
		@Result(column="fundescription",property="fundescription"),
		@Result(column="address",property="address"),
		@Result(column="flag",property="flag"),
		@Result(column="client_id",property="client",one=@One(select="org.zhl.scs.dao.ClientDao.selectByIdWithClientId",fetchType=FetchType.EAGER))
	})
	List<SensorNode> selectByPage(Map<String, Object> params);

	@Select("select * from tb_sensor_node where client_id = #{id}")
	List<SensorNode> selectByClientId(Integer id);

	@Select("select * from tb_sensor_node")
	@ResultMap(value = "full_sensor")
	List<SensorNode> selectAll();

}