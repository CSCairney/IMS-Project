package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.Utils;

/**
 * Takes in Order details for CRUD controller
 * @author charlesCairney
 *
 */
public class OrderController implements CrudController<Orders> {

	public static final Logger LOGGER = LogManager.getLogger();

	private OrdersDAO ordersDAO;
	private Utils utils;

	public OrderController(OrdersDAO ordersDAO, Utils utils) {
		super();
		this.ordersDAO = ordersDAO;
		this.utils = utils;
	}

	/**
	 * Reads all orders present in the database.
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orders = ordersDAO.readAll();
		for (Orders order : orders) {
			LOGGER.info(order);
		}
		return orders;
	}

	/**
	 * Creates an order based on the customers input.
	 */
	@Override
	public Orders create() {
		LOGGER.info("Insert CustomerId for order:");
		Long customerId = utils.getLong();

		Orders order = ordersDAO.create(new Orders(customerId));
		LOGGER.info("Order has been created");
		return order;
	}

	/**
	 * Updates an order based on the customers input.
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please insert order Id you would like to change:");
		Long orderId = utils.getLong();
		LOGGER.info("Enter new customerId for associated order id:");
		Long customerId = utils.getLong();
		Orders order = ordersDAO.update(new Orders(orderId, customerId));
		return order;
	}

	/**
	 * Deletes an order based on customers input.
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter order Id to remove:");
		Long orderId = utils.getLong();
		return ordersDAO.delete(orderId);
	}

	/**
	 * Adds an item to an existing order based on user input.
	 * @return The use of the delete item from order method in ordersDAO
	 */
	public int addItem() {
		LOGGER.info("Please enter which Order Id to ammend item to: ");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter Item Id to ammend to Order: ");
		Long itemId = utils.getLong();
		return ordersDAO.addItemToOrder(orderId, itemId);
	}

	/**
	 * Removes an item to an existing order based on user input
	 * @return calls the remove item method in ordersDAO based on inputs.
	 */
	public int deleteItem() {
		LOGGER.info("Please enter which Order Id to remove item from: ");
		Long orderId = utils.getLong();
		LOGGER.info("Please enter Item Id to remove: ");
		Long itemId = utils.getLong();
		return ordersDAO.deleteItemFromOrder(orderId, itemId);
	}

	/**
	 * Calculates the cost of an order based on user input
	 * @return sends inputs to the cost of order method in ordersDAO
	 */
	public double cost() {
		LOGGER.info("Please enter Order Id for total cost:");
		Long orderId = utils.getLong();
		double cost = ordersDAO.costOfOrder(orderId);
		LOGGER.info("Total Order Cost = £" + cost);
		return cost;
	}

}