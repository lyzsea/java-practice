package com.sean.transactionannotation.common.jdbc.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyTransactional {
    String value() default "";
}
