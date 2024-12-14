package controller;

import model.Mobil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MobilController {
    public void insertMobil(Mobil mobil) throws SQLException {
        String query = "INSERT INTO mobil (nama_mobil, jenis_mobil, harga_sewa, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, mobil.getNamaMobil());
            ps.setString(2, mobil.getJenisMobil());
            ps.setDouble(3, mobil.getHargaSewa());
            ps.setString(4, mobil.getStatus());
            ps.executeUpdate();
        }
    }

    public List<Mobil> getAllMobil() throws SQLException {
        List<Mobil> list = new ArrayList<>();
        String query = "SELECT * FROM mobil";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Mobil(
                        rs.getInt("id_mobil"),
                        rs.getString("nama_mobil"),
                        rs.getString("jenis_mobil"),
                        rs.getDouble("harga_sewa"),
                        rs.getString("status")
                ));
            }
        }
        return list;
    }

    public void updateMobil(Mobil mobil) throws SQLException {
        String query = "UPDATE mobil SET nama_mobil = ?, jenis_mobil = ?, harga_sewa = ?, status = ? WHERE id_mobil = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, mobil.getNamaMobil());
            ps.setString(2, mobil.getJenisMobil());
            ps.setDouble(3, mobil.getHargaSewa());
            ps.setString(4, mobil.getStatus());
            ps.setInt(5, mobil.getIdMobil());
            ps.executeUpdate();
        }
    }

    public void deleteMobil(int idMobil) throws SQLException {
        String query = "DELETE FROM mobil WHERE id_mobil = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, idMobil);
            ps.executeUpdate();
        }
    }
}
