<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, domain.Teacher, domain.Chair, domain.Post" %>

<jsp:include page="header.jsp"/>

<div class="content">
    <div class="topbar"><h5>Преподаватели</h5></div>

    <div class="form-container">
        <form method="post">
            <input name="firstName" placeholder="Имя" class="form-control mb-2" required>
            <input name="secondName" placeholder="Отчество" class="form-control mb-2" required>
            <input name="lastName" placeholder="Фамилия" class="form-control mb-2" required>
            <input name="phone" placeholder="Телефон" class="form-control mb-2">
            <input name="email" placeholder="Email" class="form-control mb-2">

            <%
                List<Chair> chairs = (List<Chair>) request.getAttribute("chairs");
                List<Post> posts = (List<Post>) request.getAttribute("posts");
            %>

            <select name="idChair" class="form-control mb-2" required>
                <option value="">Выберите кафедру</option>
                <%
                    if (chairs != null) {
                        for (Chair c : chairs) {
                %>
                <option value="<%= c.getId() %>"><%= c.getNameChair() %></option>
                <%
                        }
                    }
                %>
            </select>

            <select name="idPost" class="form-control mb-2" required>
                <option value="">Выберите должность</option>
                <%
                    if (posts != null) {
                        for (Post p : posts) {
                %>
                <option value="<%= p.getId() %>"><%= p.getNamePost() %></option>
                <%
                        }
                    }
                %>
            </select>

            <button type="submit" class="btn btn-primary">Добавить</button>
        </form>
    </div>

    <table class="table mt-4">
        <tr>
            <th>ID</th>
            <th>ФИО</th>
            <th>Телефон</th>
            <th>Email</th>
            <th>Кафедра</th>
            <th>Должность</th>
            <th>Факультет</th>
            <th></th>
        </tr>

        <%
            List<Teacher> list = (List<Teacher>) request.getAttribute("teachers");
            String editId = request.getParameter("editId");

            if (list != null) {
                for (Teacher t : list) {
                    boolean isEdit = editId != null && editId.equals(String.valueOf(t.getId()));
                    if (isEdit) {
        %>
        <tr>
            <form method="post">
                <input type="hidden" name="action" value="update">
                <input type="hidden" name="id" value="<%= t.getId() %>">

                <td><%= t.getId() %></td>

                <td>
                    <input name="lastName" value="<%= t.getLastName() %>" class="form-control mb-1" required>
                    <input name="firstName" value="<%= t.getFirstName() %>" class="form-control mb-1" required>
                    <input name="secondName" value="<%= t.getSecondName() %>" class="form-control" required>
                </td>

                <td><input name="phone" value="<%= t.getPhone() == null ? "" : t.getPhone() %>" class="form-control"></td>
                <td><input name="email" value="<%= t.getEmail() == null ? "" : t.getEmail() %>" class="form-control"></td>

                <td>
                    <select name="idChair" class="form-control" required>
                        <%
                            if (chairs != null) {
                                for (Chair c : chairs) {
                        %>
                        <option value="<%= c.getId() %>" <%= c.getNameChair() != null && c.getNameChair().equals(t.getChairName()) ? "selected" : "" %>>
                            <%= c.getNameChair() %>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>
                </td>

                <td>
                    <select name="idPost" class="form-control" required>
                        <%
                            if (posts != null) {
                                for (Post p : posts) {
                        %>
                        <option value="<%= p.getId() %>" <%= p.getNamePost() != null && p.getNamePost().equals(t.getPostName()) ? "selected" : "" %>>
                            <%= p.getNamePost() %>
                        </option>
                        <%
                                }
                            }
                        %>
                    </select>
                </td>

                <td><%= t.getFacultyName() %></td>

                <td>
                    <button type="submit" class="btn btn-success btn-sm">Сохранить</button>
                    <a href="teacher" class="btn btn-secondary btn-sm">Отмена</a>
                </td>
            </form>
        </tr>
        <%
                    } else {
        %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getLastName() %> <%= t.getFirstName() %> <%= t.getSecondName() %></td>
            <td><%= t.getPhone() %></td>
            <td><%= t.getEmail() %></td>
            <td><%= t.getChairName() %></td>
            <td><%= t.getPostName() %></td>
            <td><%= t.getFacultyName() %></td>
            <td>
                <a href="teacher?editId=<%= t.getId() %>" class="btn btn-warning btn-sm">Редактировать</a>
                <a href="teacher?action=delete&id=<%= t.getId() %>" class="btn btn-danger btn-sm">Удалить</a>
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