package ro.sit.eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDaoImpl extends AbstractModelDao implements ProductDao {

	private Connection conn;
	private int id;
	private String name;
	private String description;
	private int counter;
	private static int numberOfCustomers;

	public ProductDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "Bogdan123!");
	}

	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user, String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	@Override
	public void createProduct(int id, String name, String description) {
		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO products(id, name, description) VALUES (" + id + ", '" + name + "', '" + description + "')";
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
	public void readAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM products";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "name", "description");
				do {
					System.out.format(format, rs.getInt("id"), rs.getString("name"), rs.getString("description"));
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
	public void readProduct(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM products WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				this.id = rs.getInt("id");
				this.name = rs.getString("name");
				this.description = rs.getString("description");
				System.out.format(format, id, name, description);

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
	public void deleteProduct(int id) {
		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM products WHERE id=?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

	@Override
	public void updateProductName(int id, String name) {
		PreparedStatement ps = null;
		String sqlQuery = "update products set name = ? where id =?";
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
	public void updateProductDescription(int id, String description) {
		PreparedStatement ps = null;
		String sqlQuery = "update products set description = ? where id =?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(2, id);
			ps.setString(1, description);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

}
