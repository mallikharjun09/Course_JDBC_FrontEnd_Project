package com.tmf.sfe.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.tmf.students.backend.entities.Course;
import com.tmf.students.backend.repository.CourseRepository;
import com.tmf.students.backend.repository.CourseRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DisplayCourses extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException{
		
		CourseRepository repo = new CourseRepositoryImpl();
		
		List<Course> courses = repo.displayAllCourses();
		
		PrintWriter out = resp.getWriter();
		
		out.println("<table border='2' cellpadding='5' >");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Course Code</th>");
		out.println("<th>Course Name</th>");
		out.println("<th>Course Duration</th>");
		out.println("<th>Course Fee</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Course c : courses) {
			out.println("<tr>");
			out.println("<td>"+c.getCourseCode()+"</td>");
			out.println("<td>"+c.getCourseName()+"</td>");
			out.println("<td>"+c.getDuration()+"</td>");
			out.println("<td>"+c.getFee()+"</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		
	}
}
