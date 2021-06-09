package my.member.access;

import java.util.ArrayList;

import my.member.model.Friends;

// 친구 관리 프로그램 개발 표준
public interface FriendAccess {
	// 등록
	void insert(Friends friend);

	// 수정
	void update(Friends friend);

	// 삭제
	void delete(String name);

	// 전체조회
	ArrayList<Friends> selectAll();

	// 검색
	Friends selectOne(String name);
	
	Friends findTel(String tel);
}
