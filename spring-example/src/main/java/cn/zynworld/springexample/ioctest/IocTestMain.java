package cn.zynworld.springexample.ioctest;

import cn.zynworld.springexample.ioctest.service.Order;
import cn.zynworld.springexample.ioctest.service.OrderRepositoryImpl;
import cn.zynworld.springexample.ioctest.service.OrderService;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.*;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;

/**
 * @author zhaoyuening
 */
public class IocTestMain {

	/**
	 * 通过编码方式录入bean信息
	 */
	private static void buildBeansByCode() {
		// DefaultListableBeanFactory 实现了BeanDefinitionRegistry & BeanFactory 接口
		// BeanFactory 负责对 bean 进行获取 面向使用者
		// BeanDefinitionRegistry 负责对bean进行注册及依赖管理
		BeanDefinitionRegistry beanRegister = new DefaultListableBeanFactory();

		// 创建 beanDefinition
		BeanDefinitionBuilder orderServiceDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OrderService.class);
		BeanDefinitionBuilder orderRepositoryDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OrderRepositoryImpl.class);

		// 配置依赖
		orderServiceDefinitionBuilder.addPropertyReference("orderRepository", "orderRepository");

		// 注入 beanDefinition
		beanRegister.registerBeanDefinition("orderService",orderServiceDefinitionBuilder.getRawBeanDefinition());
		beanRegister.registerBeanDefinition("orderRepository", orderRepositoryDefinitionBuilder.getRawBeanDefinition());

		// 使用bean工厂获取对象
		BeanFactory beanFactory = (BeanFactory) beanRegister;
		OrderService orderService = beanFactory.getBean(OrderService.class);

		// 调用方法
		Order order = new Order();
		order.setOrderId(100L);
		orderService.saveOrder(order);
	}

	/**
	 * 通过 xml 配置文件方式来构建bean
	 */
	private static void buildBeanByXml() {
		BeanDefinitionRegistry beanRegister = new DefaultListableBeanFactory();

		// 通过 BeanDefinitionReader 来对配置文件进行解析
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanRegister);
		beanDefinitionReader.loadBeanDefinitions("classpath:ioctest/beans.xml");

		// 使用bean工厂获取对象
		BeanFactory beanFactory = (BeanFactory) beanRegister;
		OrderService orderService = beanFactory.getBean(OrderService.class);

		// 调用方法
		Order order = new Order();
		order.setOrderId(100L);
		orderService.saveOrder(order);
	}


	public static void main(String[] args) {
		// 通过编码方式构建bean及其依赖
		// buildBeansByCode();

		// 通过xml配置文件来构建bean
		buildBeanByXml();
	}
}
