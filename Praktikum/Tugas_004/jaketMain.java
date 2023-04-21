package Tugas_004;
import java.util.Scanner;

public class jaketMain {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final char MAX_JACKET_TYPE = 'C';
        int pilihan, jml = 0, hargaJaket = 0;
        char pilihBahan = ' ';
        jaket jkt = new jaket();
        do {
            System.out.println("\nMenu Program: ");
            System.out.println("1. Lihat Jenis Jaket\n2. Pembelian Jaket\n3. Lihat detail pembelian\n4. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch(pilihan){
                case 1:{
                    char type = 'A';
                    while(type <= MAX_JACKET_TYPE){
                        System.out.printf("%s %-9c: Rp %,3d.00/buah\n", "Tipe Bahan", type, jkt.getJaket(type)[0]);
                        type++;
                    }
                    System.out.println("INFO: Setiap pembelian lebih dari 100 buah jaket, akan mendapatkan potongan harga!");
                    break;
                }
                case 2:{
                    System.out.print("Masukkan bahan jaket (A/B/C): ");
                    pilihBahan = scanner.nextLine().toUpperCase().charAt(0);
                    if(!(pilihBahan == 'A' || pilihBahan == 'B' || pilihBahan == 'C')) System.out.println("ERROR: Invalid input!");
                    else{
                        System.out.print("Masukkan jumlah jaket yang ingin dipesan: ");
                        jml = scanner.nextInt();
                        if(jml <= 0) System.out.println("ERROR: Invalid input!");
                        else{
                            if(jml > 100){
                                hargaJaket = jkt.getJaket(pilihBahan)[1];
                            }
                            else hargaJaket = jkt.getJaket(pilihBahan)[0];
                            System.out.printf("SYSTEM: Berhasil membeli jaket tipe %c\n", pilihBahan);
                            System.out.print(jml > 100 ? "Anda mendapatkan potongan harga karena pembelian lebih dari 100 buah\n" : "");
                            System.out.println("Pesanan anda akan segera diproses\nMasukkan pilihan 3 jika ingin melihat detail pesanan!");
                        }
                    }
                    break;
                }
                case 3:{
                    if(jml == 0 || pilihBahan == ' ') System.out.println("ERROR: Anda belum melakukan pemesanan jaket!\nPilih 2 untuk memesan jaket");
                    else{
                        System.out.println("=====[DETAIL PEMESANAN JAKET]=====");
                        System.out.printf("%-20s: %c\n", "Jenis Bahan", pilihBahan);
                        System.out.printf("%-20s: %d\n", "Jumlah Pesanan", jml);
                        System.out.printf("%-20s: Rp %,3d.00\n", "Harga Satuan", hargaJaket);
                        System.out.printf("%-20s: Rp %,3d.00\n", "Total Harga", hargaJaket * jml);
                    }
                    break;
                }
                default:{
                    System.out.print(pilihan != 4 ? "ERROR: Invalid input!\n" : "");
                    break;
                }
            }
        } while (pilihan != 4);
    }
}
