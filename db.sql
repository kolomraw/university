CREATE TABLE Faculty (
    id SERIAL PRIMARY KEY,
    nameFaculty VARCHAR(255) NOT NULL,
    shortNameFaculty VARCHAR(100)
);

CREATE TABLE Chair (
    id SERIAL PRIMARY KEY,
    idFaculty INT REFERENCES Faculty(id),
    nameChair VARCHAR(255) NOT NULL,
    shortNameChair VARCHAR(100)
);

CREATE TABLE Post (
    id SERIAL PRIMARY KEY,
    namePost VARCHAR(255) NOT NULL
);

CREATE TABLE Teacher (
    id SERIAL PRIMARY KEY,
    idChair INT REFERENCES Chair(id),
    idPost INT REFERENCES Post(id),
    firstName VARCHAR(100),
    secondName VARCHAR(100),
    lastName VARCHAR(100),
    phone VARCHAR(50),
    email VARCHAR(100)
);

INSERT INTO Faculty (nameFaculty, shortNameFaculty) VALUES
('Факультет информационных технологий', 'ФИТ'),
('Факультет экономики', 'ФЭ'),
('Факультет математики', 'ФМ'),
('Факультет физики', 'ФФ'),
('Факультет управления', 'ФУ');

INSERT INTO Chair (idFaculty, nameChair, shortNameChair) VALUES
(1, 'Кафедра программирования', 'КП'),
(1, 'Кафедра информационных систем', 'КИС'),
(2, 'Кафедра экономики предприятий', 'КЭП'),
(3, 'Кафедра высшей математики', 'КВМ'),
(4, 'Кафедра теоретической физики', 'КТФ');

INSERT INTO Post (namePost) VALUES
('Ассистент'),
('Старший преподаватель'),
('Доцент'),
('Профессор'),
('Заведующий кафедрой');

INSERT INTO Teacher (
    idChair, idPost, firstName, secondName, lastName, phone, email
) VALUES
(1, 3, 'Иван', 'Иванович', 'Иванов', '+79990000001', 'ivanov@mail.com'),
(2, 2, 'Пётр', 'Петрович', 'Петров', '+79990000002', 'petrov@mail.com'),
(3, 1, 'Сергей', 'Сергеевич', 'Сергеев', '+79990000003', 'sergeev@mail.com'),
(4, 4, 'Алексей', 'Алексеевич', 'Алексеев', '+79990000004', 'alekseev@mail.com'),
(5, 5, 'Дмитрий', 'Дмитриевич', 'Дмитриев', '+79990000005', 'dmitriev@mail.com');