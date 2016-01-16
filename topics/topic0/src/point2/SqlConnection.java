package point2;

import java.sql.ResultSet;

import javax.management.Query;

public interface SqlConnection {

	/**
	 * Metod to execute a query in to a DB
	 * 
	 * @param sentence
	 * @return result of the query
	 */
	public ResultSet executeQuery(Query sentence);
}
