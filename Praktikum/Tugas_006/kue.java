package Tugas_006;

public abstract class kue {
    private String nama;
    private double harga;

    public kue(String nama, double harga){
        this.nama = nama;
        this.harga = harga;
    }
    public String getNama() {
        return nama;
    }
    public double getHarga() {
        return harga;
    }
    public abstract double hitungHarga();
    
    public String toString() {
        return String.format("%-15s: %s\n%-15s: Rp %,3.2f", "Nama Kue", this.nama, "Harga", this.hitungHarga());
    }
}
