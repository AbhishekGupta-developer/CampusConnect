<%@
    page import="java.util.*, com.myorganisation.model.Student"
%>

<h2>Student List</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Course</th>
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