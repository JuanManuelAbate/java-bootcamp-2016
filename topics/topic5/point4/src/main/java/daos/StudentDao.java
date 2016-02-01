package daos;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

import com.mongodb.MongoClient;

import entities.Student;

public class StudentDao extends BasicDAO<Student, ObjectId> {

	public StudentDao(Morphia morphia, MongoClient mongo) {
		super(mongo, morphia, "high-school");
	}

	public QueryResults<Student> findByCoursePassed(Datastore datastore, String courseName) {
		Query<Student> query = datastore.createQuery(Student.class);
		query.and(query.criteria("courses.courseName").equal(courseName),
				query.criteria("courses.finalNote").greaterThanOrEq(4));
		return this.find(query);
	}
}
