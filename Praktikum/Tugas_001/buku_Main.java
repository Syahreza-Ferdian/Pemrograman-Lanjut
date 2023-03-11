package Praktikum.Tugas_001;

import java.util.Scanner;

public class buku_Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan;
        //judul, kategori, penulis, jml halaman, tahun terbit
        String[][] Agama = {{"Pendidikan Agama Islam", "Mr. X", "12", "2021"},
                                {"Pendidikan Agama Kristen", "Mr. Y", "13", "2017"},
                                {"Pendidikan Agama Hindu", "Mr. Z", "14", "2015"},
                                {"Pendidikan Agama Buddha", "Mr. ZZ", "14", "2016"},
                                {"Pendidikan Agama Konghuchu", "Mr. ZZ", "14", "2022"}};
        String[][] Teknologi = {{"Pengenalan HTML 5", "Mr. X", "220", "2020"},
                                {"Java Programming", "Mr. X", "224", "2018"},
                                {"Belajar C++", "Mr.X", "225", "2018"}, 
                                {"Mahir AutoCad", "Mr. X", "340", "2016"},
                                {"Dasar Pengoperasian MS. Office", "Mr. X", "225", "2018"}};     

        do {
            System.out.println("=======[Perpustakaan]========");
            System.out.println("Masukkan pilihan untuk melihat buku berdasarkan kategori");
            System.out.println("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi\n8. Keluar dari program");
            System.out.print("Pilihan anda: ");
            pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1: loopAndSetData(Teknologi, "Teknologi"); break;
                case 4: loopAndSetData(Agama, "Agama"); break;
                default: if(pilihan != 8) System.out.println("ERROR: Masukkan pilihan yang benar!");
            }
            
        } while (pilihan != 8);
        System.out.println("USERINFO: Program Berhenti");
    }

    public static void loopAndSetData(String[][]data, String kategoriBuku){
        buku bukuN = new buku();
        bukuN.setKategori(kategoriBuku);
        bukuN.tampilkanKategori();
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data.length; j++){
                bukuN.setNamaBuku(data[i][0]);
                bukuN.setNamaPenulis(data[i][1]);
                bukuN.setJumlahHalaman(data[i][2]);
                bukuN.setTahunTerbit(data[i][3]);
                bukuN.setNomorBuku(String.valueOf(i+1));
            }
            bukuN.tampilkan();
        }
    }
}

