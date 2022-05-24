package com.javaex.ex04;

import java.util.List;

public class AuthorApp {

	public static void main(String[] args) {
		
		AuthorDao authorDao= new AuthorDao();
		
		/*AuthorVo vo01 = new AuthorVo("이문열","경북영양");
		AuthorVo vo02 = new AuthorVo("박경리", "경상남도 통영");
		AuthorVo vo03 = new AuthorVo("유시민", "17대 국회의원");
		AuthorVo vo04 = new AuthorVo("기안84", "기안동에서 산 84년생");
		AuthorVo vo05 = new AuthorVo("강풀", "온라인 만화가 1세대");
		AuthorVo vo06 = new AuthorVo("김영하", "알쓸신잡");
		AuthorVo vo07 = new AuthorVo("정우성","영화배우");
		
		authorDao.authorInsert(vo01);
		authorDao.authorInsert(vo02);
		authorDao.authorInsert(vo03);
		authorDao.authorInsert(vo04);
		authorDao.authorInsert(vo05);
		authorDao.authorInsert(vo06);
		authorDao.authorInsert(vo07);
		*/
		//authorDao.authorInsert("이문열","경북영양");
		
		/*authorDao.authorInsert("김문열", "경북 영양");
		authorDao.authorInsert("박경리", "경상남도 통영");
		authorDao.authorInsert("유시민", "17대 국회의원");
		authorDao.authorInsert("기안84", "기안동에서 산 84년생");
		authorDao.authorInsert("강풀", "온라인 만화가 1세대");
		authorDao.authorInsert("김영하", "알쓸신잡");
		*/
		
		
		/*AuthorVo uVo = new AuthorVo(7,"유재석","개그맨");
		
		authorDao.authorUpdate(uVo);*/
		
		
		
		//authorDao.authorDelete(4); 
		
		//authorDao.authorUpdate(1, "이문열","삼국지 작가");		
		
		List<AuthorVo> authorList = authorDao.authorSelect();
		for(int i =0; i<authorList.size(); i++) {
			
			/*int authorId= authorList.get(i).getAuthorId();
			String authorName = authorList.get(i).getAuthorName();
			String authorDesc = authorList.get(i).getAuthorDesc();
			System.out.println( "번호:"+authorId + " 이름:" +authorName + " \t뭔가:" + authorDesc);
			*/
			
			AuthorVo authorVo = authorList.get(i);
			System.out.println(authorVo.getAuthorId()+", "+authorVo.getAuthorName()+", "+authorVo.getAuthorDesc());
			
		
		}
	}

}
