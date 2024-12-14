package controller;

import model.Pelanggan;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PelangganController {
    private Connection connection;

    public PelangganController() {
        try {
    Connection connection = DatabaseConnection.getConnection();
    // Operasi database di sini
} catch (SQLException e) {
    // Menangani exception
    e.printStackTrace(); // Debugging, cetak stack trace
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}

    }

    public List<Pelanggan> getAllPelanggan() {
        List<Pelanggan> pelangganList = new ArrayList<>();
        try {
            String query = "SELECT * FROM pelanggan";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Pelanggan pelanggan = new Pelanggan(
                        resultSet.getInt("id_pelanggan"),
                        resultSet.getString("nama_pelanggan"),
                        resultSet.getString("alamat"),
                        resultSet.getString("no_telepon")
                );
                pelangganList.add(pelanggan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pelangganList;
    }

    public void insertPelanggan(Pelanggan pelanggan) {
        try {
            String query = "INSERT INTO pelanggan (nama_pelanggan, alamat, no_telepon) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pelanggan.getNamaPelanggan());
            preparedStatement.setString(2, pelanggan.getAlamat());
            preparedStatement.setString(3, pelanggan.getNoTelepon());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePelanggan(Pelanggan pelanggan) {
        try {
            String query = "UPDATE pelanggan SET nama_pelanggan = ?, alamat = ?, no_telepon = ? WHERE id_pelanggan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, pelanggan.getNamaPelanggan());
            preparedStatement.setString(2, pelanggan.getAlamat());
            preparedStatement.setString(3, pelanggan.getNoTelepon());
            preparedStatement.setInt(4, pelanggan.getIdPelanggan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePelanggan(int idPelanggan) {
        try {
            String query = "DELETE FROM pelanggan WHERE id_pelanggan = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idPelanggan);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
