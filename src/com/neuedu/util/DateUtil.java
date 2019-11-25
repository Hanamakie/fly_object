package com.neuedu.util;

import java.util.Date;

public class DateUtil {
	public static String getDateString(Date d){
		Date d2 = new Date();
		long timediff = (d2.getTime() - d.getTime())/1000;
		String s = "";
		if(timediff<60 && timediff>0){
			s = "刚刚";
		}else{
			timediff = timediff/60;
			if(timediff<60 && timediff>0){
				s = timediff+"分前";	
			}else{
				timediff = timediff/60;
				if(timediff<24 && timediff>0){
					s = timediff+"小时前";
				}else{
					timediff = timediff/24;
					if(timediff<7 && timediff>0){
						s = timediff+"周前";
					}else{
						s = d.toString();
					}
				}
			} 
		}
		return s;
	}

}
