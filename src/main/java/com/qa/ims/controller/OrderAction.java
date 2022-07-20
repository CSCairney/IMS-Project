package com.qa.ims.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

public enum OrderAction {
	CREATE("To save a new entity into the database"), READ("To read an order from the database"),
	UPDATE("To change an order already in the database"), DELETE("To remove an order from the database"),
	ADD_ITEM("To add an item to the order selected"), DELETE_ITEM("To delete an item from the order selected"),
	COST("To calculate the total cost of an order"), RETURN("To return to domain selection");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	OrderAction(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	public static void printActions() {
		for (OrderAction action : OrderAction.values()) {
			LOGGER.info(action.getDescription());
		}
	}

	public static OrderAction getAction(Utils utils) {
		OrderAction action = null;
		do {
			try {
				action = OrderAction.valueOf(utils.getString().toUpperCase());
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		} while (action == null);
		return action;
	}
}
