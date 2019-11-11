package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Userscurity;

public class UserscurityDynaSqlProvider {

	public String insertUserscurity(Userscurity entity){
		return new SQL(){
			{
				INSERT_INTO("tb_userscurity");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getFingerpoint() != null && !entity.getFingerpoint().equals("")){
					VALUES("fingerpoint", "#{fingerpoint}");
				}
				if(entity.getFaceid() != null && !entity.getFaceid().equals("")){
					VALUES("faceid", "#{faceid}");
				}
				if(entity.getCardid() != null && !entity.getCardid().equals("")){
					VALUES("cardid", "#{cardid}");
				}
				if(entity.getUser() != null){
					VALUES("user_id", "#{user.id}");
				}
			}
		}.toString();
	}

	public String updateUserscurity(Userscurity entity){
		return new SQL(){
			{
				UPDATE("tb_userscurity");
				if(entity.getFingerpoint() != null && !entity.getFingerpoint().equals("")){
					SET(" fingerpoint = #{fingerpoint} ");
				}
				if(entity.getFaceid() != null && !entity.getFaceid().equals("")){
					SET(" faceid = #{faceid} ");
				}
				if(entity.getCardid() != null && !entity.getCardid().equals("")){
					SET(" cardid = #{cardid} ");
				}
				if(entity.getUser() != null){
					SET(" user_id = #{user.id} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_userscurity");
				if(params.get("userscurity") != null){
					Userscurity entity = (Userscurity)params.get("userscurity");
					if(entity.getId() != null){
						WHERE(" id = #{userscurity.id} ");
					}
					if(entity.getFingerpoint() != null && !entity.getFingerpoint().equals("")){
						WHERE(" fingerpoint LIKE CONCAT ('%',#{userscurity.fingerpoint},'%') ");
					}
					if(entity.getFaceid() != null && !entity.getFaceid().equals("")){
						WHERE(" faceid LIKE CONCAT ('%',#{userscurity.faceid},'%') ");
					}
					if(entity.getCardid() != null && !entity.getCardid().equals("")){
						WHERE(" cardid LIKE CONCAT ('%',#{userscurity.cardid},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{userscurity.user.id} ");
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
				FROM("tb_userscurity");
				if(params.get("userscurity") != null){
					Userscurity entity = (Userscurity)params.get("userscurity");
					if(entity.getId() != null){
						WHERE(" id = #{userscurity.id} ");
					}
					if(entity.getFingerpoint() != null && !entity.getFingerpoint().equals("")){
						WHERE(" fingerpoint LIKE CONCAT ('%',#{userscurity.fingerpoint},'%') ");
					}
					if(entity.getFaceid() != null && !entity.getFaceid().equals("")){
						WHERE(" faceid LIKE CONCAT ('%',#{userscurity.faceid},'%') ");
					}
					if(entity.getCardid() != null && !entity.getCardid().equals("")){
						WHERE(" cardid LIKE CONCAT ('%',#{userscurity.cardid},'%') ");
					}
					if(entity.getUser() != null){
						WHERE(" user_id = #{userscurity.user.id} ");
					}
				}
			}
		}.toString();
	}

}