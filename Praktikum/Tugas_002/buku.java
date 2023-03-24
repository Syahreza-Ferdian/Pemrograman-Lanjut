package Praktikum.Tugas_002;

public class buku{
    private String kategoriBuku;
    private String penulis;
    private String namaBuku;
    private String jumlahHalaman;
    private String nomorBuku;
    private String tahunTerbit;
    private String penerbit;
    private String sinopsis;

    public buku(){
        
    }
    public buku(String kategoriBuku, String penulis, String namaBuku, String jumlahHalaman, String nomorBuku, String tahunTerbit, String penerbit, String sinopsis){
        this.kategoriBuku = kategoriBuku;
        this.penulis = penulis;
        this.namaBuku = namaBuku;
        this.jumlahHalaman = jumlahHalaman;
        this.nomorBuku = nomorBuku;
        this.tahunTerbit = tahunTerbit;
        this.penerbit = penerbit;
        this.sinopsis = sinopsis;
    }

    //mutator (setter)
    public void setKategori(String kategoriBuku){
        this.kategoriBuku = kategoriBuku;
    }
    public void setNamaPenulis(String penulis){
        this.penulis = penulis;
    }
    public void setNamaBuku(String namaBuku){
        this.namaBuku = namaBuku;
    }
    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }
    public void setNomorBuku(String nomorBuku) {
        this.nomorBuku = nomorBuku;
    }
    public void setTahunTerbit(String tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    //methods
    public void tampilkanKategori(){
        System.out.printf("=========[BUKU KATEGORI %s]========\n", kategoriBuku.toUpperCase());
    }
    public void tampilkan(){
        System.out.printf("Buku ke-%s\n", nomorBuku);
        System.out.printf("1. Nama Buku\t\t: %s\n", namaBuku);
        System.out.printf("2. Penulis\t\t: %s\n", penulis);
        System.out.printf("3. Jumlah Halaman\t: %s\n", jumlahHalaman);
        System.out.printf("4. Tahun Terbit\t\t: %s\n", tahunTerbit);
        System.out.printf("5. Nama Penerbit\t: %s\n", penerbit);
        System.out.printf("6. Sinopsis\t\t: %s\n", sinopsis);
        System.out.printf("%23s\t: %d\n", "Jumlah Kata Sinopsis",hitungJmlKata(sinopsis));
        System.out.println();
    }
    public int hitungJmlKata(String sinopsis){
        boolean afkhSpasi = true;
        int jmlKata = 0;
        for(int i = 0; i < sinopsis.length(); i++){
            if(sinopsis.charAt(i) == ' ') afkhSpasi = true;
            else{
                if(afkhSpasi) jmlKata++;
                afkhSpasi = false;
            }
        }
        return jmlKata;
    }
    public buku copy(buku asal){
        return new buku(asal.kategoriBuku, asal.penulis, asal.namaBuku, asal.jumlahHalaman, asal.nomorBuku, asal.tahunTerbit, asal.penerbit, asal.sinopsis);
    }
    public void tampilkanCopy(){
        System.out.println("====[Menampilkan hasil copy-an]====");
        System.out.printf("1. Kategori\t\t: %s\n", this.kategoriBuku);
        System.out.printf("2. Nomor Buku\t\t: %s\n", this.nomorBuku);
        System.out.printf("3. Nama Buku\t\t: %s\n", this.namaBuku);
        System.out.printf("4. Penulis\t\t: %s\n", this.penulis);
        System.out.printf("5. Jumlah Halaman\t: %s\n", this.jumlahHalaman);
        System.out.printf("6. Tahun Terbit\t\t: %s\n", this.tahunTerbit);
        System.out.printf("7. Nama Penerbit\t: %s\n", this.penerbit);
        System.out.printf("8. Sinopsis\t\t: %s\n", this.sinopsis);
        System.out.printf("%23s\t: %d\n", "Jumlah Kata Sinopsis",hitungJmlKata(this.sinopsis));
    }
}
