package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Client;

public class ClientDynaSqlProvider {

	public String insertClient(Client entity){
		return new SQL(){
			{
				INSERT_INTO("tb_client");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getName() != null && !entity.getName().equals("")){
					VALUES("name", "#{name}");
				}
			}
		}.toString();
	}

	public String updateClient(Client entity){
		return new SQL(){
			{
				UPDATE("tb_client");
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
				FROM("tb_client");
				if(params.get("client") != null){
					Client entity = (Client)params.get("client");
					if(entity.getId() != null){
						WHERE(" id = #{client.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{client.name},'%') ");
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
				FROM("tb_client");
				if(params.get("client") != null){
					Client entity = (Client)params.get("client");
					if(entity.getId() != null){
						WHERE(" id = #{client.id} ");
					}
					if(entity.getName() != null && !entity.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{client.name},'%') ");
					}
				}
			}
		}.toString();
	}

}