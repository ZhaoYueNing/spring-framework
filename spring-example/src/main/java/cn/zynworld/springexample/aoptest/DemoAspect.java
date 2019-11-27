package cn.zynworld.springexample.aoptest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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

	@Before(value = "addLog()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("@Before ");
	}

	@After(value = "addLog()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("@After");
	}

	@AfterReturning(value = "addLog()", returning = "result")
	public void doAfterReturning(Object result) {
		System.out.println("result:" + result);
	}
}
