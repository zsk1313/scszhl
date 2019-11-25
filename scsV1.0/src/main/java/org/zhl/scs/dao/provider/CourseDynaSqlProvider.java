package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Student;

public class CourseDynaSqlProvider {

	public String insertCourse(Course entity){
		return new SQL(){
			{
				INSERT_INTO("tb_course");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getClassroom() != null){
					VALUES("classroom", "#{classroom}");
				}
				if(entity.getStart_time()!= null){
					VALUES("start_time", "#{start_time}");
				}
				if(entity.getEnd_time() != null){
					VALUES("end_time", "#{end_time}");
				}
				if(entity.getName() != null && !entity.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(entity.getScore() != null ){
					VALUES("score", "#{score}");
				}
				if(entity.getCode() != null && !entity.getCode().equals("")){
					VALUES("code", "#{code}");
				}
				if(entity.getWeek() != null){
					VALUES("week", "#{week}");
				}
				if(entity.getDateorder() != null){
					VALUES("dateorder", "#{dateorder}");
				}
				if(entity.getTeacher() != null){
					VALUES("teacher_id", "#{teacher.id}");
				}
			}
		}.toString();
	}

	public String updateCourse(Course entity){
		return new SQL(){
			{
				UPDATE("tb_course");
				if(entity.getName() != null && !entity.getName().equals("")){
					SET(" name = #{name} ");
				}
				if(entity.getClassroom() != null){
					SET("classroom=#{classroom}");
				}
				if(entity.getStart_time()!= null){
					SET("start_time=#{start_time}");
				}
				if(entity.getEnd_time() != null){
					SET("end_time=#{end_time}");
				}
				if(entity.getScore() != null ){
					SET(" score = #{score} ");
				}
				if(entity.getCode() != null && !entity.getCode().equals("")){
					SET(" code = #{code} ");
				}
				if(entity.getWeek() != null){
					SET(" week = #{week} ");
				}
				if(entity.getDateorder() != null){
					SET(" dateorder = #{dateorder} ");
				}
				if(entity.getTeacher() != null){
					SET(" teacher_id = #{teacher.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_course");
				if(params.get("course") != null){
					Course entity = (Course)params.get("course");
					if(entity.getId() != null){
						WHERE(" id = #{course.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{course.name},'%') ");
					}
					if(entity.getScore() != null ){
						WHERE(" score= #{course.score} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{course.code},'%') ");
					}
					if(entity.getClassroom() != null){
						WHERE(" classroom LIKE CONCAT ('%',#{course.classroom},'%') ");
					}
					if(entity.getStart_time() != null){
						WHERE(" start_time = #{course.start_time} ");
					}
					if(entity.getEnd_time()!= null){
						WHERE(" end_time = #{course.end_time} ");
					}
					if(entity.getWeek() != null){
						WHERE(" week = #{course.week} ");
					}
					if(entity.getDateorder() != null){
						WHERE(" dateorder = #{course.dateorder} ");
					}
					if(entity.getTeacher() != null){
						WHERE(" teacher_id = #{course.teacher.id} ");
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
				FROM("tb_course");
				if(params.get("course") != null){
					Course entity = (Course)params.get("course");
					if(entity.getId() != null){
						WHERE(" id = #{course.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{course.name},'%') ");
					}
					if(entity.getScore() != null){
						WHERE(" score  = #{course.score} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{course.code},'%') ");
					}
					if(entity.getWeek() != null){
						WHERE(" week = #{course.week} ");
					}
					if(entity.getClassroom() != null){
						WHERE(" classroom LIKE CONCAT ('%',#{course.classroom},'%') ");
					}
					if(entity.getStart_time() != null){
						WHERE(" start_time = #{course.start_time} ");
					}
					if(entity.getEnd_time()!= null){
						WHERE(" end_time = #{course.end_time} ");
					}
					if(entity.getDateorder() != null){
						WHERE(" dateorder = #{course.dateorder} ");
					}
					if(entity.getTeacher() != null){
						WHERE(" teacher_id = #{course.teacher.id} ");
					}
				}
			}
		}.toString();
	}

	public String insertStudents(Course entity){
		StringBuilder stringBuilder=new StringBuilder("insert into student_course (student_id,course_id) values ");
		for (Student temp : entity.getStudents()) {
			stringBuilder.append("(");
			stringBuilder.append(temp.getId());
			stringBuilder.append(",");
			stringBuilder.append(entity.getId());
			if (temp==entity.getStudents().get(entity.getStudents().size()-1)) {
				stringBuilder.append(")");
			}else {
				stringBuilder.append("),");
			}
		}
		return stringBuilder.toString();
	}

}