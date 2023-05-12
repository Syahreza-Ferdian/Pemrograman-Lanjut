package Tugas_006;

public class kuePesanan extends kue{
    private double berat;
    
    public kuePesanan(String nama, double harga, double berat){
        super(nama, harga);
        this.berat = berat;
    }
    //getter
    public double getBerat() {
        return berat;
    }
    //override parent class method
    @Override
    public double hitungHarga() {
        return this.berat * super.getHarga();
    }
}
