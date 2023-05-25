package Tugas_007;
import java.util.Scanner;

public class mainProg {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int userChoice;
        boolean isUserLoggedIn = false;
        String[][] daftarProduk = {{"Air Mineral", "4500"}, {"Pulpen", "2000"}, {"Correction Tape", "5000"}, 
                                    {"Spidol", "8000"}, {"Tinta Spidol", "35000"}, {"Kabel Data", "25000"},
                                    {"Mouse Geming", "450000"}, {"Steelseries Mechanical Gaming Keyboard", "790000"}, {"Razer Goliathus Control Mousepad", "290000"},
                                    {"Steelseries Arctis 1 Gaming Headset", "800000"}, {"SanDisk Extreme Pro M.2 NVME 500GB", "1700000"},
                                    {"GSkill Ripjaws V DDR4 8GB RAM @ 3200Mhz", "450000"}, {"Diecast Innova Reborn Venturer", "1500000"}};
        employee pegawai = null;
        
        do {
            System.out.println("\n========[KOPERASI KARYAWAN]========");
            System.out.println("Pilihan Program: ");
            System.out.println("1. Login\n2. Belanja\n3. Lihat Detail Belanja\n4. Keluar");
            System.out.print("Masukkan pilihan Anda: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch(userChoice){
                case 1:
                    if(!isUserLoggedIn){
                        System.out.print("Masukkan nama Anda: ");
                        String nama = scanner.nextLine();
                        System.out.print("Masukkan nomor registrasi pegawai: ");
                        int reg = scanner.nextInt();
                        System.out.print("Masukkan jumlah gaji per bulan: ");
                        int slry = scanner.nextInt();

                        pegawai = new employee(nama, reg, slry);
                        System.out.println("USERINFO: Successfully logged in!");
                        isUserLoggedIn = true;
                    }
                    else System.out.println("ERROR: You're already logged in!");
                    break;
                case 2:
                    boolean stopLoop = false;
                    if(!isUserLoggedIn) System.out.println("ERROR: Anda harus login untuk dapat mengakses menu ini!");
                    else{
                        while(!stopLoop){
                            System.out.println("Daftar Produk: ");
                            for(int i = 0; i < daftarProduk.length; i++){
                                System.out.printf("%d. %s -- Rp %,3d.00\n", i+1, daftarProduk[i][0], Integer.parseInt(daftarProduk[i][1]));
                            }
                            System.out.printf("%d. Selesai belanja\n", daftarProduk.length + 1);
                            System.out.print("Masukkan pilihan produk: ");
                            int productChoice = scanner.nextInt();

                            if(productChoice <= 0 || productChoice > daftarProduk.length + 1) System.out.println("ERROR: Input invalid!");
                            else if(productChoice != daftarProduk.length + 1){
                                System.out.print("Masukkan jumlah yang ingin dibeli: ");
                                int qtty = scanner.nextInt();
                                if(pegawai.getPayableAmount() - Integer.parseInt(daftarProduk[productChoice - 1][1]) * qtty < 0) System.out.println("ERROR: Maaf, Anda tidak memiliki cukup gaji tersisa untuk membeli barang tersebut!\n");
                                else pegawai.addInvoice(new invoice(daftarProduk[productChoice - 1][0], qtty, Integer.parseInt(daftarProduk[productChoice - 1][1])));
                            }
                            else{
                                System.out.println("USERINFO: Anda telah mengakhiri belanja.");
                                stopLoop = true;
                            }
                        }
                    }
                    break;
                case 3: 
                    if(!isUserLoggedIn) System.out.println("ERROR: Anda harus login untuk dapat mengakses menu ini!");
                    else{
                        System.out.println("=========================[EMPLOYEE STATS]===========================");
                        System.out.println(pegawai);
                        pegawai.getDetailBelanja();
                        System.out.printf("%-18s: Rp %,3d.00\n", "Gaji Akhir", pegawai.getPayableAmount());
                    }
                    break;
                default:
                    System.out.println(userChoice != 4 ? "ERROR: Input invalid!": "");
                    break;
            }
        } while (userChoice != 4);
    }
}


//Program menu and abilities
/*
1. Login --> input name, reg num, salary --> give an error msg when user already logged in
2. Belanja --> login needed --> while-loop iteration, STOP when user input certain number --> display product list on each iteration
   --> ability to add the purchase amount if user selects an item that has been purchased before.
3. Lihat detail belanja --> login needed
4. Keluar program
*/

//menu 3 details:
/*
nama
reg id
gaji awal (sblm dikurang jumlah belanja)
detail belanjaan --> show lists and grand total
gaji akhir (stlh dikurang jumlah belanja)
 */