package point4;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import daos.StudentDao;
import entities.Student;

public class Main {
	public static void main(String[] args) {

		String dbName = new String("high-school");
		MongoClient mongoClient = new MongoClient();
		Morphia morphia = new Morphia();
		Datastore datastore = morphia.createDatastore(mongoClient, dbName);
		morphia.mapPackage("entities");
		StudentDao studentDao = new StudentDao(morphia, mongoClient);

		QueryResults<Student> queryResult = studentDao.findByCoursePassed(datastore, "course1");
	}
}
