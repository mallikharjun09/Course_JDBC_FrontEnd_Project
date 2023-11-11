package com.tmf.sfe.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.tmf.students.backend.entities.Course;
import com.tmf.students.backend.repository.CourseRepository;
import com.tmf.students.backend.repository.CourseRepositoryImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddCourse extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		out.println("Adding new Course");
		
		//Get parameters from the form
		int id = Integer.parseInt(req.getParameter("cid"));
		String name = req.getParameter("cname");
		String code = req.getParameter("ccode");
		int duration = Integer.parseInt(req.getParameter("cduration"));
		double fee = Double.parseDouble(req.getParameter("cfee"));
		
		//Set these details to a course object.
		Course c = new Course();
		
		c.setCourseCode(code);
		c.setCourseId(id);
		c.setCourseName(name);
		c.setDuration(duration);
		c.setFee(fee);
		
		//Send this object to repositoty
		CourseRepository repo = new CourseRepositoryImpl();
		
		repo.addCourse(c);
		
		System.out.println("Course Added Successfully...");
		
		RequestDispatcher rd = req.getRequestDispatcher("displayCourses");
		rd.forward(req, resp);
	}
}
