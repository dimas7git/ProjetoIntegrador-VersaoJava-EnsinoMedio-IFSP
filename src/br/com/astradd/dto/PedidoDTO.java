package br.com.astradd.dto;

/**
 * Essa classe contém os metodos para manipular os atributo de pedido
 *Projeto AstraDD
 * @author Darryê Roberto S. Mellin/Dimas de Lima Ferreira
 * @version 1.0
 */
public class PedidoDTO {

    private int  cod_ped,  cod_pac;
;
    private String bio_resp,conf_receb_ped,cod_fun,cod_tp_ex,obs_ped,laudo,medico,data_ped;

    /**
     * Retorna a data do pedido
     * @return datas_ped inteiro contendo a data do pedido
     */
   

    /**
     * Retorna o código do pedido
     * @return cod_ped inteiro contendo o código do pedido
     */
    public int getCod_ped() {
        return cod_ped;
    }

    /**
     * Recebe o código do pedido 
     * @param cod_ped, o código do pedido 
     */
    public void setCod_ped(int cod_ped) {
        this.cod_ped = cod_ped;
    }

    /**
     * Retorna o biomédico responsável 
     * @return bio_resp string contendo o biomédico responsável
     */
    public String getBio_resp() {
        return bio_resp;
    }

    /**
     * Recebe o biomédico responsável pelo pedido
     * @param bio_resp, biomédico responsável pelo pedido 
     */
    public void setBio_resp(String bio_resp) {
        this.bio_resp = bio_resp;
    }

    /**
     * Retorna a confirmação do recebimento do pedido
     * @return conf_receb_ped string contendo a confirmação do recebimento do pedido
     */
    public String getConf_receb_ped() {
        return conf_receb_ped;
    }

    /**
     * Recebe a confirmação de recebimento do pedido
     * @param conf_receb_ped, confirmação de recebimento do pedido 
     */
    public void setConf_receb_ped(String conf_receb_ped) {
        this.conf_receb_ped = conf_receb_ped;
    }
    /**
     * Retorna o codigo do funcionario
     * @return cod_fun int contendo o codigo do funcionario
     */
    public String getCod_fun() {
        return cod_fun;
    }
    /**
     * Recebe o codigo do funcionario
     * @param cod_fun, codigo do funcionario
     */
    public void setCod_fun(String cod_fun) {
        this.cod_fun = cod_fun;
    }
    /**
     * Retorna o codigo do tipo de exame
     * @return cod_fun int contendo o codigo do tipo de exame
     */
    public String getCod_tp_ex() {
        return cod_tp_ex;
    }
    /**
     * Recebe o codigo do tipo de exame
     * @param cod_tp_ex, codigo do tipo de exame
     */
    public void setCod_tp_ex(String cod_tp_ex) {
        this.cod_tp_ex = cod_tp_ex;
    }
    /**
     * Retorna o codigo do paciente
     * @return cod_fun int contendo o codigo do paciente
     */
    public int getCod_pac() {
        return cod_pac;
    }
    /**
     * Recebe o codigo do paciente
     * @param cod_pac, codigo do paciente
     */
    public void setCod_pac(int cod_pac) {
        this.cod_pac = cod_pac;
    }
    
    /**
     * Retorna as observaçoes do pedido
     * @return cod_fun String contendo as observaçoes do pedido
     */
    public String getObs_ped() {
        return obs_ped;
    }
    /**
     * Recebe as observaçoes do pedido
     * @param obs_ped, obsevaçoes do pedido
     */
    public void setObs_ped(String obs_ped) {
        this.obs_ped = obs_ped;
    }
    /**
     * Retorna o laudo do pedido
     * @return laudo String contendo o laudo do pedido
     */
    public String getLaudo() {
        return laudo;
    }
    /**
     * Recebe o laudo do pedido
     * @param laudo, laudo do pedido
     */
    public void setLaudo(String laudo) {
        this.laudo = laudo;
    }
    /**
     * Retorna o codigo do medico do pedido
     * @return meddico int contendo o codigo do medico do pedido
     */
    public String getMedico() {
        return medico;
    }
    /**
     * Recebe o codigo do medico do pedido
     * @param medico, codigo do medico do pedido
     */
    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getData_ped() {
        return data_ped;
    }

    public void setData_ped(String data_ped) {
        this.data_ped = data_ped;
    }
    
}
