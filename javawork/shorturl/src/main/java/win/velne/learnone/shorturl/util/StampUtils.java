package win.velne.learnone.shorturl.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StampUtils {

    public static Timestamp current() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return Timestamp.valueOf(sdf.format(date));
    }

}
