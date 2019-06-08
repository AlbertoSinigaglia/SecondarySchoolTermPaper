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
public class GraphObjNc {
    String denom;
    int nc;

    public GraphObjNc(String denom, int nc) {
        this.denom = denom;
        this.nc = nc;
    }

    public String getDenom() {
        return denom;
    }

    public int getNc() {
        return nc;
    }

    public void setDenom(String denom) {
        this.denom = denom;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    @Override
    public String toString() {
        return "GraphObjNc{" + "denom=" + denom + ", nc=" + nc + '}';
    }
    
}
