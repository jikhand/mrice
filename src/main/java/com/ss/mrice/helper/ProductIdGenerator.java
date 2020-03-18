package com.ss.mrice.helper;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductIdGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {

		String prefix = "PRO";

		Connection connection = session.connection();

		try {
			PreparedStatement ps = connection.prepareStatement("SELECT MAX(prod_id) as value from mrice.tbl_product");
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String proid = rs.getString("value");
				int id = Integer.parseInt(proid.substring(3, proid.length())) + 1;
				String code = prefix + id;
				System.out.println("Generated Stock Code: " + code);
				return code;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
