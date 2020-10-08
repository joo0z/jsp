package kr.or.ddit.cookie;

import static org.junit.Assert.*;

import org.junit.Test;

import kr.or.ddit.cookie.CookieSplit;

public class CookieSplitTest {

	@Test
	public void getCookieSplitTest() {
		/*** Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/*** When : 행위 ***/
		String result = cookieSplit.getCookieValue("USERNM");
		String result2 = cookieSplit.getCookieValue("REMEMBERME");
		
		/*** Then : 결과 ***/
//		assertNotNull(result);
//		assertNotNull(result2);
		assertEquals("joo0z", result);
	}
	@Test
	public void getCookieValueFailTest() {
		/*** Given : 주어진 상황 기술 ***/
		CookieSplit cookieSplit = new CookieSplit();
		
		/*** When : 행위 ***/
		String result = cookieSplit.getCookieValue("PASSWORD");
		
		/*** Then : 결과 ***/
		assertEquals("", result);
	}
}
