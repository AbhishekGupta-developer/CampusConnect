package com.myorganisation.servlet;

import com.myorganisation.dao.StudentDAO;
import com.myorganisation.model.Student;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.addStudent(student);

        response.sendRedirect("StudentServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        StudentDAO studentDAO = new StudentDAO();

        List<Student> studentList = studentDAO.getAllStudents();

        request.setAttribute("students", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewStudents.jsp");
        requestDispatcher.forward(request, response);
    }
}
