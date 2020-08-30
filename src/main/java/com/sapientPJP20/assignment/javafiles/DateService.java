package com.sapientPJP20.assignment.javafiles;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

@Service
public class DateService {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private Boolean headed = false;
	
	
	public void addToHistory(HttpSession session,String inputOne,String inputTwo,String operation, String output) {
		if(!headed) {
			Action action = new Action("inputOne","inputTwo","operation","output","sessionId");
			OutputScanner.writeAction(action);
			headed =  true;
		}
			
		
		if(session.getAttribute("history")==null) {
	        List<Action> actionsHistory = new ArrayList<>();
			session.setAttribute("history", actionsHistory);
	    }
		List<Action> history =  (List<Action>)session.getAttribute("history");
		Action action = new Action();
		action.setSessionId(session.getId());
		action.setInputOne(inputOne);
		action.setInputTwo(inputTwo);
		action.setOperation(operation);
		action.setOutput(output);
		history.add(action); 
		OutputScanner.writeAction(action);
		System.out.println(OutputScanner.readAction());
		return;
	}
	
	
	public String addNdays(String string, HttpSession session) throws ParseException {
		System.out.println("addNdays");
		String[] strings = string.split(",");
		Integer ndays = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusDays(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"addNdays",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
     public String weekOfMonth(String string, HttpSession session) throws ParseException {
		Date date1 = null;
		SimpleDateFormat dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		date1 = dateFormat.parse(string);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		addToHistory(session,string,"NA","addNdays",Integer.toString(dateone.getDayOfMonth()/7+1));
		return Integer.toString(dateone.getDayOfMonth()/7+1);
	}
	public String subNdays(String string, HttpSession session) throws ParseException {
		String[] strings = string.split(",");
		Integer ndays = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusDays(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"subNdays",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	
	public String dayBefYesterday(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusDays(2);
		DayOfWeek day = dateone.getDayOfWeek();
		addToHistory(session,"NA","NA","dayBefYesterday",day.toString());
		return day.toString();
	}
	
	public String nextMonth(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusMonths(1);
		Month month = dateone.getMonth();
		addToHistory(session,"NA","NA","nextMonth",month.toString());
		return month.toString();
	}
	
	public String nWeeksFromNow(String string, HttpSession session) {
		System.out.println("nWeeksFromNow");
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusWeeks(Integer.parseInt(string));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA",string,"nWeeksFromNow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	public String nDaysEarlier(String string, HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusDays(Integer.parseInt(string));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,string,"NA","nDaysEarlier",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	public String addNweeks(String string, HttpSession session) throws ParseException {
		String[] strings = string.split(",");
		Integer nWeeks = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusWeeks(nWeeks);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"addNweeks",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
    public String today(HttpSession session) {
    	addToHistory(session,"NA","NA","today",dateFormat.format(new Date()));
    	return dateFormat.format(new Date());    	
	}
	
    public String lastWeek(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusDays(7);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","lastWeek",dateFormat.format(date1));
		return dateFormat.format(date1);
    }
	
    
	public String addDates(String string, HttpSession session) throws ParseException{
		String[] strings = string.split(",");
		Date date1 = null;
		Date date2 = null;
		date1 = dateFormat.parse(strings[0]);
		date2 = dateFormat.parse(strings[1]);
	    LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate datetwo = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusYears(datetwo.getYear());
		dateone =dateone.plusMonths(datetwo.getMonthValue());
		dateone =dateone.plusDays(datetwo.getDayOfMonth());
		int days =dateone.getDayOfYear();
		Month month = dateone.getMonth();
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"addDates",dateFormat.format(date1));
		String output = "days="+days+", month = "+month+", weeks = "+(days/7)+", date ="+dateFormat.format(date1);
		addToHistory(session,strings[0],strings[1],"addDates",output);
		return output;
	}
	
	
	
	public String addNmonths(String string, HttpSession session) throws ParseException {
		String[] strings = string.split(",");
		Integer ndays = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusMonths(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"addNmonths",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String addNyears(String string,HttpSession session) throws ParseException {
		String[] strings = string.split(",");
		Integer ndays = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusYears(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"addNYears",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	
	
	
	
	public String subDates(String string, HttpSession session) throws ParseException {
		String[] strings = string.split(",");
		Date date1 = null;
		Date date2 = null;
		date1 = dateFormat.parse(strings[0]);
		date2 = dateFormat.parse(strings[1]);
		if(date1.after(date2))
			return "subtraction is not possible";
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate datetwo = date2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusYears(datetwo.getYear());
		dateone =dateone.minusMonths(datetwo.getMonthValue());
		dateone =dateone.minusDays(datetwo.getDayOfMonth());
		int days =dateone.getDayOfYear();
		Month month = dateone.getMonth();
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		String output ="days="+days+", month = "+month+", weeks = "+(days/7)+", date ="+dateFormat.format(date1);
		addToHistory(session,strings[0],strings[1],"subDates",output);
		return output;
	}
	
	public String dayOfWeek(String data, HttpSession session) throws ParseException{
		Date date1 = null;
		date1 = dateFormat.parse(data);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		DayOfWeek day = dateone.getDayOfWeek();
		addToHistory(session,day.toString(),"NA","dayOfWeek",dateFormat.format(date1));
		return day.toString();
	}
	
	public String nextYear(HttpSession session) {	
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusYears(1);
		addToHistory(session,"NA","NA","nextYear",String.valueOf(dateone.getYear()));
		return String.valueOf(dateone.getYear());
    }
	public String lastMonth(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.minusMonths(1);
		Month month = dateone.getMonth();
		addToHistory(session,"NA","NA","lastMonth",month.toString());
		return month.toString();
	}
	
	public String nDaysFromNow(String string, HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusDays(Integer.parseInt(string));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA",string,"nDaysFromNow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String nWeeksEarlier(String data, HttpSession session) {
			Date date1 = new Date();
			LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			dateone = dateone.minusWeeks(Integer.parseInt(data));
			date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
			addToHistory(session,"NA",data,"nWeeksEarlier",dateFormat.format(date1));
			return	dateFormat.format(date1);
	}
	public String tomorrow(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusDays(1);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","tomorrow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	public String nMonthsFromNow(String data, HttpSession session) {
		Integer ndays = Integer.parseInt(data);
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.plusMonths(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA",data,"nMonthsFromNow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String yesterday(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusDays(1);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","yesterday",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String nextWeek(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusWeeks(1);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","nextWeek",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String lastYear(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusYears(1);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","lastYear",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String nYearsFromNow(String data, HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusYears(Integer.parseInt(data));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","nYearsFromNow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String nYearsEarlier(String data, HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.minusYears(Integer.parseInt(data));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA",data,"nYearsEarlier",dateFormat.format(date1));
		return	dateFormat.format(date1);
	}
	public String nMonthsEarlier(String data, HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.minusMonths(Integer.parseInt(data));
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA",data,"nMonthsEarlier",dateFormat.format(date1));	
		return	dateFormat.format(date1);
	}
	public String subNmonths(String string, HttpSession session) throws ParseException {
        String[] strings = string.split(",");
		Integer ndays = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusMonths(ndays);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"subNmonths",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String subNweeks(String string, HttpSession session) throws ParseException {
        String[] strings = string.split(",");
		Integer nWeeks = Integer.parseInt(strings[1]);
		Date date1 = null;
		date1 = dateFormat.parse(strings[0]);
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone =dateone.minusWeeks(nWeeks);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,strings[0],strings[1],"subNweeks",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	public String dayAfterTomorrow(HttpSession session) {
		Date date1 = new Date();
		LocalDate dateone = date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		dateone = dateone.plusDays(2);
		date1 = Date.from(dateone.atStartOfDay(ZoneId.systemDefault()).toInstant());
		addToHistory(session,"NA","NA","dayAfterTomorrow",dateFormat.format(date1));
		return dateFormat.format(date1);
	}
	
	
	
	

}
