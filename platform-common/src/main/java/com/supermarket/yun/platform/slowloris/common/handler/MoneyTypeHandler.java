package com.supermarket.yun.platform.slowloris.common.handler;

import com.supermarket.yun.platform.slowloris.common.domain.Money;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * money 数据库映射
 *
 * @author : 朝阳
 * @version : v1.0
 * @email : licy13@lenovo.com
 * @time : 2017/11/12 23:21
 */
public class MoneyTypeHandler extends BaseTypeHandler<Money> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Money money, JdbcType jdbcType) throws SQLException {
        ps.setBigDecimal(i, money.getAmount());
    }

    @Override
    public Money getNullableResult(ResultSet rs, String columnName) throws SQLException {
        BigDecimal value = rs.getBigDecimal(columnName);
        return new Money((value == null ? new BigDecimal(0.0) : value));
    }

    @Override
    public Money getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        BigDecimal value = rs.getBigDecimal(columnIndex);
        return new Money((value == null ? new BigDecimal(0.0) : value));
    }

    @Override
    public Money getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        BigDecimal value = cs.getBigDecimal(columnIndex);
        return new Money((value == null ? new BigDecimal(0.0) : value));
    }
}
