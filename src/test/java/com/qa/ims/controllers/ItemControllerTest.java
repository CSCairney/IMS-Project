package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.ItemController;
import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class ItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private ItemsDAO DAO;

	@InjectMocks
	private ItemController controller;

	@Test
	public void testCreate() {
		final String itemName = "dragon";
		final double Price = (double)200.50;
		final Items item = new Items(itemName, Price);

		Mockito.when(utils.getString()).thenReturn(itemName);
		Mockito.when(utils.getDouble()).thenReturn(Price);
		Mockito.when(DAO.create(item)).thenReturn(item);

		assertEquals(item, controller.create());

		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(DAO, Mockito.times(1)).create(item);

	}
	
	@Test
	public void testReadAll() {
		List<Items> item = new ArrayList<>();
		item.add(new Items(1L, "Cat", (double) 100.20));

		Mockito.when(DAO.readAll()).thenReturn(item);

		assertEquals(item, controller.readAll());

		Mockito.verify(DAO, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		Items item = new Items(1L, "Dog", (double)50.50);

		Mockito.when(this.utils.getLong()).thenReturn(1L);
		Mockito.when(this.utils.getString()).thenReturn(item.getItemName());
		Mockito.when(this.utils.getDouble()).thenReturn(item.getPrice());
		Mockito.when(this.DAO.update(item)).thenReturn(item);

		assertEquals(item, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(1)).getLong();
		Mockito.verify(this.utils, Mockito.times(1)).getString();
		Mockito.verify(this.utils, Mockito.times(1)).getDouble();
		Mockito.verify(this.DAO, Mockito.times(1)).update(item);
	}

	@Test
	public void testDelete() {
		final long Id = 1L;

		Mockito.when(utils.getLong()).thenReturn(Id);
		Mockito.when(DAO.delete(Id)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(DAO, Mockito.times(1)).delete(Id);
	}

	
}
