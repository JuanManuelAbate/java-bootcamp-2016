package point2;

public class SqlFactory extends AbstractSqlFactory {

	@Override
	public SqlConnection getSqlConnectionType(String type) {
		if (type == null) {
			return null;
		}

		if (type.equals("mysql")) {
			return MySql.getInstance();
		} else if (type.equals("postgresql")) {
			return PostgreSql.getInstance();
		}
		return null;
	}

}
