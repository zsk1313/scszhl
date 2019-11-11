package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.UserscurityDynaSqlProvider;
import org.zhl.scs.domain.Userscurity;

@Mapper
public interface UserscurityDao{

	@InsertProvider(type=UserscurityDynaSqlProvider.class,method="insertUserscurity")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Userscurity entity);

	@UpdateProvider(type=UserscurityDynaSqlProvider.class,method="updateUserscurity")
	void update(Userscurity entity);

	@Delete(" delete from tb_userscurity where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=UserscurityDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_userscurity where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="fingerpoint",property="fingerpoint"),
		@Result(column="faceid",property="faceid"),
		@Result(column="cardid",property="cardid"),
		@Result(column="user_id",property="user",one=@One(select="org.zhl.scs.dao.UserDao.selectByIdWithUserId",fetchType=FetchType.EAGER))
	})
	Userscurity selectById(Integer id);

	@SelectProvider(type=UserscurityDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="fingerpoint",property="fingerpoint"),
		@Result(column="faceid",property="faceid"),
		@Result(column="cardid",property="cardid"),
		@Result(column="user_id",property="user",one=@One(select="org.zhl.scs.dao.UserDao.selectByIdWithUserId",fetchType=FetchType.EAGER))
	})
	List<Userscurity> selectByPage(Map<String, Object> params);

	@Select("select * from tb_userscurity where user_id = #{id}")
	Userscurity selectByUserId(Integer id);

}