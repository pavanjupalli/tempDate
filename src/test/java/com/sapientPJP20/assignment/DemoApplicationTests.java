package com.sapientPJP20.assignment;

import javax.servlet.http.HttpSession;

import static org.junit.Assert.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sapientPJP20.assignment.javafiles.DateController;
import com.sapientPJP20.assignment.javafiles.DateService;
import com.sapientPJP20.assignment.javafiles.*;

import java.text.ParseException;
import java.util.*;

@SpringBootTest
class DemoApplicationTests {
	
	//i have tested only few methods because a lot to do.
	
	
	@Mock
	public HttpSession session;
	
	
	@BeforeEach
	public void call() {
		MockitoAnnotations.initMocks(this);
	}
	
	
	
	
	@Test
	void today() {
		
		DateService dateService = new DateService();
	    when(session.getAttribute("history")).thenReturn("history", new ArrayList<Action>());
	    assertEquals(dateService.today(session),"30/08/2020");
	    
		
	}
	
	@Test
	void addDates() {
		
		DateService dateService = new DateService();
	    when(session.getAttribute("history")).thenReturn("history", new ArrayList<Action>());
	    try {
			assertEquals(dateService.addDates("1/1/2000,1/1/2000", session),"days=33, month = FEBRUARY, weeks = 4, date =02/02/4000");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		
	}

}
