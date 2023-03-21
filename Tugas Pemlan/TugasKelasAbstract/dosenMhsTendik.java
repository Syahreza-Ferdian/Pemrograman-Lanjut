import java.lang.reflect.Array;
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
    protected String NIM;
    protected String fakultas;
    protected String jurusan;
    protected static ArrayList<Integer>nilai = new ArrayList<Integer>();
    protected ArrayList<String>matkul = new ArrayList<String>();

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
    public void setMatkul(String matkul) {
        this.matkul.add(matkul);
    }
    public ArrayList<String> getMatkul() {
        return matkul;
    }
    public void tampilkanDetails(){
        System.out.printf("Nama\t\t: %s\n", this.nama);
        System.out.printf("Gender\t\t: %s\n", this.jenisKelamin);
        System.out.printf("Fakultas\t: %s\n", this.fakultas);
        System.out.printf("Jurusan\t\t: %s\n", this.jurusan);
        System.out.printf("Nilai Matkul\t:\n");
        // System.out.printf("%s\t: %d\n", this.matkul, mahasiswa.nilai);
        for(int i = 0; i < this.matkul.size() || i < mahasiswa.nilai.size(); i++){
            if(matkul.size() > nilai.size()){
                nilai.add(matkul.size()-1, null);
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
}
class dosen extends civitas{
    protected String NIP;
    protected String matkul;
    private mahasiswa mahasiswaN;

    public dosen(){
        NIP = "";
        matkul = "";
    }
    public dosen(String nama, String NIP, String jenisKelamin){
        this.nama = nama;
        this.NIP = NIP;
        this.jenisKelamin = jenisKelamin;
    }

    public void setNilai(int nilai, Object mahasiswaN, String matkul) {
        if(mahasiswaN instanceof mahasiswa){
            int index = ((mahasiswa)mahasiswaN).cariMatkul(matkul);
            if(index == -1){
                mahasiswa.nilai.add(nilai);
                ((mahasiswa) mahasiswaN).setMatkul(matkul);
            }
            else if(index >= 0){
                mahasiswa.nilai.add(index, nilai);
            }
            System.out.printf("DOSEN INFO: Berhasil memberikan nilai pada %s untuk matkul %s dengan nilai %d\n", ((mahasiswa)mahasiswaN).nama, matkul, nilai);
        }
        else System.out.println("ERROR: Tidak bisa memberikan nilai kepada selain mahasiswa!");
    }

    public void lihatDetailMhs(mahasiswa mahasiswaN){
        System.out.println("Berhasil mengambil data mahasiswa tersebut");
        mahasiswaN.tampilkanDetails();
    }
}
class tendik extends civitas{
    private String job;
    protected String jamKerja;

    public tendik(){
        nama = "";
    }
    // public tendik(String nama, String job, ){
    //     this.nama = nama;
    // }

}

public class dosenMhsTendik {
    public static void main(String[] args) {
        //Mhs
        mahasiswa mahasiswa1 = new mahasiswa("Syahreza", "Laki-laki", "Teknologi Informasi", "Filkom", "225150701111036");
        
        //Dosen
        dosen dosen1 = new dosen("Pak Budi", "38918293091", "Laki-laki");
        dosen dosen2 = new dosen("Pak Doni", "3271630129341", "Laki-laki");
        //Tendik
        tendik tendik1 = new tendik();

        //All methods goes here
        // mahasiswa1.setMatkul("Pemrograman");
        // System.out.println(mahasiswa1.cariMatkul("Pemrograman"));
        dosen1.setNilai(90, mahasiswa1, "Pemrograman");
        dosen2.setNilai(86, mahasiswa1, "DDAP");
        dosen1.setNilai(86, mahasiswa1, "AOK");
        dosen1.lihatDetailMhs(mahasiswa1);
        dosen1.setNilai(90, mahasiswa1, "PKK");
        mahasiswa1.tampilkanDetails();
    }   
    
}