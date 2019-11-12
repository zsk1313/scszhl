package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.ClientDynaSqlProvider;
import org.zhl.scs.domain.Client;

@Mapper
public interface ClientDao{

	@InsertProvider(type=ClientDynaSqlProvider.class,method="insertClient")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Client entity);

	@UpdateProvider(type=ClientDynaSqlProvider.class,method="updateClient")
	void update(Client entity);

	@Delete(" delete from tb_client where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=ClientDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_client where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="id",property="sensorNodes",many=@Many(select="org.zhl.scs.dao.SensorNodeDao.selectByClientId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="controllerNodes",many=@Many(select="org.zhl.scs.dao.ControllerNodeDao.selectByClientId",fetchType=FetchType.LAZY))
	})
	Client selectById(Integer id);

	@SelectProvider(type=ClientDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="id",property="sensorNodes",many=@Many(select="org.zhl.scs.dao.SensorNodeDao.selectByClientId",fetchType=FetchType.LAZY)),
		@Result(column="id",property="controllerNodes",many=@Many(select="org.zhl.scs.dao.ControllerNodeDao.selectByClientId",fetchType=FetchType.LAZY))
	})
	List<Client> selectByPage(Map<String, Object> params);

	@Select("select * from tb_client where id = #{client_id}")
	Client selectByIdWithClientId(@Param("client_id") Integer id);

}