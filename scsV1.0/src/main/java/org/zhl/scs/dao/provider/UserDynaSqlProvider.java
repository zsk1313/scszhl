package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Role;
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
				if(entity.getLocked()!=null){
					SET(" locked = #{locked} ");
				}
				if (entity.getEnable()!=null){
					SET(" enable = #{enable} ");
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
					if(entity.getLocked()!=null){
						WHERE(" locked = #{user.locked} ");
					}
					if (entity.getEnable()!=null) {
						WHERE(" enable = #{user.enable} ");
					}
				}
			}
		}.toString();
	}
	public String insertRoles(User entity){
		StringBuilder stringBuilder=new StringBuilder("insert into user_role (user_id,role_id) values ");
		for (Role temp : entity.getRoles()) {
			stringBuilder.append("(");
			stringBuilder.append(entity.getId());
			stringBuilder.append(",");
			stringBuilder.append(temp.getId());
			if (temp==entity.getRoles().get(entity.getRoles().size()-1)) {
				stringBuilder.append(")");
			}else {
				stringBuilder.append("),");
			}
		}
		return stringBuilder.toString();
	}

}