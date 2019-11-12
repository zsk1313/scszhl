package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.ImageDynaSqlProvider;
import org.zhl.scs.domain.Image;

@Mapper
public interface ImageDao{

	@InsertProvider(type=ImageDynaSqlProvider.class,method="insertImage")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Image entity);

	@UpdateProvider(type=ImageDynaSqlProvider.class,method="updateImage")
	void update(Image entity);

	@Delete(" delete from tb_image where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=ImageDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_image where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="path",property="path"),
		@Result(column="id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="clazz",one=@One(select="org.zhl.scs.dao.ClazzDao.selectByImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByImageId",fetchType=FetchType.EAGER))
	})
	Image selectById(Integer id);

	@SelectProvider(type=ImageDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="path",property="path"),
		@Result(column="id",property="teacher",one=@One(select="org.zhl.scs.dao.TeacherDao.selectByImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="clazz",one=@One(select="org.zhl.scs.dao.ClazzDao.selectByImageId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="student",one=@One(select="org.zhl.scs.dao.StudentDao.selectByImageId",fetchType=FetchType.EAGER))
	})
	List<Image> selectByPage(Map<String, Object> params);

	@Select("select * from tb_image where id = #{image_id}")
	Image selectByIdWithImageId(@Param("image_id") Integer id);

}