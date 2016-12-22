package br.com.materres.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name = "movel")
public class Movel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue
    @Column(name = "idMovel")
    private Integer id;
    @Column(name = "modelo", nullable = false, length = 50)
    private String modelo;
    @Column(name="anoFab", nullable=false, length = 5)
    private String anoFab;
    @Column(name="anoModelo", nullable=false, length = 5)
    private String anoModelo;
    @Column(name="Chassi", nullable=false, length = 30)
    private String chassi;
    @Column(name="numeroPassageiros", nullable=false)
    private Integer numeroPassageiros;
    @Column(name="combustivel", nullable=false, length = 20)
    private String combustivel;
    @Column(name = "valorFIPE", nullable = false, length = 20)
    private String valorFIPE;
    @Column(name = "percFIPE", nullable = false, length = 5)
    private String percFIPE;
    @Column(name="franquiaCasco", nullable = false, length = 20)
    private String franquiaCasco;
    @Column(name="franquiaAcessorios", nullable = false, length = 20)
    private String franquiaAcessorios;
    @Column(name="franquiaVPBT", nullable = false, length = 20)
    private String franquiaVPBT;
    @Column(name="franquiaVL", nullable = false, length = 20)
    private String franquiaVL;
    @Column(name="franquiaRet", nullable = false, length = 20)
    private String franquiaRet;
    @Column(name="franquiaFLC", nullable = false, length = 20)
    private String franquiaFLC;
    @Column(name="franquiaFX", nullable = false, length = 20)
    private String franquiaFX;
    @Column(name="franquiaLED", nullable = false, length = 20)
    private String franquiaLED;
    @Column(name="franquiaEquip", nullable = false, length = 20)
    private String franquiaEquip;
    
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @ForeignKey(name = "ClienteItem")
    @JoinColumn(name = "clienteFK")
    private Cliente cliente;
    
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @ForeignKey(name = "SeguroItem")
    @JoinColumn(name = "seguroFK")
    private Seguro seguro;
    
    public Movel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getAnoFab() {
        return anoFab;
    }

    public void setAnoFab(String anoFab) {
        this.anoFab = anoFab;
    }

    public String getAnoModelo() {
        return anoModelo;
    }

    public void setAnoModelo(String anoModelo) {
        this.anoModelo = anoModelo;
    }

    public String getChassi() {
        return chassi;
    }

    public void setChassi(String chassi) {
        this.chassi = chassi;
    }

    public Integer getNumeroPassageiros() {
        return numeroPassageiros;
    }

    public void setNumeroPassageiros(Integer numeroPassageiros) {
        this.numeroPassageiros = numeroPassageiros;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getValorFIPE() {
        return valorFIPE;
    }

    public void setValorFIPE(String valorFIPE) {
        this.valorFIPE = valorFIPE;
    }

    public String getPercFIPE() {
        return percFIPE;
    }

    public void setPercFIPE(String percFIPE) {
        this.percFIPE = percFIPE;
    }

    public String getFranquiaCasco() {
        return franquiaCasco;
    }

    public void setFranquiaCasco(String franquiaCasco) {
        this.franquiaCasco = franquiaCasco;
    }

    public String getFranquiaAcessorios() {
        return franquiaAcessorios;
    }

    public void setFranquiaAcessorios(String franquiaAcessorios) {
        this.franquiaAcessorios = franquiaAcessorios;
    }

    public String getFranquiaVPBT() {
        return franquiaVPBT;
    }

    public void setFranquiaVPBT(String franquiaVPBT) {
        this.franquiaVPBT = franquiaVPBT;
    }

    public String getFranquiaVL() {
        return franquiaVL;
    }

    public void setFranquiaVL(String franquiaVL) {
        this.franquiaVL = franquiaVL;
    }

    public String getFranquiaRet() {
        return franquiaRet;
    }

    public void setFranquiaRet(String franquiaRet) {
        this.franquiaRet = franquiaRet;
    }

    public String getFranquiaFLC() {
        return franquiaFLC;
    }

    public void setFranquiaFLC(String franquiaFLC) {
        this.franquiaFLC = franquiaFLC;
    }

    public String getFranquiaFX() {
        return franquiaFX;
    }

    public void setFranquiaFX(String franquiaFX) {
        this.franquiaFX = franquiaFX;
    }

    public String getFranquiaLED() {
        return franquiaLED;
    }

    public void setFranquiaLED(String franquiaLED) {
        this.franquiaLED = franquiaLED;
    }

    public String getFranquiaEquip() {
        return franquiaEquip;
    }

    public void setFranquiaEquip(String franquiaEquip) {
        this.franquiaEquip = franquiaEquip;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movel other = (Movel) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
