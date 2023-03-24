package Praktikum.Tugas_002;

import java.util.Scanner;

public class buku_Main {
    /* 
        Data     : judul, penulis, jml halaman, tahun terbit, nama penerbit, sinopsis
        Kol.index:   0       1         2             3             4            5
    */
    private static String[][] agama = {{"Pendidikan Agama Islam Untuk Peguruan Tinggi", "Dr. Mardani", "342", "2017", "Kencana", "Buku ini berisi materi perkuliahan yang penulis sampaikan di beberapa Perguruan Tinggi Umum (PTU)"},
                                        {"Pengantar Pendidikan Agama Kristen", "Dr. Hasudungan Simatupang, M.Pd., Ronny Simatupang, S.Th., M.Pd.K., Tianggur Medi Napitupulu, S.PAK., M.Pd.K.", "256", "2020", "Penerbit Andi", "Buku ini berfungsi mempersatukan persepsi tentang perbedaan pemahaman keseluruhan bentuk dan lembaga pengelola Pendidikan Agama Kristen di Indonesia."},
                                        {"Dharma Acarya: Pembelajaran Pendidikan Agama Hindu untuk Menembus Portal Revolusi Industri 4.0", "I Made Dwi Susila Adnyana", "173", "2021", "Nilacakra", "Berisi ajaran supaya menjadikan generasi muda yang berpotensi, berilmu, kreatif, dan tentunya berlandaskan moral kea­gamaan yang baik untuk dapat menjadi manusia yang beriman dan bertakwa kepada Tuhan Yang Maha Esa atau dalam ajaran Agama Hindu dikenal dengan istilah Moksartham Jagaditha Ya Ca Iti Dharma."},
                                        {"Pengembangan Kurikulum Pendidikan Agama Islam Transformatif", "Umar, dkk", "414", "2016", "Deepublish", "Berisi cara pengembangan kurikulum PAI yang mengacu pada standar nasional pendidikan untuk mewujudkan tujuan pendidikan nasional."},
                                        {"Revolusi Diri: Memaksimalkan Potensi untuk Menjadi yang Terbaik", "Amru Khalid", "308", "2007", "Qisthi Press", "Buku ini akan mengupas misteri nasib ini dan langkah-langkah yang harus ditempuh oleh seorang Muslim untuk menjadi yang terbaik dalam segala hal."}};

    private static String[][] teknologi = {{"Lebih Mahir dengan Microsoft Word 2019", "Edi S. Mulyanta, Joko Irawan Mumpuni", "212", "2020", "Penerbit Andi", "Petunjuk dan kiat supaya mahir dalam menggunakan Microsoft Word 2019 dalam penggunaan secara professional."},
                                            {"Introduction to Java Programming, Comprehensive Version 10th Edition", "Y. Daniel Liang", "1345", "2015", "Pearson Education Inc.", "Buku ini berisi pembelajaran tentang pemrograman Java yang cocok untuk pemula hingga expert."},
                                            {"Inovasi Desain dengan AutoCAD", "Suparno Sastra M.", "264", "2013", "Elex Media Komputindo", "Buku ini menjelaskan tentang cara-cara membuat desain 3D dengan AutoCad"}, 
                                            {"Phyton Game Programming By Example", "Alejandro Rodas de Paz, Joseph Howse", "230", "2015", "Packt Publishing", "Buku ini menjelaskan tentang contoh penggunaan bahasa Phyton sebagai bahasa pemrograman untuk membuat sebuah game sederhana."},
                                            {"C++ For Dummies", "Stephen R. Davis", "432", "2009", "Wiley", "Berisi tentang pedoman dan materi untuk belajar C++ yang sangat cocok untuk pemula."},
                                            {"High Performance MySQL", "Baron Schwartz, Peter Zaitsev, dkk", "712", "2008", "O'Reilly Media", "Buku ini berisi tentang cara-cara untuk mengelola database berbasis MySQL sehingga mempunyai optimasi yang bagus."},
                                            {"Web Programming (Client Side and Server Side)", "Fitri Marisa", "259", "2017", "Deepublish", "Menjelaskan tentang pedoman untuk mempelajari pemrograman web, baik di sisi server maupun sisi client."}};
        
