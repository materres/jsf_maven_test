package br.com.project1.model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="Endereco")

public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name="IdEndereco", nullable=false)
    private Integer idEndereco;
    @Column(name="Bairro", length=60, nullable=false)
    private String bairro;
    @Column(name="CEP", length=9, nullable=false)
    private String cep;
    @Column(name="Complemento", length=20, nullable=false)
    private String complemento;
    @Column(name="NomeLogradouro", length=80, nullable=false)
    private String nomeLogradouro;
    @Column(name="Numero", nullable=false)
    private Integer numero;
    
    @ManyToOne(optional=false)
    @ForeignKey(name="CidadeEndereco")
    private Cidade cidade;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="EstadoEndereco")
    private Estado estado;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="PessoaEndereco")
    private Pessoa pessoa;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="TipoEndereceoEndereco")
    private TipoEndereco tipoEndereco;
    
    @ManyToOne(optional = false)
    @ForeignKey(name="TipoLogradouroEndereco")
    private TipoLogradouro tipoLogradouro;
}
