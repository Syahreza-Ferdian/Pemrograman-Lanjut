import java.util.ArrayList;

abstract class civitas {
    protected String nama;
    protected String jenisKelamin; 

    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public String getNama(){
        return nama;
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }
}
class mahasiswa extends civitas{
    final static int MAX_MATKUL = 8;
    protected int SKS, totalSKS;
    protected String NIM;
    protected String fakultas;
    protected String jurusan;
    protected static ArrayList<Integer>nilai = new ArrayList<Integer>(MAX_MATKUL);
    protected ArrayList<String>matkul = new ArrayList<String>(MAX_MATKUL);

    // protected String matkul;
    public mahasiswa(){
        nama = "";
        jenisKelamin = "";
        jurusan = "";
        nilai.add(0);
    }
    public mahasiswa(String nama, String jenisKelamin, String jurusan, String fakultas, String NIM){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
        this.NIM = NIM;
    }
    // public mahasiswa(String nama, )
    public int getNilai(String matkul) {
        int index = 0;
        for(int i = 0; i < this.matkul.size(); i++){
            if(this.matkul.get(i).equals(matkul)){
                index = i;
                break;
            }
            else index = -1;
        }
        return (mahasiswa.nilai.get(index) == null) ? 0 : mahasiswa.nilai.get(index);
    }
    public void setMatkul(String kodeMatkul) {
        int indexRowMatkul = -1;
        for(int i = 0; i < dosenMhsTendik.dataMatkul.length; i++){
            if(dosenMhsTendik.dataMatkul[i][1].equals(kodeMatkul)){
                indexRowMatkul = i;
                break;
            }
        }
        if(indexRowMatkul == -1) System.out.println("ERROR: Matkul tidak ditemukan!");
        else{
            String namaMatkul = dosenMhsTendik.dataMatkul[indexRowMatkul][0];
            this.matkul.add(namaMatkul);
            SKS = Integer.valueOf(dosenMhsTendik.dataMatkul[indexRowMatkul][2]);
            totalSKS += SKS;
        }
    }
    public ArrayList<String> getMatkul() {
        return matkul;
    }
    public void tampilkanDetails(){
        System.out.println("===[DATA MAHASISWA]===");
        System.out.printf("Nama\t\t: %s\n", this.nama);
        System.out.printf("Gender\t\t: %s\n", this.jenisKelamin);
        System.out.printf("Fakultas\t: %s\n", this.fakultas);
        System.out.printf("Jurusan\t\t: %s\n", this.jurusan);
        System.out.println("Matkul yang diambil: ");
        tampilkanMatkulYgDiambil();
        System.out.printf("Nilai Matkul\t:\n");
        for(int i = 0; i < this.matkul.size(); i++){
            if(i >= mahasiswa.nilai.size()){
                mahasiswa.nilai.add(null);
            }
            System.out.printf("%s = %d\n", matkul.get(i), nilai.get(i));
        }
    }
    public int cariMatkul(String matkul){
        int index = -1;
        for(int i = 0; i < this.matkul.size(); i++){
            if(this.matkul.get(i).equalsIgnoreCase(matkul)) index = i;
        }   
        return index;
    }
    public void tampilkanMatkulYgDiambil(){
        for(int i = 0; i < this.matkul.size(); i++){
            for(int j = 0; j < dosenMhsTendik.dataMatkul.length; j++){
                if(matkul.get(i).equalsIgnoreCase(dosenMhsTendik.dataMatkul[j][0])){
                    System.out.printf("%-30s%s%20s\n", dosenMhsTendik.dataMatkul[j][0], dosenMhsTendik.dataMatkul[j][1], dosenMhsTendik.dataMatkul[j][2]);
                }
            }
        }
    }
    public void emptyIsNull(ArrayList<Integer> nilai){
        int i = 0;
        while(i != MAX_MATKUL){
            nilai.add(null);
            i++;
        }
    }
}
class dosen extends civitas{
    protected String NIP;
    protected String matkul;
    // private mahasiswa mahasiswaN;

    public dosen(){
        NIP = "";
        matkul = "";
    }
    public dosen(String nama, String NIP, String jenisKelamin){
        this.nama = nama;
        this.NIP = NIP;
        this.jenisKelamin = jenisKelamin;
    }

