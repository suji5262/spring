package com.fastcampus.ch2;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
	public class YoilTellerMVC6 {
    	
	@ExceptionHandler(Exception.class)
    	public String catcher(Exception ex, BindingResult result) {
			System.out.print("result =" + result);
			FieldError error = result.getFieldError();
			
			System.out.println("code =" + error.getCode());
			System.out.println("fied =" + error.getField());
			System.out.println("msg =" + error.getDefaultMessage());
			
    		ex.printStackTrace();
       		return "yoilError";
    	}
    
    @RequestMapping("/getYoilMVC6") // http://localhost:8080/ch2/getYoilMVC6?year=2022&month=12&day=16
//  public String main(@ModelAttribute("myDate") MyDate date, Model m) { // �Ʒ��� ���� 
    public String main(MyDate date, BindingResult result) { // @ModelAttribute���, ��ȯ Ÿ���� String  
    	System.out.println("result="+result);

    	// 1. ��ȿ�� �˻� 
    	if(!isValid(date))
    		return "yoilError";
    	
        // 2. ó��
//    	char yoil = getYoil(date);

    	// 3. Model�� �۾��� ����� ���� 
        // @ModelAttribute ���п� MyDate�� ������ص� ��. View�� �ڵ� ���޵�.
//      m.addAttribute("myDate", date);     	
//      m.addAttribute("yoil", yoil);        
        
      	// 4. �۾� ����� ������ ���� �̸��� ��ȯ  
      	return "yoil";
    }
    
    private @ModelAttribute("yoil") char getYoil(MyDate date) {
    	return getYoil(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private char getYoil(int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return " �Ͽ�ȭ�������".charAt(dayOfWeek);
    }

    private boolean isValid(MyDate date) {
    	return isValid(date.getYear(), date.getMonth(), date.getDay());
    }
    
    private boolean isValid(int year, int month, int day) {    
    	if(year==-1 || month==-1 || day==-1) 
    		return false;
    	
    	return (1<=month && month<=12) && (1<=day && day<=31); // ������ üũ 
    }
}