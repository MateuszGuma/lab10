package java_lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanWrapper {
    String wrapped_data;
    Pattern patern = Pattern.compile("^M{0,2}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$|^M{0,3}$");

    RomanWrapper(String zn)
    {
        Matcher matcher = patern.matcher(zn);
        if(matcher.matches())
        {
            this.wrapped_data = zn;
        }else throw new IllegalArgumentException();
    }

    public String stringValue()
    {
        return wrapped_data;
    }
}
