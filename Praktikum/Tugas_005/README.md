### Developer's Note
> Agak sedikit membingungkan awalnya karena harus menggunakan 'LocalDate' yang itu merupakan hal baru bagi saya. Jadi harus belajar dulu cara penggunaannya. 

### Footnote
> ~~Ini belum program yang fix. Nanti akan saya update lagi kalau ada perubahan/kesalahan yang saya temukan. Sementara saya test menggunakan test case dan saya hitung manual nilainya sudah benar.~~  Sudah fix, InsyaAllah

### Detail Perhitungan Pendapatan Pada Setiap Test Case
> Saya buat dengan tujuan buat memastikan bahwa programnya udah benar dengan mencocokkannya menggunakan perhitungan secara manual


**1. Manusia**
   - ```java 
     manusia hooman1 = new manusia("Slamet Raharjo, S.Pd., M.Pd., M.Si", "45670192", true, true);
     ```
     - Pendapatan = tunjangan(laki2 menikah) = **$25** 
     <br>
   - ```java
     manusia hooman2 = new manusia("Ibu Sriani", "689821309", false, true);
     ```
     - Pendapatan = tunjangan(perempuan menikah) = **$20**
     <br>
   - ```java
     manusia hooman3 = new manusia("Mas Adi", "890831094", true, false);
     ```
     - Pendapatan = tunjangan (belum menikah) = **$15**
     <br>
**2. Mahasiswa Filkom**
   - ```java
     mahasiswaFILKOM saya1 = new mahasiswaFILKOM("225150701111036", 2.8, "Syahreza Fisti Ferdian", "56712093", true, false);
     ```
     - Pendapatan = tunjangan(belum menikah) = **$15**
     <br>
   - ```java
     mahasiswaFILKOM saya2 = new mahasiswaFILKOM("225150701111036", 3.3, "Syahreza Fisti Ferdian", "56712093", true, false);
     ```
     - Pendapatan = tunjangan(belum menikah) + beasiswa (IPK 3.3) = $15 + $50 = **$65**
     <br>
   - ```java
     mahasiswaFILKOM saya3 = new mahasiswaFILKOM("225150701111036", 3.9, "Syahreza Fisti Ferdian", "56712093", true, false);
     ```
     - Pendapatan = tunjangan (belum menikah) + beasiswa (IPK 3.9) = $15 + $75 = **$90**
     <br>
**3. Pekerja**
   - ```java
     pekerja pekerja1 = new pekerja(5000, 2021, 01, 25, 2, "Slamet", "92180411", true, true);
     ```
     - Pendapatan = tunjangan(laki2 menikah) + tunjangan 2 anak + bonus(2 thn) + gaji = $25 + $40 + $250 + $5000 = **$5315**
     <br>
   - ```java
     pekerja pekerja2 = new pekerja(5000, 2014, 02, 24, 0, "Yuli", "891209312", false, false);
     ```
     - Pendapatan = tunjangan(tidak menikah) + bonus(9 thn) + gaji = $15 + $500 + $5000 = **$5515**
     <br>
   - ```java
     pekerja pekerja3 = new pekerja(5000, 2003, 04, 15, 10, "Bpk. Santoso", "891831021", true, true);
     ```
     - Pendapatan = tunjangan(laki2 menikah) + tunjangan 10 anak + bonus(20 thn) + gaji = $25 + $200 + $750 + $5000 = **$5975**
     <br>
**4. Manager**
   - ```java
     manager manager1 = new manager("Quality Assurance", 7500, 2008, 03, 28, 0, "Achmad, S.T., M.T., Ph.D", "1453241", true, false);
     ```
     - Pendapatan = tunjangan (tidak menikah) + bonus(15 thn) + tunjangan manager + gaji = $15 + $1125 + $750 + $7500 = **$9390**

