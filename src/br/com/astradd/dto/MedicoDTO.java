package br.com.astradd.dto;

/**
 * Essa classe contém os métodos para manipular os atributos de Medicos
 * Projeto AstraDD
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class MedicoDTO extends FuncionarioDTO{
    private String especializacao_med;

    /**
     * Retorna a especialização do médico
     * @return especializacao_med string contendo a especialização do médico
     */
    public String getEspecializacao_med() {
        return especializacao_med;
    }

    /**
     * Recebe a especialização do médico
     * @param especializacao_med, da especialização do médico
     */
    public void setEspecializacao_med(String especializacao_med) {
        this.especializacao_med = especializacao_med;
    }
}
