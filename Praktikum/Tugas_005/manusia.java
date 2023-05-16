package Tugas_005;


public class manusia {
    private String nama, nik;
    private boolean jenisKelamin; //true = male, false = female
    private boolean menikah;

    public manusia(String nama, String nik, boolean jenisKelamin, boolean menikah){
        this.nama = nama;
        this.nik = nik;
        this.jenisKelamin = jenisKelamin;
        this.menikah = menikah;
    }
    //mutator
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setNik(String nik) {
        this.nik = nik;
    }
    public void setMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    //accessor
    public String getNama() {
        return nama;
    }
    public String getNik() {
        return nik;
    }
    public String getJenisKelamin(){
        return jenisKelamin == true ? ("Laki - laki") : ("Perempuan");
    }
    public boolean getMenikah(){
        return menikah;
    }
    public double getTunjangan(){
        if(menikah){
            if(jenisKelamin) return 25;
            else return 20;
        }
        else return 15;
    }
    public double getPendapatan(){
        return getTunjangan();
    }

    //methods
    @Override
    public String toString() {
        return String.format("%-15s: %s\n%-15s: %s\n%-15s: %s\n%-15s: $%.1f\n", "Nama", nama, "NIK", nik, "Jenis Kelamin", this.getJenisKelamin(), "Pendapatan", this.getPendapatan());
    }
}
