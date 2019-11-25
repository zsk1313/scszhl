package org.zhl.scs.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.zhl.scs.util.common.Sex;

/**
 * 性别类型转换器
 * @author zsk
 * @version 1.0
 * Create on 2019/11/14
 */
// 声明JdbcType为整形
@MappedJdbcTypes(JdbcType.INTEGER)
// 声明JavaType为SexEnum
@MappedTypes(value=Sex.class)
public class SexTypeHandler extends BaseTypeHandler<Sex> {
 
    // 通过列名读取性别
    @Override
    public Sex getNullableResult(ResultSet rs, String col)
            throws SQLException {
        int sex = rs.getInt(col);
        if (sex == 0 || sex == 1) {
            return Sex.getSexByOrdinal(sex);
        }
        return null;
    }

    // 通过下标读取性别
    @Override
    public Sex getNullableResult(ResultSet rs, int idx)
            throws SQLException {
        int sex = rs.getInt(idx);
        if (sex == 0 || sex == 1) {
            return Sex.getSexByOrdinal(sex);
        }
        return null;
    }
    
    
    // 通过存储过程读取性别
    @Override
    public Sex getNullableResult(CallableStatement cs, int idx)
            throws SQLException {
        int sex = cs.getInt(idx);
        if (sex == 0 || sex == 1) {
            return Sex.getSexByOrdinal(sex);
        }
        return null;
    }

    // 设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int idx,
            Sex sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(idx, sex.ordinal());
    }
}