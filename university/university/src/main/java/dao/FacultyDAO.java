package dao;

import domain.Faculty;
import dao.DbConnection;

import java.sql.*;
import java.util.*;

public class FacultyDAO {

    public List<Faculty> findAll() {
        List<Faculty> list = new ArrayList<>();

        String sql = "SELECT * FROM Faculty";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Faculty(
                        rs.getInt("id"),
                        rs.getString("nameFaculty"),
                        rs.getString("shortNameFaculty")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Faculty findById(int id) {
        String sql = "SELECT * FROM Faculty WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Faculty(
                        rs.getInt("id"),
                        rs.getString("nameFaculty"),
                        rs.getString("shortNameFaculty")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Faculty f) {
        String sql = "INSERT INTO Faculty(nameFaculty, shortNameFaculty) VALUES (?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getNameFaculty());
            ps.setString(2, f.getShortNameFaculty());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Faculty f) {
        String sql = "UPDATE Faculty SET nameFaculty=?, shortNameFaculty=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, f.getNameFaculty());
            ps.setString(2, f.getShortNameFaculty());
            ps.setInt(3, f.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Faculty WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}