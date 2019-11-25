package org.zhl.scs.dao.provider;

import org.apache.ibatis.jdbc.SQL;
import org.zhl.scs.domain.Menu;
import org.zhl.scs.domain.Role;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MenuDynaSqlProvider {
    public String insertMenu(Menu entity){
        return new SQL(){
            {
                INSERT_INTO("tb_menu");
                if(entity.getId() != null){
                    VALUES("id", "#{id}");
                }
                if(entity.getPattern() != null && !entity.getPattern().equals("")){
                    VALUES("pattern", "#{pattern}");
                }
            }
        }.toString();
    }

    public String updateMenu(Menu entity){
        return new SQL(){
            {
                UPDATE("tb_menu");
                if(entity.getPattern() != null && !entity.getPattern().equals("")){
                    SET(" pattern = #{pattern} ");
                }
                WHERE(" id = #{id} ");
            }
        }.toString();
    }

    public String selectWithParam(Map<String, Object> params){
        String sql =  new SQL(){
            {
                SELECT("*");
                FROM("tb_menu");
                if(params.get("menu") != null){
                    Menu entity = (Menu)params.get("menu");
                    if(entity.getId() != null){
                        WHERE(" id = #{menu.id} ");
                    }
                    if(entity.getPattern() != null && !entity.getPattern().equals("")){
                        WHERE("pattern LIKE CONCAT ('%',#{menu.pattern},'%')");
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
                FROM("tb_menu");
                if(params.get("menu") != null){
                    Menu entity = (Menu)params.get("menu");
                    if(entity.getId() != null){
                        WHERE(" id = #{menu.id} ");
                    }
                    if(entity.getPattern() != null && !entity.getPattern().equals("")){
                        WHERE("pattern LIKE CONCAT ('%',#{menu.pattern},'%')");
                    }
                }
            }
        }.toString();
    }

    public String insertRoles(Menu entity){
        StringBuilder stringBuilder=new StringBuilder("insert into menu_role (menu_id,role_id) values ");
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

    public String selectByIds(Map<String, Object> params){
        StringBuilder stringBuilder=new StringBuilder("select * from tb_menu where id in (");
        List<Integer> menuIds= (List<Integer>) params.get("menuIds");
        for(int i=0;i<menuIds.size();i++){
            stringBuilder.append(menuIds.get(i));
            if (i==(menuIds.size()-1)){
                stringBuilder.append(")");
            }else {
                stringBuilder.append(",");
            }
        }
        return stringBuilder.toString();
    }
}
