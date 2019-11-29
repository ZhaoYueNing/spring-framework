package cn.zynworld.springexample.ioctest;

import cn.zynworld.springexample.ioctest.service.Order;
import cn.zynworld.springexample.ioctest.service.OrderRepositoryImpl;
import cn.zynworld.springexample.ioctest.service.OrderService;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * @author zhaoyuening
 */
public class IocTestMain {

	/**
	 * 通过编码方式录入bean信息
	 */
	public static void buildBeansByCode() {
		DefaultListableBeanFactory beanRegister = new DefaultListableBeanFactory();

		// 创建 beanDefinition
		BeanDefinitionBuilder orderServiceDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OrderService.class);
		BeanDefinitionBuilder orderRepositoryDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(OrderRepositoryImpl.class);

		// 配置依赖
		orderServiceDefinitionBuilder.addPropertyReference("orderRepository", "orderRepository");

		// 注入 beanDefinition
		beanRegister.registerBeanDefinition("orderService",orderServiceDefinitionBuilder.getRawBeanDefinition());
		beanRegister.registerBeanDefinition("orderRepository", orderRepositoryDefinitionBuilder.getRawBeanDefinition());

		// 使用bean工厂获取对象
		BeanFactory beanFactory = beanRegister;
		OrderService orderService = beanFactory.getBean(OrderService.class);

		// 调用方法
		Order order = new Order();
		order.setOrderId(100L);
		orderService.saveOrder(order);
	}


	public static void main(String[] args) {
		// 通过编码方式构建bean及其依赖
		buildBeansByCode();

	}
}
