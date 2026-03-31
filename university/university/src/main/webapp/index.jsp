<%@ page contentType="text/html;charset=UTF-8" %>

<jsp:include page="views/header.jsp"/>

<div class="content">

    <div class="topbar">
        <h5>Система учета преподавателей</h5>
    </div>

    <div class="container mt-4">
        <div class="row g-4 justify-content-center">

            <div class="col-md-6 col-lg-3">
                <div class="card card-custom text-center">
                    <div class="card-body">
                        <h5>Факультеты</h5>
                        <p>Управление факультетами</p>
                        <a href="faculty" class="btn btn-primary">Перейти</a>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="card card-custom text-center">
                    <div class="card-body">
                        <h5>Кафедры</h5>
                        <p>Управление кафедрами</p>
                        <a href="chair" class="btn btn-primary">Перейти</a>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="card card-custom text-center">
                    <div class="card-body">
                        <h5>Преподаватели</h5>
                        <p>Список преподавателей</p>
                        <a href="teacher" class="btn btn-primary">Перейти</a>
                    </div>
                </div>
            </div>

            <div class="col-md-6 col-lg-3">
                <div class="card card-custom text-center">
                    <div class="card-body">
                        <h5>Должности</h5>
                        <p>Управление должностями</p>
                        <a href="post" class="btn btn-primary">Перейти</a>
                    </div>
                </div>
            </div>

        </div>
    </div>

</div>

<jsp:include page="views/footer.jsp"/>