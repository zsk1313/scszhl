package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.User;

public class UserDynaSqlProvider {

	public String insertUser(User entity){
		return new SQL(){
			{
				INSERT_INTO("tb_user");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getUsername() != null && !entity.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(entity.getPassword() != null && !entity.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
				if(entity.getRole() != null){
					VALUES("role_id", "#{role.id}");
				}
			}
		}.toString();
	}

	public String updateUser(User entity){
		return new SQL(){
			{
				UPDATE("tb_user");
				if(entity.getUsername() != null && !entity.getUsername().equals("")){
					SET(" username = #{username} ");
				}
				if(entity.getPassword() != null && !entity.getPassword().equals("")){
					SET(" password = #{password} ");
				}
				if(entity.getRole() != null){
					SET(" role_id = #{role.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_user");
				if(params.get("user") != null){
					User entity = (User)params.get("user");
					if(entity.getId() != null){
						WHERE(" id = #{user.id} ");
					}
					if(entity.getUsername() != null && !entity.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(entity.getPassword() != null && !entity.getPassword().equals("")){
						WHERE(" password LIKE CONCAT ('%',#{user.password},'%') ");
					}
					if(entity.getRole() != null){
						WHERE(" role_id = #{user.role.id} ");
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
				FROM("tb_user");
				if(params.get("user") != null){
					User entity = (User)params.get("user");
					if(entity.getId() != null){
						WHERE(" id = #{user.id} ");
					}
					if(entity.getUsername() != null && !entity.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(entity.getPassword() != null && !entity.getPassword().equals("")){
						WHERE(" password LIKE CONCAT ('%',#{user.password},'%') ");
					}
					if(entity.getRole() != null){
						WHERE(" role_id = #{user.role.id} ");
					}
				}
			}
		}.toString();
	}

}