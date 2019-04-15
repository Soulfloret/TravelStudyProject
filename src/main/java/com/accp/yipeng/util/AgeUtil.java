package com.accp.yipeng.util;
import java.util.Calendar;

import com.accp.domain.users;

public class AgeUtil {
	/**
	 * 通过   传入的客户对象  计算出年龄返回
	 * @return
	 */
	public static int getage(users use) {
		int briday=Integer.parseInt(use.getIdcardno().substring(6, 10));
		Calendar cal = Calendar.getInstance();
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH)+1;  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        int yearBirth =briday;
        int monthBirth =Integer.parseInt(use.getIdcardno().substring(10, 12));
        int dayOfMonthBirth =Integer.parseInt(use.getIdcardno().substring(12, 14));
        int age = yearNow - yearBirth;  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) {
                	age--;
                }
            }else{  
                age--;  
            }  
        } 
		return age;
	}
		
}
