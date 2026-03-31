<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Chair, domain.Faculty" %>

<jsp:include page="header.jsp"/>

<div class="content">

    <div class="topbar">
        <h5>Кафедры</h5>
    </div>

    <%
        List<Faculty> faculties = (List<Faculty>) request.getAttribute("faculties");
        List<Chair> list = (List<Chair>) request.getAttribute("chairs");
        String editId = request.getParameter("editId");
    %>

    <div class="form-container">
        <form method="post">
            <input type="text" name="nameChair" placeholder="Название кафедры" class="form-control mb-2" required>
            <input type="text" name="shortNameChair" placeholder="Короткое название" class="form-control mb-2" required>

            <select name="idFaculty" class="form-control mb-2" required>
                <option value="">Выберите факультет</option>
                <%
                    if (faculties != null) {
                        for (Faculty f : faculties) {
                %>
                <option value="<%= f.getId() %>"><%= f.getNameFaculty() %></option>
                <% } } %>
            </select>

            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>

    <table class="table table-hover mt-4">
        <thead>
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th>Короткое</th>
            <th>Факультет</th>
            <th></th>
        </tr>
        </thead>
        <tbody>

        <%
            if (list != null) {
                for (Chair c : list) {
                    boolean isEdit = editId != null && editId.equals(String.valueOf(c.getId()));
                    if (isEdit) {
        %>

        <tr>
            <form method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%=c.getId()%>">

                <td><%= c.getId() %></td>

                <td><input name="nameChair" value="<%=c.getNameChair()%>" class="form-control"></td>
                <td><input name="shortNameChair" value="<%=c.getShortNameChair()%>" class="form-control"></td>

                <td>
                    <select name="idFaculty" class="form-control">
                        <%
                            if (faculties != null) {
                                for (Faculty f : faculties) {
                        %>
                        <option value="<%=f.getId()%>" <%= f.getNameFaculty().equals(c.getFacultyName()) ? "selected" : "" %>>
                            <%=f.getNameFaculty()%>
                        </option>
                        <% } } %>
                    </select>
                </td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="chair" class="btn btn-secondary btn-sm">Отмена</a>
                </td>
            </form>
        </tr>

        <%
                    } else {
        %>

        <tr>
            <td><%= c.getId() %></td>
            <td><%= c.getNameChair() %></td>
            <td><%= c.getShortNameChair() %></td>
            <td><%= c.getFacultyName() %></td>
            <td>
                <a href="chair?editId=<%=c.getId()%>" class="btn btn-warning btn-sm">Редактировать</a>
                <a href="chair?action=delete&id=<%=c.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
            </td>
        </tr>

        <%
                    }
                }
            }
        %>

        </tbody>
    </table>

</div>

<jsp:include page="footer.jsp"/>