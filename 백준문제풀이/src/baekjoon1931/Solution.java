package baekjoon1931;
/*
 * 회의실 배정
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

class Confe{
	private int start, end, term;

	public Confe(int start, int end) {
		super();
		this.start = start;
		this.end = end;
		this.term = end - start;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getTerm() {
		return term;
	}

	@Override
	public String toString() {
		return "Confe [start=" + start + ", end=" + end + ", term=" + term + "]";
	}

}

public class Solution {

	static ArrayList<Confe> process = new ArrayList<Confe>();
	static ArrayList<Confe> result = new ArrayList<Confe>();
	

	public static void main(String[] args) {
		process.add(new Confe(1, 4));
		process.add(new Confe(3, 5));
		process.add(new Confe(0, 6));
		process.add(new Confe(5, 7));
		process.add(new Confe(3, 8));
		process.add(new Confe(5, 9));
		process.add(new Confe(6, 10));
		process.add(new Confe(8, 11));
		process.add(new Confe(8, 12));
		process.add(new Confe(2, 13));
		process.add(new Confe(12, 14));
		
		Collections.sort(process, new Comparator<Confe>() {
			@Override
			public int compare(Confe o1, Confe o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});

		for (int i = 1; i < process.size(); i++) {
			if (process.get(0).getEnd() >= process.get(i).getStart()) {
				process.remove(i);
				i--;
			}
		}
		
		System.out.println(process);
	}
}
