package com.qa.ims.persistence.domain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Enum containing all entities and their descriptions
 * @author charlesCairney
 *
 */
public enum Domain {

	CUSTOMER("Information about customers"), ITEMS("Individual Items"), ORDER("Purchases of items"),
	STOP("To close the application");

	public static final Logger LOGGER = LogManager.getLogger();

	private String description;

	private Domain(String description) {
		this.description = description;
	}

	/**
	 * Gets description of enum selected
	 * @return description string
	 */
	public String getDescription() {
		return this.name() + ": " + this.description;
	}

	/**
	 * Prints all domains in enum
	 */
	public static void printDomains() {
		for (Domain domain : Domain.values()) {
			LOGGER.info(domain.getDescription());
		}
	}

	/**
	 * Gets the domain selected
	 * @param utils
	 * @return domain selected or response telling the user to try again if domain is not present in enum
	 */
	public static Domain getDomain(Utils utils) {
		Domain domain;
		while (true) {
			try {
				domain = Domain.valueOf(utils.getString().toUpperCase());
				break;
			} catch (IllegalArgumentException e) {
				LOGGER.error("Invalid selection please try again");
			}
		}
		return domain;
	}

}
