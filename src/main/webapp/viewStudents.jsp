<%@
    page import="java.util.*, com.myorganisation.model.Student"
%>

<h2 style="text-align:center;">Student List</h2>
</br>
</br>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
        <th>Update</th>
        <th>Delete</th>
    </tr>
<%
        List<Student> studentList = (List<Student>) request.getAttribute("students");

        if(studentList != null && !studentList.isEmpty()) {
            for(Student s : studentList) {
%>
                <tr>
                    <td><%= s.getId() %></td>
                    <td><%= s.getName() %></td>
                    <td><%= s.getEmail() %></td>
                    <td><%= s.getCourse() %></td>
                    <td><a href="editStudent.jsp?id=<%= s.getId() %>">Update</a></td>
                    <td><a href="RemoveStudentServlet?id=<%= s.getId() %>">Delete</a></td>
                </tr>
<%
            }
        } else {
%>
            <tr>
                <td colspan="4">No Students Found!</td>
            </tr>
<%
        }
%>
</table>