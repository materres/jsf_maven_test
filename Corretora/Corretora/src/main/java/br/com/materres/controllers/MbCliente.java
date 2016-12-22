package br.com.materres.controllers;

import br.com.materres.model.dao.HibernateDAO;
import br.com.materres.model.dao.InterfaceDAO;
import br.com.materres.model.entities.Cliente;
import br.com.materres.model.entities.Cobertura;
import br.com.materres.model.entities.Item;
import br.com.materres.util.FacesContextUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class MbCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes;
    private Item item;
    private List<Cobertura> coberturas;
    
    private boolean maiorIdade;
    private String cadastro;
    private String busca;
    private String tipoBusca;
    private String valorBusca;
    private Date dataInicial = new Date();    
    private Date dataFinal = new Date();
    
    
    
    private Calendar calendario = Calendar.getInstance();
    private Date data1CNH = new Date();
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public InterfaceDAO<Cliente> clienteDAO() {
        InterfaceDAO<Cliente> clienteDAO = new HibernateDAO<Cliente>(Cliente.class,
                FacesContextUtil.getRequestSession());
        return clienteDAO;
    }
    
    public void adicionaCliente() {
        if ((cliente.getId() == null) || (cliente.getId() == 0)){
            clienteDAO().save(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Adicionado com sucesso", ""));
        } else {
            clienteDAO().update(cliente);
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Atualizado com sucesso", ""));
        }
    }
    
    public void deletaCliente() {
        clienteDAO().remove(cliente);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "Removido com sucesso", ""));
    }
    
    public void limpaTudo() {
        cliente = new Cliente();
        item = new Item();
    }

    public boolean isMaiorIdade() {
        Date hoje = new Date();
        Calendar dataNascimento = Calendar.getInstance();
        int limite = 18;
        
        calendario.setTime(hoje);
        calendario.set(Calendar.YEAR, calendario.get(Calendar.YEAR) - limite);
        dataNascimento.setTime(cliente.getDataNascimento());
        maiorIdade = calendario.after(dataNascimento);
        return maiorIdade;
    }
    
    public Date getData1CNH() {
        int idadeMinima = 18;
        int mesesAno = 12;
        calendario.setTime(cliente.getDataNascimento());
        calendario.set(Calendar.MONTH, calendario.get(Calendar.MONTH) + (idadeMinima * mesesAno));
        data1CNH = calendario.getTime();
        return data1CNH;
    }

    public String fazBusca() {
        
        return "/restrict/cliente/gerencia.htm";
    }
    
    public void verCoberturas() {
        Map<String, Object> options = new HashMap<String, Object>();
        Map<String, List<String>> params = new HashMap<String, List<String>>();
        List<String> values = new ArrayList<String>();
        
        options.put("modal", true);
        options.put("draggable", true);
        options.put("resizable", false);
        options.put("includeViewParams", true);
        values.add(item.getDescricao());
        params.put("itemDescricao", values);
        RequestContext.getCurrentInstance().openDialog(
                "/restrict/item/cobertura", options, params);
    }
    
    public String getCadastro() {
        return cadastro;
    }

    public void setCadastro(String cadastro) {
        this.cadastro = cadastro;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public String getBusca() {
        return busca;
    }

    public void setBusca(String busca) {
        this.busca = busca;
    }

    public String getTipoBusca() {
        if (busca.contains("data")) {
            tipoBusca = "data";
        } else {
            tipoBusca = "texto";
        }
        return tipoBusca;
    }

    public String getValorBusca() {
        return valorBusca;
    }

    public void setValorBusca(String valorBusca) {
        this.valorBusca = valorBusca;
    }
    

    public void setTipoBusca(String tipoBusca) {
        this.tipoBusca = tipoBusca;
    }
      
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        clientes = clienteDAO().getEnteties();
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Cobertura> getCoberturas() {
        InterfaceDAO<Cobertura> coberturaDAO = new HibernateDAO<Cobertura>(Cobertura.class,
                FacesContextUtil.getRequestSession());
        
        
        DetachedCriteria criteria = DetachedCriteria.forClass(Cobertura.class);
        criteria.add(Restrictions.eq("item.id",item.getId()));
        criteria.addOrder(Order.asc("nome"));
        coberturas = coberturaDAO.getListByDetachedCriteria(criteria);
        return coberturas;
    }

    public void setCoberturas(List<Cobertura> coberturas) {
        this.coberturas = coberturas;
    }
    
}
