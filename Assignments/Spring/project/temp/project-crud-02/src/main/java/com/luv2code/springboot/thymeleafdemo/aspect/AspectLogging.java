package com.luv2code.springboot.thymeleafdemo.aspect;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AspectLogging {

    private static Logger myLogger = Logger.getLogger(AspectLogging.class.getName());

    @Before("com.luv2code.springboot.thymeleafdemo.aspect.AspectExpressions.delete()")
    public void beforeDeleting(){
       myLogger.info("\n =====>>>> Deleting from the repository using service layer");
    }

    @After("com.luv2code.springboot.thymeleafdemo.aspect.AspectExpressions.delete()")
    public void afterDeleting(){
        myLogger.info("\n =====>>>> Deleted from the repository using service layer");
    }

    @Before("com.luv2code.springboot.thymeleafdemo.aspect.AspectExpressions.save()")
    public void beforeSaving(){
        myLogger.info("\n =====>>>> Saving to the database using service layer");
    }

    @AfterReturning("com.luv2code.springboot.thymeleafdemo.aspect.AspectExpressions.save()")
    public void afterSaving(){
        myLogger.info("\n =====>>>> Saved to the database using service layer");
    }

}