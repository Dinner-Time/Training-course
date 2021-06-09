package my.memo.view;

import my.memo.access.MemoList;
import my.memo.model.Memos;
import my.memo.util.ScannerUtil;

public class MemoCliApp {

	MemoList memoList = new MemoList();

	public void start() {
		int menunum;
		do {
			menuTitle();
			menunum = ScannerUtil.readInt("입력");
			switch (menunum) {
			case 1: insert(); break;
			case 2: update(); break;
			case 3: delete(); break;
			case 4: selectAll(); break;
			case 5: findDate(); break;
			case 6: findContent(); break;
			}
		} while (menunum != 0);
	}
	// 메모 등록
	public void insert() {
		memoList.insert(ScannerUtil.readMemo());
	}
	// 메모 내용 수정 -> 날짜로 검색해서 내용을 수정
	public void update() {
		memoList.update(ScannerUtil.readMemo());
	}
	// 메모 삭제 -> 날짜로 검색해서 메모를 삭제
	public void delete() {
		memoList.delete(ScannerUtil.readDate());
	}
	// 전체 조회
	public void selectAll() {
		System.out.println(memoList.selectAll());
	}
	// 날짜로 조회
	public void findDate() {
		Memos pr = memoList.findDate(ScannerUtil.readDate());
		if(pr == null) {
			System.out.println("null");
		} else {
			pr.getContent();
		}
	}
	// 내용으로 조회
	public void findContent() {
		System.out.println(memoList.findContent(ScannerUtil.readStr("포함된 내용>")));;
	}
	// 활동 선택
	public void menuTitle() {
		System.out.println("=====메모 관리======");
		System.out.print("1.등록 | ");
		System.out.print("2.수정 | ");
		System.out.print("3.삭제 | ");
		System.out.print("4.전체 조회 | ");
		System.out.print("5.날짜로 조회(yyyy-MM-dd) | ");
		System.out.print("6.내용으로 조회 | ");
		System.out.print("0. 종료");
		System.out.println();
	}

}
