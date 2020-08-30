package com.sapientPJP20.assignment.javafiles;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DateController {
	
	@Autowired
	public DateService dateService;
	
	@RequestMapping("/internalization")
	public String internalization(@RequestParam("theLocale") String theLocale,HttpServletRequest request) {
		request.setAttribute("theLocale", theLocale);
		return "internalization.jsp";
	}
	
	@RequestMapping("/history")
	public String history(@RequestParam(name="theLocale",required = false) String theLocale,HttpServletRequest request) {
		request.setAttribute("theLocale", theLocale);
		return "history.jsp";
	}
	
	@RequestMapping("/instructions")
	public String instruction(@RequestParam("theLocale") String theLocale,HttpServletRequest request){
		System.out.println("okay, instructions");
		request.setAttribute("theLocale", theLocale);
		return "instructions.jsp";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam(name ="theLocale",required = false) String theLocale, HttpServletRequest req,HttpSession session ) {
		String data = req.getParameter("data");
		if(data == null) {data = "";}
		try {
		if(req.getParameter("one")!=null) data += 1;
		else if(req.getParameter("two")!=null) data+="2";
		else if(req.getParameter("three")!=null) data+="3";
		else if(req.getParameter("four")!=null) data+="4";
		else if(req.getParameter("five")!=null) data+="5";
		else if(req.getParameter("six")!=null) data+="6";
		else if(req.getParameter("seven")!=null) data+="7";
		else if(req.getParameter("eight")!=null) data+="8";
		else if(req.getParameter("nine")!=null) data+="9";
		else if(req.getParameter("zero")!=null) 	data+="0";
		else if(req.getParameter("slash")!=null) 	data+="/";
		else if(req.getParameter("comma")!=null) 	data+=",";
		else if(req.getParameter("clear")!=null) 	data ="";
		else if(req.getParameter("addDates")!=null)data = dateService.addDates(data,session);
		else if(req.getParameter("subDates")!=null) data = dateService.subDates(data,session);
		else if(req.getParameter("addNdays")!=null) 	data =dateService.addNdays(data,session);
		else if(req.getParameter("addNmonths")!=null) 	data =dateService.addNmonths(data,session);
		else if(req.getParameter("dayOfWeek")!=null) 	data =dateService.dayOfWeek(data,session);
		else if(req.getParameter("weekOfMonth")!=null) 	data =dateService.weekOfMonth(data,session);
		else if(req.getParameter("subNdays")!=null) 	data =dateService.subNdays(data,session);
		else if(req.getParameter("subNmonths")!=null) 	data =dateService.subNmonths(data,session);
		else if(req.getParameter("dayBefYesterday")!=null) 	data =dateService.dayBefYesterday(session);
		else if(req.getParameter("nextMonth")!=null) 	data =dateService.nextMonth(session);
		else if(req.getParameter("nWeeksFromNow")!=null) 	data =dateService.nWeeksFromNow(data,session);
		else if(req.getParameter("nDaysEarlier")!=null) 	data =dateService.nDaysEarlier(data,session);
		else if(req.getParameter("addNweeks")!=null) 	data =dateService.addNweeks(data,session);
		else if(req.getParameter("subNweeks")!=null) 	data =dateService.subNweeks(data,session);
		else if(req.getParameter("today")!=null) 	data =dateService.today(session);
		else if(req.getParameter("lastWeek")!=null||req.getParameter("prevWeek")!=null) 	data =dateService.lastWeek(session);
		else if(req.getParameter("nextYear")!=null) 	data =dateService.nextYear(session);
		else if(req.getParameter("lastMonth")!=null) 	data =dateService.lastMonth(session);
		else if(req.getParameter("nDaysFromNow")!=null) 	data =dateService.nDaysFromNow(data,session);
		else if(req.getParameter("nWeeksEarlier")!=null) 	data =dateService.nWeeksEarlier(data,session);
		else if(req.getParameter("tomorrow")!=null) 	data =dateService.tomorrow(session);
		else if(req.getParameter("dayAfterTomorrow")!=null) 	data =dateService.dayAfterTomorrow(session);
		else if(req.getParameter("nMonthsFromNow")!=null) 	data =dateService.nMonthsFromNow(data,session);
		else if(req.getParameter("yesterday")!=null) 	data =dateService.yesterday(session);
		else if(req.getParameter("nextWeek")!=null) 	data =dateService.nextWeek(session);
		else if(req.getParameter("lastYear")!=null) 	data =dateService.lastYear(session);
		else if(req.getParameter("nYearsFromNow")!=null) 	data =dateService.nYearsFromNow(data,session);
		else if(req.getParameter("nYearseEarlier")!=null) 	data =dateService.nYearsEarlier(data,session);
		else if(req.getParameter("nMonthsEarlier")!=null) 	data =dateService.nMonthsEarlier(data,session);
		else if(req.getParameter("history")!=null) 	return "history.jsp";
		}catch(NumberFormatException e) {
			return "entered InvalidNumber";
		}
		catch(ParseException e) {
			return "entered Invalid Dates";
		}
		req.setAttribute("data", data);
		req.setAttribute("theLocale", theLocale);
		return "index.jsp";
	}
}
