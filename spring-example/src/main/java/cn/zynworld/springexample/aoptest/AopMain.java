package cn.zynworld.springexample.aoptest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * @author zhaoyuening
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cn.zynworld.springexample.aoptest")
public class AopMain {

	@Bean(name = "customPointcut")
	public org.springframework.aop.Pointcut customPointcut() {
		return new CustomMethodPointcut();
	}

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AopMain.class);
		AopHelloService helloService = applicationContext.getBean(AopHelloService.class);
		helloService.sayHello("zhao");
	}
}
