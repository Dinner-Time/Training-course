package baekjoon1931;
/*
 * 회의실 배정
 */

import java.util.ArrayList;
import java.util.Collections;

class Confe implements Comparable<Confe>{
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
		return "\nConfe [start=" + start + ", end=" + end + ", term=" + term + "]";
	}

	@Override
	public int compareTo(Confe o) {
		if(this.end > o.getEnd()) {
			return -1;
		} else if (this.end == o.getEnd()) {
			return 0;
		} else {
			return -1;
		}
	}

}

public class MySolution1931 {

	static ArrayList<Confe> process = new ArrayList<Confe>();
	static ArrayList<Confe> result = new ArrayList<Confe>();
	static int confeNum, confeStart, confeEnd;
	
//	public static void setting() {
//		confeNum = (int)(Math.random()*30)+1;
//		confeStart = (int)(Math.random()*30)+1;
//		while(confeEnd >= confeStart) {
//			confeEnd = (int)(Math.random()*30)+1;
//		}
//		
//		for(int i=0; i<confeNum; i++) {
//			process.add(new Confe(confeStart, confeEnd));
//		}
//	}
	
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
		
//		setting();
		
		Collections.sort(process);
		Collections.reverse(process);
		result.add(process.get(0));
		process.remove(0);
		
		int k = 0;
		while(process.size() != 0) {
			for (int i = 0; i < process.size(); i++) {
				if (result.get(k).getEnd() >= process.get(i).getStart()) {
					process.remove(i);
					i--;
				}
			}
			
			Confe f = process.get(0);
			for (int i = 1; i < process.size(); i++) {
				if ((process.get(0).getStart() >= process.get(i).getStart()) && 
						(process.get(0).getTerm() >= process.get(i).getTerm())) {
					f = process.get(i);
				}
			}
			result.add(f);
			process.remove(process.indexOf(f));
			k++;
		}
//		System.out.printf("%d,\n",confeNum);
		System.out.println(result.size());
		
	}
	
}
