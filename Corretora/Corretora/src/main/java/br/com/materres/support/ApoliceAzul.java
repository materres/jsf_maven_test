package br.com.materres.support;

import br.com.materres.converters.ConverterNumber;
import br.com.materres.model.entities.Cliente;
import br.com.materres.model.entities.Item;
import br.com.materres.model.entities.Movel;
import br.com.materres.model.entities.Parcela;
import br.com.materres.model.entities.Seguro;
import br.com.materres.model.enums.FormaPagamento;
import br.com.materres.model.enums.SeletorConversao;
import br.com.materres.model.enums.StatusParcela;
import br.com.materres.model.enums.TipoSeguro;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApoliceAzul {
    
    public ApoliceAzul() {
    }

    public String getResultado(String linha, String regex) {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(linha);
        
        if (m.find()) {
            return m.group();
        } 
        return null;
    }

    public List<String> getResultados(String linha, String regex) {
        List<String> resultados = new ArrayList<String>();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(linha);
        resultados.clear();
        while (m.find()) {
            resultados.add(m.group());            
        }
        return resultados;
    }
       
    public Cliente getInfosCliente(String texto){
        Cliente cliente = new Cliente();
        int deslocamento = 170;
        Iterator<String> it;
        HashMap<String, Integer> linhaBase = new HashMap<String, Integer>();
        HashMap<String, String> regex = new HashMap<String, String>();
        
        String[] linha = texto.split("\\n");
        
        linhaBase.put("nome", 11);
        regex.put("nome","[a-zA-Z]{1,}(\\s[a-zA-Z]{1,}){1,}");
        linhaBase.put("cpf", 11);
        regex.put("cpf", "(\\d{3}\\.?){2}\\d{3}-\\d{2}");
        linhaBase.put("cnpj", 11);
        regex.put("cnpj", "(\\d{2}\\.?)\\d{3}\\.?\\d{3}\\/?\\d{4}-\\d{2}");
        linhaBase.put("logradouro", 12);
        regex.put("logradouro", "[a-zA-Z]{1,}(\\s[a-zA-Z]{1,}){1,}\\s\\d{1,}");
        linhaBase.put("bairro", 13);
        regex.put("bairro", "[a-zA-Z]{1,}(\\s[a-zA-Z]{1,}){0,}");
        linhaBase.put("cep", 14);
        regex.put("cep", "\\d{5}-\\d{3}");
        linhaBase.put("cidade", 14);
        regex.put("cidade", "[a-zA-Z]{1,}(\\s[a-zA-Z]{1,}){1,}");
        linhaBase.put("estado", 14);
        regex.put("estado", "[A-Z]{2}$");
        
        it = linhaBase.keySet().iterator();
        while (it.hasNext()) {
            String n = it.next();
            int l = linhaBase.get(n);
            String rx = regex.get(n);
            String r = getResultado(linha[l], rx);
            
            regex.put(n, r);
        }
        for (int i = deslocamento; i < linha.length; ++i) {
            if (linha[i].contains("Data de nascimento do segurado:")) {
                String r = getResultado(linha[i], "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}");
                regex.put("nascimento", r);
            }
        }
        
        cliente.setNome(regex.get("nome"));
        cliente.setCpf(regex.get("cpf"));
        cliente.setCnpj(regex.get("cnpj"));
        cliente.setBairro(regex.get("bairro"));
        cliente.setCep(regex.get("cep"));
        cliente.setCidade(regex.get("cidade"));
        cliente.setEstado(regex.get("estado"));
        cliente.setLogradouro(regex.get("logradouro"));
        try {
            cliente.setDataNascimento(formataData(regex.get("nascimento")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }
    
    public Seguro getInfosSeguro(String texto){
        Seguro seguro = new Seguro();
        HashMap<String, Integer> linhaBase = new HashMap<String, Integer>();
        HashMap<String, String> regex = new HashMap<String, String>();
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt","BR"));
        
        String[] linha = texto.split("\\n");
        
        linhaBase.put("apolice", 2);
        regex.put("apolice", "(\\d{2}\\.){2}\\d{4}\\.\\d{6}\\.\\d{3}");
        linhaBase.put("data", 2);
        regex.put("data", "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}");
        linhaBase.put("proposta", 3);
        regex.put("proposta", "\\w{6}\\.(\\d{3}\\s{0,1}){3}\\d");
        linhaBase.put("numeroItens", 15);
        regex.put("numeroItens", "\\d{3}");
        linhaBase.put("premioCasco", 16);
        regex.put("premioCasco", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("premioRCFV", 17);
        regex.put("premioRCFV", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("premioAPP", 18);
        regex.put("premioAPP", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("servicos", 19);
        regex.put("servicos", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("adicional", 20);
        regex.put("adicional", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("custo", 21);
        regex.put("custo", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("iof", 22);
        regex.put("iof", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("total", 23);
        regex.put("total", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        
        linhaBase.put("p01Valor", 26);
        regex.put("p01Valor", "(\\d\\.?){0,}\\d{1,3},\\d{2}");
        linhaBase.put("p01Venc", 26);
        regex.put("p01Venc", "\\d{1,2}\\/\\d{1,2}\\/\\d{2,4}");
        
        Iterator<String> it = linhaBase.keySet().iterator();
        while (it.hasNext()) {
            String n = it.next();
            int l = linhaBase.get(n);
            String rx = regex.get(n);
            
            if ((!n.equals("data"))) {
                String r = getResultado(linha[l], rx);
                regex.put(n, r);
            } else {
                List<String> rs = getResultados(linha[l], rx);
                if (rs.size() >= 2) {
                    try {
                        seguro.setDataVigenciaFinal(formataData(rs.get(1)));
                        seguro.setDataVigenciaInicial(formataData(rs.get(0)));
                    } catch (Exception e) {
                        seguro.setDataVigenciaFinal(null);
                        seguro.setDataVigenciaInicial(null);
                    }
                } else {
                    System.out.println("Datas de vigência não encontradas.");
                }   
            }
        }
        
        Double d1 = ConverterNumber.toDouble(SeletorConversao.NUMERO, regex.get("premioCasco"));
        Double d2 = ConverterNumber.toDouble(SeletorConversao.NUMERO, regex.get("premioRCFV"));
        Double d3 = ConverterNumber.toDouble(SeletorConversao.NUMERO, regex.get("premioAPP"));
        Double d4 = ConverterNumber.toDouble(SeletorConversao.NUMERO, regex.get("servicos"));
        Double dt = d1 + d2 + d3 + d4;
        regex.put("premioLiquido", ConverterNumber.toString(dt));
        
        seguro.setNumeroApolice(regex.get("apolice"));
        seguro.setNumeroProposta(regex.get("proposta"));
        seguro.setPremioAdicional(regex.get("adicional"));
        seguro.setPremioCusto(regex.get("custo"));
        seguro.setPremioDesconto("0,00");
        seguro.setPremioIOF(regex.get("iof"));
        seguro.setPremioLiquido(regex.get("premioLiquido"));
        seguro.setPremioTotal(regex.get("total"));
        
        return seguro;
    }
    
    public List<Parcela> getInfosParcela(String texto) {
        List<Parcela> parcelas = new ArrayList<Parcela>();
        int linhaParcelas = 26;
        int linhaCobranca = 24;
        int fim = 32;
        Iterator<String> it;

        String[] linha = texto.split("\\n");
        
        int l = linhaParcelas;
        
        while ((linha[l].startsWith("   0") || linha[l].startsWith("   1")) && (l < fim)) {
            List<String> rsNum = getResultados(linha[l], "(?<!,)(?<!/)(?<!\\d)\\d{2}(?<!,)(?!\\d)(?<!/)");
            List<String> rsVal = getResultados(linha[l], "(\\d\\.?){0,}\\d{1,3},\\d{2}");
            List<String> rsVen = getResultados(linha[l], "([a-zA-Z]{4})|(\\d{1,2}\\/\\d{1,2}\\/\\d{2,4})");
            
            int i = 0;
            int j = 1;
            it = rsNum.iterator();
            while (it.hasNext()) {
                String n = it.next();
                Integer num = Integer.parseInt(rsNum.get(i));
                
                if (num == j) {
                    Parcela parc = new Parcela();
                    if (rsVen.get(j-1).contains("PAGA")) {
                        parc.setStatusParcela(StatusParcela.PAGA);
                    } else {
                        try {
                            parc.setDataVencimento(formataData(rsVen.get(j-1)));
                        } catch (Exception e) {
                            parc.setDataVencimento(null);
                        }
                    }
                    parc.setNumero(Integer.parseInt(rsNum.get(j-1)));
                    parc.setValor(rsVal.get(j-1));

                    parcelas.add(parc);
                    ++j;
                }
                ++i;
            }
            ++l;
        }
        
        Iterator<Parcela> pt = parcelas.iterator();
        while (pt.hasNext()) {
            Parcela n = pt.next();
            if (linha[linhaCobranca].contains("FICHA DE COMPENSA")) {
                n.setFormaPagamento(FormaPagamento.FICHA_COMPENSACAO);
            } else {
                if (linha[linhaCobranca].contains("BITO EM CONTA")) {
                    n.setFormaPagamento(FormaPagamento.DEBITO_AUTOMATICO);
                } else {
                    if (linha[linhaCobranca].contains("BOLETO")) {
                        n.setFormaPagamento(FormaPagamento.BOLETO);
                    }
                }
            }
        }
        return parcelas;
    }
    
    public Item getInfosItem(String texto) {
        Item item = new Item();
        String[] linha = texto.split("\\n");
        int inicio = 40;
        int fim = 60;
        int i = inicio;
        
        while ((!linha[i].contains("COMPREENSIVA")) && (i < fim)) {
            ++i;
        }
        
        
        
        return null;
    }
    
    public static Date formataData(String data) throws Exception { 
        if (data == null || data.equals(""))
            return null;
        Date date;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = (java.util.Date)formatter.parse(data);
        return date;
    }
}
