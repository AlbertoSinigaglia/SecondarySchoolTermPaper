/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wba.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import wba.model.NonConformita;

/**
 *
 * @author FSEVERI\sinigaglia3584
 */
public class NonConformitaUtils {
    public static int getNumNcAperte(Set<NonConformita> nc){
        int count=0;
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()==null) count++;
        }
        return count;
    }
    public static int getNumNcChiuse(Set<NonConformita> nc){
        int count=0;
        for(NonConformita x: nc){
            if(x.getDataFine()!=null) count++;
        }
        return count;
    }
    public static int getNumNcEsec(Set<NonConformita> nc){
        int count=0;
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()!=null) count++;
        }
        return count;
    }
    public static String getLA(Set<NonConformita> nc){
        Date data=null;
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()==null){
                if(data==null) data=x.getDataInizio();
                else {
                    if(data.compareTo(x.getDataInizio())<0) data=x.getDataInizio();
                }
            }
        }
        if (data==null) return "Nessuna NC aperta";
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_MONTH)+" / "+cal.get(Calendar.MONTH)+" / "+cal.get(Calendar.YEAR);
    }
    public static String getLE(Set<NonConformita> nc){
        Date data=null;
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()!=null){
                if(data==null) data=x.getDataInizio();
                else {
                    if(data.compareTo(x.getDataInizio())<0) data=x.getDataInizio();
                }
            }
        }
        if (data==null) return "Nessuna NC in esecuzione";
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_MONTH)+" / "+cal.get(Calendar.MONTH)+" / "+cal.get(Calendar.YEAR);
    }
    public static String getLC(Set<NonConformita> nc){
        Date data=null;
        Iterator i= nc.iterator();
        for(NonConformita x: nc){
            if(x.getDataFine()!=null){
                if(data==null) data=x.getDataInizio();
                else {
                    if(data.compareTo(x.getDataInizio())<0) data=x.getDataInizio();
                }
            }
        }
        if (data==null) return "Nessuna NC chiusa";
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        return cal.get(Calendar.DAY_OF_MONTH)+" / "+cal.get(Calendar.MONTH)+" / "+cal.get(Calendar.YEAR);
    }
    public static List<NonConformita> getNCAperte(Set<NonConformita> nc){
        ArrayList<NonConformita> lista= new ArrayList<>(0);
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()==null){
                lista.add(x);
            }
        }
        return lista;
    }
    public static List<NonConformita> getNCEsec(Set<NonConformita> nc){
        ArrayList<NonConformita> lista= new ArrayList<>(0);
        for(NonConformita x: nc){
            if(x.getDataFine()==null&&x.getDataInizio()!=null&&x.getAzioneContenimento()!=null){
                lista.add(x);
            }
        }
        return lista;
    }
    public static List<NonConformita> getNCChiuse(Set<NonConformita> nc){
        ArrayList<NonConformita> lista= new ArrayList<>(0);
        for(NonConformita x: nc){
            if(x.getDataFine()!=null){
                lista.add(x);
            }
        }
        return lista;
    }
}
