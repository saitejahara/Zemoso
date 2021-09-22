package com.luv2code.springboot.thymeleafdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AspectExpressions {
    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.delete*(..))")
    public void delete() {
//        method declared to use in aspectLogging class
    }

    @Pointcut("execution(* com.luv2code.springboot.thymeleafdemo.service.*.save*(..))")
    public void save() {
        //        method declared to use in aspectLogging class
    }

}
