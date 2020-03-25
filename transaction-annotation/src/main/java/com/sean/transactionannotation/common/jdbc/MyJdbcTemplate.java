package com.sean.transactionannotation.common.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class MyJdbcTemplate {
    @Autowired
    private MyDataSourceUtils myDataSourceUtils;

    public void execute(String sql) throws SQLException {
        Connection connection = myDataSourceUtils.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(sql);
    }
}
