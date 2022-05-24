package com.javaex.ex02;

import java.util.List;

public class BookApp {

	public static void main(String[] args) {
		
		BookDao bookDao = new BookDao();
		
		/*bookDao.bookInsert("우리들의 일그러진 영웅", "다림", "98-02-22", 1);
		bookDao.bookInsert("삼국지", "민음사", "02-03-01", 1);
		bookDao.bookInsert("토지", "마로니에북스", "12-08-15", 2);
		bookDao.bookInsert("유시민의 글쓰기 특강", "생각의길", "15-04-01", 3);
		bookDao.bookInsert("패션왕", "중앙북스(books)", "12-02-22", 4);
		bookDao.bookInsert("순정만화", "재미주의", "11-08-03", 5);
		bookDao.bookInsert("오직두사람", "문학동네", "17-05-04", 6);
		bookDao.bookInsert("26년", "재미주의", "12-02-04", 5);
		*/
		
		//bookDao.bookUpdate("일그러진", "다림", "01-04-12", 1, 9);
		
		//bookDao.bookDelete(9);
		
		List<BookVo> bookList = bookDao.bookSelect();
		
		for(int i = 0; i<bookList.size(); i++) {
			BookVo bookVo = bookList.get(i);
			System.out.println(bookVo.getBookId()+", "+bookVo.getTitle()+", "+bookVo.getPubs()+", "+bookVo.getPubDate()+", "+bookVo.getAuthorName());
		}
		
	}

}
