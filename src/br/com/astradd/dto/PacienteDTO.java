package br.com.astradd.dto;

/**
 * Essa classe contém os métodos para manipular os atributos de Paciente
 * Projeto AstraDD
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class PacienteDTO {
    private String nome_p;
    private int cod_pac;
    
    /**
     * Retorna o nome do paciente 
     * @return nome_p String contendo o nome do paciente
     */
    public String getNome_p() {
        return nome_p;
    }
    
    /**
     * Recebe o nome do paciente
     * @param nome_p, do paciente
     */
    public void setNome_p(String nome_p) {
        this.nome_p = nome_p;
    }
    
    /**
     * Retorna o código do paciente
     * @return cod_pac inteiro contendo ome do clinte
     */
    public int getCod_pac() {
        return cod_pac;
    }
    
    /**
     * Recebe o código do Paciente
     * @param cod_pac, do paciente 
     */
    public void setCod_pac(int cod_pac) {
        this.cod_pac = cod_pac;
    }
    
    
}