    public void setNilai(int nilai, Object mahasiswaN, String kodeMatkul) {
        ((mahasiswa)mahasiswaN).emptyIsNull(mahasiswa.nilai);
        if(mahasiswaN instanceof mahasiswa){
            int indexRowMatkul = -1;
            for(int i = 0; i < dosenMhsTendik.dataMatkul.length; i++){
                if(dosenMhsTendik.dataMatkul[i][1].equals(kodeMatkul)){
                    indexRowMatkul = i;
                    break;
                }
            }
            if(indexRowMatkul == -1) System.out.println("ERROR: Kode Matkul tidak ditemukan");
            else{
                String namaMatkul = dosenMhsTendik.dataMatkul[indexRowMatkul][0];
                boolean afkhMhsMengambilMatkul = (((mahasiswa)mahasiswaN).cariMatkul(namaMatkul) >= 0) ? true : false;
                if(afkhMhsMengambilMatkul){
                    mahasiswa.nilai.set(((mahasiswa)mahasiswaN).cariMatkul(namaMatkul), nilai);
                    System.out.println(((mahasiswa)mahasiswaN).cariMatkul(namaMatkul));
                }
                else System.out.println("ERROR: Mahasiswa Tidak mengambil matkul tersebut!");
            }
        }
        else System.out.println("ERROR: Tidak bisa memberikan nilai kepada selain mahasiswa!");
    }

    public void lihatDetailMhs(mahasiswa mahasiswaN){
        System.out.println("Berhasil mengambil data mahasiswa tersebut");
        mahasiswaN.tampilkanDetails();
    }
}
class tendik extends civitas{
    private String gaji;
    private String idPegawai;
    protected String tugas;
    protected String jamKerja;
    protected String jabatan;
    public tendik(){
        nama = "";
        jenisKelamin = "";
        tugas = "";
        idPegawai = "";
    }
    public tendik(String nama, String jenisKelamin, String idPegawai, String tugas){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.idPegawai = idPegawai;
        this.tugas = tugas;
    }
    public tendik(String nama, String jenisKelamin, String idPegawai, String tugas, String jabatan){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.idPegawai = idPegawai;
        this.tugas = tugas;
        this.jabatan = jabatan;
    }
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public void tampilkanDetails(){
        System.out.println("===[PROFIL TENAGA PENDIDIK]===");
        System.out.printf("Nama\t\t: %s\n", this.nama);
        System.out.printf("Jenis Kelamin\t: %s\n", this.jenisKelamin);
        System.out.printf("ID Pegawai\t: %s\n", this.idPegawai);
        System.out.printf("Tugas\t\t: %s\n", this.tugas);
        if(!(this.jabatan == null)) System.out.printf("Jabatan\t\t: %s\n", this.jabatan);
    }
    public void inputMatkulMhs(Object mahasiswaN, String kodeMatkul){
        if(this.jabatan.equalsIgnoreCase("Akademik")){
            if(mahasiswaN instanceof mahasiswa){
                ((mahasiswa)mahasiswaN).setMatkul(kodeMatkul);
            }
            else System.out.println("ERROR: Tidak bisa set matkul kepada selain mahasiswa");
        }
        else System.out.println("ERROR: Anda tidak mempunyai otoritas untuk menggunakan fungsi ini!");
    }
}

public class dosenMhsTendik {
    public static String[][] dataMatkul = {{"Pemrograman Lanjut", "001", "5"},
                                            {"Dasar Desain Antarmuka Pengguna", "002", "3"},
                                            {"Dasar Pengembangan Sistem Informasi", "003", "2"},
                                            {"Pengantar Sistem Operasi", "004", "2"},
                                            {"Sistem Basis Data", "005", "4"},
                                            {"Kewarganegaraan", "006", "2"},
                                            {"Bahasa Indonesia", "007", "2"}};
    public static void main(String[] args) {
        //Mhs
        mahasiswa mahasiswa1 = new mahasiswa("Syahreza", "Laki-laki", "Teknologi Informasi", "Filkom", "225150701111036");
        
        //Dosen
        dosen dosen1 = new dosen("Pak Budi", "38918293091", "Laki-laki");
        dosen dosen2 = new dosen("Pak Doni", "3271630129341", "Laki-laki");
        //Tendik
        tendik tendik1 = new tendik("Agus", "Laki-laki", "20945", "Menjaga Keamanan");
        tendik tendik2 = new tendik("Slamet", "Laki-laki", "28901", "Menginput data mahasiswa", "Akademik");

        //All methods goes here

        // tendik1.tampilkanDetails();
        // tendik2.tampilkanDetails();
        tendik2.inputMatkulMhs(mahasiswa1, "001");
        tendik2.inputMatkulMhs(mahasiswa1, "004");
        dosen1.setNilai(90, mahasiswa1, "001");
        dosen1.setNilai(80, mahasiswa1, "004");
        mahasiswa1.setMatkul("006");
        mahasiswa1.setMatkul("007");
        mahasiswa1.setMatkul("003");
        dosen1.setNilai(10, mahasiswa1, "007");
        dosen1.setNilai(80, mahasiswa1, "003");
        dosen1.setNilai(85, mahasiswa1, "006");
        mahasiswa1.tampilkanDetails();
    }   
}