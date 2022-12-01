package com.fastcampus.ch2;


import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// ��, ��, ���� �Է��ϸ� ������ �˷��ִ� ���α׷�
@Controller
public class YoilTellerMVC { 
//		http://localhost:8080/ch2/getYoilMVC?year=2022&month=11&day=17
	
	@RequestMapping("/getYoilMVC")
//	public void main(HttpServletRequest request, HttpServletResponse response) throws IOException{
	public String main(int year, int month, int day, Model m) throws IOException{
//	public void main(int year, int month, int day, Model model) throws IOException{
    // ��ȯŸ���� ���� ������ mapping�� �ּҷ�! > �����̷��Դ� �Ⱦ�   
//	public ModelAndView main(int year, int month, int day, Model model) throws IOException{

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