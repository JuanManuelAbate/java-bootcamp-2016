package point3;

import java.sql.ResultSet;

import javax.management.Query;

import point1.DbConnection;

public class ProxyAccessor implements Accessor {

	private DbConnection connection = null;

	public ProxyAccessor() {

	}

	@Override
	public ResultSet executeQuery(Query sentence) {
		if (connection == null) {
			connection = DbConnection.getInstance();
		}
		return connection.executeQuery(sentence);
	}

}
