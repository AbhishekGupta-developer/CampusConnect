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

public class RemoveStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        Student student = new Student();
        student.setId(id);
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.removeStudent(student.getId());


        List<Student> studentList = studentDAO.getAllStudents();

        request.setAttribute("students", studentList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("viewStudents.jsp");
        requestDispatcher.forward(request, response);
    }
}
