package com.synjones.bluetooth;

public class DecodeWlt {
    static {
        System.loadLibrary("DecodeWlt");
    }
    public DecodeWlt(){

    }

    public native int Wlt2Bmp(String var1, String var2);
}
