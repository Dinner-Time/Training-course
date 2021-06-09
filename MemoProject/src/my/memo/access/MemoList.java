package my.memo.access;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import my.memo.model.Memos;

public class MemoList implements MemoAccess {

	ArrayList<Memos> memos; // Memos타입의 memos 배열리스트 생성

	public MemoList() {
		memos = new ArrayList<Memos>();
		open();
	}

	String path = "d:/temp/memo.txt";

	public void open() {
		try {
			Scanner scanner = new Scanner(new File(path));
			while (true) {
				if (!scanner.hasNext())
					break;
				String str = scanner.nextLine();
				String[] arr = str.split(" : ");
				memos.add(new Memos(arr[0], arr[1]));
			}
			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(path));
			for (Memos f : memos) {
				fw.write(String.format("%s : %s\n", f.getDate(), f.getContent()));
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insert(Memos memo) {
		memos.add(memo);
		save();
	}

	@Override
	public void update(Memos memo) {
		for (Memos f : memos) {
			if (f.getDate().equals(memo.getDate())) {
				memos.set(memos.indexOf(f), memo);
				save();
			}
		}
	}

	@Override
	public void delete(String date) { // 동명이인 일경우?
		for (Memos f : memos) {
			if (f.getDate().equals(date)) {
				memos.remove(f);
				save();
			}
		}
	}

	@Override
	public ArrayList<Memos> selectAll() {
		return memos;
	}

	@Override
	public Memos findDate(String date) {
		for (Memos f : memos) {
			if (f.getDate().equals(date)) { // contains -> 포함
				return f;
			}
		}
		return null;
	}

	public Memos findContent(String content) {
		for (Memos f : memos) {
			if (f.getContent().contains(content)) { // contains -> 포함
				return f;
			}
		}
		return null;
	}

}
