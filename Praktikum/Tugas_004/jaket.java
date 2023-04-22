package Tugas_004;

public class jaket {
    final char MAX_JACKET_TYPE = 'C';
    //                          harga_awal, harga_stlh_diskon
    private final int HARGA_JAKET_A[] = {100_000, 95_000};
    private final int HARGA_JAKET_B[] = {125_000, 120_000};
    private final int HARGA_JAKET_C[] = {175_000, 160_000};

    public int[] getHargaJaket(char jaket){
        return (jaket == 'A') ? HARGA_JAKET_A : ((jaket == 'B') ? HARGA_JAKET_B : HARGA_JAKET_C);
    }
}
