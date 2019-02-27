package com.jy.service.order;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jy.dao.order.order.OrdersMapper;
import com.jy.dao.order.order.OrderscolseMapper;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.order.order.Orders;
import com.jy.entiy.order.order.Orderscolse;

public class Mythread extends Thread{
	private Long orderid;
	
	public Mythread() {
		
	}
	
	public Mythread(Long orderid) {
		this.orderid = orderid;
	}

	@Override
	public void run() {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
		
		OrderscolseMapper orderscolseMapper = (OrderscolseMapper) context.getBean("orderscolseMapper");
		Orderscolse orderscolse = orderscolseMapper.selectByPrimaryKey(Constant.ORDER_COLSE_TIME);
		try {
			Thread.sleep(orderscolse.getTime()*1000*60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		OrdersMapper ordersMapper = (OrdersMapper) context.getBean("ordersMapper");
		Orders orders =  ordersMapper.selectByPrimaryKey(orderid);
		
		if (orders.getOrderstatus() == 1) {
			orders.setOrderstatus(4);
		}
		orders.setUpdatepersonid(-1L);
		orders.setUpdatetime(new Date());
		ordersMapper.updateByPrimaryKeySelective(orders);
	}
	
	
}
