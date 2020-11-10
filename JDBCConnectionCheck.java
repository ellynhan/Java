import java.sql.*;

public class Hw6 {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost/javabook";
			String url = "jdbc:mysql://localhost/javabook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//jdbc:mysql://localhost/db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			con = DriverManager.getConnection(url,"username","password");
			System.out.println("연결 성공");
		}
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패!!!");
		}
		catch(SQLException e) {
			System.out.println("에러: "+e);
		}
		finally {
			try {
				if(con!=null&&!con.isClosed()) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
