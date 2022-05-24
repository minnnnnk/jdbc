package com.javaex.ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
	
	//필드
	
	//생성자
	
	//메소드 gs
	
	//메소드 일반
	//입력하기 메소드
	public int bookInsert(String title, String pubs, String pubDate, int authorId) {
		int count = -1;
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query ="";
			query += " insert into book ";
			query += " values(seq_book_id.nextval,?,?,?,?) ";
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);
			//실행
			count = pstmt.executeUpdate();
			// 4.결과처리
			System.out.println(count+ "건이 등록되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
			/*if (rs != null) {
				rs.close();
			}
			*/
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		}
		return count;
	}
	//전체 가져오기
	public List<BookVo> bookSelect() {
		List<BookVo> bookList = new ArrayList<BookVo>();
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			//SQL문 준비
			String query = "";
			query += " select  book_id ";
			query += "         ,title ";
			query += "         ,pubs ";
			query += "         ,to_char(b.pub_date,'YY/MM/DD') pub_date ";
			query += "         ,author_name ";
			query += " from author a , book b ";
			query += " where a.author_id = b.author_id ";
			//바인딩
			pstmt = conn.prepareStatement(query);
			///실행
			
			//rs가져오기
			
			rs = pstmt.executeQuery();
			
			// 4.결과처리
			//반복문으로 리스트 처리
			while(rs.next()) {
				int bookId = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_date");
				String authorName = rs.getString("author_name");
				
				BookVo bookVo = new BookVo(bookId, title , pubs , pubDate, authorName);
				
				bookList.add(bookVo);
			}
			//toString출력
			
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		}
		return bookList;
	}
	//삭제하기메소드
	public int bookDelete(int bookId) {
		int count = -1;
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += " delete from book ";
			query += " where book_id = ? ";
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookId);
			//실행
			count = pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count+"건이 삭제되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
			/*if (rs != null) {
			rs.close();
			}
			 */
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		}
		return count;
	}
	///업데이트메소드
	public int bookUpdate(String title, String pubs, String pubDate, int authorId, int bookId) {
		int count = -1;
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//ResultSet rs = null;
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			// 3. SQL문 준비 / 바인딩 / 실행
			
			//SQL문 준비
			String query = "";
			query += " update book ";
			query += " set title = ? ";
			query += "     ,pubs = ? ";
			query += "     ,pub_date = ? ";
			query += "     ,author_id = ? ";
			query += " where book_id = ? ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, title);
			pstmt.setString(2, pubs);
			pstmt.setString(3, pubDate);
			pstmt.setInt(4, authorId);
			pstmt.setInt(5, bookId);
			
			//실행
			count = pstmt.executeUpdate();
			
			// 4.결과처리
			System.out.println(count + "건이 변경되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
		} finally {
		// 5. 자원정리
		try {
			/*if (rs != null) {
				rs.close();
			}
			 */
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
		}
		return count;
	}
	
}
