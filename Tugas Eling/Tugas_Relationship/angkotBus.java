class mobil{
    protected String noPol, kategori, tipe, manufaktur;
    protected int kapasitasPnp;
    public String getNoPol() {
        return noPol;
    }
    public String getKategori() {
        return kategori;
    }
    public int getKapasitasPnp() {
        return kapasitasPnp;
    }
}
class person{
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
    private driverAngkot driverAngkot;
    //Penumpang list agregasi
    private penumpang[] daftarPnp;

    public angkot(String noPol, String kategori, String tipe, String manufaktur, int kapasitasPnp){
        this.noPol = noPol;
        this.kategori = kategori;
        this.tipe = tipe;
        this.manufaktur = manufaktur;
        this.kapasitasPnp = kapasitasPnp;
        this.daftarPnp = new penumpang[this.kapasitasPnp];
    }
    public driverAngkot getDriver() {
        return driverAngkot;
    }
    public void setDriver(driverAngkot driverAngkot) {
        this.driverAngkot = driverAngkot;
    }
    public penumpang[] getDaftarPnp() {
        return daftarPnp;
    }
    public void setPenumpang(penumpang pnp) {
        for(int i = 0; i < this.daftarPnp.length; i++){
            if(this.daftarPnp[i] == null){
                this.daftarPnp[i] = pnp;
                break;
            }
        }
    }
    public void removePenumpang(penumpang pnp){
        for(int i = 0; i < daftarPnp.length; i++){
            if(daftarPnp[i] != null && daftarPnp[i].getNama().equals(pnp.getNama())){
                daftarPnp[i] = null;
                break;
            }
        }
    }
    public void details(){
        System.out.println("=====[INFORMASI KENDARAAN]=====");
        System.out.printf("%-20s: %s\n", "Kategori", this.kategori.toUpperCase());
        System.out.printf("%-20s: %s\n", "Nomor Polisi", this.noPol.toUpperCase());
        System.out.printf("%-20s: %s\n", "Pengemudi", (getDriver() == null) ? " " : getDriver().getNama());
        System.out.printf("%-20s: %s\n", "Type Kendaraan", this.tipe);
        System.out.printf("%-20s: %s\n", "Pabrikan", this.manufaktur);
        System.out.printf("%-20s: %d %s\n", "Kapasitas", this.kapasitasPnp, "penumpang");
        System.out.printf("%-20s: \n", "Daftar Penumpang");
        boolean isPenumpangAvailable = false;
        for(int i = 0; i < daftarPnp.length; i++){
            if(daftarPnp[i] != null){
                System.out.printf("%3s %s\n", "-", daftarPnp[i].getNama());
                isPenumpangAvailable = true;
            }
        }
        if(!isPenumpangAvailable) System.out.printf("%3s %s\n", "-", "Tidak ada penumpang di dalam angkot :(");
    }
}
class bus extends mobil{
    //driverBus
    private driverBus driverBus;
    //penumpang list
    private penumpang[] daftarPenumpang;

    public bus(String noPol,String kategori, String tipe, String manufaktur, int kapasitasPnp){
        this.kategori = kategori;
        this.noPol = noPol;
        this.tipe = tipe;
        this.manufaktur = manufaktur;
        this.kapasitasPnp = kapasitasPnp;
        this.daftarPenumpang = new penumpang[this.kapasitasPnp];
    }
    public void details(){
        System.out.println("=====[INFORMASI KENDARAAN]=====");
        System.out.printf("%-20s: %s\n", "Kategori", this.kategori.toUpperCase());
        System.out.printf("%-20s: %s\n", "Nomor Polisi", this.noPol.toUpperCase());
        System.out.printf("%-20s: %s\n", "Pengemudi", (getDriver() == null) ? " " : getDriver().getNama());
        System.out.printf("%-20s: %s\n", "Type Kendaraan", this.tipe);
        System.out.printf("%-20s: %s\n", "Pabrikan", this.manufaktur);
        System.out.printf("%-20s: %d %s\n", "Kapasitas", this.kapasitasPnp, "penumpang");
        System.out.printf("%-20s: \n", "Daftar Penumpang");
        boolean isPenumpangAvailable = false;
        for(int i = 0; i < daftarPenumpang.length; i++){
            if(daftarPenumpang[i] != null){
                System.out.printf("%3s %s\n", "-", daftarPenumpang[i].getNama());
                isPenumpangAvailable = true;
            }
        }
        if(!isPenumpangAvailable) System.out.printf("%3s %s\n", "-", "Tidak ada penumpang di dalam bus :(");
    }
    public void setDriver(driverBus driverBus) {
        this.driverBus = driverBus;
    }
    public void setPenumpang(penumpang pnp) {
        for(int i = 0; i < daftarPenumpang.length; i++){
            if(this.daftarPenumpang[i] == null){
                this.daftarPenumpang[i] = pnp;
                break;
            }
        }
    }
    public void removePenumpang(penumpang pnp){
        for(int i = 0; i < daftarPenumpang.length; i++){
            if(daftarPenumpang[i] != null && daftarPenumpang[i].getNama().equals(pnp.getNama())){
                daftarPenumpang[i] = null;
                break;
            }
        }
    }
    public driverBus getDriver() {
        return driverBus;
    }
    public penumpang[] getDaftarPenumpang() {
        return daftarPenumpang;
    }
}
class driverBus extends person{
    String licenses;
    boolean hasSim_B;

