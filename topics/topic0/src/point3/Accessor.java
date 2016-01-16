package point3;

import java.sql.ResultSet;

import javax.management.Query;

public interface Accessor {

	/**
	 * Metod to execute a query in to a DB
	 * 
	 * @param sentence
	 * @return result of the query
	 */
	public ResultSet executeQuery(Query sentence);
}
