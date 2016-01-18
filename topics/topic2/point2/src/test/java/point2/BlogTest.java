package point2;

import java.util.ArrayList;

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
		try {
			testBlog.deleteEntry(newEntry);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		Assert.assertEquals(totalEntrys - 1, testBlog.totalEntrys());
	}
	
	@Test (expected = InvalidInputException.class)
	public void whenAnEntryThatNotBelongToTheBlogIsSentToDeleteThenExceptionIsThrown() throws InvalidInputException{
		testBlog.deleteEntry(newEntry);
	}
	
	@Test
	public void whenTenMostRecentEntriesAreRequestedThenReturnOnlyTen() {
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		ArrayList<Entry> recentTen = testBlog.getTenMostRecentEntries();
		Assert.assertEquals(10, recentTen.size());
	}

	@Test
	public void whenTenMostRecentEntriesAreRequestedAndBlogHaveLessEntriesThenReturnTotalEntries() {
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		testBlog.postEntry(newEntry);
		ArrayList<Entry> recentTen = testBlog.getTenMostRecentEntries();
		Assert.assertEquals(3, recentTen.size());
	}
}
