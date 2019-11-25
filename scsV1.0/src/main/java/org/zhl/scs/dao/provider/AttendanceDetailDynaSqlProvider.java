package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.AttendanceDetail;

public class AttendanceDetailDynaSqlProvider {

	public String insertAttendanceDetail(AttendanceDetail entity){
		return new SQL(){
			{
				INSERT_INTO("tb_attendance_detail");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getIsattendance() != null){
					VALUES("isattendance", "#{isattendance}");
				}
				if(entity.getStudent() != null){
					VALUES("student_id", "#{student.id}");
				}
				if(entity.getAttenance() != null){
					VALUES("attendance_id", "#{attenance.id}");
				}
				if(entity.getSigntime() != null){
                    VALUES("sign_time", "#{sign.time}");
                }
			}
		}.toString();
	}

	public String updateAttendanceDetail(AttendanceDetail entity){
		return new SQL(){
			{
				UPDATE("tb_attendance_detail");
				if(entity.getIsattendance() != null){
					SET(" isattendance = #{isattendance} ");
				}
				if(entity.getStudent() != null){
					SET(" student_id = #{student.id} ");
				}
				if(entity.getAttenance() != null){
					SET(" attendance_id = #{attenance.id} ");
				}
				if(entity.getSigntime() != null){
				    SET(" sign_time = #{sign.time} ");
            }

				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_attendance_detail");
				if(params.get("attendanceDetail") != null){
					AttendanceDetail entity = (AttendanceDetail)params.get("attendanceDetail");
					if(entity.getId() != null){
						WHERE(" id = #{attendanceDetail.id} ");
					}
					if(entity.getIsattendance() != null){
						WHERE(" isattendance = #{attendanceDetail.isattendance} ");
					}
					if(entity.getStudent() != null){
						WHERE(" student_id = #{attendanceDetail.student.id} ");
					}
					if(entity.getAttenance() != null){
						WHERE(" attendance_id = #{attendanceDetail.attenance.id} ");
					}
                    if(entity.getSigntime() != null){
                        WHERE(" sign_time = #{attendanceDetail.sign.time} ");
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
				FROM("tb_attendance_detail");
				if(params.get("attendanceDetail") != null){
					AttendanceDetail entity = (AttendanceDetail)params.get("attendanceDetail");
					if(entity.getId() != null){
						WHERE(" id = #{attendanceDetail.id} ");
					}
					if(entity.getIsattendance() != null){
						WHERE(" isattendance = #{attendanceDetail.isattendance} ");
					}
					if(entity.getStudent() != null){
						WHERE(" student_id = #{attendanceDetail.student.id} ");
					}
					if(entity.getAttenance() != null){
						WHERE(" attendance_id = #{attendanceDetail.attenance.id} ");
					}
					if(entity.getSigntime() !=null){
					    WHERE("sign_time = #{attendanceDetail.sign.time}");
                    }
				}
			}
		}.toString();
	}

}