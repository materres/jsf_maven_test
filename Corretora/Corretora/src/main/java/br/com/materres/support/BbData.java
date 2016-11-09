package br.com.materres.support;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "bbData")
@ViewScoped
        
public class BbData implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Date dataAtual = new Date();
    private Date dataInicial = new Date();
    private Calendar calendario = Calendar.getInstance();
    
    public Date getDataAtual(){
        return dataAtual;
    }
    
    public Date getDataInicial(){
        calendario.setTime(dataInicial);
        calendario.set(Calendar.YEAR, 1900);
        dataInicial = calendario.getTime();
        return dataInicial;
    }
}
