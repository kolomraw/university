<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Post" %>

<jsp:include page="header.jsp"/>

<div class="content">
    <div class="topbar"><h5>Должности</h5></div>

    <%
        List<Post> list = (List<Post>) request.getAttribute("posts");
        String editId = request.getParameter("editId");
    %>

    <div class="form-container">
        <form method="post">
            <input type="text" name="namePost" placeholder="Название" class="form-control mb-2" required>
            <button class="btn btn-primary">Добавить</button>
        </form>
    </div>

    <table class="table mt-4">
        <tr>
            <th>ID</th>
            <th>Название</th>
            <th></th>
        </tr>

        <%
            if (list != null) {
                for (Post p : list) {
                    boolean isEdit = editId != null && editId.equals(String.valueOf(p.getId()));
                    if (isEdit) {
        %>

        <tr>
            <form method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%=p.getId()%>">

                <td><%= p.getId() %></td>

                <td>
                    <input name="namePost" value="<%=p.getNamePost()%>" class="form-control">
                </td>

                <td>
                    <button class="btn btn-success btn-sm">Сохранить</button>
                    <a href="post" class="btn btn-secondary btn-sm">Отмена</a>
                </td>
            </form>
        </tr>

        <%
                    } else {
        %>

        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getNamePost() %></td>
            <td>
                <a href="post?editId=<%=p.getId()%>" class="btn btn-warning btn-sm">Редактировать</a>
                <a href="post?action=delete&id=<%=p.getId()%>" class="btn btn-danger btn-sm">Удалить</a>
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