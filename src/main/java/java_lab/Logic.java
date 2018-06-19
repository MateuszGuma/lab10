package java_lab;

//przykładowe wywołanie
/*        Logic l = new Logic();
                System.out.println(l.convert(Logic.Convert.fromArabicToRoman, "10"));
                System.out.println(l.convert(Logic.Convert.fromArabicToUrnfield, "10"));
                System.out.println(l.convert(Logic.Convert.fromRomanToArabic, "MMCC"));
                System.out.println(l.convert(Logic.Convert.fromUrnfieldToArabic, "//\\"));*/ //return 7


import java.io.FileNotFoundException;
import java.io.IOException;

public class Logic {
    private DataSaver saver;

    public enum Convert {
        fromUrnfieldToArabic, fromArabicToUrnfield, fromRomanToArabic, fromArabicToRoman;
    }

    Logic() {
        saver = new DataSaver();
    }

    public String convert(Convert  en, String number){
        String result;


        //Convert t = Convert.valueOf()[en];

        switch (en) {
            case fromUrnfieldToArabic:
                UrnfieldNumber fromUrnfie =  new UrnfieldNumber();
                try {
                    result = String.valueOf(fromUrnfie.urnfieldToArabic(new UrnfieldWrapper(number)));

                }catch (IllegalArgumentException ee){
                    result = "IllegalArgument";
                }
                break;

            case fromArabicToUrnfield:
                UrnfieldNumber ToUrnfield =  new UrnfieldNumber();
                try {
                    result = ToUrnfield.arabicToUrnfield(Integer.parseInt(number));

                }catch (IllegalArgumentException ee){
                    result = "IllegalArgument";
                }
                break;

            case fromRomanToArabic:
                RomanNumber fromRoman =  new RomanNumber();
                try {
                    result = String.valueOf(fromRoman.romanToArabic(new RomanWrapper(number)));

                }catch (IllegalArgumentException ee){
                    result = "IllegalArgument";
                }
                break;

            case fromArabicToRoman:
                RomanNumber ToRoman =  new RomanNumber();
                try {
                    result = ToRoman.arabicToRoman(Integer.parseInt(number));

                }catch (IllegalArgumentException ee){
                    result = "IllegalArgument";
                }
                break;

            default:
                result = "Convert " + en;
        }

        try{
            saver.data_save(number, result);
        }catch (IOException e)
        {

        }
        return result;
    }

    public String history()
            //Return last 5 operations from history
    {
        return saver.history();
    }



}
