package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Role;

public class RoleDynaSqlProvider {

	public String insertRole(Role entity){
		return new SQL(){
			{
				INSERT_INTO("tb_role");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getName() != null && !entity.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					VALUES("description", "#{description}");
				}
			}
		}.toString();
	}

	public String updateRole(Role entity){
		return new SQL(){
			{
				UPDATE("tb_role");
				if(entity.getName() != null && !entity.getName().equals("")){
					SET(" name = #{name} ");
				}
				if(entity.getDescription() != null && !entity.getDescription().equals("")){
					SET(" description = #{description} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_role");
				if(params.get("role") != null){
					Role entity = (Role)params.get("role");
					if(entity.getId() != null){
						WHERE(" id = #{role.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{role.name},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{role.description},'%') ");
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
				FROM("tb_role");
				if(params.get("role") != null){
					Role entity = (Role)params.get("role");
					if(entity.getId() != null){
						WHERE(" id = #{role.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{role.name},'%') ");
					}
					if(entity.getDescription() != null && !entity.getDescription().equals("")){
						WHERE(" description LIKE CONCAT ('%',#{role.description},'%') ");
					}
				}
			}
		}.toString();
	}

}