    public driverBus(){

    }
    public driverBus(String nama, String SIM){
        this.nama = nama;
        licenses = SIM;
        this.hasSim_B = SIM.equalsIgnoreCase("B") ? true : false;
    }
    public void narikBus(boolean params, bus b){
        if(this.hasSim_B){
            if(params) {
                System.out.printf("Driver bus dengan nama %s siap mengemudi\n", this.nama);
                b.setDriver(this);
            }
            else {
                System.out.printf("Driver bus dengan nama %s berhenti narik bus\n", this.nama);
                b.setDriver(null);
            }
        }
        else System.out.println("Maaf, anda tidak diijinkan mengemudi bus karena tidak mempunyai SIM B");
    }
}
class driverAngkot extends person{
    String licenses;
    boolean hasSim_A;
    
    public driverAngkot(){

    }
    public driverAngkot(String nama, String SIM){
        this.nama = nama;
        licenses = SIM;
        this.hasSim_A = SIM.equalsIgnoreCase("A") ? true : false;
    }
    public void narikAngkot(boolean params, angkot a){
        if(hasSim_A){
            if(params) {
                System.out.printf("Driver angkot dengan nama %s siap mengemudi\n", this.nama);
                a.setDriver(this);
            }
            else {
                System.out.printf("Driver angkot dengan nama %s berhenti narik angkot\n", this.nama);
                a.setDriver(null);
            }
        }
        else if(hasSim_A == false && params == true) System.out.println("Maaf, anda tidak diijinkan mengemudi bus karena tidak mempunyai SIM A");
    }
}
class penumpang extends person{
    public penumpang(String nama){
        this.nama = nama;
    }
    public void naik(mobil a){
        if(a instanceof angkot){
            ((angkot)a).setPenumpang(this);
            System.out.printf("Penumpang dengan nama %s naik ke dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
        }
        else if(a instanceof bus){
            ((bus)a).setPenumpang(this);
            System.out.printf("Penumpang dengan nama %s naik ke dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
        }
    }
    public void turun(mobil a){
        if(a instanceof angkot){
            ((angkot)a).removePenumpang(this);
            System.out.printf("Penumpang dengan nama %s turun dari dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
        }
        else if(a instanceof bus){
            ((bus)a).removePenumpang(this);
            System.out.printf("Penumpang dengan nama %s turun dari dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
        }
    }
}

public class angkotBus {
    public static void main(String[] args) {
        angkot angkot1 = new angkot("N 111 GA", "Angkot", "L 300", "Mitsubishi", 20);
        bus bus1 = new bus("B 1564 VGA", "Bus", "OH 1626 NG", "Mercedes-Benz", 40);
        driverAngkot driver1 = new driverAngkot("Budi", "a");
        driverBus driver2 = new driverBus("Bayu", "b");
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
        penumpang1.naik(angkot1);
        penumpang2.naik(bus1);
        penumpang3.naik(bus1);
        penumpang4.naik(bus1);
        penumpang5.naik(bus1);
        penumpang6.naik(angkot1);

        penumpang1.turun(angkot1);
        penumpang6.turun(angkot1);
        System.out.println();
        bus1.details();
        angkot1.details();
    }
}
