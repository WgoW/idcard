package com.lv.tools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android_serialport_api.SerialPort;

/**
 *         description 读卡信息的帮助类
 */
public class CardHelper {
    private static final ExecutorService SERVICE = Executors.newSingleThreadExecutor();
    private static ReadIdRunnable readIdRunnable;
    private static ReadInfoRunnable readInfoRunnable;

    /**
     * 得到卡体管理号
     *
     * @param port       串口对象{@link SerialPort}
     * @param outTime    超时时间
     * @param readResult 读卡结果{@link ReadIdResult}
     */
    public static void getCardId(SerialPort port, int outTime, ReadIdResult readResult) {
        readIdRunnable = new ReadIdRunnable(port, outTime, readResult);
        SERVICE.execute(readIdRunnable);
    }

    /**
     * 得到身份证信息
     *
     * @param port           串口对象{@link SerialPort}
     * @param outTime        超时时间
     * @param readInfoResult 读卡结果{@link ReadInfoResult}
     */
    public static void getCardInfo(SerialPort port, int outTime, ReadInfoResult readInfoResult) {
        readInfoRunnable = new ReadInfoRunnable(port, outTime, readInfoResult);
        SERVICE.execute(readInfoRunnable);
    }

    public static void stops() {
        if (readIdRunnable != null)
            readIdRunnable.setStop();
        if (readInfoRunnable != null)
            readInfoRunnable.setStop();
    }
}
