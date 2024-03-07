package ch20.oracle.sec12.step3;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
	private String userid;
	private String username;
	private String userpassword;
	private int userage;
	private String useremail;
	
	public User (String name, String password, int age, String email) {
		this("", name, password, age, email);
	}
	
	public void print() {
		System.out.printf("%-6s%-50s%-10s\n"
				, userid
				, username
				, userage);
	}
	public void printDetail() {
		System.out.println("사번 : " + userid);
		System.out.println("이름 : " + username);
		System.out.println("pw : " + userpassword);
		System.out.println("나이 : " + userage);
		System.out.println("이메일 : " + useremail);
	}


}
