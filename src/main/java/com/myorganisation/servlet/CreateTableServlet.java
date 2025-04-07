package com.myorganisation.servlet;

import com.myorganisation.dao.StudentDAO;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CreateTableServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.createTable();

        response.getWriter().println("Table Created Successfully!");
    }
}
