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
		entrys.add(0, entry);
		totalEntrys = totalEntrys + 1;
	}

	public void deleteEntry(Entry entry) throws InvalidInputException {
		if (entrys.contains(entry) == false){
			throw new InvalidInputException ("That entry do not belong to the blog");
		}else{
			entrys.remove(entry);
			totalEntrys = totalEntrys - 1;
		}
	}

	public ArrayList<Entry> getTenMostRecentEntries() {
		ArrayList<Entry> recentTen = new ArrayList<Entry>();
		if (this.totalEntrys() < 10) {
			for (int i = 0; i < this.totalEntrys(); i++) {
				recentTen.add(entrys.get(i));
			}
		} else {
			for (int i = 0; i <= 9; i++) {
				recentTen.add(entrys.get(i));
			}
		}
		return recentTen;
	}

	public int totalEntrys() {
		return totalEntrys;
	}

}
