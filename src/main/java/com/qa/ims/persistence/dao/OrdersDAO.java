package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrdersDAO implements Dao<Orders>{
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	@Override
	public Orders read(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orders WHERE order_id = ?");) {
			statement.setLong(1, orderId);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orders(fk_customer_id) VALUES (?)");) {
			statement.setLong(1, orders.getCustomerId());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Orders update(Orders orders) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orders SET fk_customer_id = ? WHERE order_id = ?");) {
			statement.setLong(1, orders.getCustomerId());
			statement.setLong(2, orders.getOrderId());
			statement.executeUpdate();
			return read(orders.getOrderId());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orders WHERE order_id = ?");) {
			statement.setLong(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("order_id");
		Long customerId = resultSet.getLong("fk_customer_id");
		List<Items> itemList = getOrderItems(orderId);
		return new Orders(orderId, customerId, itemList);
	}
	
	public Items itemFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("item_id");
		String itemName = resultSet.getString("item_name");
		Double Price = resultSet.getDouble("item_price");
		return new Items(id, itemName, Price);
	}

	public List<Items> getOrderItems(Long id){
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT i.item_id, i.item_name, i.item_price "
						+ "FROM items i "
						+ "INNER JOIN order_items oi ON oi.fk_item_id = i.item_id "
						+ "WHERE oi.fk_order_id = ?;");) {
			statement.setLong(1, id);
			try(ResultSet resultSet = statement.executeQuery();){
				List<Items> items = new ArrayList<Items>();
				while (resultSet.next()) {
					items.add(itemFromResultSet(resultSet));
				}
				return items;
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	
	public int addItemToOrder(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO order_items(fk_order_id, fk_item_id) VALUES (?, ?)");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	public int deleteItemFromOrder(Long orderId, Long itemId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM order_items WHERE fk_order_id = ? AND item_id = ?");) {
			statement.setLong(1, orderId);
			statement.setLong(2, itemId);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}
	
	public double costOfOrder(Long orderId) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT SUM(i.item_price) "
						+ "FROM items i "
						+ "INNER JOIN order_items oi ON oi.fk_item_id = i.item_id "
						+ "WHERE oi.fk_order_id = ?;");) {
			statement.setLong(1, orderId);
			try(ResultSet resultSet = statement.executeQuery();){
				resultSet.next();
				return resultSet.getDouble("SUM(i.item_price)");
			}
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0f;
	}
	
}
