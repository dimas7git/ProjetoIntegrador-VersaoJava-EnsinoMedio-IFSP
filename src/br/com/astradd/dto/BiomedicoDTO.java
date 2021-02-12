package br.com.astradd.dto;

/**
 * Essa classe contém os métodos para manipular os atributos de Biomedicos
 * Projeto AstraDD
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class BiomedicoDTO extends FuncionarioDTO {
    private String cargo_bio;
    private int cod_fun;
    /**
     * Retorna o cargo do biomedico
     * @return cargo_bio string contendo o cardo do biomedico
     */
    public String getCargo_bio() {
        return cargo_bio;
    }

    /**
     * Recebe o cargo do biomedico
     * @param cargo_bio, do cargo do biomedico
     */
    public void setCargo_bio(String cargo_bio) {
        this.cargo_bio = cargo_bio;
    } 
    
}
