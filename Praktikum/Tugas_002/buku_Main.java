package Praktikum.Tugas_002;

import java.util.Scanner;

public class buku_Main {
    /* 
        Data     : judul, penulis, jml halaman, tahun terbit, nama penerbit, sinopsis
        Kol.index:   0       1         2             3             4            5
    */
    private static String[][] agama = {{"Pendidikan Agama Islam Untuk Peguruan Tinggi", "Dr. Mardani", "342", "2017", "Kencana", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Pengantar Pendidikan Agama Kristen", "Dr. Hasudungan Simatupang, M.Pd., Ronny Simatupang, S.Th., M.Pd.K., Tianggur Medi Napitupulu, S.PAK., M.Pd.K.", "256", "2020", "Penerbit Andi", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Dharma Acarya: Pembelajaran Pendidikan Agama Hindu untuk Menembus Portal Revolusi Industri 4.0", "I Made Dwi Susila Adnyana", "173", "2021", "Nilacakra", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Pengembangan Kurikulum Pendidikan Agama Islam Transformatif", "Umar, dkk", "414", "2016", "Deepublish", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Revolusi Diri: Memaksimalkan Potensi untuk Menjadi yang Terbaik", "Amru Khalid", "308", "2007", "Qisthi Press", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."}};

    private static String[][] teknologi = {{"Lebih Mahir dengan Microsoft Word 2019", "Edi S. Mulyanta, Joko Irawan Mumpuni", "212", "2020", "Penerbit Andi", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."},
                                            {"Introduction to Java Programming, Comprehensive Version 10th Edition", "Y. Daniel Liang", "1345", "2015", "Pearson Education Inc.", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."},
                                            {"Inovasi Desain dengan AutoCAD", "Suparno Sastra M.", "264", "2013", "Elex Media Komputindo", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."}, 
                                            {"Phyton Game Programming By Example", "Alejandro Rodas de Paz, Joseph Howse", "230", "2015", "Packt Publishing", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."},
                                            {"C++ For Dummies", "Stephen R. Davis", "432", "2009", "Wiley", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."},
                                            {"High Performance MySQL", "Baron Schwartz, Peter Zaitsev, dkk", "712", "2008", "O'Reilly Media", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."},
                                            {"Web Programming (Client Side and Server Side)", "Fitri Marisa", "259", "2017", "Deepublish", "Lorem ipsum dolor sit amet consectetur, adipisicing elit. Optio cum at quibusdam."}};
        
    private static String[][] filsafat = {{"Filsafat Modern: Dari Machiavelli sampai Nietzsche", "F. Budi Hardiman", "312", "2004", "Gramedia Pustaka Utama", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Pokok-pokok Filsafat Hukum: Apa dan Bagaimana Filsafat Hukum Indonesia", "Darji Darmodiharjo, Shidarta", "322", "1995", "Gramedia Pustaka Utama", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Filsafat Ilmu di Era Milenial", "Dr. Ismail Marzuki, M.Si, dkk", "224", "2021", "Fakultas Teknik UNIFA", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Contemporary Approaches to Philosophy", "Paul K. Moser, Dwayne Mulder", "488", "1994", "Macmillan Publishing Company", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Filsafat Umum Zaman Now", "Hamidulloh Ibda", "296", "2018", "CV. Kataba Group", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."}};
        
    private static String[][] sejarah = {{"Sejarah Dunia yang Disembunyikan", "Jonathan Black", "636", "2015", "Pustaka Alvabet", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"History of World War II", "Francis Trevelyan Miller", "999", "1948 (didigitalkan 2010)", "Universal Book and Bible House", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Sejarah Peradaban Islam", "Dr. Ahmadin, S.Ag., S.Pd., M.Pd.", "162", "2020", "Prenada Media", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"Sejarah & Kebudayaan Islam Periode Klasik (Abad VII-XII M)", "Prof. Dr. H. Faisal Ismail, M.A.", "420", "2017", "IRCiSoD", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                        {"The Colonial Machine: French Science and Overseas Expansion in the Old Regime", "James Edward McClellan (III), François Regourd", "694", "2011", "Brepols", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."}};

    private static String[][] psikologi = {{"Teori Psikologi Kepribadian Manusia", "Nur Fatwikiningsih, S. Psi, M.Psi, Psikolog", "352", "2020", "Penerbit Andi","Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                            {"Psikologi Gestalt: Seri Sejarah Psikologi Modern", "Duane P. Schultz dan Sydney Ellen Schultz, Lita Hardian (Penerjemah), M. Rizal (Penyunting)", "115", "2021", "Nusamedia", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                            {"Pengantar Psikologi dan Pandangan Al-Qur'an Tentang Psikologi", "Nurussakinah Daulay, M.Psi", "174", "2015", "Kencana", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                            {"Psikologi Agama: Implementasi Psikologi untuk Memahami Perilaku Agama", "Ahmad Saifuddin", "316", "2019", "Kencana", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."},
                                            {"Psikologi Pendidikan", "Pupu Saeful Rahmat", "208", "2021", "Bumi Aksara", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque expedita obcaecati nihil assumenda vel? Dolores."}};
                    
    private static String[][] politik = {{"Reformasi Politik: Dinamika Politik Nasional Dalam Arus Politik Global", "Achmad Tirtosudiro, M. Dawam Rahardjo", "306", "1997 (didigitalkan 2008)", "Intermasa", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Politik Bebas Aktif: Tantangan dan Kesempatan", "Mohamad Sabir", "259", "1987 (didigitalkan 2006)", "Haji Masagung", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Menelaah kembali format politik Orde Baru", "M. Riza Sihbudi", "201", "1995", "PT. Gramedia Pustaka Utama", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Politik Pembangunan: Sebuah Analisis Konsep, Arah, dan Strategi", "Moeljarto Tjokrowinoto", "131", "1987 (didigitalkan 2007)", "Tiara Wacana Yogya", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."},
                                            {"Dasar-Dasar Ilmu Politik", "Miriam Budiardjo", "247", "2003", "Gramedia Pustaka Utama", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Veniam tenetur voluptatum qui odit."}};

    private static String[][] fiksi = {{"Bumi Manusia", "Pramoedya Ananta Toer", "405", "1981", "Hasta Mitra", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente autem ipsum porro eligendi optio."},
                                        {"Ayat-ayat Cinta", "Habiburrahman El-Shirazy", "426", "2005", "Republika Penerbit", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente autem ipsum porro eligendi optio."},
                                        {"Penjelajah Antariksa 5: Kapten Raz", "Djokolelono", "201", "2015", "Kepustakaan Populer Gramedia", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente autem ipsum porro eligendi optio."},
                                        {"Laskar Pelangi", "Andrea Hirata", "529", "2005", "Bentang Pustaka", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente autem ipsum porro eligendi optio."},
                                        {"Negeri 5 Menara", "A. Fuadi", "440", "2013", "Gramedia Pustaka Utama", "Lorem, ipsum dolor sit amet consectetur adipisicing elit. Sapiente autem ipsum porro eligendi optio."}};

    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int pilihan;
        final int MAX_PILIHAN = 10;
        do {
            System.out.println("=======[Perpustakaan]========");
            System.out.println("Masukkan pilihan untuk melihat buku berdasarkan kategori");
            System.out.println("1. Teknologi\n2. Filsafat\n3. Sejarah\n4. Agama\n5. Psikologi\n6. Politik\n7. Fiksi\n8. Tampilkan total buku yang tersedia\n9. [ADVANCED] Copy buku\n10. Keluar dari program");
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
                case 9: {
                    scanner.nextLine();
                    System.out.print("Masukkan judul buku yang ingin di-copy: ");
                    String judul = scanner.nextLine();
                    int[] params = cariBukuHelper(judul);
                    int urutan = params[1], indexRow = params[0];
                    if(indexRow == -1) {
                        System.out.println("ERROR: Buku tidak ditemukan!"); 
                        break;
                    }
                    else{
                        System.out.println("USERINFO: Berhasil membuat object copy dari buku tersebut");
                        if(urutan == 0){
                            buku asal = new buku("Teknologi", teknologi[indexRow][1], teknologi[indexRow][0], teknologi[indexRow][2], String.valueOf(indexRow+1), teknologi[indexRow][3], teknologi[indexRow][4], teknologi[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 1){
                            buku asal = new buku("Filsafat", filsafat[indexRow][1], filsafat[indexRow][0], filsafat[indexRow][2], String.valueOf(indexRow+1), filsafat[indexRow][3], filsafat[indexRow][4], filsafat[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 2){
                            buku asal = new buku("Sejarah", sejarah[indexRow][1], sejarah[indexRow][0], sejarah[indexRow][2], String.valueOf(indexRow+1), sejarah[indexRow][3], sejarah[indexRow][4], sejarah[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 3){
                            buku asal = new buku("Agama", agama[indexRow][1], agama[indexRow][0], agama[indexRow][2], String.valueOf(indexRow+1), agama[indexRow][3], agama[indexRow][4], agama[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 4){
                            buku asal = new buku("Psikologi", psikologi[indexRow][1], psikologi[indexRow][0], psikologi[indexRow][2], String.valueOf(indexRow+1), psikologi[indexRow][3], psikologi[indexRow][4], psikologi[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 5){
                            buku asal = new buku("Politik", politik[indexRow][1], politik[indexRow][0], politik[indexRow][2], String.valueOf(indexRow+1), politik[indexRow][3], politik[indexRow][4], politik[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                        else if(urutan == 6){
                            buku asal = new buku("Fiksi", fiksi[indexRow][1], fiksi[indexRow][0], fiksi[indexRow][2], String.valueOf(indexRow+1), fiksi[indexRow][3], fiksi[indexRow][4], fiksi[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy(tujuan);
                        }
                    }
                    break;
                }
                
                default: if(pilihan != MAX_PILIHAN) System.out.println("ERROR: Masukkan pilihan yang benar!");
            }
        } while (pilihan != MAX_PILIHAN);
        System.out.println("USERINFO: Program Berhenti");
    }

    public static void loopAndSetData(String[][]data, String kategoriBuku){
        boolean afakahKategoriSudahTampil = false;
        for(int i = 0; i < data.length; i++){
            buku bukuN = new buku(kategoriBuku, data[i][1], data[i][0], data[i][2], String.valueOf(i+1), data[i][3], data[i][4], data[i][5]);
            if(!afakahKategoriSudahTampil){
                bukuN.tampilkanKategori();
                afakahKategoriSudahTampil = true;
            }
            bukuN.tampilkan();
        }
    }

    public static int cariBuku(String judul, String[][] data){
        int indexRow = -1;
        for(int i = 0; i < data.length; i++){
            if(data[i][0].equalsIgnoreCase(judul)){
                indexRow = i;
                break;
            }
        }
        return indexRow;
    }

    public static int[] cariBukuHelper(String judul){
        int output[] = new int[2];
        int index = cariBuku(judul, teknologi), count = 0;
        if(index == -1) {
            index = cariBuku(judul, filsafat);
            count++;
        }
        if(index == -1) {
            index = cariBuku(judul, sejarah);
            count++;
        }
        if(index == -1) {
            index = cariBuku(judul, agama);
            count++;
        }
        if(index == -1) {
            index = cariBuku(judul, psikologi);
            count++;
        }
        if(index == -1) {
            index = cariBuku(judul, politik);
            count++;
        }
        if(index == -1) {
            index = cariBuku(judul, fiksi);
            count++;
        }
        output[0] = index;
        output[1] = count;
        return output;
    }
}

