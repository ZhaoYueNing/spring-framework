package cn.zynworld.springexample.aoptest;

import org.aspectj.lang.JoinPoint;
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

	// 定义切点表达式
	@Pointcut("execution(* cn.zynworld.springexample.Demo.Student.getName())")
	public void addLog(){}

	@Pointcut("@annotation(cn.zynworld.springexample.aoptest.AopMethodMatchingAnnotation)")
	private void annotationMethod(){}

	@Autowired
	private org.springframework.aop.Pointcut customPointcut;


	@Before(value = "addLog() || annotationMethod() ")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("@Before ");
	}

	@After(value = "addLog() || annotationMethod()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("@After");
	}

	@AfterReturning(value = "addLog()", returning = "result")
	public void doAfterReturning(Object result) {
		System.out.println("result:" + result);
	}
}
