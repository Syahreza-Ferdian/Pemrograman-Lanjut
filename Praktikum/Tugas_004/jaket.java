package Tugas_004;

public class jaket {
    //                          harga_awal, harga_stlh_diskon
    private final int jaketA[] = {100_000, 95_000};
    private final int jaketB[] = {125_000, 120_000};
    private final int jaketC[] = {175_000, 160_000};

    public int[] getJaket(char jaket){
        return (jaket == 'A') ? jaketA : ((jaket == 'B') ? jaketB : jaketC);
    }
}
