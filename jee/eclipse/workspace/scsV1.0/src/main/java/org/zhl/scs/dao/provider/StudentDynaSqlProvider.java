package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Course;
import org.zhl.scs.domain.Student;

public class StudentDynaSqlProvider {

	public String insertStudent(Student entity){
		return new SQL(){
			{
				INSERT_INTO("tb_student");
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
				if(entity.getAdmissiontime() != null){
					VALUES("admissiontime", "#{admissiontime}");
				}
				if(entity.getNativeplace() != null && !entity.getNativeplace().equals("")){
					VALUES("nativeplace", "#{nativeplace}");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					VALUES("address", "#{address}");
				}
				if(entity.getPostcode() != null && !entity.getPostcode().equals("")){
					VALUES("postcode", "#{postcode}");
				}
				if(entity.getProfession() != null && !entity.getProfession().equals("")){
					VALUES("profession", "#{profession}");
				}
				if(entity.getUser() != null){
					VALUES("user_id", "#{user.id}");
				}
				if(entity.getImage() != null){
					VALUES("image_id", "#{image.id}");
				}
				if(entity.getClazz() != null){
					VALUES("clazz_id", "#{clazz.id}");
				}
			}
		}.toString();
	}

	public String updateStudent(Student entity){
		return new SQL(){
			{
				UPDATE("tb_student");
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
				if(entity.getAdmissiontime() != null){
					SET(" admissiontime = #{admissiontime} ");
				}
				if(entity.getNativeplace() != null && !entity.getNativeplace().equals("")){
					SET(" nativeplace = #{nativeplace} ");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					SET(" address = #{address} ");
				}
				if(entity.getPostcode() != null && !entity.getPostcode().equals("")){
					SET(" postcode = #{postcode} ");
				}
				if(entity.getProfession() != null && !entity.getProfession().equals("")){
					SET(" profession = #{profession} ");
				}
				if(entity.getUser() != null){
					SET(" user_id = #{user.id} ");
				}
				if(entity.getImage() != null){
					SET(" image_id = #{image.id} ");
				}
				if(entity.getClazz() != null){
					SET(" clazz_id = #{clazz.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_student");
				if(params.get("student") != null){
					Student entity = (Student)params.get("student");
					if(entity.getId() != null){
						WHERE(" id = #{student.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}
					if(entity.getUid() != null && !entity.getUid().equals("")){
						WHERE(" uid LIKE CONCAT ('%',#{student.uid},'%') ");
					}
					if(entity.getSex() != null && !entity.getSex().equals("")){
						WHERE(" sex LIKE CONCAT ('%',#{student.sex},'%') ");
					}
					if(entity.getBirthday() != null){
						WHERE(" birthday = #{student.birthday} ");
					}
					if(entity.getAdmissiontime() != null){
						WHERE(" admissiontime = #{student.admissiontime} ");
					}
					if(entity.getNativeplace() != null && !entity.getNativeplace().equals("")){
						WHERE(" nativeplace LIKE CONCAT ('%',#{student.nativeplace},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{student.address},'%') ");
					}
					if(entity.getPostcode() != null && !entity.getPostcode().equals("")){
						WHERE(" postcode LIKE CONCAT ('%',#{student.postcode},'%') ");
					}
					if(entity.getProfession() != null && !entity.getProfession().equals("")){
						WHERE(" profession LIKE CONCAT ('%',#{student.profession},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{student.user.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{student.image.id} ");
					}
					if(entity.getClazz() != null){
						WHERE(" clazz_id = #{student.clazz.id} ");
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
				FROM("tb_student");
				if(params.get("student") != null){
					Student entity = (Student)params.get("student");
					if(entity.getId() != null){
						WHERE(" id = #{student.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{student.name},'%') ");
					}
					if(entity.getUid() != null && !entity.getUid().equals("")){
						WHERE(" uid LIKE CONCAT ('%',#{student.uid},'%') ");
					}
					if(entity.getSex() != null && !entity.getSex().equals("")){
						WHERE(" sex LIKE CONCAT ('%',#{student.sex},'%') ");
					}
					if(entity.getBirthday() != null){
						WHERE(" birthday = #{student.birthday} ");
					}
					if(entity.getAdmissiontime() != null){
						WHERE(" admissiontime = #{student.admissiontime} ");
					}
					if(entity.getNativeplace() != null && !entity.getNativeplace().equals("")){
						WHERE(" nativeplace LIKE CONCAT ('%',#{student.nativeplace},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{student.address},'%') ");
					}
					if(entity.getPostcode() != null && !entity.getPostcode().equals("")){
						WHERE(" postcode LIKE CONCAT ('%',#{student.postcode},'%') ");
					}
					if(entity.getProfession() != null && !entity.getProfession().equals("")){
						WHERE(" profession LIKE CONCAT ('%',#{student.profession},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{student.user.id} ");
					}
					if(entity.getImage() != null){
						WHERE(" image_id = #{student.image.id} ");
					}
					if(entity.getClazz() != null){
						WHERE(" clazz_id = #{student.clazz.id} ");
					}
				}
			}
		}.toString();
	}

	public String insertCourses(Student entity){
		StringBuilder stringBuilder=new StringBuilder("insert into student_course (student_id,course_id) values ");
		for (Course temp : entity.getCourses()) {
			stringBuilder.append("(");
			stringBuilder.append(entity.getId());
			stringBuilder.append(",");
			stringBuilder.append(temp.getId());
			if (temp==entity.getCourses().get(entity.getCourses().size()-1)) {
				stringBuilder.append(")");
			}else {
				stringBuilder.append("),");
			}
		}
		return stringBuilder.toString();
	}

}