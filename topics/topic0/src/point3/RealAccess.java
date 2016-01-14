package point3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import point1.DbConnection;

public class RealAccess implements Query {

	public RealAccess() {

	}

	@Override
	public String executeQuery(String sentence) {
		Statement stmt;
		try {
			stmt = DbConnection.getInstance().getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sentence);
			String result = rs.toString();
			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
