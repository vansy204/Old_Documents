package java_58;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class test {
    @SuppressWarnings("deprecaton")
    public static void main(String[] args) {

        // ham lay thoi gian hien tai
        long t1 = System.currentTimeMillis();
        for (int i = 1; i <= 100; i++) {
            System.out.println("TEST");
        }
        long t2 = System.currentTimeMillis();
        System.out.println("truoc khi chay for: " + t1);
        System.out.println("Sau khi chay for: " + t2);
        System.out.println("Thoi gian: " + ((t2 - t1)) + "mls");

        // TimeUnit => chuyen doi giua cac dinh dang thoi gian
        System.out.println("3000 nam  = " + TimeUnit.DAYS.toSeconds(3000 * 365));
        System.out.println("125h= " + TimeUnit.HOURS.toSeconds(3000 * 365));
        // lấy ngay tháng theo thời gian thực (quan trọng)
        Date d = new Date(System.currentTimeMillis());

        // calendar
        Calendar c = Calendar.getInstance();
        System.out.println(c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR));
        // ham thay doi thong tin ngay gio
        c.add(Calendar.HOUR, 30);
        System.out.println(c.get(Calendar.DATE) + "-" + (c.get(Calendar.MONTH) + 1) + "-" + c.get(Calendar.YEAR));

        // DateFormat
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(d));

    }
}
