package Praktikum.Tugas_001;

import java.util.Scanner;

public class buku_Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan;
        /* 
        Data     : judul, penulis, jml halaman, tahun terbit, nama penerbit
        Kol.index:   0       1         2             3             4
        */
        String[][] agama = {{"Pendidikan Agama Islam Untuk Peguruan Tinggi", "Dr. Mardani", "342", "2017", "Kencana"},
                            {"Pengantar Pendidikan Agama Kristen", "Dr. Hasudungan Simatupang, M.Pd., Ronny Simatupang, S.Th., M.Pd.K., Tianggur Medi Napitupulu, S.PAK., M.Pd.K.", "256", "2020", "Penerbit Andi"},
                            {"Dharma Acarya: Pembelajaran Pendidikan Agama Hindu untuk Menembus Portal Revolusi Industri 4.0", "I Made Dwi Susila Adnyana", "173", "2021", "Nilacakra"},
                            {"Pengembangan Kurikulum Pendidikan Agama Islam Transformatif", "Umar, dkk", "414", "2016", "Deepublish"},
                            {"Revolusi Diri: Memaksimalkan Potensi untuk Menjadi yang Terbaik", "Amru Khalid", "308", "2007", "Qisthi Press"}};

        String[][] teknologi = {{"Lebih Mahir dengan Microsoft Word 2019", "Edi S. Mulyanta, Joko Irawan Mumpuni", "212", "2020", "Penerbit Andi"},
                                {"Introduction to Java Programming, Comprehensive Version 10th Edition", "Y. Daniel Liang", "1345", "2015", "Pearson Education Inc."},
                                {"Inovasi Desain dengan AutoCAD", "Suparno Sastra M.", "264", "2013", "Elex Media Komputindo"}, 
                                {"Phyton Game Programming By Example", "Alejandro Rodas de Paz, Joseph Howse", "230", "2015", "Packt Publishing"},
                                {"C++ For Dummies", "Stephen R. Davis", "432", "2009", "Wiley"},
                                {"High Performance MySQL", "Baron Schwartz, Peter Zaitsev, dkk", "712", "2008", "O'Reilly Media"},
                                {"Web Programming (Client Side and Server Side)", "Fitri Marisa", "259", "2017", "Deepublish"}};
        
        String[][] filsafat = {{"Filsafat Modern: Dari Machiavelli sampai Nietzsche", "F. Budi Hardiman", "312", "2004", "Gramedia Pustaka Utama"},
                                {"Pokok-pokok Filsafat Hukum: Apa dan Bagaimana Filsafat Hukum Indonesia", "Darji Darmodiharjo, Shidarta", "322", "1995", "Gramedia Pustaka Utama"},
                                {"Filsafat Ilmu di Era Milenial", "Dr. Ismail Marzuki, M.Si, dkk", "224", "2021", "Fakultas Teknik UNIFA"},
                                {"Contemporary Approaches to Philosophy", "Paul K. Moser, Dwayne Mulder", "488", "1994", "Macmillan Publishing Company"},
                                {"Filsafat Umum Zaman Now", "Hamidulloh Ibda", "296", "2018", "CV. Kataba Group"}};
        
        String[][] sejarah = {{"Sejarah Dunia yang Disembunyikan", "Jonathan Black", "636", "2015", "Pustaka Alvabet"},
                                {"History of World War II", "Francis Trevelyan Miller", "999", "1948 (didigitalkan 2010)", "Universal Book and Bible House"},
                                {"Sejarah Peradaban Islam", "Dr. Ahmadin, S.Ag., S.Pd., M.Pd.", "162", "2020", "Prenada Media"},
                                {"Sejarah & Kebudayaan Islam Periode Klasik (Abad VII-XII M)", "Prof. Dr. H. Faisal Ismail, M.A.", "420", "2017", "IRCiSoD"},
                                {"The Colonial Machine: French Science and Overseas Expansion in the Old Regime", "James Edward McClellan (III), François Regourd", "694", "2011", "Brepols"}};

        String[][] psikologi = {{"Teori Psikologi Kepribadian Manusia", "Nur Fatwikiningsih, S. Psi, M.Psi, Psikolog", "352", "2020", "Penerbit Andi"},
                                {"Psikologi Gestalt: Seri Sejarah Psikologi Modern", "Duane P. Schultz dan Sydney Ellen Schultz, Lita Hardian (Penerjemah), M. Rizal (Penyunting)", "115", "2021", "Nusamedia"},
                                {"Pengantar Psikologi dan Pandangan Al-Qur'an Tentang Psikologi", "Nurussakinah Daulay, M.Psi", "174", "2015", "Kencana"},
                                {"Psikologi Agama: Implementasi Psikologi untuk Memahami Perilaku Agama", "Ahmad Saifuddin", "316", "2019", "Kencana"},
                                {"Psikologi Pendidikan", "Pupu Saeful Rahmat", "208", "2021", "Bumi Aksara"}};
                    
        String[][] politik = {{"Reformasi Politik: Dinamika Politik Nasional Dalam Arus Politik Global", "Achmad Tirtosudiro, M. Dawam Rahardjo", "306", "1997 (didigitalkan 2008)", "Intermasa"},
                                {"Politik Bebas Aktif: Tantangan dan Kesempatan", "Mohamad Sabir", "259", "1987 (didigitalkan 2006)", "Haji Masagung"},
                                {"Menelaah kembali format politik Orde Baru", "M. Riza Sihbudi", "201", "1995", "PT. Gramedia Pustaka Utama"},
                                {"Politik Pembangunan: Sebuah Analisis Konsep, Arah, dan Strategi", "Moeljarto Tjokrowinoto", "131", "1987 (didigitalkan 2007)", "Tiara Wacana Yogya"},
                                {"Dasar-Dasar Ilmu Politik", "Miriam Budiardjo", "247", "2003", "Gramedia Pustaka Utama"}};

        String[][] fiksi = {{"Bumi Manusia", "Pramoedya Ananta Toer", "405", "1981", "Hasta Mitra"},
                            {"Ayat-ayat Cinta", "Habiburrahman El-Shirazy", "426", "2005", "Republika Penerbit"},
                            {"Penjelajah Antariksa 5: Kapten Raz", "Djokolelono", "201", "2015", "Kepustakaan Populer Gramedia"},
                            {"Laskar Pelangi", "Andrea Hirata", "529", "2005", "Bentang Pustaka"},
                            {"Negeri 5 Menara", "A. Fuadi", "440", "2013", "Gramedia Pustaka Utama"}};

        do {
            System.out.println("=======[Perpustakaan]========");
            System.out.println("Masukkan pilihan untuk melihat buku berdasarkan kategori");
            System.out.println("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi\n8. Tampilkan total buku yang tersedia\n9. Keluar dari program");
            System.out.print("Pilihan anda: ");
            pilihan = scanner.nextInt();
            
            switch (pilihan) {
                case 1: loopAndSetData(teknologi, "Teknologi"); break;
                case 2: loopAndSetData(filsafat, "Filsafat"); break;
                case 3: loopAndSetData(sejarah, "Sejarah"); break;
                case 4: loopAndSetData(agama, "Agama"); break;
                case 5: loopAndSetData(psikologi, "Psikologi"); break;
                case 6: loopAndSetData(politik, "Politik"); break;
                case 7: loopAndSetData(fiksi, "Fiksi"); break;
                case 8: System.out.printf("COUNT: Total semua buku = %d\n", teknologi.length + filsafat.length + sejarah.length + agama.length + psikologi.length + politik.length + fiksi.length); break;
                default: if(pilihan != 9) System.out.println("ERROR: Masukkan pilihan yang benar!");
            }
            
        } while (pilihan != 9);
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
                bukuN.setPenerbit(data[i][4]);
                bukuN.setNomorBuku(String.valueOf(i+1));
            }
            bukuN.tampilkan();
        }
    }
}

