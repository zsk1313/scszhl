package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Clazz;

public class ClazzDynaSqlProvider {

	public String insertClazz(Clazz entity){
		return new SQL(){
			{
				INSERT_INTO("tb_clazz");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getClazzNum() != null && !entity.getClazzNum().equals("")){
					VALUES("clazz_num", "#{clazzNum}");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					VALUES("description", "#{description}");
				}
				if(entity.getTeacher() != null){
					VALUES("teacher_id", "#{teacher.id}");
				}
				if(entity.getImage() != null){
					VALUES("image_id", "#{image.id}");
				}
			}
		}.toString();
	}

	public String updateClazz(Clazz entity){
		return new SQL(){
			{
				UPDATE("tb_clazz");
				if(entity.getClazzNum() != null && !entity.getClazzNum().equals("")){
					SET(" clazz_num = #{clazzNum} ");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					SET(" description = #{description} ");
				}
				if(entity.getTeacher() != null){
					SET(" teacher_id = #{teacher.id} ");
				}
				if(entity.getImage() != null){
					SET(" image_id = #{image.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_clazz");
				if(params.get("clazz") != null){
					Clazz entity = (Clazz)params.get("clazz");
					if(entity.getId() != null){
						WHERE(" id = #{clazz.id} ");
					}
					if(entity.getClazzNum() != null && !entity.getClazzNum().equals("")){
						WHERE(" clazz_num LIKE CONCAT ('%',#{clazz.clazzNum},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{clazz.description},'%') ");
					}
					if(entity.getTeacher() != null){
						WHERE(" teacher_id = #{clazz.teacher.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{clazz.image.id} ");
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
				FROM("tb_clazz");
				if(params.get("clazz") != null){
					Clazz entity = (Clazz)params.get("clazz");
					if(entity.getId() != null){
						WHERE(" id = #{clazz.id} ");
					}
					if(entity.getClazzNum() != null && !entity.getClazzNum().equals("")){
						WHERE(" clazz_num LIKE CONCAT ('%',#{clazz.clazzNum},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{clazz.description},'%') ");
					}
					if(entity.getTeacher() != null){
						WHERE(" teacher_id = #{clazz.teacher.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{clazz.image.id} ");
					}
				}
			}
		}.toString();
	}

}