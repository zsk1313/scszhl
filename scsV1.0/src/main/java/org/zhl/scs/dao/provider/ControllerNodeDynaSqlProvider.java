package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.ControllerNode;

public class ControllerNodeDynaSqlProvider {

	public String insertControllerNode(ControllerNode entity){
		return new SQL(){
			{
				INSERT_INTO("tb_controller_node");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getCode() != null && !entity.getCode().equals("")){
					VALUES("code", "#{code}");
				}
				if(entity.getTime() != null){
					VALUES("time", "#{time}");
				}
				if(entity.getType() != null && !entity.getType().equals("")){
					VALUES("type", "#{type}");
				}
				if(entity.getStatus() != null && !entity.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(entity.getValue() != null && !entity.getValue().equals("")){
					VALUES("value", "#{value}");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					VALUES("address", "#{address}");
				}
				if(entity.getFlag() != null && !entity.getFlag().equals("")){
					VALUES("flag", "#{flag}");
				}
				if(entity.getClient() != null){
					VALUES("client_id", "#{client.id}");
				}
			}
		}.toString();
	}

	public String updateControllerNode(ControllerNode entity){
		return new SQL(){
			{
				UPDATE("tb_controller_node");
				if(entity.getCode() != null && !entity.getCode().equals("")){
					SET(" code = #{code} ");
				}
				if(entity.getTime() != null){
					SET(" time = #{time} ");
				}
				if(entity.getType() != null && !entity.getType().equals("")){
					SET(" type = #{type} ");
				}
				if(entity.getStatus() != null && !entity.getStatus().equals("")){
					SET(" status = #{status} ");
				}
				if(entity.getValue() != null && !entity.getValue().equals("")){
					SET(" value = #{value} ");
				}
				if(entity.getAddress() != null && !entity.getAddress().equals("")){
					SET(" address = #{address} ");
				}
				if(entity.getFlag() != null && !entity.getFlag().equals("")){
					SET(" flag = #{flag} ");
				}
				if(entity.getClient() != null){
					SET(" client_id = #{client.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_controller_node");
				if(params.get("controllerNode") != null){
					ControllerNode entity = (ControllerNode)params.get("controllerNode");
					if(entity.getId() != null){
						WHERE(" id = #{controllerNode.id} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{controllerNode.code},'%') ");
					}
					if(entity.getTime() != null){
						WHERE(" time = #{controllerNode.time} ");
					}
					if(entity.getType() != null && !entity.getType().equals("")){
						WHERE(" type LIKE CONCAT ('%',#{controllerNode.type},'%') ");
					}
					if(entity.getStatus() != null && !entity.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{controllerNode.status},'%') ");
					}
					if(entity.getValue() != null && !entity.getValue().equals("")){
						WHERE(" value LIKE CONCAT ('%',#{controllerNode.value},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{controllerNode.address},'%') ");
					}
					if(entity.getFlag() != null && !entity.getFlag().equals("")){
						WHERE(" flag LIKE CONCAT ('%',#{controllerNode.flag},'%') ");
					}
					if(entity.getClient() != null){
						WHERE(" client_id = #{controllerNode.client.id} ");
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
				FROM("tb_controller_node");
				if(params.get("controllerNode") != null){
					ControllerNode entity = (ControllerNode)params.get("controllerNode");
					if(entity.getId() != null){
						WHERE(" id = #{controllerNode.id} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{controllerNode.code},'%') ");
					}
					if(entity.getTime() != null){
						WHERE(" time = #{controllerNode.time} ");
					}
					if(entity.getType() != null && !entity.getType().equals("")){
						WHERE(" type LIKE CONCAT ('%',#{controllerNode.type},'%') ");
					}
					if(entity.getStatus() != null && !entity.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{controllerNode.status},'%') ");
					}
					if(entity.getValue() != null && !entity.getValue().equals("")){
						WHERE(" value LIKE CONCAT ('%',#{controllerNode.value},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{controllerNode.address},'%') ");
					}
					if(entity.getFlag() != null && !entity.getFlag().equals("")){
						WHERE(" flag LIKE CONCAT ('%',#{controllerNode.flag},'%') ");
					}
					if(entity.getClient() != null){
						WHERE(" client_id = #{controllerNode.client.id} ");
					}
				}
			}
		}.toString();
	}

}