package cn.zynworld.springexample.ioctest.service;

/**
 * @author zhaoyuening
 */
public class OrderService {

	private OrderRepository orderRepository;

	public void saveOrder(Order order) {
		orderRepository.saveOrder(order);
	}

	public void setOrderRepository(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
}
