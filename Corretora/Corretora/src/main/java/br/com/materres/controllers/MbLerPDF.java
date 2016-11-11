package br.com.materres.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped

public class MbLerPDF {
    private UploadedFile arquivo;
    
    public UploadedFile getArquivo() {
        return arquivo;
    }
    
    public void setArquivo(UploadedFile arquivo) {
        this.arquivo = arquivo;
    }
    
    public void fileUploadTratamento(FileUploadEvent e) {
        this.arquivo = e.getFile();
        
        System.out.println("PASSEI AQUI");
        
        if (arquivo != null) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", 
                            arquivo.getFileName() + " foi carregado."));
        }else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Erro!"));
        }
    }
    
    public void fileUploadCopia() throws IOException {
        InputStream entrada = null;
        OutputStream saida = null;
        
        try {
            String nomeTemp = "tmp_";
            String nomeArquivo = arquivo.getFileName();
            nomeTemp = nomeTemp.concat(nomeArquivo);
            System.out.println("Nome do arquivo final: " + nomeTemp);
            
            entrada = arquivo.getInputstream();
            saida = new FileOutputStream(new File("C:/apolice/", nomeArquivo));
            
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = entrada.read(bytes)) != -1) {                
                saida.write(bytes, 0, read);
            }
            System.out.println("Feito.");
            
        } catch (IOException e) {
//            FacesContext.getCurrentInstance().addMessage(null, 
//                new FacesMessage(FacesMessage.SEVERITY_ERROR, 
//                        "Nenhum arquivo foi carregado."));
            e.printStackTrace();
        } finally {
            if (entrada != null) {
                try {
                    entrada.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (saida != null) {
                try {
                    saida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }       
    }
}
