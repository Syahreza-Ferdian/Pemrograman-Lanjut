package Tugas_007;

public class invoice implements payable{
    private String productName;
    private int quantity;
    private int pricePerItem;

    public invoice(String productName, int quantity, int pricePerItem){
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
    }

    public String getProductName() {
        return productName;
    }
    public int getPricePerItem() {
        return pricePerItem;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    @Override
    public int getPayableAmount() {
        return quantity * pricePerItem;
    }
}
