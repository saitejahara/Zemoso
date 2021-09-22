package com.aopdemo.aspect;

import com.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	/*@Pointcut("execution(* com.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}

	// create pointcut for getter methods
	@Pointcut("execution(* com.aopdemo.dao.*.get*(..))")
	private void getter() {}

	// create pointcut for setter methods
	@Pointcut("execution(* com.aopdemo.dao.*.set*(..))")
	private void setter() {}

	// create pointcut: include package ... exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}*/

	@Before("com.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

		System.out.println("Method: "+methodSignature);

		Object[] args=joinPoint.getArgs();
		for (Object tempArg : args){
			System.out.println(tempArg);

			if(tempArg instanceof Account) {
				Account tempAccount = (Account) tempArg;
				System.out.println("Account name: "+tempAccount.getName());
				System.out.println("Account level: "+tempAccount.getLevel());
			}
		}
	}


}










