package Praktikum.Tugas_001;

import java.util.Arrays;
import java.util.Scanner;

public class buku_Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan;
        //judul, kategori, penulis, jml halaman, tahun terbit
        String[][] dummyData = new String[10][5];
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
        buku bukuN = new buku();       

        do {
            System.out.println("=======[Perpustakaan]========");
            System.out.println("Masukkan pilihan untuk melihat buku berdasarkan kategori");
            System.out.println("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi\n8. Keluar dari program");
            System.out.print("Pilihan anda: ");
            pilihan = scanner.nextInt();
            
            if(pilihan != 8){
                switch(pilihan){
                    case 1: {
                        dummyData = Arrays.copyOf(Teknologi, Teknologi.length); 
                        bukuN.setKategori("Teknologi");
                        bukuN.tampilkanKategori(); 
                        break;
                    }
                    case 4: {
                        dummyData = Arrays.copyOf(Agama, Agama.length);
                        bukuN.setKategori("Agama");
                        bukuN.tampilkanKategori(); 
                        break;
                    }
                }
    
                for(int i = 0; i < dummyData.length; i++){
                    for(int j = 0; j < dummyData[i].length; j++){
                        bukuN.setNamaBuku(dummyData[i][0]);
                        bukuN.setNamaPenulis(dummyData[i][1]);
                        bukuN.setJumlahHalaman(dummyData[i][2]);
                        bukuN.setTahunTerbit(dummyData[i][3]);
                        bukuN.setNomorBuku(String.valueOf(i+1));
                    }
                    bukuN.tampilkan();
                }
            }
        } while (pilihan != 8);
        System.out.println("USERINFO: Program Berhenti");
    }
}

