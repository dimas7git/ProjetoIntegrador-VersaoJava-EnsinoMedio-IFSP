package br.com.astradd.dto;

/**
 * Essa classe contém os métodos para manipular os atributos de Login Projeto
 * AstraDD
 *
 * @Author Darryê Roberto da S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class LoginDTO {

    private int cod_log, cod_fun;
    public static int p_login;
    public static String control_user;
    private String tp_usuario, senha, nome_login;

    /**
     * Retorna o codigo do funcionario
     *
     * @return cod_fun inteiro contendo o codigo do funcionario
     */
    public int getCod_fun() {
        return cod_fun;
    }

    /**
     * recebe o codigo do funcionario
     * @param cod_fun, do funcionario
     */
    public void setCod_fun(int cod_fun) {
        this.cod_fun = cod_fun;
    }

    /**
     * Retorna o código de ligação com um usuário específico
     *
     * @return cod_log inteiro contendo o código
     */
    public int getCod_log() {
        return cod_log;
    }

    /**
     * recebe o código do usuário
     *
     * @param cod_log, do usuário
     */
    public void setCod_log(int cod_log) {
        this.cod_log = cod_log;
    }

    /**
     * retorna o tipo de usuário
     *
     * @return tp_usuario String contendo o tipo de usuário
     */
    public String getTp_usuario() {
        return tp_usuario;
    }

    /**
     * recebe o tipo de usuário
     *
     * @param tp_usuario, do usuário
     */
    public void setTp_usuario(String tp_usuario) {
        this.tp_usuario = tp_usuario;
    }

    /**
     * retorna a senha do usuário
     *
     * @return senha, uma String contendo a senha do usuario
     */
    public String getSenha() {
        return senha;
    }

    /**
     * recebe a senha do usuário
     *
     * @param senha, do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * retorna o nome de login
     *
     * @return nome do login, uma String contendo o nome do login
     */
    public String getNome_login() {
        return nome_login;
    }

    /**
     * recebe o nome de login
     *
     * @param nome_login, nome do login
     */
    public void setNome_login(String nome_login) {
        this.nome_login = nome_login;
    }

//    public int getP_login() {
//        return p_login;
//    }
//
//    public void setP_login(int p_login) {
//        this.p_login = p_login;
//    }


}
