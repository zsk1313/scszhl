package org.zhl.scs.dao;

import java.util.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.zhl.scs.dao.provider.JobDynaSqlProvider;
import org.zhl.scs.domain.Job;

@Mapper
public interface JobDao{

	@InsertProvider(type=JobDynaSqlProvider.class,method="insertJob")
	@Options(useGeneratedKeys=true,keyProperty="id")
	void save(Job entity);

	@UpdateProvider(type=JobDynaSqlProvider.class,method="updateJob")
	void update(Job entity);

	@Delete(" delete from tb_job where id = #{id} ")
	void deleteById(Integer id);

	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);

	@Select("select * from tb_job where ID = #{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="id",property="teachers",many=@Many(select="org.zhl.scs.dao.TeacherDao.selectByJobId",fetchType=FetchType.LAZY))
	})
	Job selectById(Integer id);

	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWithParam")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="id",property="teachers",many=@Many(select="org.zhl.scs.dao.TeacherDao.selectByJobId",fetchType=FetchType.LAZY))
	})
	List<Job> selectByPage(Map<String, Object> params);

	@Select("select * from tb_job where id = #{job_id}")
	Job selectByIdWithJobId(@Param("job_id") Integer id);

}