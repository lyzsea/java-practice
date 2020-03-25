package com.sean.transactionannotation.common.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class MyDataSourceUtils {
    /**
     * 多线程数据库连接处理，事务实现依赖DB的连接，故
     */
    private ThreadLocal<Connection> connections = new ThreadLocal<>();

    @Autowired
    private DataSource dataSource;

    public Connection getConnection() throws SQLException {
        if (connections.get() == null) {
            connections.set(dataSource.getConnection());
        }
        return connections.get();
    }
}
