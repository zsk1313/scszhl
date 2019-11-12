package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.TeacherDynaSqlProvider;
import org.zhl.scs.domain.Teacher;

@Mapper
public interface TeacherDao{

	@InsertProvider(type=TeacherDynaSqlProvider.class,method="insertTeacher")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Teacher entity);

	@UpdateProvider(type=TeacherDynaSqlProvider.class,method="updateTeacher")
	void update(Teacher entity);

	@Delete(" delete from tb_teacher where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=TeacherDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_teacher where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="uid",property="uid"),
		@Result(column="sex",property="sex"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="entertime",property="entertime",javaType=java.util.Date.class),
		@Result(column="address",property="address"),
		@Result(column="description",property="description"),
		@Result(column="user_id",property="user",one=@One(select="org.zhl.scs.dao.UserDao.selectByIdWithUserId",fetchType=FetchType.EAGER)),
		@Result(column="image_id",property="image",one=@One(select="org.zhl.scs.dao.ImageDao.selectByIdWithImageId",fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",one=@One(select="org.zhl.scs.dao.JobDao.selectByIdWithJobId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="clazzs",many=@Many(select="org.zhl.scs.dao.ClazzDao.selectByTeacherId",fetchType=FetchType.LAZY))
	})
	Teacher selectById(Integer id);

	@SelectProvider(type=TeacherDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="uid",property="uid"),
		@Result(column="sex",property="sex"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="entertime",property="entertime",javaType=java.util.Date.class),
		@Result(column="address",property="address"),
		@Result(column="description",property="description"),
		@Result(column="user_id",property="user",one=@One(select="org.zhl.scs.dao.UserDao.selectByIdWithUserId",fetchType=FetchType.EAGER)),
		@Result(column="image_id",property="image",one=@One(select="org.zhl.scs.dao.ImageDao.selectByIdWithImageId",fetchType=FetchType.EAGER)),
		@Result(column="job_id",property="job",one=@One(select="org.zhl.scs.dao.JobDao.selectByIdWithJobId",fetchType=FetchType.EAGER)),
		@Result(column="id",property="clazzs",many=@Many(select="org.zhl.scs.dao.ClazzDao.selectByTeacherId",fetchType=FetchType.LAZY))
	})
	List<Teacher> selectByPage(Map<String, Object> params);

	@Select("select * from tb_teacher where user_id = #{id}")
	Teacher selectByUserId(Integer id);

	@Select("select * from tb_teacher where image_id = #{id}")
	Teacher selectByImageId(Integer id);

	@Select("select * from tb_teacher where job_id = #{id}")
	List<Teacher> selectByJobId(Integer id);

	@Select("select * from tb_teacher where id = #{teacher_id}")
	Teacher selectByIdWithTeacherId(@Param("teacher_id") Integer id);

}