package kr.or.ddit.cookie;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	
	// cookieStrim 문자열 변수에 담긴 값은 쿠키이름1 = 쿠키값1; 쿠키이름2 = 쿠키값2;...
	// 형태로 구성된다. 
	// 구성된 쿠키 이름과 값은 상황에 따라 변경될 수 있음
	public String cookieString = "USERNM=joo0z; REMEMBERME=Y; TEST=T; ";
	
	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		 
		logger.debug(cookieSplit.getCookieValue("USERNM")); // 기대되는 값 joo0z
		logger.debug(cookieSplit.getCookieValue("REMEMBERME")); // 기대되는 값 T
		logger.debug(cookieSplit.getCookieValue("XXXX")); // 기대되는 값  ""(WHITE SPACE)
	}
	
	// cookieString 필드를 분석하여 메소드 인자로 넘어온 cookieName에 해당하는 쿠키가 있을경우
	// 해당 쿠키의 값을 반환하는 메소드
	public String getCookieValue(String cookieName) {
			String result ="";
			String[] cookies = cookieString.split("; ");
			for (int i = 0; i < cookies.length ; i++) {
				String[] cookie = cookies[i].split("=");
//				logger.debug(Arrays.toString(cookie));
				if(cookie[0].equals(cookieName)) {
					result = cookie[1];
				}
			}
		return result;
	}
}

