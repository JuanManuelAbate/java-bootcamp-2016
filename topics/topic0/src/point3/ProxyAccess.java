package point3;

public class ProxyAccess implements Query {

	private RealAccess connection = null;

	public ProxyAccess() {

	}

	@Override
	public String executeQuery(String sentence) {
		if (connection == null) {
			connection = new RealAccess();
		}
		return connection.executeQuery(sentence);
	}

}
