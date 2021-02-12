package br.com.astradd.dto;

/**
 * Essa classe contém os metodos para manipulação dos atributos de tipo de exame
 * Projeto AstraDD
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class Tipo_do_exameDTO {
    private String nome_ex,qtd_amostra,material_analise;
    private int cod_tp_ex;

    /**
     * Retorna nome do exame
     * @return nome_ex String contendo nome do exame
     */
    public String getNome_ex() {
        return nome_ex;
    }

    /**
     * Recebe o nome do exame 
     * @param nome_ex, nome do exame 
     */
    public void setNome_ex(String nome_ex) {
        this.nome_ex = nome_ex;
    }

    /**
     * Retorna a quantidade de amostra a ser analisada
     * @return qtd_amostra String contendo a quantidade de amostra a ser analisada
     */
    public String getQtd_amostra() {
        return qtd_amostra;
    }

    /**
     * Recebe a quantidade de amostra a ser analisada
     * @param qtd_amostra, quantidade de amostra a ser analisada 
     */
    public void setQtd_amostra(String qtd_amostra) {
        this.qtd_amostra = qtd_amostra;
    }

    /**
     * Retorna o material a ser analisado
     * @return material_analise String contendo o material a ser analisado
     */
    public String getMaterial_analise() {
        return material_analise;
    }

    /**
     * Recebe o material a ser analisado
     * @param material_analise, material a ser analisado 
     */
    public void setMaterial_analise(String material_analise) {
        this.material_analise = material_analise;
    }

    /**
     * Retorna código do tipo do exame
     * @return cod_tp_ex Inteiro contendo o código do tipo do exame 
     */
    public int getCod_tp_ex() {
        return cod_tp_ex;
    }

    /**
     * Recebe o codigo do tipo do exame
     * @param cod_tp_ex, codigo do tipo do exame 
     */
    public void setCod_tp_ex(int cod_tp_ex) {
        this.cod_tp_ex = cod_tp_ex;
    }
    
}
