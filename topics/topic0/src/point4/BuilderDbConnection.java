package point4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BuilderDbConnection {

	private String driver;
	private String url;
	private String user;
	private String pass;
	private Connection conn;

	static final class BuilderConnection {

		private String builderDriver;
		private String builderUrl;
		private String builderUser;
		private String builderPass;

		public BuilderConnection setDriver(String driver) {
			this.builderDriver = driver;
			return this;
		}

		public BuilderConnection setUrl(String url) {
			this.builderUrl = url;
			return this;
		}

		public BuilderConnection setUser(String user) {
			this.builderUser = user;
			return this;
		}

		public BuilderConnection setPass(String pass) {
			this.builderPass = pass;
			return this;
		}

		public BuilderDbConnection buildConnection() {
			if (builderDriver == null) {
				throw new IllegalStateException("No driver");
			}
			if (builderUrl == null) {
				throw new IllegalStateException("No url");
			}
			if (builderUser == null) {
				throw new IllegalStateException("No user");
			}
			if (builderPass == null) {
				throw new IllegalStateException("No pass");
			}
			return new BuilderDbConnection(this);
		}
	}

	private BuilderDbConnection(BuilderConnection builder) {

		driver = builder.builderDriver;
		url = builder.builderUrl;
		user = builder.builderUser;
		pass = builder.builderPass;

		try {
			Class.forName("driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection("url", "user", "pass");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
