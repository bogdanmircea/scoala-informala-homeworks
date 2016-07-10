package ro.sit.eshop;

public interface OrderItemsDao {
	void createOrderItem(int id, int id_order, int quantity, int id_product);

	void readAll();

	void readOrderItem(int id);

	void deleteOrderItem(int id);

	void updateOrderItemQuantity(int id, int quantity);

}
