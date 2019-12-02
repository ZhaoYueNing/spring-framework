package cn.zynworld.springexample.ioctest.service;

/**
 * @author zhaoyuening
 */
public class OrderRepositoryImpl implements OrderRepository {

	public OrderRepositoryImpl() {
	}

	@Override
	public void saveOrder(Order order) {
		System.out.println("saved order. orderId:" + order.getOrderId());
	}
}
