package dao;

import domain.Chair;
import dao.DbConnection;

import java.sql.*;
import java.util.*;

public class ChairDAO {

    public List<Chair> findAll() {
        List<Chair> list = new ArrayList<>();

        String sql = """
            SELECT c.id, c.nameChair, c.shortNameChair,
                   f.nameFaculty
            FROM Chair c
            LEFT JOIN Faculty f ON c.idFaculty = f.id
        """;

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Chair c = new Chair();

                c.setId(rs.getInt("id"));
                c.setNameChair(rs.getString("nameChair"));
                c.setShortNameChair(rs.getString("shortNameChair"));
                c.setFacultyName(rs.getString("nameFaculty"));

                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public Chair findById(int id) {
        String sql = "SELECT * FROM Chair WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Chair(
                        rs.getInt("id"),
                        rs.getInt("idFaculty"),
                        rs.getString("nameChair"),
                        rs.getString("shortNameChair")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public void insert(Chair c) {
        String sql = "INSERT INTO Chair(idFaculty, nameChair, shortNameChair) VALUES (?, ?, ?)";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getIdFaculty());
            ps.setString(2, c.getNameChair());
            ps.setString(3, c.getShortNameChair());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Chair c) {
        String sql = "UPDATE Chair SET idFaculty=?, nameChair=?, shortNameChair=? WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getIdFaculty());
            ps.setString(2, c.getNameChair());
            ps.setString(3, c.getShortNameChair());
            ps.setInt(4, c.getId());
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM Chair WHERE id=?";

        try (Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}