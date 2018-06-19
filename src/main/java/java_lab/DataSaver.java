package java_lab;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataSaver {
    FileWriter save_to_file = null;
    File file = null;
    List <String>list = null;


    static String file_path = "history.txt";

    DataSaver()
    {
        file = new File(file_path);
        list = new ArrayList<String>();
    }

    public void data_save (String number, String resoult) throws IOException
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

    public void data_load() throws IOException
    {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        }
    }

    public String history()
    {
        String tmp = "";

        try{
            this.data_load();
        }catch (IOException e)
        {
        }

        if(list.size() > 0) {
            int stop;
            if(list.size() > 5) stop = list.size() - 5;
            else stop = 0;
            for(int i = list.size() - 1; i >= stop; i--) {
                tmp = tmp + list.get(i) + "\n";
            }
        }

        return tmp;
    }
}
