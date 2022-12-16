package com.fastcampus.ch2;


import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ��, ��, ���� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC2 { 
//		http://localhost:8080/ch2/getYoilMVC?year=2022&month=11&day=17
	@ExceptionHandler
	public String chtcher(Exception ex) {
		ex.printStackTrace();
		return "yoilError";
	}
	
	@RequestMapping("/getYoilMVC2")
//	1. public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
//	3. public String main(int year, int month, int day, Model m) throws IOException{
//	2. public void main(int year, int month, int day, Model model) throws IOException{
    // ��ȯŸ���� ���� ������ mapping�� �ּҷ�! > �����̷��Դ� �Ⱦ�   
//	4. public ModelAndView main(int year, int month, int day, Model model) throws IOException{
		public String main(@RequestParam(required=true) int year, 
							@RequestParam(required=true)int month, 
							@RequestParam(required=true)int day, Model m) throws IOException{

//		ModelAndView mv = new ModelAndView();
//		//1. ��ȿ�� �˻�
//		if(!isValid(year, month, day))
//			return "yoilError";
		
		//2. ���� ���
        char yoil = getYoil(year, month, day); 
        
        //3. ����� ����� model�� ����
        m.addAttribute("year", year);
        m.addAttribute("month", month);
        m.addAttribute("day", day);
        m.addAttribute("yoil", yoil);
        
        //4. ����� ������ view�� ����
//        mv.setViewName("yoil");
//        return mv;     
        return "yoil"; // WEB-INF/views/yoil. jsp
       

    }

	private boolean isValid(int year, int month, int day) {
		// TODO Auto-generated method stub
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day); 

		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 1:�Ͽ���, 2:������ ...
		return " �Ͽ�ȭ�������".charAt(dayOfWeek);
	}
}