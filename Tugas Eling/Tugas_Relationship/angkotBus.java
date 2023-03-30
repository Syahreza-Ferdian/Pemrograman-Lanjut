import java.util.ArrayList;

abstract class mobil{
    String noPol, kategori, tipe, manufaktur;
    ArrayList<penumpang> pnp = new ArrayList<penumpang>();

    public String getNoPol() {
        return noPol;
    }
    public String getKategori() {
        return kategori;
    }
    public void tambahPenumpang(penumpang p){
        System.out.printf("Penumpang dengan nama %s telah naik ke %s dengan nopol %s\n", p.nama, this.kategori, this.noPol);
        pnp.add(p);
    }
    public void turunkanPenumpang(penumpang p){
        System.out.printf("Penumpang dengan nama %s telah turun dari %s nopol %s\n", p.nama, this.kategori, this.noPol);
        pnp.remove(p);
    }
}
abstract class person{
    String nama;

    public person(){

    }
    public person(String nama){
        this.nama = nama;
    }
    public String getNama() {
        return nama;
    }
}
class angkot extends mobil{
    //driver komposisi
    driverAngkot driver = new driverAngkot();
    
    public angkot(String noPol, String kategori, String tipe, String manufaktur){
        this.noPol = noPol;
        this.kategori = kategori;
        this.tipe = tipe;
        this.manufaktur = manufaktur;
    }
    public void details(){
        System.out.printf("%-20s: %s\n", "Angkot Nopol", this.noPol);
        System.out.printf("%-20s: %s\n", "Pengemudi", (driver.nama == null) ? " " : driver.nama);
        System.out.printf("%-20s: %s\n", "Type Kendaraan", this.tipe);
        System.out.printf("%-20s: %s\n", "Pabrikan", this.manufaktur);
        System.out.printf("%-20s: \n", "Daftar Penumpang");
        for (penumpang penumpang : this.pnp) {
            System.out.printf("%3s %s\n", "-", penumpang.getNama());
        }
    }
    //Penumpang list agregasi
}
class bus extends mobil{
    //driverBus
    driverBus driver = new driverBus();

    public bus(String noPol,String kategori, String tipe, String manufaktur){
        this.kategori = kategori;
        this.noPol = noPol;
        this.tipe = tipe;
        this.manufaktur = manufaktur;
    }
    public void details(){
        System.out.printf("%-20s: %s\n", "Bus Nopol", this.noPol);
        System.out.printf("%-20s: %s\n", "Pengemudi", (driver.nama == null) ? " " : driver.nama);
        System.out.printf("%-20s: %s\n", "Type Kendaraan", this.tipe);
        System.out.printf("%-20s: %s\n", "Pabrikan", this.manufaktur);
        System.out.printf("%-20s: \n", "Daftar Penumpang");
        for (penumpang penumpang : this.pnp) {
            System.out.printf("%3s %s\n", "-", penumpang.getNama());
        }
    }
    //penumpang list
}
class driverBus extends person{
    boolean hasSim_B = true;

    public driverBus(){

    }
    public driverBus(String nama){
        this.nama = nama;
    }
    public void narikBus(boolean params, bus b){
        if(params) {
            System.out.printf("Driver bus dengan nama %s siap mengemudi\n", this.nama);
            b.driver.nama = this.nama;
        }
        else {
            System.out.printf("Driver bus dengan nama %s berhenti narik bus\n", this.nama);
            b.driver.nama = "";
        }
    }
}
class driverAngkot extends person{
    boolean hasSim_A = true;
    
    public driverAngkot(){

    }
    public driverAngkot(String nama){
        this.nama = nama;
    }
    public void narikAngkot(boolean params, angkot a){
        if(params) {
            System.out.printf("Driver angkot dengan nama %s siap mengemudi\n", this.nama);
            a.driver.nama = this.nama;
        }
        else {
            System.out.printf("Driver angkot dengan nama %s berhenti narik angkot\n", this.nama);
            a.driver.nama = "";
        }
    }
}
class penumpang extends person{
    public penumpang(String nama){
        this.nama = nama;
    }
    public void naik(mobil a, penumpang p){
        a.tambahPenumpang(p);
    }
    public void turun(mobil a, penumpang p){
        a.turunkanPenumpang(p);
    }
}

public class angkotBus {
    public static void main(String[] args) {
        angkot angkot1 = new angkot("N 111 GA", "Angkot", "L 300", "Mitsubishi");
        bus bus1 = new bus("B 1564 VGA", "Bus", "OH 1626 NG", "Mercedes-Benz");
        driverAngkot driver1 = new driverAngkot("Budi");
        driverBus driver2 = new driverBus("Bayu");
        driver2.narikBus(true, bus1);
        driver1.narikAngkot(true, angkot1);
        penumpang penumpang1 = new penumpang("Doni");
        penumpang penumpang2 = new penumpang("Arif");
        penumpang penumpang3 = new penumpang("John");
        penumpang penumpang4 = new penumpang("Joseph");
        penumpang penumpang5 = new penumpang("Jono");
        penumpang penumpang6 = new penumpang("Eric");
        penumpang penumpang7 = new penumpang("Paul");
        penumpang penumpang8 = new penumpang("Mark");
        penumpang penumpang9 = new penumpang("Slamet");
        // angkot1.tambahPenumpang(penumpang1);
        penumpang1.naik(angkot1, penumpang1);
        penumpang2.naik(bus1, penumpang2);
        penumpang3.naik(bus1, penumpang3);
        penumpang4.naik(bus1, penumpang4);
        penumpang5.naik(bus1, penumpang5);
        penumpang6.naik(angkot1, penumpang6);
        // angkot1.details();
        // penumpang1.turun(angkot1, penumpang1);
        // angkot1.details();
        System.out.println();
        bus1.details();
        angkot1.details();
    }
}
