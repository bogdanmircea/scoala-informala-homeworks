package ro.sit.eshop;

public interface CustomerDao {

	void createCustomer(int id, String name, String email);

	void readAll();

	void readCustomer(int id);

	void deleteCustomer(int id);

	void updateCustomerName(int id, String name);

	void updateCustomerEmail(int id, String email);

}
