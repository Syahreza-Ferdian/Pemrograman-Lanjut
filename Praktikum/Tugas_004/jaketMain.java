package Tugas_004;
import java.util.Scanner;

public class jaketMain {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final int MAX_PILIHAN_MENU = 5; //termasuk exit
        final int MAX_ORDER_ALLOWED = 3;
        int pilihan;
        int[] jml = new int[MAX_ORDER_ALLOWED];
        int[] hargaJaket = new int[MAX_ORDER_ALLOWED];
        char[] pilihBahan = new char[MAX_ORDER_ALLOWED];
        jaket jkt = new jaket();
        do {
            System.out.println("\nMenu Program: ");
            System.out.println("1. Lihat Jenis Jaket & Harganya\n2. Pembelian Jaket\n3. Lihat detail pembelian\n4. Cancel pembelian\n5. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch(pilihan){
                case 1:{
                    char type = 'A';
                    System.out.println("==============================================================");
                    System.out.printf("%7s%4s%19s%8s%19s\n", "TIPE", "|", "HARGA NORMAL", "|", "HARGA DISKON");
                    while(type <= jkt.MAX_JACKET_TYPE){
                        System.out.printf("%s %-4c%-5sRp %,3d.00/buah%5s%-4sRp %,3d.00/buah\n", "Bahan", type, "|", jkt.getHargaJaket(type)[0], "|", "", jkt.getHargaJaket(type)[1]);
                        type++;
                    }
                    System.out.println("==============================================================");
                    System.out.println("\n*INFO: Diskon hanya akan berlaku untuk pembelian di atas 100 buah");

                    break;
                }
                case 2:{
                    System.out.print("Masukkan bahan jaket (A/B/C): ");
                    char inputBahan = scanner.nextLine().toUpperCase().charAt(0);
                    if(!(inputBahan == 'A' || inputBahan == 'B' || inputBahan == 'C')) System.out.println("ERROR: Invalid input!");
                    else{
                        System.out.print("Masukkan jumlah jaket yang ingin dipesan: ");
                        int inputJumlah = scanner.nextInt();
                        if(inputJumlah <= 0) System.out.println("ERROR: Value tidak bisa kurang dari atau sama dengan nol!");
                        else if(getIndexOfElement(pilihBahan, inputBahan) != -1){ //nek semisal wis pernah order tipe kwi sakdurunge
                            System.out.printf("WARNING: Anda sudah melakukan pemesanan tipe jaket tersebut (jumlah pemesanan : %d buah). Apakah Anda ingin: \n", jml[getIndexOfElement(pilihBahan, inputBahan)]);
                            System.out.println("1. Rubah pesanan sebelumnya");
                            System.out.println("2. Tambahkan jumlah pada pesanan sebelumnya");
                            System.out.println("3. Tetap pada pesanan sebelumnya");
                            System.out.print("Masukkan pilihan Anda: ");
                            int caseTwoChoice = scanner.nextInt();
                            switch(caseTwoChoice){
                                case 1:{
                                    //sing lawas langsung diganti sing anyar
                                    jml[getIndexOfElement(pilihBahan, inputBahan)] = inputJumlah;
                                    System.out.println("SYSTEM: Jumlah pembelian berhasil dirubah!");
                                    break;
                                }
                                case 2: {
                                    //value sing lawas ditambahke karo value sing anyar
                                    jml[getIndexOfElement(pilihBahan, inputBahan)] += inputJumlah;
                                    System.out.println("SYSTEM: Jumlah pembelian telah berhasil ditambahkan!");
                                    break;
                                }
                                case 3: break; //tetep nganggo value sing lawas
                                default: {
                                    System.out.println("ERROR: Invalid Input!");
                                    break;
                                }
                            }
                            //rego-ne melu di-update ojo lali
                            if(jml[getIndexOfElement(pilihBahan, inputBahan)] > 100) hargaJaket[getIndexOfElement(pilihBahan, inputBahan)] = jkt.getHargaJaket(inputBahan)[1];
                            else hargaJaket[getIndexOfElement(pilihBahan, inputBahan)] = jkt.getHargaJaket(inputBahan)[0];
                        }
                        else {
                            setElementInArray(jml, inputJumlah);
                            setElementInArray(pilihBahan, inputBahan);
                            int currIndex = getIndexOfElement(pilihBahan, inputBahan); //NOTE FOR MYSELF: misal ono bug, kemungkinan bug e nang kene (index ga sync)
                            
                            if(jml[currIndex] > 100) hargaJaket[currIndex] = jkt.getHargaJaket(pilihBahan[currIndex])[1];
                            else hargaJaket[currIndex] = jkt.getHargaJaket(pilihBahan[currIndex])[0];

                            System.out.printf("SYSTEM: Berhasil membeli jaket tipe %c\n", pilihBahan[currIndex]);
                            System.out.print(jml[currIndex] > 100 ? "Anda mendapatkan potongan harga karena pembelian lebih dari 100 buah\n" : "");
                            System.out.println("Pesanan anda akan segera diproses\nMasukkan pilihan 3 jika ingin melihat detail pesanan!");
                        }
                    }
                    break;
                }
                case 3:{
                    int j, grandTotal = 0, count = 0;
                    if(checkForEmptArray(jml)) System.out.println("ERROR: Anda belum melakukan pemesanan jaket!\nPilih 2 untuk memesan jaket");
                    else{  
                        System.out.println("=====[DETAIL PEMESANAN JAKET]=====");
                        for(j = 0; j < jml.length; j++){
                            if(jml[j] > 0){
                                count++;
                                System.out.printf("Pesanan ke-%d\n", count);
                                showDetailPemesanan(pilihBahan[j], jml[j], hargaJaket[j]);
                                grandTotal += hargaJaket[j] * jml[j];
                            }
                        }
                        if(j > 1) {
                            System.out.println("=============================================");
                            System.out.printf("%-24s Rp %,3d.00\n", "GRAND TOTAL", grandTotal);
                        }
                    }
                    break;
                }
                case 4:{
                    int j, count = 0;
                    if(checkForEmptArray(hargaJaket)) System.out.println("ERROR: Anda tidak memiliki pesanan jaket!\nPilih 2 untuk melakukan pemesanan.");
                    else{
                        System.out.println("List Pembelian: ");
                        for(j = 0; j < jml.length; j++){
                            if(jml[j] > 0) {
                                count++;
                                System.out.printf("%3s%d. Tipe %s (%d buah)\n", "", count, pilihBahan[j], jml[j]);
                            }
                        }
                        System.out.print("Masukkan nomor sesuai list yang ingin di-cancel: ");
                        int hapus = scanner.nextInt();
                        if(hapus < 1 || hapus > count) System.out.println("ERROR: Invalid input!");
                        else{
                            //nek inputan valid, hapus siji siji array list sesuai index e
                            pilihBahan[hapus - 1] = '\u0000';
                            jml[hapus - 1] = 0;
                            hargaJaket[hapus - 1] = 0;
                            reConstructArrayAfterDeletion(pilihBahan);
                            reConstructArrayAfterDeletion(jml);
                            reConstructArrayAfterDeletion(hargaJaket);
                            System.out.printf("Order nomor %d berhasil di-cancel\n", hapus);
                        }
                    }
                    break;
                }
                default:{
                    System.out.print(pilihan != MAX_PILIHAN_MENU ? "ERROR: Invalid input!\n" : "");
                    break;
                }
            }
        } while (pilihan != MAX_PILIHAN_MENU);
    }
    public static void showDetailPemesanan(char bahan, int jumlah, int harga){
        System.out.printf("%3s%-20s: %c\n", "", "Jenis Bahan", bahan);
        System.out.printf("%3s%-20s: %d\n", "", "Jumlah Pesanan", jumlah);
        System.out.printf("%3s%-20s: Rp %,3d.00\n", "", "Harga Satuan", harga);
        System.out.printf("%3s%-20s: Rp %,3d.00\n", "", "Total Harga", harga * jumlah);
    }
    public static void setElementInArray(int[] array, int element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == 0){
                array[i] = element;
                break;
            }
        }
    }
    public static void setElementInArray(char[] array, char element){
        for(int i = 0; i < array.length; i++){
            if(array[i] == '\u0000'){
                array[i] = element;
                break;
            }
        }
    }
    public static int getIndexOfElement(int[] array, int element){
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                index = i;
                break;
            }
        }
        return index;
    }
    public static int getIndexOfElement(char[] array, char element){
        int index = -1;
        for(int i = 0; i < array.length; i++){
            if(array[i] == element){
                index = i;
                break;
            }
        }
        return index;
    }
    public static boolean checkForEmptArray(int[] array){
        boolean afkhKosong = true;
        for(int i = 0; i < array.length; i++){
            if(array[i] > 0){
                afkhKosong = false;
                break;
            }
        }
        return afkhKosong;
    }
    public static void reConstructArrayAfterDeletion(int[] array){
        for(int i = 0; i + 1 < array.length; i++){
            if(array[i] == 0 && array[i + 1] != 0){
                array[i] = array[i + 1];
                array[i + 1] = 0;
            }
        }
    }
    public static void reConstructArrayAfterDeletion(char[] array){
        for(int i = 0; i + 1 < array.length; i++){
            if(array[i] == '\u0000' && array[i + 1] != '\u0000'){
                array[i] = array[i + 1];
                array[i + 1] = '\u0000';
            }
        }
    }
}