package com.sean.transactionannotation.common.jdbc.annotation;

import com.sean.transactionannotation.common.jdbc.MyDataSourceUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;

@Component
@Aspect // 这是一个aop程序，spring提供
public class MyTransactionalAspect {
    @Autowired
    MyDataSourceUtils myDataSourceUtils;

    @Around("@annotation(MyTransactional)")
    public Object doTransactional(ProceedingJoinPoint proceedingJoinPoint) throws SQLException {
        Connection connection = myDataSourceUtils.getConnection();
        connection.setAutoCommit(false);
        Object value = null;
        try {
            value = proceedingJoinPoint.proceed();
            connection.commit();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            connection.rollback();
        }

        return value;
    }
}
