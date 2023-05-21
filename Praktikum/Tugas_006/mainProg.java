package Tugas_006;

public class mainProg {
    public static void main(String[] args) {
        double totalHargaKuePesanan = 0, totalHargaKueJadi = 0, totalBerat = 0, totalJumlah = 0;
        double hargaItemKueTermahal = 0;
        String namaKueTermahal = "";

        kue kumpulanKue[] = new kue[20];
        kumpulanKue[0] = new kueJadi("Klepon", 1500, 3);
        kumpulanKue[1] = new kuePesanan("Onde-onde", 2000, 40);
        kumpulanKue[2] = new kuePesanan("Dadar Gulung", 3500, 45);
        kumpulanKue[3] = new kueJadi("Lemper", 2500, 10);
        kumpulanKue[4] = new kuePesanan("Serabi", 7000, 69);
        kumpulanKue[5] = new kuePesanan("Bikang", 4000, 47);
        kumpulanKue[6] = new kueJadi("Nagasari", 2000, 15);
        kumpulanKue[7] = new kueJadi("Kue Lumpur", 4000, 12);
        kumpulanKue[8] = new kuePesanan("Kue Cucur", 5500, 89);
        kumpulanKue[9] = new kueJadi("Lopis", 4500, 20);
        kumpulanKue[10] = new kueJadi("Bikang", 3500, 25);
        kumpulanKue[11] = new kuePesanan("Apem", 3500, 90);
        kumpulanKue[12] = new kuePesanan("Kue Putu Ayu", 6000, 80);
        kumpulanKue[13] = new kueJadi("Lumpia", 5000, 30);
        kumpulanKue[14] = new kuePesanan("Kue Lapis Legit", 3500, 100);
        kumpulanKue[15] = new kuePesanan("Getuk Lindri", 2000, 50);
        kumpulanKue[16] = new kueJadi("Molen", 2000, 40);
        kumpulanKue[17] = new kuePesanan("Misro", 2400, 50);
        kumpulanKue[18] = new kueJadi("Bika Ambon", 4500, 30);
        kumpulanKue[19] = new kueJadi("Bolu Kukus", 3000, 40);

        for(int i = 0; i < kumpulanKue.length; i++){
            System.out.printf("\n%s\n", kumpulanKue[i]);
            if(kumpulanKue[i] instanceof kuePesanan){
                totalBerat += ((kuePesanan) kumpulanKue[i]).getBerat();
                totalHargaKuePesanan += ((kuePesanan) kumpulanKue[i]).hitungHarga();
            }
            else if(kumpulanKue[i] instanceof kueJadi){
                totalJumlah += ((kueJadi) kumpulanKue[i]).getJumlah();
                totalHargaKueJadi += ((kueJadi) kumpulanKue[i]).hitungHarga();
            }
            if(kumpulanKue[i].hitungHarga() > hargaItemKueTermahal) {
                hargaItemKueTermahal = kumpulanKue[i].hitungHarga();
                namaKueTermahal = kumpulanKue[i].getNama();
            }
            System.out.printf("%-15s: %s\n", "Jenis Kue", kumpulanKue[i].getClass().getSimpleName().equals("kuePesanan") ? "Kue Pesanan" : "Kue Jadi");
        }

        System.out.println("\n==============[S T A T S]================");
        System.out.printf("%-25s: Rp %,3.2f\n", "TOTAL HARGA SEMUA KUE", totalHargaKuePesanan + totalHargaKueJadi);
        System.out.println();
        System.out.printf("%-25s: Rp %,3.2f\n", "TOTAL HARGA KUE PESANAN", totalHargaKuePesanan);
        System.out.printf("%-25s: %,3.1f gram\n", "TOTAL BERAT KUE PESANAN", totalBerat);
        System.out.println();
        System.out.printf("%-25s: Rp %,3.2f\n", "TOTAL HARGA KUE JADI", totalHargaKueJadi);
        System.out.printf("%-25s: %,3.1f buah\n", "TOTAL JUMLAH KUE JADI", totalJumlah);
        System.out.println();
        System.out.println("KUE DENGAN HARGA TERTINGGI");
        System.out.printf("%3s%-25s: %s\n", "", "Berdasarkan Jenis", totalHargaKueJadi > totalHargaKuePesanan ? "Kue Jadi" : "Kue Pesanan");
        System.out.printf("%3s%-25s: %s\n", "", "Berdasarkan Nama Kue", namaKueTermahal);
    }
}
