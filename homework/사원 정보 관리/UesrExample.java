package ch20.oracle.sec12.step3;

import java.util.List;
import java.util.Scanner;

import ch20.oracle.sec12.step1.Board;
import ch20.oracle.sec12.step1.BoardDAO;
import ch20.oracle.sec12.step1.BoardExample14;


public class UserExample {
	private Scanner scanner = new Scanner(System.in);
	//참조 변수 선언 
	UserDAO userDAO;
	
	//생성자
	public UserExample(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	//함수
	public void list() {
		System.out.println();
		System.out.println("[사원 목록]");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("사번     이름    나이");
		System.out.println("-----------------------------------------------------------------------");
		
		List<User> list = userDAO.list();
		for(User user : list) {
			user.print();
		}
		if(list.size() == 0) {
			System.out.println("사원 정보가 존재하지 않습니다.");
		}
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("메인 메뉴: 1.사원 정보 추가 | 2.사원 상세 정보 | 3.종료");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		System.out.println();
		
		switch (menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> exit();
		}
	}
	
	public void create() {
		System.out.println("[새 사원 등록]");
		System.out.print("이름: ");
		String username = scanner.nextLine();
		
		System.out.print("pw: ");
		String userpassword = scanner.nextLine();
		
		System.out.print("나이: ");
		int userage = Integer.parseInt(scanner.nextLine());
		
		System.out.print("email: ");
		String useremail = scanner.nextLine();
		System.out.println();
		
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
			int updated = userDAO.insert(new User(username, userpassword, userage, useremail));
			// 변경된 건 수
			System.out.println("변경 건수  : " + updated);
		}

		// 게시물 목록 출력
		list();
	}
	
	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		// 사번 입력
		String userid = scanner.nextLine();
		
		User user = userDAO.read(userid);
		
		if(user != null) {
			user.printDetail();
			// 보조 메뉴 출력
			System.out.println("-------------------------------------------------------------------");
			System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
			System.out.print("메뉴 선택: ");
			String menuNo = scanner.nextLine();
			System.out.println();

			switch (menuNo) {
				case "1" -> update(userid);
				case "2" -> delete(userid);
				case "3" -> list();
				}
		} else {
			// 찾고자 하는 자료가 없음
			System.out.println("[" + userid + "] 에 대한 자료가 존재하지않습니다 ");
			userid = null;
		}
	}
		
	public void update(String userid) {
		// 수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.print("이름: ");
		String username = scanner.nextLine();
		
		System.out.print("pw: ");
		String userpassword = scanner.nextLine();
		
		System.out.print("나이: ");
		int userage = scanner.nextInt();
		
		System.out.print("email: ");
		String useremail = scanner.nextLine();	
		
		// 보조 메뉴 출력
		System.out.println("-------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scanner.nextLine();
		if (menuNo.equals("1")) {
				userDAO.update(new User(userid, username, userpassword, userage, useremail));
		}
			// 게시물 목록 출력
		list();
	}
	
	public void delete(String userid) {
		System.out.println("사원 정보를 삭제합니다.");
		int updated = userDAO.delete(userid);

		// 변경된 건 수
		System.out.println("삭제 건수  : " + updated);

		// 게시물 목록 출력
		list();
	}

	public void exit() {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		UserExample userExample = new UserExample(new UserDAO());
		userExample.list();
	}
	
}
