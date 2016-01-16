package point2;

public abstract class AbstractSqlFactory {
	abstract SqlConnection getSqlConnectionType(String type);
}
