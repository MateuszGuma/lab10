package java_lab;

//przykładowe wywołanie
/*        Logic l = new Logic();
                System.out.println(l.convert(Logic.Convert.fromArabicToRoman, "10"));
                System.out.println(l.convert(Logic.Convert.fromArabicToUrnfield, "10"));
                System.out.println(l.convert(Logic.Convert.fromRomanToArabic, "MMCC"));
                System.out.println(l.convert(Logic.Convert.fromUrnfieldToArabic, "//\\"));*/ //return 7


public class Logic {

    public enum Convert {
        fromUrnfieldToArabic, fromArabicToUrnfield, fromRomanToArabic, fromArabicToRoman;
    }


    public String convert(Convert operationNumber, String number){
        String result;

        switch (operationNumber) {
            case fromUrnfieldToArabic:
                UrnfieldNumber fromUrnfie =  new UrnfieldNumber();
                try {
                    result = String.valueOf(fromUrnfie.urnfieldToArabic(number));

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
                    result = String.valueOf(fromRoman.romanToArabic(number));

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
                result = "Convert " + operationNumber;
        }
        return result;
    }

}
