package com.lh.schedule;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @version :1.0
 * CREATE TIME :2018/3/14 14:31
 * @authro :LH
 */
public class TimerTest {

    public static void main(String[] args) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务");
                timer.cancel();
            }
        },3 * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.set(2018,2,14,19,18,00);
        final Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("主线任务");
                timer1.cancel();
            }
        }, calendar.getTime());
    }

}
