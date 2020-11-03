package kr.or.ddit.config.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateStringConverter implements Converter<String, Date>{ // 문자열 => 날짜로 변환 

	@Override
	public Date convert(String source) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = fm.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	} 
	

}
