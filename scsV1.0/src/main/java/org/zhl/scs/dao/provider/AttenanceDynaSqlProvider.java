package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Attenance;

public class AttenanceDynaSqlProvider {

	public String insertAttenance(Attenance entity){
		return new SQL(){
			{
				INSERT_INTO("tb_attenance");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getDate() != null){
					VALUES("date", "#{date}");
				}
				if(entity.getTotal() != null){
					VALUES("total", "#{total}");
				}
				if(entity.getActual() != null){
					VALUES("actual", "#{actual}");
				}
				if(entity.getNote() != null && !entity.getNote().equals("")){
					VALUES("note", "#{note}");
				}
				if(entity.getClazz() != null){
					VALUES("clazz_id", "#{clazz.id}");
				}
				if(entity.getCourse() != null){
					VALUES("course_id", "#{course.id}");
				}
			}
		}.toString();
	}

	public String updateAttenance(Attenance entity){
		return new SQL(){
			{
				UPDATE("tb_attenance");
				if(entity.getDate() != null){
					SET(" date = #{date} ");
				}
				if(entity.getTotal() != null){
					SET(" total = #{total} ");
				}
				if(entity.getActual() != null){
					SET(" actual = #{actual} ");
				}
				if(entity.getNote() != null && !entity.getNote().equals("")){
					SET(" note = #{note} ");
				}
				if(entity.getClazz() != null){
					SET(" clazz_id = #{clazz.id} ");
				}
				if(entity.getCourse() != null){
					SET(" course_id = #{course.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_attenance");
				if(params.get("attenance") != null){
					Attenance entity = (Attenance)params.get("attenance");
					if(entity.getId() != null){
						WHERE(" id = #{attenance.id} ");
					}
					if(entity.getDate() != null){
						WHERE(" date = #{attenance.date} ");
					}
					if(entity.getTotal() != null){
						WHERE(" total = #{attenance.total} ");
					}
					if(entity.getActual() != null){
						WHERE(" actual = #{attenance.actual} ");
					}
					if(entity.getNote() != null && !entity.getNote().equals("")){
						WHERE(" note LIKE CONCAT ('%',#{attenance.note},'%') ");
					}
					if(entity.getClazz() != null){
						WHERE(" clazz_id = #{attenance.clazz.id} ");
					}
					if(entity.getCourse() != null){
						WHERE(" course_id = #{attenance.course.id} ");
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
				FROM("tb_attenance");
				if(params.get("attenance") != null){
					Attenance entity = (Attenance)params.get("attenance");
					if(entity.getId() != null){
						WHERE(" id = #{attenance.id} ");
					}
					if(entity.getDate() != null){
						WHERE(" date = #{attenance.date} ");
					}
					if(entity.getTotal() != null){
						WHERE(" total = #{attenance.total} ");
					}
					if(entity.getActual() != null){
						WHERE(" actual = #{attenance.actual} ");
					}
					if(entity.getNote() != null && !entity.getNote().equals("")){
						WHERE(" note LIKE CONCAT ('%',#{attenance.note},'%') ");
					}
					if(entity.getClazz() != null){
						WHERE(" clazz_id = #{attenance.clazz.id} ");
					}
					if(entity.getCourse() != null){
						WHERE(" course_id = #{attenance.course.id} ");
					}

				}
			}
		}.toString();
	}

}