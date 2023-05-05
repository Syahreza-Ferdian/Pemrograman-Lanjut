package Tugas_005;

public class mahasiswaFILKOM extends manusia{
    private String nim;
    private double ipk;

    public mahasiswaFILKOM(String nim, double ipk, String nama, String nik, boolean jenisKelamin, boolean menikah){
        super(nama, nik, jenisKelamin, menikah);
        this.nim = nim;
        this.ipk = ipk;
    }
    
    //mutator
    public void setIpk(double ipk) {
        this.ipk = ipk;
    }
    public void setNim(String nim) {
        this.nim = nim;
    }

    //accessor
    public String getNim() {
        return nim;
    }
    public double getIpk() {
        return ipk;
    }

    public double getBeasiswa(){
        double output = 0;

        if(ipk <= 3.5 && ipk >= 3.0) output = 50;
        else if(ipk <= 4 && ipk > 3.5) output = 75;
        return output;
    }
    public String getStatus(){
        String angkatan = "20" + nim.substring(0, 2);
        String prodi = "";
        int nimProdi = Integer.valueOf(String.valueOf(nim.charAt(6)));
        
        switch(nimProdi){
            case 2: prodi = "Teknik Informatika"; break;
            case 3: prodi = "Teknik Komputer"; break;
            case 4: prodi = "Sistem Informasi"; break;
            case 6: prodi = "Pendidikan Teknologi Informasi"; break;
            case 7: prodi = "Teknologi Informasi"; break;
        }
        return String.format("%s, %s", prodi, angkatan);
    }
    @Override
    public double getPendapatan() {
        // TODO Auto-generated method stub
        return super.getPendapatan() + getBeasiswa();
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + String.format("%-15s: %s\n%-15s: %.1f\n%-15s: %s\n", "NIM", nim, "IPK", ipk, "Status", getStatus());
    }
}
