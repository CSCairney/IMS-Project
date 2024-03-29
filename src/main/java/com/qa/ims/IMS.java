package com.qa.ims;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.controller.Action;
import com.qa.ims.controller.CrudController;
import com.qa.ims.controller.CustomerController;
import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderAction;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.dao.OrdersDAO;
import com.qa.ims.persistence.domain.Domain;
import com.qa.ims.utils.DBUtils;
import com.qa.ims.utils.Utils;

public class IMS {

	public static final Logger LOGGER = LogManager.getLogger();

	private final CustomerController customers;
	private final Utils utils;
	private final ItemController items;
	private final OrderController orders;

	public IMS() {
		this.utils = new Utils();
		final CustomerDAO custDAO = new CustomerDAO();
		this.customers = new CustomerController(custDAO, utils);
		final ItemsDAO itemsDAO = new ItemsDAO();
		this.items = new ItemController(itemsDAO, utils);
		final OrdersDAO ordersDAO = new OrdersDAO();
		this.orders = new OrderController(ordersDAO, utils);
	}

	/**
	 * First method which greets the user and takes the input of the user for which domain.
	 * Prints all domain types. Also calls the stop function to end the program.
	 */
	public void imsSystem() {
		LOGGER.info("Welcome to the Inventory Management System! CharlesCairney.Inc");
		DBUtils.connect();

		Domain domain = null;
		do {
			LOGGER.info("Which field would you like to use?");
			Domain.printDomains();

			domain = Domain.getDomain(utils);

			domainAction(domain);

		} while (domain != Domain.STOP);
	}

	/**
	 * Takes the domain selected and activates the domain selected print their options in respective CRUD controller,
	 * with options.
	 * Special case for domain here if ORDER is selected as order required more than the basic options therefore calls the
	 * orderAction instead.
	 * @param domain
	 */
	private void domainAction(Domain domain) {
		boolean changeDomain = false;
		do {

			CrudController<?> active = null;
			switch (domain) {
			case CUSTOMER:
				active = this.customers;
				break;
			case ITEMS:
				active = this.items;
				break;
			case ORDER:
				active = this.orders;
				break;
			case STOP:
				return;
			default:
				break;
			}

			LOGGER.info(() ->"What would you like to do with " + domain.name().toLowerCase() + ":");
			if(domain.equals(Domain.ORDER)) {
				OrderAction.printActions();
				OrderAction action = OrderAction.getAction(utils);
				if (action == OrderAction.RETURN) {
					changeDomain = true;
				} else {
					doOrderAction(active, action);
				}
			}
			else {
				Action.printActions();
				Action action = Action.getAction(utils);
				if (action == Action.RETURN) {
					changeDomain = true;
				} else {
					doAction(active, action);
				}
			}

			
		} while (!changeDomain);
	}

	/**
	 * Method for the selection of which CRUD controller action to use from the Action Enum.
	 * @param crudController
	 * @param action
	 */
	public void doAction(CrudController<?> crudController, Action action) {
		switch (action) {
		case CREATE:
			crudController.create();
			break;
		case READ:
			crudController.readAll();
			break;
		case UPDATE:
			crudController.update();
			break;
		case DELETE:
			crudController.delete();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}

	/**
	 * Method for the selection of which CRUD controller action to use from the OrderAction Enum.
	 * @param crudController
	 * @param action
	 */
	public void doOrderAction(CrudController<?> crudController, OrderAction action) {
		OrderController controller = (OrderController) crudController;
		switch (action) {
		case CREATE:
			controller.create();
			break;
		case READ:
			controller.readAll();
			break;
		case UPDATE:
			controller.update();
			break;
		case DELETE:
			controller.delete();
			break;
		case ADD_ITEM:
			controller.addItem();
			break;
		case DELETE_ITEM:
			controller.deleteItem();
			break;
		case COST:
			controller.cost();
			break;
		case RETURN:
			break;
		default:
			break;
		}
	}
}
