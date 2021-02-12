package br.com.astradd.dto;

/**
 * Essa classe contém os métodos para manipular os atributos de Funcionario
 * Projeto AstraDD
 *
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class FuncionarioDTO {

    private String nome_f, tel_f, cargo_bio, especializacao_med, endereco, rg, cpf, cep, data_nasc,crm;
    private int cod_fun, cod_log;

    /**
     * Retorna o endereço do funcionario
     *
     * @return endereco String contendo endereço do funcionario
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Recebe o endereco do funcionario
     *
     * @param endereco, do funcionario
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o rg do funcionario
     *
     * @return rg String contendo rg do funcionario
     */
    public String getRg() {
        return rg;
    }

    /**
     * Recebe o rg do funcionario
     *
     * @param rg, do funcionario
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Retorna o cpf do funcionario
     *
     * @return cpf String contendo rg do funcionario
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Recebe o cpf do funcionario
     *
     * @param cpf, do funcionario
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o cep do funcionario
     *
     * @return cep String contendo rg do funcionario
     */
    public String getCep() {
        return cep;
    }

    /**
     * Recebe o cep do funcionario
     *
     * @param cep, do funcionario
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Retorna o nome do funcionario
     *
     * @return nome_f String contendo nome do funcionario
     */
    public String getNome_f() {
        return nome_f;
    }

    /**
     * Recebe o nome do funcionario
     *
     * @param nome_f, do funcionario
     */
    public void setNome_f(String nome_f) {
        this.nome_f = nome_f;
    }

    /**
     * Retorna o numero do telefone do funcionario
     *
     * @return tel_f string contendo o telefone do funcionario
     */
    public String getTel_f() {
        return tel_f;
    }

    /**
     * Recebe o numero do telefone do funcionario
     *
     * @param tel_f, do telefone
     */
    public void setTel_f(String tel_f) {
        this.tel_f = tel_f;
    }

    /**
     * Retorna o codigo do funcionario
     *
     * @return cod_fun inteiro contendo o código do funcionario
     */
    public int getCod_fun() {
        return cod_fun;
    }

    /**
     * Recebe o código do funcionario
     *
     * @param cod_fun,do funcionario
     */
    public void setCod_fun(int cod_fun) {
        this.cod_fun = cod_fun;
    }

    /**
     * Retorna o CRM do funcionario
     *
     * @return crm inteiro contendo CRM do funcionario
     */
    public String getCrm() {
        return crm;
    }

    /**
     * Recebe o CRM do funcionario
     *
     * @param crm, CRM do funcionario
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * Retorna o código do login
     *
     * @return cod_log inteiro contendo o código do login
     */
    public int getCod_log() {
        return cod_log;
    }

    /**
     * Recebe o código do login
     *
     * @param cod_log, código do login
     */
    public void setCod_log(int cod_log) {
        this.cod_log = cod_log;
    }

    /**
     * Retorna a data de nascimento do funcionoario
     *
     * @return data_nasc string contendo a data de nascimento
     */
    public String getData_nasc() {
        return data_nasc;
    }

    /**
     * Recebe a data de nascimento do funcionario
     *
     * @param data_nasc, data nascimento
     */
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

}
