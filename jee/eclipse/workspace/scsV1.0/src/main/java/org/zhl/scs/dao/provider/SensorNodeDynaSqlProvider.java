package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.SensorNode;

public class SensorNodeDynaSqlProvider {

	public String insertSensorNode(SensorNode entity){
		return new SQL(){
			{
				INSERT_INTO("tb_sensor_node");
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
				if(entity.getFundescription() != null && !entity.getFundescription().equals("")){
					VALUES("fundescription", "#{fundescription}");
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

	public String updateSensorNode(SensorNode entity){
		return new SQL(){
			{
				UPDATE("tb_sensor_node");
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
				if(entity.getFundescription() != null && !entity.getFundescription().equals("")){
					SET(" fundescription = #{fundescription} ");
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
				FROM("tb_sensor_node");
				if(params.get("sensorNode") != null){
					SensorNode entity = (SensorNode)params.get("sensorNode");
					if(entity.getId() != null){
						WHERE(" id = #{sensorNode.id} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{sensorNode.code},'%') ");
					}
					if(entity.getTime() != null){
						WHERE(" time = #{sensorNode.time} ");
					}
					if(entity.getType() != null && !entity.getType().equals("")){
						WHERE(" type LIKE CONCAT ('%',#{sensorNode.type},'%') ");
					}
					if(entity.getStatus() != null && !entity.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{sensorNode.status},'%') ");
					}
					if(entity.getFundescription() != null && !entity.getFundescription().equals("")){
						WHERE(" fundescription LIKE CONCAT ('%',#{sensorNode.fundescription},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{sensorNode.address},'%') ");
					}
					if(entity.getFlag() != null && !entity.getFlag().equals("")){
						WHERE(" flag LIKE CONCAT ('%',#{sensorNode.flag},'%') ");
					}
					if(entity.getClient() != null){
						WHERE(" client_id = #{sensorNode.client.id} ");
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
				FROM("tb_sensor_node");
				if(params.get("sensorNode") != null){
					SensorNode entity = (SensorNode)params.get("sensorNode");
					if(entity.getId() != null){
						WHERE(" id = #{sensorNode.id} ");
					}
					if(entity.getCode() != null && !entity.getCode().equals("")){
						WHERE(" code LIKE CONCAT ('%',#{sensorNode.code},'%') ");
					}
					if(entity.getTime() != null){
						WHERE(" time = #{sensorNode.time} ");
					}
					if(entity.getType() != null && !entity.getType().equals("")){
						WHERE(" type LIKE CONCAT ('%',#{sensorNode.type},'%') ");
					}
					if(entity.getStatus() != null && !entity.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{sensorNode.status},'%') ");
					}
					if(entity.getFundescription() != null && !entity.getFundescription().equals("")){
						WHERE(" fundescription LIKE CONCAT ('%',#{sensorNode.fundescription},'%') ");
					}
					if(entity.getAddress() != null && !entity.getAddress().equals("")){
						WHERE(" address LIKE CONCAT ('%',#{sensorNode.address},'%') ");
					}
					if(entity.getFlag() != null && !entity.getFlag().equals("")){
						WHERE(" flag LIKE CONCAT ('%',#{sensorNode.flag},'%') ");
					}
					if(entity.getClient() != null){
						WHERE(" client_id = #{sensorNode.client.id} ");
					}
				}
			}
		}.toString();
	}

}