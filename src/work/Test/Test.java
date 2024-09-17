package work.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Date date = sdf.parse("3:00");
        String parsedDate = sdf.format(date);
        System.out.println(parsedDate);
    }
}
