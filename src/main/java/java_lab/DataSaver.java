package java_lab;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataSaver {
    FileWriter save_to_file = null;
    File file = null;
    List <String>list = null;


    static String file_path = "test.txt";

    DataSaver()
    {
        file = new File(file_path);
        list = new ArrayList<>();
    }

    void data_save (String number, String resoult) throws IOException
    {
        String tmp;
        save_to_file = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(save_to_file);
        PrintWriter pw = new PrintWriter(bw);

        tmp = number +" -> "+resoult;

        if( !resoult.equals("IllegalArgument") )
        {
            pw.println(tmp);
        }
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
