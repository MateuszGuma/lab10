package java_lab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UrnfieldWrapper {
    String wrapped_data;
    Pattern patern = Pattern.compile("^((\\/*\\\\{1,})|(\\/{1,}\\\\*))$");

    UrnfieldWrapper(String zn)
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
