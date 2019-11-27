package cn.zynworld.springexample.aoptest;

import org.springframework.stereotype.Component;

/**
 * @author zhaoyuening
 */
@Component
public class AopHelloService {

	@AopMethodMatchingAnnotation
	public void sayHello(String name){
		String hello = "hello " + name;
		System.out.println(hello);
	}

	public void customPointcutTest() {
		System.out.println("test custom pointcut!");
	}
}
