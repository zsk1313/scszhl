package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Teacher;

public class TeacherDynaSqlProvider {

	public String insertTeacher(Teacher entity){
		return new SQL(){
			{
				INSERT_INTO("tb_teacher");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getName() != null && !entity.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(entity.getUid() != null && !entity.getUid().equals("")){
					VALUES("uid", "#{uid}");
				}
				if(entity.getSex() != null && !entity.getSex().equals("")){
					VALUES("sex", "#{sex}");
				}
				if(entity.getBirthday() != null){
					VALUES("birthday", "#{birthday}");
				}
				if(entity.getEntertime() != null){
					VALUES("entertime", "#{entertime}");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					VALUES("address", "#{address}");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					VALUES("description", "#{description}");
				}
				if(entity.getUser() != null){
					VALUES("user_id", "#{user.id}");
				}
				if(entity.getImage() != null){
					VALUES("image_id", "#{image.id}");
				}
				if(entity.getJob() != null){
					VALUES("job_id", "#{job.id}");
				}
			}
		}.toString();
	}

	public String updateTeacher(Teacher entity){
		return new SQL(){
			{
				UPDATE("tb_teacher");
				if(entity.getName() != null && !entity.getName().equals("")){
					SET(" name = #{name} ");
				}
				if(entity.getUid() != null && !entity.getUid().equals("")){
					SET(" uid = #{uid} ");
				}
				if(entity.getSex() != null && !entity.getSex().equals("")){
					SET(" sex = #{sex} ");
				}
				if(entity.getBirthday() != null){
					SET(" birthday = #{birthday} ");
				}
				if(entity.getEntertime() != null){
					SET(" entertime = #{entertime} ");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					SET(" address = #{address} ");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					SET(" description = #{description} ");
				}
				if(entity.getUser() != null){
					SET(" user_id = #{user.id} ");
				}
				if(entity.getImage() != null){
					SET(" image_id = #{image.id} ");
				}
				if(entity.getJob() != null){
					SET(" job_id = #{job.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_teacher");
				if(params.get("teacher") != null){
					Teacher entity = (Teacher)params.get("teacher");
					if(entity.getId() != null){
						WHERE(" id = #{teacher.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{teacher.name},'%') ");
					}
					if(entity.getUid() != null && !entity.getUid().equals("")){
						WHERE(" uid LIKE CONCAT ('%',#{teacher.uid},'%') ");
					}
					if(entity.getSex() != null && !entity.getSex().equals("")){
						WHERE(" sex LIKE CONCAT ('%',#{teacher.sex},'%') ");
					}
					if(entity.getBirthday() != null){
						WHERE(" birthday = #{teacher.birthday} ");
					}
					if(entity.getEntertime() != null){
						WHERE(" entertime = #{teacher.entertime} ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{teacher.address},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{teacher.description},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{teacher.user.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{teacher.image.id} ");
					}
					if(entity.getJob() != null){
						WHERE(" job_id = #{teacher.job.id} ");
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
				FROM("tb_teacher");
				if(params.get("teacher") != null){
					Teacher entity = (Teacher)params.get("teacher");
					if(entity.getId() != null){
						WHERE(" id = #{teacher.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{teacher.name},'%') ");
					}
					if(entity.getUid() != null && !entity.getUid().equals("")){
						WHERE(" uid LIKE CONCAT ('%',#{teacher.uid},'%') ");
					}
					if(entity.getSex() != null && !entity.getSex().equals("")){
						WHERE(" sex LIKE CONCAT ('%',#{teacher.sex},'%') ");
					}
					if(entity.getBirthday() != null){
						WHERE(" birthday = #{teacher.birthday} ");
					}
					if(entity.getEntertime() != null){
						WHERE(" entertime = #{teacher.entertime} ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{teacher.address},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{teacher.description},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{teacher.user.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{teacher.image.id} ");
					}
					if(entity.getJob() != null){
						WHERE(" job_id = #{teacher.job.id} ");
					}
				}
			}
		}.toString();
	}

}