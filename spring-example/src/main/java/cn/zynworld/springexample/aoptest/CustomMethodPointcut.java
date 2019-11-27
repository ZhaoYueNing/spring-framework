package cn.zynworld.springexample.aoptest;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author zhaoyuening
 */
public class CustomMethodPointcut extends StaticMethodMatcherPointcut {

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		// 自定义切点
		return method.getName().equals("customPointcutTest");
	}
}
