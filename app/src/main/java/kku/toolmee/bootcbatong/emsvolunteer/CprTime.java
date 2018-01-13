package kku.toolmee.bootcbatong.emsvolunteer;


import android.content.Context;

/**
 * Created by DELL on 15/11/2560.
 */

public class CprTime implements  Runnable {

    public static final long MILLIS_TO_MINUTES = 60000;

    Context CprContext;
    long CprStartTime;
    boolean CprIsRunning;

    public CprTime(Context context) {
        CprContext = context;
    }

    public CprTime(Context context, long startTime) {
        this(context);
        CprStartTime = startTime;
    }

    public void start() {
        if(CprStartTime == 0) { //if the start time was not set before! e.g. by second constructor
            CprStartTime = System.currentTimeMillis();
        }
        CprIsRunning = true;
    }


    public void stop() {
        CprIsRunning = false;
    }


    @Override
    public void run() {
        while(CprIsRunning) {

            long since = System.currentTimeMillis() - CprStartTime;

            int seconds = (int) (since / 1000) % 60;
            int minutes = (int) ((since / (MILLIS_TO_MINUTES)) % 60);
            int millis = (int) since % 1000; //the last 3 digits of millisecs
            int numbertime = (int)  (since/(MILLIS_TO_MINUTES/100)%101);

            ((CprAid) CprContext).UpdateTimeText(String.format("เวลา %02d:%02d:%03d"
                    , minutes, seconds, millis));
            ((CprAid) CprContext).UpdateTimeTextCircle(String.format("จำนวนรอบในการกด %02d รอบ"
                    , minutes));
            ((CprAid) CprContext).UpdateTimeTextNumOfTime(String.format("" + "%02d"
                    , numbertime));


            //Sleep the thread for a short amount, to prevent high CPU usage!
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    }


