package point2;

import java.util.ArrayList;
import java.util.List;

public class Blog {

	int totalEntrys;
	private List<Entry> entrys;

	public Blog() {
		totalEntrys = 0;
		entrys = new ArrayList<Entry>();
	}

	public void postEntry(Entry entry) {
		entrys.add(entry);
		totalEntrys = totalEntrys + 1;
	}

	public void deleteEntry(Entry entry) {
		entrys.remove(entry);
		totalEntrys = totalEntrys - 1;
	}

	public int totalEntrys() {
		return totalEntrys;
	}

}
