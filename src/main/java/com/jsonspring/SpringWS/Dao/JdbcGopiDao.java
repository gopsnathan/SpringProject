package com.jsonspring.SpringWS.Dao;

import java.sql.*;
import javax.sql.*;

import com.jsonspring.SpringWS.model.Gopi;
public class JdbcGopiDao {
		private static DataSource dataSource;

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
		}

		public void insert(Gopi customer){

			String sql = "INSERT INTO gopi " +
					"(id, firstName, lastName email, reg_date) VALUES (?, ?, ?, ?, ?)";
			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, customer.getCustId());
				ps.setString(2, customer.getFirstName());
				ps.setString(3, customer.getLasttName());
				ps.setString(4, customer.getEmail());
				ps.setString(5, customer.getTimestamp());
				ps.executeUpdate();
				ps.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);

			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {}
				}
			}
		}

		public static Gopi findByCustomerId(int custId){

			String sql = "SELECT * FROM gopi WHERE id = ?";

			Connection conn = null;

			try {
				conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, custId);
				Gopi customer = null;
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					customer = new Gopi(
							rs.getInt("id"),
							rs.getString("firstName"),
							rs.getString("lastName"),
							rs.getString("email"),
							rs.getString("reg_date")
					);
				}
				rs.close();
				ps.close();
				return customer;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} finally {
				if (conn != null) {
					try {
					conn.close();
					} catch (SQLException e) {}
				}
			}
		}
	

}
