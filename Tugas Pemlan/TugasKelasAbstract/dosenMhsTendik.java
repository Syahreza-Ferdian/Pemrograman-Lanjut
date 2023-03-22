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
    protected int SKS, totalSKS;
    protected static int totalMatkulDiambil = 0;
    protected String NIM;
    protected String fakultas;
    protected String jurusan;
    protected static ArrayList<Integer>nilai = new ArrayList<Integer>(totalMatkulDiambil);
    protected ArrayList<String>matkul = new ArrayList<String>(totalMatkulDiambil);
    //constructor
    public mahasiswa(){
        nama = "";
        jenisKelamin = "";
        jurusan = "";
        fakultas = "";
        NIM = "";
    }
    public mahasiswa(String nama, String jenisKelamin, String jurusan, String fakultas, String NIM){
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.jurusan = jurusan;
        this.fakultas = fakultas;
        this.NIM = NIM;
    }
    //setter
    public void setFakultas(String fakultas) {
        this.fakultas = fakultas;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }
    public void setNIM(String nIM) {
        NIM = nIM;
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
            SKS = Integer.valueOf(dosenMhsTendik.dataMatkul[indexRowMatkul][2]);
            totalSKS += SKS;
            if(totalSKS > 24) {
                System.out.println("ERROR: Tidak bisa menambah matkul, melebihi jumlah SKS maksimal!");
                totalSKS -= SKS;
            }
            else {
                this.matkul.add(namaMatkul);
                System.out.println("SUCCESS: Berhasil menambah matkul!");
                totalMatkulDiambil++;
            }
        }
    }
    //getter
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
    public ArrayList<String> getMatkul() {
        return matkul;
    }
    //methods
    public void tampilkanDetails(){
        System.out.println("===[DATA MAHASISWA]===");
        System.out.printf("%-25s: %s\n","Nama", this.nama);
        System.out.printf("%-25s: %s\n","NIM", this.NIM);
        System.out.printf("%-25s: %s\n","Jenis Kelamin", this.jenisKelamin);
        System.out.printf("%-25s: %s\n", "Fakultas", this.fakultas);
        System.out.printf("%-25s: %s\n", "Jurusan", this.jurusan);
        System.out.printf("%-25s:\n", "Matkul yang diambil");
        System.out.println();
        tampilkanMatkulYgDiambil();
        System.out.println();
        System.out.printf("%-25s:\n", "Nilai Matkul");
        for(int i = 0; i < this.matkul.size(); i++){
            if(i >= mahasiswa.nilai.size()){
                mahasiswa.nilai.add(null);
            }
            System.out.printf("%-40s = %d\n", matkul.get(i), nilai.get(i));
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
        System.out.printf("%-40s|%s|%25s\n", "Nama Matkul", "Kode", "Jumlah SKS");
        for(int i = 0; i < this.matkul.size(); i++){
            for(int j = 0; j < dosenMhsTendik.dataMatkul.length; j++){
                if(matkul.get(i).equalsIgnoreCase(dosenMhsTendik.dataMatkul[j][0])){
                    System.out.printf("%-40s|%2s|%20s\n", dosenMhsTendik.dataMatkul[j][0], dosenMhsTendik.dataMatkul[j][1], dosenMhsTendik.dataMatkul[j][2]);
                }
            }
        }
        System.out.printf("%-20s: %d\n", "TOTAL SKS", totalSKS);
        System.out.printf("%-20s: %d\n", "TOTAL MATKUL", totalMatkulDiambil);
    }
    public void emptyIsNull(ArrayList<Integer> nilai){
        int i = 0;
        while(i != totalMatkulDiambil){
            nilai.add(null);
            i++;
        }
    }
}
class dosen extends civitas{
    private String NIDN;
    //constructor
    public dosen(){
        NIDN = "";
        nama = "";
        jenisKelamin = "";
    }
    public dosen(String nama, String NIDN, String jenisKelamin){
        this.nama = nama;
        this.NIDN = NIDN;
        this.jenisKelamin = jenisKelamin;
    }
    //setter
    public void setNIDN(String nIDN) {
        NIDN = nIDN;
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
                    System.out.printf("SUCCESS: Berhasil memberikan nilai %d untuk matkul %s kepada mhs %s\n", nilai, namaMatkul, ((mahasiswa)mahasiswaN).getNama());
                }
                else System.out.println("ERROR: Mahasiswa Tidak mengambil matkul tersebut!");
            }
        }
        else System.out.println("ERROR: Tidak bisa memberikan nilai kepada selain mahasiswa!");
    }
    //method
    public void lihatDetailMhs(mahasiswa mahasiswaN){
        System.out.println("Berhasil mengambil data mahasiswa tersebut");
        mahasiswaN.tampilkanDetails();
    }
    public void tampilkanDetails(){
        System.out.println("=====[BIODATA DOSEN]======");
        System.out.printf("%-20s: %s\n", "Nama", this.nama);
        System.out.printf("%-20s: %s\n", "Jenis Kelamin", this.jenisKelamin);
        System.out.printf("%-20s: %s\n", "NIDN", this.NIDN);
    }
    public void lihatDetailDosen(Object dosenN){
        if(dosenN instanceof dosen){
            System.out.println("USERINFO: Melihat biodata dosen lain");
            System.out.println("=====[BIODATA DOSEN]======");
            System.out.printf("%-20s: %s\n", "Nama", ((dosen)dosenN).getNama());
            System.out.printf("%-20s: %s\n", "Jenis Kelamin", ((dosen)dosenN).getJenisKelamin());
            System.out.printf("%-20s: %s\n", "NIDN", ((dosen)dosenN).NIDN);
        }
        else System.out.println("ERROR: Orang tersebut bukan dosen!");
    }
}
class tendik extends civitas{
    private int gaji;
    private String idPegawai;
    protected String tugas;
    protected String jamKerja;
    protected String jabatan;
    //constructor
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
    //setter
    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }
    public void setIdPegawai(String idPegawai) {
        this.idPegawai = idPegawai;
    }
    public void setTugas(String tugas) {
        this.tugas = tugas;
    }
    public void setJamKerja(String jamKerja) {
        this.jamKerja = jamKerja;
    }
    //methods
    public void tampilkanDetails(){
        System.out.println("===[PROFIL TENAGA PENDIDIK]===");
        System.out.printf("%-20s: %s\n", "Nama", this.nama);
        System.out.printf("%-20s: %s\n","Jenis Kelamin", this.jenisKelamin);
        System.out.printf("%-20s: %s\n","ID Pegawai", this.idPegawai);
        System.out.printf("%-20s: %s\n","Tugas", this.tugas);
        if(!(this.jabatan == null)) System.out.printf("%-20s: %s\n","Jabatan", this.jabatan);
        if(!(this.gaji == 0)) System.out.printf("%-20s: Rp. %,3d.00", "Gaji Bulan Ini", gaji);
    }
    public void inputMatkulMhs(Object mahasiswaN, String kodeMatkul){
        if(!(this.jabatan == null) && this.jabatan.equalsIgnoreCase("Akademik")){
            if(mahasiswaN instanceof mahasiswa) ((mahasiswa)mahasiswaN).setMatkul(kodeMatkul);
            else System.out.println("ERROR: Tidak bisa set matkul kepada selain mahasiswa");
        }
        else System.out.println("ERROR: Anda tidak mempunyai otoritas untuk menggunakan fungsi ini!");
    }
    public void setGajiPegawai(Object tendikN, int gaji){
        if(!(this.jabatan == null) && this.jabatan.equalsIgnoreCase("Keuangan")){
            if(tendikN instanceof tendik) {
                ((tendik)tendikN).gaji = gaji;
                System.out.printf("SUCCESS: Berhasil memberikan gaji untuk tendik a.n. %s\n", ((tendik)tendikN).getNama());
            }
            else System.out.println("ERROR: Anda hanya bisa meng-set gaji ke tendik");
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
                                            {"Bahasa Indonesia", "007", "2"},
                                            {"Pengembangan Aplikasi Web", "008", "4"},
                                            {"Algoritma dan Struktur Data", "009", "3"},
                                            {"Analisis & Desain Sist. Informasi", "010", "4"},
                                            {"Jaringan Komputer Dasar", "011", "3"},
                                            {"Pemrograman Basis Data", "012", "3"},
                                            {"Statistika", "013", "3"}};
    public static void main(String[] args) {
        //Mhs
        mahasiswa mahasiswa1 = new mahasiswa("Syahreza", "Laki-laki", "Teknologi Informasi", "Filkom", "225150701111036");
        mahasiswa mahasiswa2 = new mahasiswa();
        //Dosen
        dosen dosen1 = new dosen("Pak Budi, S.Kom, M.Kom", "38918293091", "Laki-laki");
        dosen dosen2 = new dosen("Pak Doni, S.T, M.T, Ph.D", "3271630129341", "Laki-laki");
        //Tendik
        tendik tendik1 = new tendik("Agus", "Laki-laki", "20945", "Menjaga Keamanan");
        tendik tendik2 = new tendik("Slamet", "Laki-laki", "28901", "Menginput data mahasiswa", "Akademik");
        tendik keuangan = new tendik("Agung", "Laki-laki", "20839", "Mengatur Keuangan", "Keuangan");
        //All methods goes here
        // mahasiswa1.setMatkul("001");
        // mahasiswa1.setMatkul("002");
        // dosen1.setNilai(90, mahasiswa1, "001");
        // dosen1.setNilai(85, mahasiswa1, "005");
        // tendik1.tampilkanDetails();

    }
}