    private static String[][] filsafat = {{"Filsafat Modern: Dari Machiavelli sampai Nietzsche", "F. Budi Hardiman", "312", "2004", "Gramedia Pustaka Utama", "Menjelaskan pemikirian para filsuf modern yang mengembangkan ketiga elemen kesadaran modern itu dalam berbagai ajaran, mulai dari humanisme Renaisans, rasionalisme, empirisme, kritisisme, idealisme, materialisme, romantisme dan positivisme."},
                                            {"Pokok-pokok Filsafat Hukum: Apa dan Bagaimana Filsafat Hukum Indonesia", "Darji Darmodiharjo, Shidarta", "322", "1995", "Gramedia Pustaka Utama", "Menjelaskan tentang masalah-masalah filsafat hukum dan contoh penerapan filsafat hukum di Indonesia."},
                                            {"Filsafat Ilmu di Era Milenial", "Dr. Ismail Marzuki, M.Si, dkk", "224", "2021", "Fakultas Teknik UNIFA", "Buku ini mempunyai nilai filosofis dengan makna berbeda dengan karya sejenis sebagai torehan pemikiran yang berbeda minimal pada aspek ruang dan waktu."},
                                            {"Contemporary Approaches to Philosophy", "Paul K. Moser, Dwayne Mulder", "488", "1994", "Macmillan Publishing Company", "Buku ini menjelaskan tentang pendekatan kontemporer dalam pemahaman arti filsafat."},
                                            {"Filsafat Umum Zaman Now", "Hamidulloh Ibda", "296", "2018", "CV. Kataba Group", "Buku ini merupakan bahan ajar kuliah yang dalam penyusunannya, penulis menggunakan riset perpustakaan atau kajian pustaka, serta kajian empirik lapangan, khusunya di dunia pendidikan."}};
        
    private static String[][] sejarah = {{"Sejarah Dunia yang Disembunyikan", "Jonathan Black", "636", "2015", "Pustaka Alvabet", "Dalam buku kontroversial yang sangat tersohor ini, Jonathan Black mengupas secara tajam penelusurannya yang brilian tentang misteri sejarah dunia."},
                                        {"History of World War II", "Francis Trevelyan Miller", "999", "1948 (didigitalkan 2010)", "Universal Book and Bible House", "Buku ini menjelaskan tentang bagaimana terjadinya perang dunia ke-2 dan negara mana saja yang terlibat."},
                                        {"Sejarah Peradaban Islam", "Dr. Ahmadin, S.Ag., S.Pd., M.Pd.", "162", "2020", "Prenada Media", "Menjelaskan tentang sejarah perkembangan peradaban Islam mulai dari zaman Rasulullah SAW hingga masa kini"},
                                        {"Sejarah & Kebudayaan Islam Periode Klasik (Abad VII-XII M)", "Prof. Dr. H. Faisal Ismail, M.A.", "420", "2017", "IRCiSoD", "Pada masa itu, Islam mengalami kemajuan pesat yang ditandai dengan kekuasaan yang sangat luas serta penyatuan antarwilayah Islam."},
                                        {"The Colonial Machine: French Science and Overseas Expansion in the Old Regime", "James Edward McClellan (III), François Regourd", "694", "2011", "Brepols", "Buku ini menjelaskan tentang expansi dan kolonialisasi Prancis pada zaman dahulu."}};

    private static String[][] psikologi = {{"Teori Psikologi Kepribadian Manusia", "Nur Fatwikiningsih, S. Psi, M.Psi, Psikolog", "352", "2020", "Penerbit Andi","Buku teks ini akan mempemudah mahasiswa maupun para pendidik untuk mempelajari beragam teori psikologi kepribadian yang masing-masing teori telah dirinci dari aspek konsep teori kepribadian, struktur kepribadian, dinamika kepribadian, dan perkembangan kepribadian"},
                                            {"Psikologi Gestalt: Seri Sejarah Psikologi Modern", "Duane P. Schultz dan Sydney Ellen Schultz, Lita Hardian (Penerjemah), M. Rizal (Penyunting)", "115", "2021", "Nusamedia", "Buku ini akan membahas perkembangan pemikiran psikologi dari mulai zaman Yunani kuno, Masa Helenistik, Abad pertengahan, Masa renaissance, awal berdirinya psikologi modern, sampai dengan psikologi pada awal abad ke-21."},
                                            {"Pengantar Psikologi dan Pandangan Al-Qur'an Tentang Psikologi", "Nurussakinah Daulay, M.Psi", "174", "2015", "Kencana", "Cakupan buku ini antara lain membahas hakikat, sejarah, dan definisi Psikologi; ruang lingkup dan hubungan bidang Psikologi dengan disiplin ilmu pengetahuan lainnya; kajian dan pembahasan Psikologi berdasarkan pandangan perspektif Al-Quran; hakikat manusia menurut Al Quran; Psikologi Islam; aplikasi Psikologi dalam bidang profesi lain (pendidikan dan pengajaran, konseling, hubungan kemasyarakatan, kepemimpinan, kriminal, dan teknologi informasi); beberapa metode dan aliran dalam Psikologi (psikoanalisa, behaviorisme, humanistik, dan kognitif); gejala kejiwaan pada manusia; beberapa pendekatan Psikologi; serta tokoh-tokoh Islam di bidang Psikologi."},
                                            {"Psikologi Agama: Implementasi Psikologi untuk Memahami Perilaku Agama", "Ahmad Saifuddin", "316", "2019", "Kencana", "Pada buku ini, pembaca akan diajak untuk memahami psikologi agama dari awal, yaitu definisi, ruang lingkup, dan manfaatnya."},
                                            {"Psikologi Pendidikan", "Pupu Saeful Rahmat", "208", "2021", "Bumi Aksara", "Fokus dari buku ini adalah tentang pemahaman, makna, dan pengalaman individu yang terlibat dalam proses belajar dan mengajar."}};
                    
