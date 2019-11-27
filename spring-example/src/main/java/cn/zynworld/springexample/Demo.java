package cn.zynworld.springexample;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author zhaoyuening
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "cn.zynworld.springexample")
public class Demo {


	public static class Student {

		private String name = "zhao";

		public String getName() {
			return name;
		}

	}

	@Bean
	public Student student() {
		return new Student();
	}

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Demo.class);
		Student student = applicationContext.getBean(Student.class);
		System.out.println(student.getName());
	}
}
