package cn.zynworld.springexample.aoptest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyuening
 */
@Aspect
@Component
public class DemoAspect {

	private Log logger = LogFactory.getLog(getClass());

	// 定义切点表达式
	@Pointcut("execution(* cn.zynworld.springexample.aoptest.AopHelloService.sayHello(..))")
	public void sayHello(){}

	// @Pointcut("@annotation(cn.zynworld.springexample.aoptest.AopMethodMatchingAnnotation)")
	private void annotationMethod(){}

	// @Around("@annotation(cn.zynworld.springexample.aoptest.AopMethodTimeAnnotation)")
	private Object logMethodTime(ProceedingJoinPoint joinPoint) throws Throwable {
		Long begin = System.currentTimeMillis();
		try {
			return joinPoint.proceed();
		} catch (Throwable throwable) {
			throw throwable;
		} finally {
			Long endTime = System.currentTimeMillis();
			logger.info("method time:" + (endTime - begin));
		}
	}

	@Autowired
	private org.springframework.aop.Pointcut customPointcut;


	@Before(value = "sayHello() ")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("@Before ");
	}

	// @After(value = "addLog() || annotationMethod()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("@After");
	}

	// @AfterReturning(value = "addLog()", returning = "result")
	public void doAfterReturning(Object result) {
		System.out.println("result:" + result);
	}
}
