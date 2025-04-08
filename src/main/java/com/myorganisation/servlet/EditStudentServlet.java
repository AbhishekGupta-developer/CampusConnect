package com.myorganisation.servlet;

import com.myorganisation.dao.StudentDAO;
import com.myorganisation.model.Student;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class EditStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        Student student = new Student();
        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setCourse(course);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.updateStudent(student);

        response.sendRedirect("StudentServlet");
    }
}
