package controller;

import model.Transaksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TransaksiController {
    private Connection connection;

    public TransaksiController() {
        try {
    Connection connection = DatabaseConnection.getConnection();
    // Operasi database di sini
} catch (SQLException e) {
    // Menangani exception
    e.printStackTrace(); // Debugging, cetak stack trace
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
}

    }

    public List<Transaksi> getAllTransaksi() {
        List<Transaksi> transaksiList = new ArrayList<>();
        try {
            String query = "SELECT * FROM transaksi";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Transaksi transaksi = new Transaksi(
                        resultSet.getInt("id_transaksi"),
                        resultSet.getInt("id_mobil"),
                        resultSet.getInt("id_pelanggan"),
                        resultSet.getString("tanggal_sewa"),
                        resultSet.getString("tanggal_kembali"),
                        resultSet.getDouble("total_biaya")
                );
                transaksiList.add(transaksi);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaksiList;
    }

    public void insertTransaksi(Transaksi transaksi) {
        try {
            String query = "INSERT INTO transaksi (id_mobil, id_pelanggan, tanggal_sewa, tanggal_kembali, total_biaya) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, transaksi.getIdMobil());
            preparedStatement.setInt(2, transaksi.getIdPelanggan());
            preparedStatement.setString(3, transaksi.getTanggalSewa());
            preparedStatement.setString(4, transaksi.getTanggalKembali());
            preparedStatement.setDouble(5, transaksi.getTotalBiaya());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTransaksi(Transaksi transaksi) {
        try {
            String query = "UPDATE transaksi SET id_mobil = ?, id_pelanggan = ?, tanggal_sewa = ?, tanggal_kembali = ?, total_biaya = ? WHERE id_transaksi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, transaksi.getIdMobil());
            preparedStatement.setInt(2, transaksi.getIdPelanggan());
            preparedStatement.setString(3, transaksi.getTanggalSewa());
            preparedStatement.setString(4, transaksi.getTanggalKembali());
            preparedStatement.setDouble(5, transaksi.getTotalBiaya());
            preparedStatement.setInt(6, transaksi.getIdTransaksi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTransaksi(int idTransaksi) {
        try {
            String query = "DELETE FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, idTransaksi);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
