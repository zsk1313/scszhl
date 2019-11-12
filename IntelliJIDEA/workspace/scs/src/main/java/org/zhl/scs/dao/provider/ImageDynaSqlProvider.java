package org.zhl.scs.dao.provider;

import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Image;

public class ImageDynaSqlProvider {

	public String insertImage(Image entity){
		return new SQL(){
			{
				INSERT_INTO("tb_image");
				if(entity.getId() != null){
					VALUES("id", "#{id}");
				}
				if(entity.getPath() != null && !entity.getPath().equals("")){
					VALUES("path", "#{path}");
				}
			}
		}.toString();
	}

	public String updateImage(Image entity){
		return new SQL(){
			{
				UPDATE("tb_image");
				if(entity.getPath() != null && !entity.getPath().equals("")){
					SET(" path = #{path} ");
				}
				WHERE(" id = #{id} ");
			}
		}.toString();
	}

	public String selectWithParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM("tb_image");
				if(params.get("image") != null){
					Image entity = (Image)params.get("image");
					if(entity.getId() != null){
						WHERE(" id = #{image.id} ");
					}
					if(entity.getPath() != null && !entity.getPath().equals("")){
						WHERE(" path LIKE CONCAT ('%',#{image.path},'%') ");
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
				FROM("tb_image");
				if(params.get("image") != null){
					Image entity = (Image)params.get("image");
					if(entity.getId() != null){
						WHERE(" id = #{image.id} ");
					}
					if(entity.getPath() != null && !entity.getPath().equals("")){
						WHERE(" path LIKE CONCAT ('%',#{image.path},'%') ");
					}
				}
			}
		}.toString();
	}

}