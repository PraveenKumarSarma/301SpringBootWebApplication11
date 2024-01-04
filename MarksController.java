package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MarksController 
{
	@RequestMapping("/")
	public String markForm()
	{
		return "student";
	}
	
	@RequestMapping("/req1")
	public String resultInfo(@RequestParam int rollNo,@RequestParam String name,@RequestParam String course,@RequestParam int hibernate,@RequestParam int spring,@RequestParam int springBoot,ModelMap model)
	{
		model.put("rollNo", rollNo);
		model.put("name", name);
		model.put("course", course);
		model.put("hibernate", hibernate);
		model.put("spring", spring);
		model.put("springBoot", springBoot);
		
		double tMarks=0.0;
		tMarks= hibernate+spring+springBoot;
		double percentage=0.0;
		percentage=tMarks/3;
		String grade="null";
		if(percentage >=70)
		{
			grade="A grade";
		}
		else if(percentage >= 60)
		{
			grade="B grade";
		}
		else if(percentage >= 50)
		{
			grade="C grade";
		}
		
		model.put("tMarks", tMarks);
		model.put("percentage", percentage);
		model.put("grade", grade);
		
		String res=null;
		if(hibernate > 35 && spring > 35 && springBoot > 35)
		{
			res="Pass";
		}
		else
		{
			res="Fail";
		}
		
		model.put("res", res);
		
		return "result";
	}
		
}
