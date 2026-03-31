package dao;

import domain.Teacher;
import dao.DbConnection;

import java.sql.*;
import java.util.*;

public class TeacherDAO {

    public List<Teacher> findAll() {
        List<Teacher> list = new ArrayList<>();

        String sql = """
            SELECT t.id, t.firstName, t.secondName, t.lastName,
                   t.phone, t.email,
                   c.nameChair,
                   p.namePost,
                   f.nameFaculty
            FROM Teacher t
            LEFT JOIN Chair c ON t.idChair = c.id
            LEFT JOIN Post p ON t.idPost = p.id
            LEFT JOIN Faculty f ON c.idFaculty = f.id
        """;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Teacher t = new Teacher();

                t.setId(rs.getInt("id"));
                t.setFirstName(rs.getString("firstName"));
                t.setSecondName(rs.getString("secondName"));
                t.setLastName(rs.getString("lastName"));
                t.setPhone(rs.getString("phone"));
                t.setEmail(rs.getString("email"));

                t.setChairName(rs.getString("nameChair"));
                t.setPostName(rs.getString("namePost"));
                t.setFacultyName(rs.getString("nameFaculty"));

                list.add(t);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Teacher findById(int id) {
        String sql = "SELECT * FROM Teacher WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Teacher(
                        rs.getInt("id"),
                        rs.getInt("idChair"),
                        rs.getInt("idPost"),
                        rs.getString("firstName"),
                        rs.getString("secondName"),
                        rs.getString("lastName"),
                        rs.getString("phone"),
                        rs.getString("email")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Teacher t) {
        String sql = """
            INSERT INTO Teacher(idChair, idPost, firstName, secondName, lastName, phone, email)
            VALUES (?, ?, ?, ?, ?, ?, ?)
        """;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, t.getIdChair());
            ps.setInt(2, t.getIdPost());
            ps.setString(3, t.getFirstName());
            ps.setString(4, t.getSecondName());
            ps.setString(5, t.getLastName());
            ps.setString(6, t.getPhone());
            ps.setString(7, t.getEmail());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Teacher t) {
        String sql = """
            UPDATE Teacher
            SET idChair=?, idPost=?, firstName=?, secondName=?, lastName=?, phone=?, email=?
            WHERE id=?
        """;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, t.getIdChair());
            ps.setInt(2, t.getIdPost());
            ps.setString(3, t.getFirstName());
            ps.setString(4, t.getSecondName());
            ps.setString(5, t.getLastName());
            ps.setString(6, t.getPhone());
            ps.setString(7, t.getEmail());
            ps.setInt(8, t.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Teacher WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}