<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Faculty" %>

<jsp:include page="header.jsp"/>

<div class="content">
    <div class="topbar"><h5>Факультеты</h5></div>

    <%
        List<Faculty> list = (List<Faculty>) request.getAttribute("faculties");
        String editId = request.getParameter("editId");
    %>

    <div class="form-container">
        <form method="post">
            <input type="text" name="nameFaculty" placeholder="Название" class="form-control mb-2" required>
            <input type="text" name="shortNameFaculty" placeholder="Короткое название" class="form-control mb-2" required>
            <button class="btn btn-primary">Добавить</button>
        </form>
    </div>

    <table class="table mt-4">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Короткое</th>
            <th></th>
        </tr>

        <%
            if (list != null) {
                for (Faculty f : list) {
                    boolean isEdit = editId != null && editId.equals(String.valueOf(f.getId()));
                    if (isEdit) {
        %>

        <tr>
            <form method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%=f.getId()%>">

                <td><%= f.getId() %></td>

                <td>
                    <input name="nameFaculty" value="<%=f.getNameFaculty()%>" class="form-control">
                </td>

                <td>
                    <input name="shortNameFaculty" value="<%=f.getShortNameFaculty()%>" class="form-control">
                </td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="faculty" class="btn btn-secondary btn-sm">Отмена</a>
                </td>
            </form>
        </tr>

        <%
                    } else {
        %>

        <tr>
            <td><%= f.getId() %></td>
            <td><%= f.getNameFaculty() %></td>
            <td><%= f.getShortNameFaculty() %></td>
            <td>
                <a href="faculty?editId=<%=f.getId()%>" class="btn btn-warning btn-sm">Редактировать</a>
                <a href="faculty?action=delete&id=<%=f.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
            </td>
        </tr>

        <%
                    }
                }
            }
        %>

    </table>
</div>

<jsp:include page="footer.jsp"/>