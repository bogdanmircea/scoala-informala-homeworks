package ro.sit.eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDaoImpl extends AbstractModelDao implements CustomerDao {

	private int counter;
	private static int numberOfCustomers = 0;
	private int id;
	private String name;
	private String email;
	private Connection conn;

	public CustomerDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "Bogdan123!");
	}

	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user, String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	@Override
	public void createCustomer(int id, String name, String email) {

		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO customer(id, name, email) VALUES (" + id + ", '" + name + "', '" + email + "')";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.executeQuery();

		}
		catch (SQLException e) {
		}
		counter = ++numberOfCustomers;
	}

	public int getcounter() {
		return counter;
	}

	@Override
	public void updateCustomerName(int id, String name) {

		PreparedStatement ps = null;
		String sqlQuery = "update customer set name = ? where id =?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(2, id);
			ps.setString(1, name);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

	@Override
	public void updateCustomerEmail(int id, String email) {

		PreparedStatement ps = null;
		String sqlQuery = "update customer set email = ? where id =?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(2, id);
			ps.setString(1, email);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

	@Override
	public void readAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM customer";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "name", "email");
				do {
					System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("email"));
				}
				while (rs.next());

			}
			else {
				System.out.println("No results");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void readCustomer(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM customer WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {
				this.id = rs.getInt("id");
				this.name = rs.getString("name");
				this.email = rs.getString("email");
				System.out.format(format, id, name, email);

			}
			else {
				System.out.println("No results");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(int id) {

		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM customer WHERE id=?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}
}
