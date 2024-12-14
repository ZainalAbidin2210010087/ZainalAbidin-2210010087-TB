package model;

public class Mobil {
    private int idMobil;
    private String namaMobil;
    private String jenisMobil;
    private double hargaSewa;
    private String status;

    // Constructor
    public Mobil(int idMobil, String namaMobil, String jenisMobil, double hargaSewa, String status) {
        this.idMobil = idMobil;
        this.namaMobil = namaMobil;
        this.jenisMobil = jenisMobil;
        this.hargaSewa = hargaSewa;
        this.status = status;
    }

    // Getter dan Setter
    public int getIdMobil() { return idMobil; }
    public void setIdMobil(int idMobil) { this.idMobil = idMobil; }
    public String getNamaMobil() { return namaMobil; }
    public void setNamaMobil(String namaMobil) { this.namaMobil = namaMobil; }
    public String getJenisMobil() { return jenisMobil; }
    public void setJenisMobil(String jenisMobil) { this.jenisMobil = jenisMobil; }
    public double getHargaSewa() { return hargaSewa; }
    public void setHargaSewa(double hargaSewa) { this.hargaSewa = hargaSewa; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
