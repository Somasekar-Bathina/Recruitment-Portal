package com.project.fdb.Recruitment.Portal.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ApplicationUtil {

	public static Date getCurrentTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:MM:SS");
		Date date=new Date();
		String datStr=dateFormat.format(date);
		Date parsedDate =null;
		try{
		parsedDate = dateFormat.parse(datStr);
		}catch(ParseException e) {
			log.info("Exception occured while parsing date:{}",e.getMessage());
		}
		return parsedDate;
	}
}
