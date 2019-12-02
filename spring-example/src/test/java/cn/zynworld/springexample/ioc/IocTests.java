package cn.zynworld.springexample.ioc;

import cn.zynworld.springexample.ioctest.service.Order;
import cn.zynworld.springexample.ioctest.service.OrderService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author zhaoyuening
 */
public class IocTests {

	/**
	 * 通过 xml 配置文件方式来构建bean
	 */
	@Test
	public void buildBeanByXmlTest() {
		BeanDefinitionRegistry beanRegister = new DefaultListableBeanFactory();

		// 通过 BeanDefinitionReader 来对配置文件进行解析
		BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanRegister);
		beanDefinitionReader.loadBeanDefinitions("classpath:ioc/beans.xml");

		// 使用bean工厂获取对象
		BeanFactory beanFactory = (BeanFactory) beanRegister;
		OrderService orderService = beanFactory.getBean(OrderService.class);

		// 调用方法
		Order order = new Order();
		order.setOrderId(100L);
		orderService.saveOrder(order);
	}
}
