import java.util.*;

class mobil{
    protected String noPol, kategori, tipe, manufaktur;
    protected int kapasitasPnp;
    //parent constructor that will be used on its children class
    public mobil(String noPol, String kategori, String tipe, String manufaktur, int kapasitasPnp){
        this.noPol = noPol;
        this.kapasitasPnp = kapasitasPnp;
        this.kategori = kategori;
        this.tipe = tipe;
        this.manufaktur = manufaktur;
    }
    public String getNoPol() {
        return noPol;
    }
    public String getKategori() {
        return kategori;
    }
    public int getKapasitasPnp() {
        return kapasitasPnp;
    }
    public String getTipe() {
        return tipe;
    }
    public String getManufaktur() {
        return manufaktur;
    }
}
class person{
    protected String nama;

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
        super(noPol, kategori, tipe, manufaktur, kapasitasPnp); //calling out parent class constructor
        this.daftarPnp = new penumpang[this.kapasitasPnp];
    }
    public driverAngkot getDriver() {
        return driverAngkot;
    }
    public void setDriver(driverAngkot driverAngkot) {
        this.driverAngkot = driverAngkot;
    }
    public void setPenumpang(penumpang pnp) throws Exception {
        if(this.driverAngkot == null) throw new Exception("ERROR: Angkot tidak memiliki driver. Penumpang tidak boleh naik.");
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
        System.out.printf("%-20s: %s\n", "Pengemudi", (this.getDriver() == null) ? " " : this.getDriver().getNama());
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
        super(noPol, kategori, tipe, manufaktur, kapasitasPnp); //calling out parent class constructor
        this.daftarPenumpang = new penumpang[this.kapasitasPnp];
    }
    public void setDriver(driverBus driverBus) {
        this.driverBus = driverBus;
    }
    public void setPenumpang(penumpang pnp) throws Exception {
        if(this.getDriver() == null) throw new Exception("ERROR: Bus tidak memiliki driver. Penumpang tidak boleh naik.");
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
    public void details(){
        System.out.println("=====[INFORMASI KENDARAAN]=====");
        System.out.printf("%-20s: %s\n", "Kategori", this.kategori.toUpperCase());
        System.out.printf("%-20s: %s\n", "Nomor Polisi", this.noPol.toUpperCase());
        System.out.printf("%-20s: %s\n", "Pengemudi", (this.getDriver() == null) ? " " : this.getDriver().getNama());
        System.out.printf("%-20s: %s\n", "Type Kendaraan", this.tipe);
        System.out.printf("%-20s: %s\n", "Pabrikan", this.manufaktur);
        System.out.printf("%-20s: %d %s\n", "Kapasitas", this.kapasitasPnp, "penumpang");
        System.out.printf("%-20s: \n", "Daftar Penumpang");
        boolean isPenumpangAvailable = false;
        for(int i = 0; i < daftarPenumpang.length; i++){
            if(daftarPenumpang[i] != null){
                System.out.printf("%3s %s duduk di kursi nomor %d\n", "-", daftarPenumpang[i].getNama(), angkotBusModifException.hashMapIterator(angkotBusModifException.penumpangMap, daftarPenumpang[i].getNama()));
                isPenumpangAvailable = true;
            }
        }
        if(!isPenumpangAvailable) System.out.printf("%3s %s\n", "-", "Tidak ada penumpang di dalam bus :(");
    }
}
class driverBus extends person{
    private boolean hasSim_B;

    public driverBus(String nama, String SIM){
        super(nama);
        this.hasSim_B = SIM.equalsIgnoreCase("B") ? true : false;
    }
    public void narikBus(boolean params, bus b){
        if(this.hasSim_B){
            if(params) {
                // System.out.printf("Driver bus dengan nama %s siap mengemudi bus dengan nopol %s\n", this.nama, b.getNoPol());
                b.setDriver(this);
            }
            else {
                // System.out.printf("Driver bus dengan nama %s berhenti narik bus\n", this.nama);
                b.setDriver(null);
            }
        }
        else if(hasSim_B == false && params == true) System.out.println("Maaf, anda tidak diijinkan mengemudi bus karena tidak mempunyai SIM B");
    }
}
class driverAngkot extends person{
    private boolean hasSim_A;
    
