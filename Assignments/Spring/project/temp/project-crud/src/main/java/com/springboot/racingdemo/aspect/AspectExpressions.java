package com.springboot.racingdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AspectExpressions {
    @Pointcut("execution(* com.springboot.racingdemo.service.*.delete*(..))")
    public void delete() {
        //        method declared to use in aspectLogging class
    }

    @Pointcut("execution(* com.springboot.racingdemo.service.*.save*(..))")
    public void save() {
        //        method declared to use in aspectLogging class
    }

}
