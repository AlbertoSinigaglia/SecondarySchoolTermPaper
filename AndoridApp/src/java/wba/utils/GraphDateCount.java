/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.utils;

/**
 *
 * @author albertosinigaglia
 */
public class GraphDateCount {
    private String mese;
    private int c;

    public GraphDateCount(int mese, int c) {
        this.mese = getMese(mese);
        this.c=c;
    }

    public void setMese(int mese) {
        this.mese = getMese(mese);
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getMese() {
        return mese;
    }

    public int getC() {
        return c;
    }

    @Override
    public String toString() {
        return "GraphDateCount{" + "mese=" + mese + ", c=" + c + '}';
    }
    public static String getMese(int i){
        String[] mesi= {"Gen","Feb","Mar","Apr","Mag","Giu","Lug","Ago","Set","Ott","Nov","Dic"};  
        return mesi[i];
    }
}
