package br.com.materres.converters;

import br.com.materres.model.enums.SeletorConversao;
import java.text.NumberFormat;
import java.util.Locale;

public class ConverterNumber {

    private static Locale local = new Locale("pt", "BR");
    
    public static Double toDouble(SeletorConversao tipo, String str) {
        NumberFormat nf;    
        Double d;
        
        if (tipo.equals(SeletorConversao.NUMERO)) {
            nf = NumberFormat.getNumberInstance(local);
            try {
                d = (Double) nf.parse(str).doubleValue();
            } catch (Exception e) {
                d = 0.0;
            }
            return d;
        } else {
            if (tipo.equals(SeletorConversao.PORCENTAGEM)) {
                nf = NumberFormat.getPercentInstance(local);
                try {
                    d = (Double) nf.parse(str).doubleValue();
                } catch (Exception e) {
                    d = 0.0;
                }
                return d;
            }
        }
        return null;
    }
    
    public static String toString (Double d) {
        NumberFormat nf = NumberFormat.getNumberInstance(local);
        
        return nf.format(d);
    }
}
