package ro.sit.eshop;

import java.util.Date;

public class Main {

	public static void main(String[] args) {

		loadDriver();

		CustomerDaoImpl customer = new CustomerDaoImpl();
		OrderDaoImpl order = new OrderDaoImpl();
		ProductDaoImpl product = new ProductDaoImpl();
		OrderItemsDaoImpl orderitems = new OrderItemsDaoImpl();

		product.createProduct(1, "Sampon", "Par colorat");
		product.createProduct(2, "Sapun", "Maini fine");
		product.createProduct(3, "Pistol", "Cu apa");
		product.createProduct(4, "Pusca", "Automata");
		product.createProduct(5, "Hamburger", "De vita");
		// product.readProduct(1);
		// product.deleteProduct(1);
		// product.updateProductName(1, "Sapun");
		// product.updateProductDescription(1, "Pt fata");
		product.readAll();
		System.out.println(product.getcounter());

		System.out.println("================================================");

		customer.createCustomer(1, "Bobo", "bobo@mail.com");
		customer.createCustomer(2, "Anda", "anda@mail.com");
		customer.createCustomer(3, "Caine", "caine@mail.com");
		customer.createCustomer(4, "Pisica", "pisi@mail.com");
		customer.readAll();
		System.out.println(customer.getcounter());
		// customer.deleteCustomer(1);
		// customer.readCustomer(2);
		// customer.updateCustomerName(3, "Vaca");
		// customer.updateCustomerEmail(3, "vaca@email.com");
		// customer.readAll();
		System.out.println("================================================");

		order.createOrder(1, 23.5, new Date(), true, 1);
		order.createOrder(2, 21.5, new Date(), false, 2);
		order.createOrder(3, 24.5, new Date(), false, 3);
		order.createOrder(4, 53.5, new Date(), true, 4);
		order.createOrder(5, 73.5, new Date(), true, 5);
		order.readAll();
		System.out.println(order.getcounter());
		System.out.println("================================================");
		// order.deleteOrder(2);
		// order.readAll();
		orderitems.createOrderItem(1, 1, 12, 1);
		orderitems.createOrderItem(2, 2, 33, 2);
		orderitems.createOrderItem(3, 3, 333, 3);
		orderitems.createOrderItem(4, 4, 43, 3);
		orderitems.createOrderItem(5, 5, 123, 4);
		orderitems.readAll();
		System.out.println(orderitems.getcounter());

		// orderitems.updateOrderItemQuantity(1, 3);
		// orderitems.deleteOrderItem(2);
		// orderitems.deleteOrderItem(1);
		// orderitems.readAll();
		// orderitems.readOrderItem(2);
	}

	public static void loadDriver() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		}
		catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
