package Tugas_005;
import java.time.LocalDate;
import java.time.Period;

public class pekerja extends manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;

    public pekerja(double gaji, int tahun, int bulan, int tanggal, int jumlahAnak, String nama, String nik, boolean jenisKelamin, boolean menikah){
        super(nama, nik, jenisKelamin, menikah);
        LocalDate tanggalan = LocalDate.of(tahun, bulan, tanggal);
        this.tahunMasuk = tanggalan;
        this.gaji = gaji;
        this.jumlahAnak = jumlahAnak;
    }
    //mutator
    public void setGaji(double gaji) {
        this.gaji = gaji;
    }
    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }
    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }
    //accessor
    public LocalDate getTahunMasuk() {
        return tahunMasuk;
    }
    public int getJumlahAnak() {
        return jumlahAnak;
    }
    public double getBonus(){
        Period bedaWaktu = Period.between(tahunMasuk, LocalDate.now());
        int lamaBekerjaDlmTahun = bedaWaktu.getYears();
        double bonus;
        
        if(lamaBekerjaDlmTahun >= 0 && lamaBekerjaDlmTahun <= 5) bonus = 0.05 * gaji;
        else if(lamaBekerjaDlmTahun > 5 && lamaBekerjaDlmTahun <= 10) bonus = 0.1 * gaji;
        else bonus = 0.15 * gaji;

        return bonus;
    }
    public double getGaji() {
        return gaji;
    }
    @Override
    public double getPendapatan() {
        return super.getPendapatan() + getBonus() + getGaji();
    }
    @Override
    public double getTunjangan() {
        return super.getTunjangan() + 20 * jumlahAnak;
    }
    @Override
    public String toString() {
        return super.toString() + String.format("%-15s: %d %d %d\n%-15s: %d\n%-15s: %.1f\n", "Tahun Masuk", tahunMasuk.getDayOfMonth(), tahunMasuk.getMonthValue(), tahunMasuk.getYear(), "Jumlah Anak", jumlahAnak, "Gaji", gaji);
    }
}
