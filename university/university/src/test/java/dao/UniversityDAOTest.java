package dao;

import domain.Faculty;
import domain.Teacher;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UniversityDAOTest {

    @Test
    public void shouldReturnFacultyList() {
        FacultyDAO dao = new FacultyDAO();

        List<Faculty> faculties = dao.findAll();

        assertNotNull(faculties);
    }

    @Test
    public void shouldInsertNewFaculty() {
        FacultyDAO dao = new FacultyDAO();

        String uniqueName = "Факультет_" + System.currentTimeMillis();

        Faculty faculty = new Faculty();
        faculty.setNameFaculty(uniqueName);
        faculty.setShortNameFaculty("ТЕСТ");

        dao.insert(faculty);

        List<Faculty> faculties = dao.findAll();

        boolean found = faculties.stream()
                .anyMatch(f -> uniqueName.equals(f.getNameFaculty()));

        assertTrue(found);
    }

    @Test
    public void shouldReturnTeachersList() {
        TeacherDAO dao = new TeacherDAO();

        List<Teacher> teachers = dao.findAll();

        assertNotNull(teachers);
    }

    @Test
    public void shouldInsertTeacher() {
        TeacherDAO dao = new TeacherDAO();

        Teacher t = new Teacher(
                1,
                1,
                "Иван",
                "Иванович",
                "Тестов_" + System.currentTimeMillis(),
                "123456789",
                "test@mail.com"
        );

        dao.insert(t);

        List<Teacher> teachers = dao.findAll();

        boolean found = teachers.stream()
                .anyMatch(x -> x.getLastName().contains("Тестов"));

        assertTrue(found);
    }
}