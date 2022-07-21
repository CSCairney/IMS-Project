package com.qa.ims.persistence.domain;

import java.util.Objects;

/**
 * Initial class for constructors and getters/setters of customer. Containing customer attributes
 * @author charlesCairney
 *
 */
public class Customer {

	private Long id;
	private String firstName;
	private String surname;

	/**
	 * Constructor class for two values
	 * @param firstName
	 * @param surname
	 */
	public Customer(String firstName, String surname) {
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	/**
	 * Constructor class for three values
	 * @param id
	 * @param firstName
	 * @param surname
	 */
	public Customer(Long id, String firstName, String surname) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setSurname(surname);
	}

	/**
	 * Method the gets the id number of a customer
	 * @return the value of the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id number of a customer
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the first name of the customer
	 * @return the string of the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name of the customer selected
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the surname of the customer
	 * @return the string of the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * Sets the surname of the customer selected
	 * @param surname
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * Returns a full string of the customer with all customer attributes
	 */
	@Override
	public String toString() {
		return "id:" + id + " first name:" + firstName + " surname:" + surname;
	}

	/**
	 * Generates a hashcode for the customer
	 */
	@Override
	public int hashCode() {
		return Objects.hash(firstName, id, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(firstName, other.firstName) && Objects.equals(id, other.id)
				&& Objects.equals(surname, other.surname);
	}

	

}
