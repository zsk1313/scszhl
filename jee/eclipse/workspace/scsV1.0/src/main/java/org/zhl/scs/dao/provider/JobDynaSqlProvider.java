package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Job;

public class JobDynaSqlProvider {

	public String insertJob(Job entity){
		return new SQL(){
			{
				INSERT_INTO("tb_job");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getName() != null && !entity.getName().equals("")){
					VALUES("name", "#{name}");
				}
			}
		}.toString();
	}

	public String updateJob(Job entity){
		return new SQL(){
			{
				UPDATE("tb_job");
				if(entity.getName() != null && !entity.getName().equals("")){
					SET(" name = #{name} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_job");
				if(params.get("job") != null){
					Job entity = (Job)params.get("job");
					if(entity.getId() != null){
						WHERE(" id = #{job.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{job.name},'%') ");
					}
				}
			}
		}.toString();
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		return sql;
	}

	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("tb_job");
				if(params.get("job") != null){
					Job entity = (Job)params.get("job");
					if(entity.getId() != null){
						WHERE(" id = #{job.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{job.name},'%') ");
					}
				}
			}
		}.toString();
	}

}