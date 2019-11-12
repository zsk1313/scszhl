package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.ClazzDynaSqlProvider;
import org.zhl.scs.domain.Clazz;

@Mapper
public interface ClazzDao{

	@InsertProvider(type=ClazzDynaSqlProvider.class,method="insertClazz")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Clazz entity);

	@UpdateProvider(type=ClazzDynaSqlProvider.class,method="updateClazz")
	void update(Clazz entity);

	@Delete(" delete from tb_clazz where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=ClazzDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_clazz where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="clazz_num",property="clazzNum"),
		@Result(column="description",property="description"),
		@Result(column="teacher_id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByIdWithTeacherId",fetchType=FetchType.EAGER)),
		@Result(column="image_id",property="image",one=@One(select="org.zhl.scs.dao.ImageDao.selectByIdWithImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="students",many=@Many(select="org.zhl.scs.dao.StudentDao.selectByClazzId",fetchType=FetchType.LAZY))
	})
	Clazz selectById(Integer id);

	@SelectProvider(type=ClazzDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="clazz_num",property="clazzNum"),
		@Result(column="description",property="description"),
		@Result(column="teacher_id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByIdWithTeacherId",fetchType=FetchType.EAGER)),
		@Result(column="image_id",property="image",one=@One(select="org.zhl.scs.dao.ImageDao.selectByIdWithImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="students",many=@Many(select="org.zhl.scs.dao.StudentDao.selectByClazzId",fetchType=FetchType.LAZY))
	})
	List<Clazz> selectByPage(Map<String, Object> params);

	@Select("select * from tb_clazz where teacher_id = #{id}")
	List<Clazz> selectByTeacherId(Integer id);

	@Select("select * from tb_clazz where image_id = #{id}")
	Clazz selectByImageId(Integer id);

	@Select("select * from tb_clazz where id = #{clazz_id}")
	Clazz selectByIdWithClazzId(@Param("clazz_id") Integer id);

}