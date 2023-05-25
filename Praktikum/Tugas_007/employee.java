package Tugas_007;

public class employee implements payable{
    private int registrationNumber;
    private String name;
    private int salaryPerMonth;
    private invoice[] invoices;

    public employee(String name, int registrationNumber, int salaryPerMonth){
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.salaryPerMonth = salaryPerMonth;
        this.invoices = new invoice[10]; //di wenehi bates maksimal 10 jenis product belanja per pegawai
    }

    @Override
    public int getPayableAmount() {
        int hutang = 0;
        for(int i = 0; i < invoices.length; i++){
            if(invoices[i] != null) hutang += invoices[i].getPayableAmount();
        }
        return salaryPerMonth - hutang;
    }
    public invoice[] getInvoices() {
        return invoices;
    }
    public void addInvoice(invoice itemToAdd){
        boolean isMaximum = true;
        if(searchElementByProductName(itemToAdd.getProductName()) != -1){
            int presentIndex = searchElementByProductName(itemToAdd.getProductName());
            invoices[presentIndex].setQuantity(itemToAdd.getQuantity() + invoices[presentIndex].getQuantity());
            isMaximum = false;
            System.out.println("USERINFO: Berhasil menambahkan jumlah pada pesanan sebelumnya!\n");
        }
        else{
            for(int i = 0; i < invoices.length; i++){
                if(invoices[i] == null){
                    invoices[i] = itemToAdd;
                    isMaximum = false;
                    System.out.println("USERINFO: Produk berhasil ditambahkan!\n");
                    break;
                }
            }
        }
        if(isMaximum) System.out.println("ERROR: Anda tidak dapat berbelanja lagi. Maksimum 10 jenis product per pegawai");
    }
    public int searchElementByProductName(String productName){
        int index = -1;
        for(int i = 0; i < invoices.length; i++){
            if(invoices[i] != null && invoices[i].getProductName().equals(productName)){
                index = i;
                break;
            }
        }
        return index;
    }
    public String toString() {
        return String.format("%-18s: %s\n%-18s: %d\n%-18s: Rp %,3d.00\n%-18s:", "Nama", name, "Registration Num", registrationNumber, "Gaji Awal", salaryPerMonth, "Detail Belanja");
    }
    public void getDetailBelanja(){
        int totalBelanja = 0;
        if(invoices[0] == null) System.out.printf("%3sAnda tidak memiliki belanjaan :(\n", "");
        else{
            for(int i = 0; i < invoices.length; i++){
                if(invoices[i] != null) {
                    System.out.printf("%3s%d. %-48s Rp %,3d.00\n", "", i+1, String.format("%d buah %s", invoices[i].getQuantity(), invoices[i].getProductName()), invoices[i].getPricePerItem() * invoices[i].getQuantity());
                    totalBelanja += invoices[i].getQuantity() * invoices[i].getPricePerItem();
                }
            }
            System.out.printf("%3s================================================================", "");
            System.out.printf("\n%3s%-51s Rp %,3d.00\n", "", "Total Belanja", totalBelanja);
        }
    }
}