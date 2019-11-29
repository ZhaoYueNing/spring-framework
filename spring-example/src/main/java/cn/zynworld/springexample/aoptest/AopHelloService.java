package cn.zynworld.springexample.aoptest;

import org.springframework.stereotype.Component;

/**
 * @author zhaoyuening
 */
@Component
public class AopHelloService {

	public AopHelloService() {
		System.out.println("init start");
	}

	@AopMethodMatchingAnnotation
	public void sayHello(String name){
		String hello = "hello " + name;
		System.out.println(hello);
	}

	public void customPointcutTest() {
		System.out.println("test custom pointcut!");
	}

	@AopMethodTimeAnnotation
	public void testTimeLog() throws InterruptedException {
		Thread.sleep(1000);
	}
}
