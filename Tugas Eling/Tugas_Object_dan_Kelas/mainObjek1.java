class lingkaran{
    private double diameter;
    final double PHI = Math.PI;

    public lingkaran(double diameter){
        this.diameter = diameter;
    }
    public double hitungLuas(){
        return 0.25 * PHI * Math.pow(diameter, 2);
    }
    public double getDiameter() {
        return diameter;
    }
}
class persegiPanjang{
    private int panjang, lebar;
    
    public persegiPanjang(int panjang, int lebar){
        this.panjang = panjang;
        this.lebar = lebar;
    }
    public int hitungLuas(){
        return panjang * lebar;
    }
    public int getLebar() {
        return lebar;
    }
    public int getPanjang() {
        return panjang;
    }
}
public class mainObjek1 {
    public static void main(String[] args) {
        //objects list
        lingkaran kepala = new lingkaran(28);
        persegiPanjang badan = new persegiPanjang(40, 35); //pjg = vertikal
        persegiPanjang tanganKiri = new persegiPanjang(25, 9);
        persegiPanjang tanganKanan = new persegiPanjang(25, 9);
        lingkaran telapakTanganKiri = new lingkaran(10);
        lingkaran telapakTanganKanan = new lingkaran(10);
        persegiPanjang kakiKiri = new persegiPanjang(45, 15);
        persegiPanjang kakiKanan = new persegiPanjang(45, 15);
        lingkaran telapakKakiKiri = new lingkaran(14);
        lingkaran telapakKakiKanan = new lingkaran(14);

        double totalLuasRobot = kepala.hitungLuas() + badan.hitungLuas() + tanganKiri.hitungLuas() + tanganKanan.hitungLuas() + telapakTanganKiri.hitungLuas() +
                            telapakTanganKanan.hitungLuas() + kakiKiri.hitungLuas() + kakiKanan.hitungLuas() + telapakKakiKiri.hitungLuas() + telapakKakiKanan.hitungLuas();
        
        double tinggiRobot = telapakKakiKiri.getDiameter() + kakiKiri.getPanjang() + badan.getPanjang() + kepala.getDiameter();

        System.out.println("=========[HASIL PERHITUNGAN]=========");
        System.out.printf("%-25s: %.3f\n", "Luas Total Robot", totalLuasRobot);
        System.out.printf("%-25s: %.3f\n", "Tinggi Badan Robot", tinggiRobot);

    }

}
