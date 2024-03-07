package ch20.oracle.sec12.step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
	// Field
		private static Connection conn = null;
		private static PreparedStatement userListPstmt = null; //사원 목록
		private static PreparedStatement userInsertPstmt = null; //사원 추가
		private static PreparedStatement userDetailPstmt = null; //사원 상세정보
		private static PreparedStatement userDeletePstmt = null; //사원 삭제

		static {
			try {
				//JDBC Driver 등록
				Class.forName("oracle.jdbc.OracleDriver");

				//연결하기
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521/xe",
						"bituser", //계정이름 
						"1004" //계정비밀번호
						);
				
				System.out.println("연결 성공");
				
				conn.setAutoCommit(false);
				
				//조회
				userListPstmt = conn.prepareStatement("select * from users");
				//추가
				userInsertPstmt = conn.prepareStatement("insert into users (userid, username, userpassword, userage, useremail) values (seq_bno.nextval, ?, ?, ?, ?)");
				//세부정보
				userDetailPstmt = conn.prepareStatement("select * from boards where bno=?");
				//삭제
				userDeletePstmt = conn.prepareStatement("delete from users where bno=?");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Method
		public List<User> list() {
			// 아래 구문이 동작할 수 있게 기능 추가
			// select * from boards
			List<User> list = new ArrayList<>();
			try {
				ResultSet rs = userListPstmt.executeQuery();
				while (rs.next()) {
					// 찾고자 하는 자료가 있음
					User user= new User(rs.getString("userid")
									,rs.getString("username")
									,rs.getString("userpassword")
									,rs.getInt("userage")
									,rs.getString("useremail")
									);
					//배열에 객체를 추가한다 
					list.add(user);
				}
				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

		public int insert(User user) {
			int updated = 0; 
			try {
				// 입력 값을 설정 한다
				userInsertPstmt.setString(1, user.getUsername());
				userInsertPstmt.setString(2, user.getUserpassword());
				userInsertPstmt.setInt(3, user.getUserage());
				userInsertPstmt.setString(4, user.getUseremail());

				updated = userInsertPstmt.executeUpdate();
				conn.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return updated;
		}
		
		public User read(String userid) {
			User user = null;
			try {
				// 입력 값을 설정 한다
				userDetailPstmt.setString(1, userid);

				ResultSet rs = userDetailPstmt.executeQuery();
				if (rs.next()) {
					user= new User(rs.getString("userid")
							,rs.getString("username")
							,rs.getString("userpassword")
							,rs.getInt("userage")
							,rs.getString("useremail")
							);
				}
				rs.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return user;
		}

		public int update(User user) {
			try {
				// 입력 값을 설정 한다
				userDetailPstmt.setString(1, user.getUsername());
				userDetailPstmt.setString(2, user.getUserpassword());
				userDetailPstmt.setInt(3, user.getUserage());
				userDetailPstmt.setString(4, user.getUseremail());

				return userDetailPstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}

		public int delete(String userid) {
			int updated = 0;
			try {
				// 입력 값을 설정 한다
				userDeletePstmt.setString(1, userid);

				updated = userDeletePstmt.executeUpdate();
				conn.commit();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return updated;
		}


}
