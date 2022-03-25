package JDBC;

import java.util.Scanner;

public class JdbcMain {

	public static void main(String[] args) {
//				DBConnection conn = new DBConnection();
//				conn.DBconnect();

		CRUD crud = new CRUD();
//				crud.insert1();

//				crud.insert();
//				crud.select();
//				crud.update();
//				crud.delete();

		System.out.println("======================================");
		System.out.println("                   네이버 회원가입 페이지             ");
		System.out.println("======================================");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("1. 가입	  2. 조회	  3.	수정 	   4.삭제   5. 종료");
			System.out.print("선택 >>> ");

			int menu = sc.nextInt();
			
			// String addr = sc.next();
			// Q. main에서 사용하는 sc.next()랑 rs.next()랑 다른건가요?
			// A. sc.next() Scanner클래스에 있는 next()메소드
			// 	 rs.next() ResultSet클래스에 있는 next()메소드
			
			switch (menu) {
			case 1:
				crud.insert();
				break;
			case 2:
				crud.select();
				break;
			case 3:
				crud.update();
				break;
			case 4:
				crud.delete();
				break;
			case 5:
				run = false;
				System.out.println("프로그램 종료!");
			default:
				System.out.println("다시 입력해주세요!");
				break;
			}
		}
	}

}
