//domain 
import java.util.Scanner;

class Car{
    //Constructor = kelas yang akan selalu dipanggil pertama kali(default) pada saat obj dibuat ketika menggunakan objek, pembeda dari kelas yang lain
    public String noPol = "";
    public int power = 100;
    public int seat = 4;
    public String namaMobil;
    //fungsi consturctor = namanya sama dgn nama kelas
    public Car(String nomor_polisi, String carName, int seat_capacity){  //--> bisa diberi macam2 variabel input
        this.noPol = nomor_polisi;  //--> 'this' merujuk pada sesuatu yang ada di kelas sendiri, bisa atribut bisa method
        this.seat = seat_capacity;
        this.namaMobil = carName;
        System.out.println("\nBerhasil membuat "+this.namaMobil+ " dengan no pol : " +this.noPol +" dengan kapasitas " +this.seat);
        //'penyederhaan'/ 'enkapsulasi' --> 
    }

    //behaviour
    public void maju(){
        System.out.println(this.noPol +" Bergerak maju");        
    }

    public void mundur(){
        System.out.println(this.noPol +" Bergerak mundur");
    }
}
class PetrolCar extends Car{
    public int kapasitasBBM;
    public int isiTangkiBBM = 0;
    Scanner scanner = new Scanner(System.in);

    public PetrolCar(String noPol, String namaMobil, int seat, int isiTangkiBBM, int kapasitasTanki){
        super(noPol, namaMobil, seat);
        this.isiTangkiBBM = isiTangkiBBM;
        kapasitasBBM = kapasitasTanki;
    }
    public void isiBBM(){
        System.out.printf("Memulai pengisian BBM untuk mobil %s\n", namaMobil);
        System.out.print("Masukkan jumlah BBM dalam liter: ");
        int beliBerapa = scanner.nextInt();
        isiTangkiBBM += beliBerapa;
        if(isiTangkiBBM > kapasitasBBM){
            System.out.printf("ERROR: Melebihi kapasitas tanki BBM. Kapasitas tangki %d liter\n", kapasitasBBM);
            isiTangkiBBM -= beliBerapa;
            isiBBM();
        }
        else System.out.printf("Berhasil membeli bensin untuk %s sebanyak %d liter! Isi tanki sekarang %d liter\n", namaMobil, beliBerapa, isiTangkiBBM);
    }
}

class ElectricCar extends Car{
    public int dayaListrik;
    public int sisaEnergiListrik = 0;
    Scanner scanner = new Scanner(System.in);
    public ElectricCar(String noPol, String namaMobil, int seat, int sisaEnergiListrik, int kapasitasDaya){
        super(noPol, namaMobil, seat);
        this.sisaEnergiListrik = sisaEnergiListrik;
        dayaListrik = kapasitasDaya;
    }
    public void isiKwh(){
        System.out.printf("Memulai pengisian KWH untuk mobil %s\n", namaMobil);
        System.out.print("Masukkan jumlah KWH yang ingin anda isikan: ");
        int beliBerapa = scanner.nextInt();
        sisaEnergiListrik += beliBerapa;
        if(sisaEnergiListrik > dayaListrik){
            System.out.printf("ERROR: Melebihi kapasitas daya KWH mobil. Kapasitas KWH %d\n", dayaListrik);
            sisaEnergiListrik -= beliBerapa;
            isiKwh();
        }
        else System.out.printf("Berhasil mengisi KwH untuk %s sebanyak %d KwH! Total KwH sekarang %d\n", namaMobil, beliBerapa, sisaEnergiListrik);
    }
}

public class OOP1_test {
    public static void main(String[] args) {
        //membuat objek dari kelas car
        Car angkot1 = new Car("N 123 GG", "Angkot", 12); // --> di create spt yang di cons
        angkot1.maju();
        angkot1.mundur();

        /*System.out.println(angkot1.power);
        System.out.println(angkot1.seat);*/

        Car angkot2 = new Car("N 456 SM", "Angkot", 2);
        angkot2.maju();
        angkot2.mundur();

        PetrolCar mobil1 = new PetrolCar("K 123 ZA", "Innova Reborn", 7, 40, 55);
        mobil1.isiBBM();
        mobil1.maju();

        ElectricCar mobil2 = new ElectricCar("K 4444 JI", "Toyota Prius", 5, 60, 100);
        mobil2.isiKwh();
        mobil2.mundur();
    }
    
}