    public driverAngkot(String nama, String SIM){
        super(nama);
        this.hasSim_A = SIM.equalsIgnoreCase("A") ? true : false;
    }
    public void narikAngkot(boolean params, angkot a){
        if(hasSim_A){
            if(params) {
                // System.out.printf("Driver angkot dengan nama %s siap mengemudi angkot dengan nopol %s\n", this.nama, a.getNoPol());
                a.setDriver(this);
            }
            else {
                // System.out.printf("Driver angkot dengan nama %s berhenti narik angkot\n", this.nama);
                a.setDriver(null);
            }
        }
        else if(hasSim_A == false && params == true) System.out.println("Maaf, anda tidak diijinkan mengemudi bus karena tidak mempunyai SIM A");
    }
}
class penumpang extends person{
    public penumpang(String nama){
        super(nama);
    }
    public void naik(mobil a){
        if(a instanceof angkot){
            try{
                ((angkot)a).setPenumpang(this);
                System.out.printf("Penumpang dengan nama %s naik ke dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else if(a instanceof bus){
            try{
                ((bus)a).setPenumpang(this);
                System.out.printf("Penumpang dengan nama %s naik ke dalam %s dengan nopol %s\n", this.nama, a.kategori, a.noPol);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
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

public class angkotBusModifException {
    static HashMap<penumpang, Integer> penumpangMap = new LinkedHashMap<>();
    public static void main(String[] args) {
        //kendaraan
        ArrayList<angkot> angkots = new ArrayList<angkot>();
        angkots.add(new angkot("N 6969 AAH", "Angkot", "Colt T-120 SS", "Mitsubishi", 22));
        angkots.add(new angkot("N 111 GA", "Angkot", "L 300", "Mitsubishi", 20));
        angkots.add(new angkot("N 911 LA", "Angkot", "Hijet 1000", "Daihatsu", 15));
        angkots.add(new angkot("N 1679 AU", "Angkot", "Kijang Diesel", "Toyota", 12));
        angkots.add(new angkot("N 8080 YU", "Angkot", "Panther Grand Touring", "Isuzu", 25));
        
        ArrayList<bus> buses = new ArrayList<bus>();
        buses.add(new bus("B 1564 VGA", "Bus", "OH 1626 NG", "Mercedes-Benz", 40));
        buses.add(new bus("K 7090 DH", "Bus", "OH 1830", "Mercedes-Benz", 35));
        buses.add(new bus("K 6996 GA", "Bus", "RN 285", "Hino", 50));
        buses.add(new bus("K 8901 DA", "Bus", "K 360 IB", "Scania", 80));

        //driver
        ArrayList<driverAngkot> dA = new ArrayList<driverAngkot>();
        dA.add(new driverAngkot("Budi", "A"));
        dA.add(new driverAngkot("Agus", "A"));
        dA.add(new driverAngkot("Setyo", "A"));
        dA.add(new driverAngkot("Doni", "A"));
        dA.add(new driverAngkot("Raharjo", "A"));

        ArrayList<driverBus> dB = new ArrayList<driverBus>();
        dB.add(new driverBus("Bayu", "B"));
        dB.add(new driverBus("Slamet", "B"));
        dB.add(new driverBus("Eko", "B"));
        dB.add(new driverBus("Suhartoyo", "B"));
        
        // Angkot Driver
        //TODO: comment for-loop supaya general exception (tidak ada driver) bisa jalan
        for(int i = 0, j = dA.size() - 1; i < angkots.size() && j >= 0; i++, j--){
            dA.get(j).narikAngkot(true, angkots.get(i));
        }
        // Bus Driver
        for(int i = 0, j = dB.size() - 1; i < buses.size() && j >= 0; i++, j--){
            dB.get(j).narikBus(true, buses.get(i));
        }

        //penumpang
        ArrayList<penumpang> penumpangs = new ArrayList<penumpang>();

        //HASHMAP PENUMPANG DAN KURSI YANG DIDUDUKINYA. IMPLEMENTASINYA HANYA BERLAKU DI BUS
        penumpangMap.put(new penumpang("Doni"), 2);
        penumpangMap.put(new penumpang("Arif"), 4);
        penumpangMap.put(new penumpang("John"), 1);
        penumpangMap.put(new penumpang("Joseph"), 5);
        penumpangMap.put(new penumpang("Jono"), 7);
        penumpangMap.put(new penumpang("Eric"), 8);
        penumpangMap.put(new penumpang("Paul"), 11);
        penumpangMap.put(new penumpang("Mark"), 15);
        penumpangMap.put(new penumpang("Slamet"), 17);
        penumpangMap.put(new penumpang("Achmad"), 20);
        penumpangMap.put(new penumpang("Sujono"), 21);
        penumpangMap.put(null, 18); //At index 11, penumpang is NULL
        
        //Iterasi nilai kunci (key) dari HashMap 'penumpangMap' ke dalam ArrayList 'penumpangs'
        //TODO: COMMENT FOR-EACH DI BAWAH UNTUK IMPLEMENTASI ARITHMETIC EXCEPTION, DAN ARRAY INDEX OUT OF BOUND
        for (Map.Entry<penumpang, Integer> out : penumpangMap.entrySet()) {
            penumpangs.add(out.getKey());
        }

        //IMPLEMENTATION OF ARRAY INDEX OUT OF BOUND, NULL POINTER, AND GENERAL EXCEPTION
        //penumpang naik kendaraan
        int indexKendaraan = -1, indexPnp = -1;
        try {
            indexPnp = Integer.parseInt("wkwkkwkw");
            indexKendaraan = 2;

            getPenumpang(indexPnp, penumpangs).naik(buses.get(indexKendaraan));
            getPenumpang(++indexPnp, penumpangs).naik(buses.get(indexKendaraan));
            getPenumpang(++indexPnp, penumpangs).naik(buses.get(indexKendaraan));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e){
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println("ERROR: Index kendaraan yang Anda masukkan di luar panjang array");
        } catch (Exception e){
            System.out.println("ERROR: Terjadi exception yang tidak diketahui");
        } finally{
            try {
                buses.get(indexKendaraan).details();
            } catch (IndexOutOfBoundsException e) {
                System.out.printf("ERROR: Index %d di luar panjang array\n", indexKendaraan);
            }
        }

        //IMPLEMENTATION OF ARITHMETIC EXCEPTION (PEMB. DGN 0)
        try{
            double jumlahKendaraan = angkots.size() + buses.size();
            double totalPenumpang = penumpangs.size();
            double perbandingan = jumlahKendaraan/totalPenumpang;
            
            if(totalPenumpang == 0) throw new ArithmeticException("\nERROR: Jumlah penumpang 0. Tidak bisa melakukan pembagian dengan 0");
            System.out.printf("\nINFO: Perbandingan jumlah kendaraan dan penumpang: %.3f\n", perbandingan);
        } catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
    }
    //Method utk mencari nama penumpang dalam nilai key HashMap dan me-return nilai value pasangannya
    public static int hashMapIterator(HashMap<penumpang, Integer> a, String passName){
        int output = 0;
        for (Map.Entry<penumpang, Integer> result : a.entrySet()) {
            if(result.getKey().getNama().equals(passName)){
                output = result.getValue();
                break;
            }
        }
        return output;
    }
    //METHOD UNTUK MENGAMBIL OBJECT PENUMPANG DARI ARRAY PENUMPANGS
    public static penumpang getPenumpang(int index, ArrayList<penumpang> penumpang) throws ArrayIndexOutOfBoundsException, NullPointerException{
        if(index >= penumpang.size() || index < 0) throw new ArrayIndexOutOfBoundsException("ERROR: Anda mencoba mengakses di luar panjang array");
        else if(penumpang.get(index) == null) throw new NullPointerException("ERROR: Penumpang tersebut tidak ada!");
        else return penumpang.get(index);
    }
}

