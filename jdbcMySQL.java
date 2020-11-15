package hw6;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class Hw6 {

	public static void main(String[] args) {
		Connection con = null;     // 데이터베이스와 연결을 위한 객체  
		PreparedStatement pstmt = null; // SQL문을 데이터베이스에 보내기위한 객체
		ResultSet insructorNameResults = null; //쿼리 결과를 저장하기 위한 객체, instructorName을 저장한다.
		ResultSet exerciseNameResults = null; //쿼리 결과를 저장하기 위한 객체, exerciseName을 저장한다.
		ResultSet submittedResults = null; //쿼리 결과를 저장하기 위한 객체, submittedResults를 저장한다.
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//javabook이라는 이름의 데이터베이스의 url이다. ?뒤에 붙은 것은 오류를 해결하기 위한 장치이다. 
			String url = "jdbc:mysql://localhost/javabook?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			//데이터베이스와 드라이버를 연결한다.
			con = DriverManager.getConnection(url,"hostname","password");
			
			//AGSStudent테이블에 insert하기위한 쿼리문이다.
			String insertAGSStudent = "insert into AGSStudent(username, password,fullname, instructorEmail) values(?, ?, ?, ?)";
			//ExerciseAssigned테이블에 insert하기위한 쿼리문이다.
			String insertExerciseAssigned = "insert into ExerciseAssigned(instructorEmail, exerciseName,maxscore) values(?, ?, ?)";
			//AGSLog테이블에 insert하기위한 쿼리문이다.
			String insertAGSLog = "insert into AGSLog(username, exerciseName,score, submitted) values(?, ?, ?, ?)";
			//AGSStudent테이블에서 해당 username에따른 instructorEmail을 확인하는쿼리문이다.
			String checkInstructorEmail="select instructorEmail from AGSStudent where username = ?";
			//ExerciseAssigned테이블에서 해당 instructorEmail에따른 exerciseName을 확인하는 쿼리문이다.
			String checkExerciseName = "select exerciseName from ExerciseAssigned where instructorEmail = ?";
			//ASGLog테이블에서 해당 username에따른 exerciseName을 확인하는 쿼리문이다.
			String checkSubmitted = "select exerciseName from AGSLog where username = ?";
			
			//데이터베이스 테이블에 값을 저장하기위한 배열들.
			String[] usernames = {"abc","cde","wbc"};
			String[] passwords = {"p1", "p2", "p3"};
			String[] fullnames = {"John Roo","Yao Mi","F3"};
			String[] emails = {"t@gmail.com","c@mail.com","t@gmail.com"};
			String[] exerciseNames = {"e1","e2","e1","e4"};
			double[] maxScores = {10,10,4,20};
			
			//이후 제출여부를 검사할 때 사용할 리스트 
			List<String> submitted = new ArrayList<String>();
		
			//테이블에 값을 저장을 시작한다.
			pstmt = con.prepareStatement(insertAGSStudent);
			for(int i=0; i<3; i++) {
				pstmt.setString(1, usernames[i]);
				pstmt.setString(2, passwords[i]);
				pstmt.setString(3, fullnames[i]);
				pstmt.setString(4, emails[i]);
				pstmt.execute();
			}
			
			pstmt = con.prepareStatement(insertExerciseAssigned);
			for(int i=0; i<4; i++) {
				if(i<2)
					pstmt.setString(1, emails[0]);
				else
					pstmt.setString(1, emails[1]);
				pstmt.setString(2, exerciseNames[i]);
				pstmt.setDouble(3, maxScores[i]);
				pstmt.execute();
			}
			
			pstmt = con.prepareStatement(insertAGSLog);
			pstmt.setString(1, usernames[0]);
			pstmt.setString(2, exerciseNames[0]);
			pstmt.setDouble(3, 9);
			pstmt.setInt(4, 1);
			pstmt.execute();
			
			pstmt.setString(1, usernames[2]);
			pstmt.setString(2, exerciseNames[1]);
			pstmt.setInt(3, 7);
			pstmt.setInt(4, 1);
			pstmt.execute();
			//여기까지하면 테이블에 값 저장이 완료되었다.
			
			//이제부터 테이블에 저장되지 않은 미제출자와 그 운동목록을 추출하여 AGSLog에 추가해주는 작업을 할 것이다. 
			for(int i=0; i<3; i++) {
				pstmt = con.prepareStatement(checkInstructorEmail);
				pstmt.setString(1, usernames[i]);
				//insructorNameResults에는 해당 유저의 instructorEmail이 저장어있다. 
				insructorNameResults = pstmt.executeQuery();
				
				pstmt= con.prepareStatement(checkSubmitted);
				pstmt.setString(1, usernames[i]);
				//submittedResults에는 해당 유저가 제출한 exerciseName이 담겨있다. 
				submittedResults = pstmt.executeQuery();
				while(submittedResults.next()) {
					submitted.add(submittedResults.getString("exerciseName"));
				}
				
				
				if(insructorNameResults.next()) {
					String email = insructorNameResults.getString("instructorEmail");
					pstmt= con.prepareStatement(checkExerciseName);
					pstmt.setString(1, email);
					//exerciseNameResults에 instructorEmail로 찾은 instructor가 가르치는 exerciseName들이 저장되어있다.
					exerciseNameResults = pstmt.executeQuery();
					while(exerciseNameResults.next()) {
						String name = exerciseNameResults.getString("exerciseName");
						//submitted(유저가 제출한 것)와 exerciseNameResults(전체 제출해야하는 것)을 비교한다.
						if(!submitted.contains(name)) {
							pstmt = con.prepareStatement(insertAGSLog);
							pstmt.setString(1, usernames[i]);
							pstmt.setString(2, name);
							pstmt.setDouble(3, 0);
							pstmt.setInt(4, 0);
							pstmt.execute();
						}
					}
					
				}
				submitted.clear();
			}
			
			//미제출자의 점수와 제출여부를 포함하여 AGSLog에 추가해준 결과를 출력해본다. 
			pstmt=con.prepareStatement("select * from AGSLog order by score DESC");
			ResultSet result = pstmt.executeQuery();
			System.out.println(String.format("%-15s%-15s%-15s%-15s","username","exerciseName","score","submitted"));
			while(result.next()) {
				System.out.println(String.format("%-15s%-15s%-15d%-15s",result.getString("username"),result.getString("exerciseName"),(int)result.getDouble("score"),result.getInt("submitted")));				
			}
			
		}
		//예외처
		catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
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
