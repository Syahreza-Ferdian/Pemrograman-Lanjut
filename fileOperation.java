import java.io.*;

public class fileOperation{
    public static void main(String[] args) {
        try{
            // File f = new File("E:\\Java\\Test\\Test_Bench", "hello.txt");
            File f = new File("E:\\Java\\Test\\Test_Bench", "hello.java");
            // f.createNewFile();
            FileReader fr = new FileReader(f);
            FileWriter fw = new FileWriter(f, true);
    
            // fw.write("\nSyahreza Fisti Ferdian\n");
            // fw.write("Reza");

            fw.close();

            // BufferedReader buff = new BufferedReader(fr);
            // String x = buff.readLine();

            // while(x != null){
            //     System.out.println(x);
            //     x = buff.readLine();
            // }
            // buff.close();
            // fr.close();
            // f.delete();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
