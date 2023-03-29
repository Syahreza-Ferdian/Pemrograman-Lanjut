// package Praktikum;

// /* 
// car
//     angkot
//         penumpang[] --> daftar penumpang
//         Driver driverAngkot
//     bus
//         penumpang[] --> daftar penumpang
//         Driver driverBus
// person
//     // driver ke angkot : komposisi
//     //     narikAngkot()
//     // penumpang ke angkot : agregasi
//     //     driver data
//     driverBus
//         SIM B = true
//         narikBus(true)
//     driverAngkot
//         SIM A = true
//         narikAngkot(true)
//     penumpang
//         naik()
//         turun()
//  */

//  class car{
//     String noPol;
//     int kapasitasPenumpang;

//     public car(){

//     }
//     public car(String noPol, int kapasitasPenumpang){
//         this.noPol = noPol;
//         this.kapasitasPenumpang = kapasitasPenumpang;
//     }
//     public String getNoPol() {
//         return noPol;
//     }
//  }
//  class angkot extends car{
//     driverAngkot driverAngkot1 = new driverAngkot("Doni");
    
//     public angkot(String noPol, int kapasitasPenumpang){
//         this.noPol = noPol;
//         this.kapasitasPenumpang = kapasitasPenumpang;
//     }
//     penumpang[] a = new penumpang[this.kapasitasPenumpang];
//     a[0] = new penumpang("Agus");
//     a[1] = new penumpang("Budi");
//  }
//  class bus extends car{
//     driverBus driverBus1 = new driverBus("AAAA");
//     public bus(String noPol, int kapasitasPenumpang){
//         this.noPol = noPol;
//         this.kapasitasPenumpang = kapasitasPenumpang;
//     }
//     penumpang[] b = new penumpang[this.kapasitasPenumpang];
//     b[0] = new penumpang("Ferdian");
//     b[1] = new penumpang("Reza");
//  }
//  class person{
//     String nama;
//     protected boolean SIM_A, SIM_B;
//     public person(){
        
//     }
//     public person(String nama){
//         this.nama = nama;
//     }
//  }
//  class driverAngkot extends person{
//     public driverAngkot(){

//     }
//     public driverAngkot(String nama){
//         super(nama);
//         this.SIM_A = true;
//     }
//     public void narikAngkot(angkot angkot1){
//         System.out.printf("%s sedang menarik angkot dengan nopol %s\n", this.nama, angkot1.getNopol());
//     }
//  }
//  class driverBus extends person{
//     boolean SIM_B = true;
//     public driverBus(String nama){
//         super(nama);
//         this.SIM_B = true;
//     }
//  }
// class penumpang extends person{
//     public penumpang(String nama){
//         this.nama = nama;
//     }
//     public void naik(Object a){
//         System.out.printf("Naik ke %s\n", ((car)a).getNoPol());
//     }
//     public void turun(Object a){
//         System.out.printf("Turun dari %s\n", ((car)a).getNoPol());
//     }
// }

// /**
//  * test
//  */
// public class test {

    
// }