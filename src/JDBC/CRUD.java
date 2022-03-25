package JDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUD {

	// CRUD
	// C : CREATE(생성)
	// R : READ(조회)
	// U : UPDATE(수정)
	// D : DELETE(삭제)

	Connection con = null;
	// DB에 접속하기 위한 객체

	Statement stmt = null;
	// SQL문을 사용하기 위한 객체

	ResultSet rs = null;
	// SQL문 조회된 내용을 저장하는 객체
	
	// Q. ResultSet은 처음에 null을 해주어서 문자타입인 줄 알았는데...
	// A. ResultSet타입 (참조형 데이터 타입 : 기본 값 null)
	
	// 데이터 기본타입 : 문자형, 정수형, 실수형, 논리형
	// char, int, double, boolean
	
	// String, Scanner, Connection, ResultSet, CRDU타입 등등.. 참조형 데이터 타입
	// 참조형 데이터 타입의 기본 값 null
	
	public void insert1() {

		try {
			// 준비단계
			con = DBConnection.DBconnect();
			stmt = con.createStatement();

			// SQL문 작성
			String sql = "INSERT INTO JAVASQL VALUES('JAVA3', 'SQL3')";

			// SQL문 실행
			int result = stmt.executeUpdate(sql);

			// 실행결과 확인
			System.out.println("결과 : " + result);

			if (result > 0) {
				System.out.println("insert success!");
			} else {
				System.out.println("insert fail!");
			}

			// stmt문과 DB접속 해제
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// NAVER 회원정보 가입하기
	public void insert() {
		// 회원정보 DB에 insert하기!
		// n_insert() 메소드 생성 후 JdbcMain클래스 실행하기
		// TESTCRUD or SQLDeveloper에서 NAVER테이블 조회해보기!

		try {
			// [1] 준비 단계
			con = DBConnection.DBconnect();
			stmt = con.createStatement();
			
			// [2] 작성 단계
			String sql = "INSERT INTO NAVER VALUES('skydowl', 1111, 'OOO', '29', '여자', 'EMAIL@NAVER.COM', '010-1111-2222')";

			// [3] 실행 단계
			int result = stmt.executeUpdate(sql);

			// [4] 확인 단계
			System.out.println("결과 : " + result);

			if (result > 0) {
				System.out.println("네이버 회원가입 성공!");
			} else {
				System.out.println("회원가입 실패!");
			}

			// [5] 해제 단계
			stmt.close();
			con.close();

		} catch (SQLException se) {
			se.printStackTrace();
		}

	}

	// 회원정보 조회 SELECT
	public void select() {
		try {
			// [1] 준비 단계
			con = DBConnection.DBconnect();
			stmt = con.createStatement();

			// [2] 작성단계
			String sql = "SELECT * FROM NAVER";

			// [3] 실행 단계
			// 조회한 정보를 rs객체에 담는다.
			rs = stmt.executeQuery(sql);

			// Q. ResultSet 타입의 변수 rs에 next()를 하면 왜 논리형 데이터로 바뀌나요?
			// A. ResultSet 클래스에 있는 next()메소드
			
			// [4] 확인 단계
			// 튜플(데이터 레코드) 갯수 만큼 반복문
			while (rs.next()) {
				// rs.next() : 데이터 타입은 boolean
				// 레코드가 존재할 경우 true,
				// 더 이상 존재하지 않을 경우 false, 반복문 종료
				System.out.println("아이디 : " + rs.getString(1));
				System.out.println("패스워드 : " + rs.getString(2));
				System.out.println("이름 : " + rs.getString(3));
				System.out.println("나이 : " + rs.getInt(4));
				System.out.println("성별 : " + rs.getString(5));
				System.out.println("이메일 : " + rs.getString(6));
				System.out.println("전화번호 : " + rs.getString(7));
				System.out.println();

			}
			
			// [5] 해제 단계
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 회원정보 수정 UPDATE
	public void update() {
		try { // 문제가 없으면 try문 실행, catch문 실행 X
			// [1] 시작 단계
			con = DBConnection.DBconnect();
			stmt = con.createStatement();

			// [2] 작성 단계
			String sql = "UPDATE NAVER SET NAGE = 15 WHERE NID = '아이디'";

			// [3] 실행 단계
			int result = stmt.executeUpdate(sql);

			// [4] 확인 단계
			if (result > 0) {
				System.out.println("update seccess!");
			} else {
				System.out.println("update fail!");
			}
			
			// [5] 해제 단계
			stmt.close();
			con.close();
			
		} catch (SQLException e) { // 문제가 생기면 try문 실행 X, catch문 실행
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { // 문제가 생기건, 문제가 생기지 않건, 무조건 실행

		}

	} // end update()

	// 회원정보 삭제 delete()
	public void delete() {
		
		// [1] 준비단계 : con(먼저), stmt(나중) => try, catch
		// [2] 작성단계 : sql
		// [3] 실행단계 : execute : CUD(int타입 executeUpdate), 
		//                                       R(ResultSet타입 executeQuery)
		// [4] 확인단계 : while, if
		// [5] 해제단계 : close
		
		try {
			// [1] 준비 단계
			con = DBConnection.DBconnect();
			stmt = con.createStatement();
			
			// [2] 작성 단계
			String sql = "DELETE FROM NAVER WHERE NID='skydowl'";
			
			// [3] 실행 단계
			int result = stmt.executeUpdate(sql);
			
			System.out.println("결과 : " + result);
			
			// [4] 확인 단계
			if(result > 0) {
				System.out.println("DELETE SUCCESS!");
			} else {
				System.out.println("DELETE FAIL!");
			}
			
			// [5] 해제 단계
			stmt.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}