package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for the CRUD functionality
 * @author charlesCairney
 *
 */
public class ItemController implements CrudController<Items> {
	
	public static final Logger LOGGER = LogManager.getLogger();
	
	private ItemsDAO itemsDAO;
	private Utils utils;
	
	public ItemController(ItemsDAO itemsDAO, Utils utils) {
		super();
		this.itemsDAO = itemsDAO;
		this.utils = utils;
	}
	

	/**
	 * Reads all items to the Logger.
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemsDAO.readAll();
		for (Items Item : items) {
			LOGGER.info(Item);
		}
		return items;
	}

	/**
	 * Creates an item based on the users inputs of name & price.
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item price");
		Double Price = utils.getDouble();
		Items item = itemsDAO.create(new Items(itemName, Price));
		LOGGER.info("Item created");
		return item;
	}


	/**
	 * Updates an existing item based on user inputs.
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter item name");
		String itemName = utils.getString();
		LOGGER.info("Please enter item price");
		Double Price = utils.getDouble();
		Items item = itemsDAO.update(new Items(id, itemName, Price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes a item present based on the users orderId input
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemsDAO.delete(id);
	}

}
