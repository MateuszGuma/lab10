package java_lab;


import java.io.*;
import java.util.Scanner;

public class DataSaver {
    FileWriter save_to_file = null;
    File file = null;

    static String file_path = "test.txt";

    DataSaver()
    {
        file = new File(file_path);
    }

    void data_save (String number, String resoult) throws IOException
    {
        String tmp;
        save_to_file = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(save_to_file);
        PrintWriter pw = new PrintWriter(bw);

        tmp = number +" -> "+resoult;

        //save_to_file.append(tmp);
        pw.println(tmp);
        //save_to_file.write("\n");
        pw.close();
    }

    void data_load() throws FileNotFoundException
    {
        //load_from_file = new File(file_path);
        //Scanner in = new Scanner(load_from_file);

        //String zdanie = in.nextLine();
        //System.out.println(zdanie);
    }

}
