package ro.sit.eshop;

public interface ProductDao {
	void createProduct(int id, String name, String description);

	void readAll();

	void readProduct(int id);

	void deleteProduct(int id);

	void updateProductName(int id, String name);

	void updateProductDescription(int id, String description);
}