    private static String[][] politik = {{"Reformasi Politik: Dinamika Politik Nasional Dalam Arus Politik Global", "Achmad Tirtosudiro, M. Dawam Rahardjo", "306", "1997 (didigitalkan 2008)", "Intermasa", "Buku ini akan membahas tentang dinamika politik indonesia pada kancah internasional."},
                                            {"Politik Bebas Aktif: Tantangan dan Kesempatan", "Mohamad Sabir", "259", "1987 (didigitalkan 2006)", "Haji Masagung", "Buku ini menjelaskan tentang tantangan yang mungkin dihadapi dan keuntungan dari penerapan politik bebas aktif."},
                                            {"Menelaah kembali format politik Orde Baru", "M. Riza Sihbudi", "201", "1995", "PT. Gramedia Pustaka Utama", "Format politik Orde Baru antara lain didirikan oleh pelembagaan peran sosial-politik ABRI, sistem semi-perwakilan, sistem kepartaian tertutup, tekanan pada sentralisasi pemerintahan dan pembangunan yang berorientasi pada pertumbuhan ekonomi."},
                                            {"Politik Pembangunan: Sebuah Analisis Konsep, Arah, dan Strategi", "Moeljarto Tjokrowinoto", "131", "1987 (didigitalkan 2007)", "Tiara Wacana Yogya", "Buku ini membahas tentang politik pembangunan secara lengkap baik berdasarkan konsep, arah, dan strategi."},
                                            {"Dasar-Dasar Ilmu Politik", "Miriam Budiardjo", "247", "2003", "Gramedia Pustaka Utama", "Buku ini membahas konsep-konsep seperti politik, kekuasaan, dan pembuatan keputusan."}};

    private static String[][] fiksi = {{"Bumi Manusia", "Pramoedya Ananta Toer", "405", "1981", "Hasta Mitra", "Buku ini menceritakan tentang kisah dua anak manusia yang meramu cinta di atas pentas pergelutan tanah kolonial awal abad 20"},
                                        {"Ayat-ayat Cinta", "Habiburrahman El-Shirazy", "426", "2005", "Republika Penerbit", "Buku ini tidak hanya sekedar menceritakan kisah cinta biasa, namun tentang bagaimana menghadapi turun-naiknya persoalan hidup dengan cara Islam."},
                                        {"Penjelajah Antariksa 5: Kapten Raz", "Djokolelono", "201", "2015", "Kepustakaan Populer Gramedia", "Ribuan tahun dari sekarang, Terra atau Bumi yang manusia tempati tiada akibat perang. Penduduk Terra berpencar mencari planet yang bisa mereka tinggal"},
                                        {"Laskar Pelangi", "Andrea Hirata", "529", "2005", "Bentang Pustaka", "Novel ini bercerita tentang kehidupan 10 anak dari keluarga miskin yang bersekolah (SD dan SMP) di sebuah sekolah Muhammadiyah di Belitung yang penuh dengan keterbatasan."},
                                        {"Negeri 5 Menara", "A. Fuadi", "440", "2013", "Gramedia Pustaka Utama", "Novel ini bercerita tentang kehidupan 6 santri dari 6 daerah yang berbeda menuntut ilmu di Pondok Madani (PM) Ponorogo Jawa Timur yang jauh dari rumah dan berhasil mewujudkan mimpi menggapai jendela dunia."}};

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
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 1){
                            buku asal = new buku("Filsafat", filsafat[indexRow][1], filsafat[indexRow][0], filsafat[indexRow][2], String.valueOf(indexRow+1), filsafat[indexRow][3], filsafat[indexRow][4], filsafat[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 2){
                            buku asal = new buku("Sejarah", sejarah[indexRow][1], sejarah[indexRow][0], sejarah[indexRow][2], String.valueOf(indexRow+1), sejarah[indexRow][3], sejarah[indexRow][4], sejarah[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 3){
                            buku asal = new buku("Agama", agama[indexRow][1], agama[indexRow][0], agama[indexRow][2], String.valueOf(indexRow+1), agama[indexRow][3], agama[indexRow][4], agama[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 4){
                            buku asal = new buku("Psikologi", psikologi[indexRow][1], psikologi[indexRow][0], psikologi[indexRow][2], String.valueOf(indexRow+1), psikologi[indexRow][3], psikologi[indexRow][4], psikologi[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 5){
                            buku asal = new buku("Politik", politik[indexRow][1], politik[indexRow][0], politik[indexRow][2], String.valueOf(indexRow+1), politik[indexRow][3], politik[indexRow][4], politik[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
                        }
                        else if(urutan == 6){
                            buku asal = new buku("Fiksi", fiksi[indexRow][1], fiksi[indexRow][0], fiksi[indexRow][2], String.valueOf(indexRow+1), fiksi[indexRow][3], fiksi[indexRow][4], fiksi[indexRow][5]);
                            buku tujuan = asal.copy(asal);
                            tujuan.tampilkanCopy();
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

