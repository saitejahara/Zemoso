package com.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(21)
public class MyApiAnalyticsAspect {

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n=====>>> Performing API analytics");		
	}

}
