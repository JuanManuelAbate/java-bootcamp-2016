package point2;

import org.junit.Assert;
import org.junit.Test;

public class BlogTest {

	Blog testBlog = new Blog();
	Entry newEntry = new Entry("title", "body");

	@Test
	public void whenOneEntryIsPostedThenReturnTheTotalEntrysOfBlogPlusOne() {
		int totalEntrys = testBlog.totalEntrys;
		testBlog.postEntry(newEntry);
		Assert.assertEquals(totalEntrys + 1, testBlog.totalEntrys());
	}

	@Test
	public void whenOneEntreIsDeletedThenReturnTheTotalEntrysOfBlogLessOne() {
		testBlog.postEntry(newEntry);
		int totalEntrys = testBlog.totalEntrys;
		testBlog.deleteEntry(newEntry);
		Assert.assertEquals(totalEntrys - 1, testBlog.totalEntrys());
	}

}
