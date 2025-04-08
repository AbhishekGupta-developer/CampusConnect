<%@ page import="com.myorganisation.dao.StudentDAO, com.myorganisation.model.Student" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    StudentDAO studentDao = new StudentDAO();
    Student student = studentDao.getStudentById(id);
%>

<h2>Update Student</h2>

<form action="EditStudentServlet" method="post">
    <input type="hidden" name="id" value="<%= student.getId() %>" />
    Name: <input type="text" name="name" value="<%= student.getName() %>" /><br>
    Email: <input type="email" name="email" value="<%= student.getEmail() %>" /><br>
    Course: <input type="text" name="course" value="<%= student.getCourse() %>" /><br>
    <input type="submit" value="Update Student"/>
</form>