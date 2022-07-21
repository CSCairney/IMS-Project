Coverage: 71%
# IMS Inventory Management System - By Charles Cairney

This repo is for te creation of an IMS (Inventory Management System) for QA.
The original repo that the template was source from was by @JHarry444 https://github.com/QACTrainers/IMS-Starter

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

Firstly you will need the the Java SE Development kit which can be found here  <br>https://www.oracle.com/java/technologies/downloads/ <br>
Secondly you will also need a version of MySQL Community including MySQL Workbench  <br>https://dev.mysql.com/downloads/windows/installer/8.0.html <br>
Finally you will need to have Apache Maven for testing  <br>https://maven.apache.org/download.cgi <br>
 - With Maven you will need two dependencies:  <br>
         [JUnit](https://mvnrepository.com/artifact/junit/junit) <br>
        [Mockito](https://mvnrepository.com/artifact/org.mockito/mockito-core) <br>

### Installing

Here is how to acquire and get the program running: <br>
```
STEP01:
Vist Clone the repository using gitBash to your local computer in a safe location.
```
```
STEP02:
In IMS-Project\src\main\resources you must do the following steps
 - Open the sql-schema.sql in your MySQL WorkBench
 - Open the sql-data.sql in your MySQL Workbench
 - Run both files in MySQL 
 - Now you need to change the db.properties to have your local access (Shown below)

db.url=jdbc:mysql://localhost:3306/ims
db.user="username here" - (if forgotten attempt = root)
db.password="password here" - (if forgotten attempt = root)
```
### Example of Build

<b>1. Here is the initial options page to direct the user to the correct space. Here we will choose order by typing "order" (not case sensitive)</b><br>
<img src=https://i.imgur.com/u7XVQd5.png/><br>
<b>2. Here is the Domain selection page where we choose the type of item we would like to view/alter. Here we will read the order then calculate cost.</b><br>
<img src=https://i.imgur.com/yhFLKkZ.png/><br>
<b>3. here we will type "read" or "READ" to display all orders.</b><br>
<img src=https://i.imgur.com/jjbg6GD.png/><br>
<b>4. Now we choose cost by typing "cost" or "COST".</b><br>
<b>5. Then we enter the orderId to select order to calculate.</b><br>
<img src=https://i.imgur.com/UtnLZyl.png/><br>
<b>6. Finally we will Use the return function then the stop function to close the application.</b><br>
<img src=https://i.imgur.com/LzuOEpv.png/><br>
<b>7. Enjoy the application!</b>



## Running the tests

Once all Prerequisites have been complete you gain access to the testing feature through the src/test/java.<br>
- Select folder with right click.
- Select "Coverage As"
- Select "JUnit test"
This will run all the tests and generate a coverage table indicating how much of the code has been covered in the testing and what percentage passed/failed/errored.

### Unit Tests 

Unit testing is a testing method where you test smaller isolated pieces of code that can be used logically by setting up condition to use before testing.<br>
An example of where unit testing was used in our project was for the getter/setter/toString methods of each class (customer, orders, items)<br>

```
@Test
	public void toStringTest() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(("Orders [customerId=" + order.getCustomerId() + ", orderId=" + order.getOrderId() + ", itemList="
				+ order.getItemList() + "]"), order.toString());
	}
  
```
```
@Test
	public void testSetCustomerId() {
		order = new Orders(orderId, customerId, itemList);
		order.setCustomerId((long) 13);
		assertEquals((long) 13, order.getCustomerId(), 0.0001);

	}
```
```
@Test
	public void testGetOrderId() {
		order = new Orders(orderId, customerId, itemList);
		assertEquals(orderId, order.getOrderId());
	}
```



### Integration Tests 
Integration testing is where you test multiple combined components of a application to see if they logically work together.<br>
Here we used Integration testing for our controllers for each (ItemController, OrdersController and CustomerController)<br>

```
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
```
```
@Test
	public void testUpdate() {
		final Long orderId = 1L, customerId = 2L;
		final Orders order = new Orders(orderId, customerId);

		Mockito.when(utils.getLong()).thenReturn(orderId, customerId);
		
		Mockito.when(DAO.update(order)).thenReturn(order);
		
		assertEquals(order, controller.update());
		
		Mockito.verify(this.utils, Mockito.times(2)).getLong();
		Mockito.verify(this.DAO, Mockito.times(1)).update(order);
		
	}
```
```
@Test
	public void testDelete() {
		final long ID = 1L;

		Mockito.when(utils.getLong()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1L, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](https://github.com/) for versioning.

## Authors

* **Charles Cairney** - *Final Product* - [CharlesCairney](https://github.com/CSCairney)
* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* **Jordan Benbelaid** - *Trainer* - [JordanBenBelaid](https://github.com/jordanbenbelaid)
* **User Guide** - *Testing Developer* - [JUnit](https://junit.org/junit5/docs/current/user-guide/#running-tests)
* **Edward Reynolds** - *Trainer* - [Edward Reynolds](https://github.com/Edrz-96)
* **Piers Barber** - *Trainer* - [Piers Barber](https://github.com/PCMBarber)
