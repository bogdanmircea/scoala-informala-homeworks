package ro.sit.eshop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderItemsDaoImpl extends AbstractModelDao implements OrderItemsDao {
	private Connection conn;
	private int id;
	private int id_order;
	private int quantity;
	private int id_product;
	private int counter;
	private static int numberOfOrderItems;

	public OrderItemsDaoImpl() {
		conn = getDbConnection("postgresql", "localhost", 5432, "eshop", "postgres", "Bogdan123!");
	}

	@Override
	protected Connection getDbConnection(String type, String host, int port, String dataBase, String user, String password) {
		return super.getDbConnection(type, host, port, dataBase, user, password);
	}

	@Override
	public void createOrderItem(int id, int id_order, int quantity, int id_product) {
		PreparedStatement ps = null;
		String sqlQuery = "INSERT INTO orderitems(id, id_order, quantity, id_product) VALUES (" + id + ", '" + id_order + "', '" + quantity + "', '"
				+ id_product + "')";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
		counter = ++numberOfOrderItems;
	}

	public int getcounter() {
		return counter;
	}

	@Override
	public void readAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM orderitems";
			ps = conn.prepareStatement(sqlQuery);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				System.out.format(format, "id", "id_order", "quantity", "id_product");
				do {
					System.out.format(format, rs.getInt("id"), rs.getInt("id_order"), rs.getInt("quantity"), rs.getInt("id_product"));
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
	public void readOrderItem(int id) {
		PreparedStatement ps = null;
		ResultSet rs = null;

		final String format = "%10s%12s%20s%20s\n";

		try {
			String sqlQuery = "SELECT * FROM orderitems WHERE id=?";
			ps = conn.prepareStatement(sqlQuery);

			ps.setInt(1, id);
			rs = ps.executeQuery();

			boolean hasResults = rs.next();
			if (hasResults) {

				this.id = rs.getInt("id");
				this.id_order = rs.getInt("id_order");
				this.quantity = rs.getInt("quantity");
				this.id_product = rs.getInt("id_product");
				System.out.format(format, id, id_order, quantity, id_product);

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
	public void deleteOrderItem(int id) {
		PreparedStatement ps = null;
		String sqlQuery = "DELETE FROM orderitems WHERE id=?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(1, id);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

	@Override
	public void updateOrderItemQuantity(int id, int quantity) {
		PreparedStatement ps = null;
		String sqlQuery = "update orderitems set quantity = ? where id =?";
		try {
			ps = conn.prepareStatement(sqlQuery);
			ps.setInt(2, id);
			ps.setInt(1, quantity);
			ps.executeQuery();
		}
		catch (SQLException e) {
		}
	}

}
