/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

Sobre os parâmetros da anotação @OneToOne:

“cascade” – define ações automatizadas no relacionamento, ex.: Ao apagar um Customer, apagar também um Usuário. Veremos sobre “cascade” em um post futuro.
“optional” – você não será obrigado a ter um User ao persistir um Customer, ou seja, você não tem que criar um usuário para satisfazer essa condição (você poderá buscar o Customer no banco de dados, mas Customer.getUser() terá null como resposta). Com o valor igual a false, ao se cadastrar um Customer, é obrigatória a presença de um User. Pode ser um User recém ainda não persistido.
“fetch” – o valor padrão é EAGER. Ou seja, ao carregar o Customer já será feita a consulta relacionada ao User de modo automático. Iremos ver sobre esse assunto em um post futuro.
“orphanRemoval” – define que uma entidade dependente, caso não tenha relacionamento, será removida do banco de dados (em nosso modelo, User depende de Customer). Caso exista um User sem Customer, esse user será removido.
Existem também duas anotações sendo que uma delas está comentada:

// @JoinColumn(name=”USER_ID”, nullable=false) – define qual é a coluna mapeada para fazer a união na consulta. É indicado o nome da coluna através do parâmetro “name” e que esse campo não pode ser nulo pelo parâmetro “nullable”.
@PrimaryKeyJoinColumn – essa anotação indica ao JPA que, para encontrar um objeto User basta procurar um registro com o mesmo ID do Customer. Ou seja, indica que um User vai ter o mesmo ID que seu Customer.

 */
package Model;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tabela de identificação das condições de secagem. Relaciona-se à tabela
 * Fruto
 *
 * @author Sara Fernandes
 */
@Entity
@Table(name = "tblCondicao")
public class Condicao implements Serializable {
   /**
     * Chave primária da entidade <code>Fruto</code>. O valor gerado pelo banco
     * de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@FieldColumn(labelValue = "id", width = 50)
    @Column(name = "CONDICAOID")
    private Integer idCondicao;
    
//    @Column(name = "FrutoID")
//    @OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
//    // @JoinColumn(name="USER_ID", nullable=false)
//    @PrimaryKeyJoinColumn
//    private Fruto fruto;
    
    @Column(name = "UR")
    @NotNull
    private double ur;// Umidade relativa do Ar
    //Atributos para Condições de Secagem
    @Column(name = "Date_Hora")//precisa  estudar um pouco de sql .....Então o eero esta no SQL? voce colocou um '&' no nome da coluna hibernate não faz milagre = huahuahua :P
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataEhoraDaSimulacao;
    
    @Column(name = "TempFruto")
    @NotNull
    private int tempeFruto;
        
    @Column(name = "TempSgm")
    @NotNull
    private int tempeSgm;
    
    @Column(name = "NumCamadas")
    private int numCamadas;
    
    @Column(name = "PAtm")
    @NotNull
    private double pAtm;
    
    @Column(name = "TeorAgua")
    @NotNull
    private double teorAgua;
    
    @Column(name = "TeorAguaInl")
    @NotNull
    private double tAguaInl;
    
//    @Column(name = "TeorAguaEqui")
//    @NotNull
//    private double tAguaEqui;
    
    @Column(name = "TeorAguaFnl")
    @NotNull
    private double tAguaFnl;
    
    @Column(name = "FxoArSgm")
    @NotNull
    private double fxoArSgm;
    
    @Column(name = "AltCmdFruto")
    private double altCmdFruto;
    
    @Column(name = "IntTempo")// INTERVALO DE TEMPO
    private int intTempo;
    
    @Column(name = "VolEspAr")
    @NotNull
    private double volEspAr;

    public Condicao() {
        this.dataEhoraDaSimulacao = new Date();
    }

    public Condicao(Integer idCondicao, double ur,int tempeFruto, int tempeSgm, int numCamadas,
                    double pAtm,double teorAgua, double tAguaInl,double tAguaFnl,double fxoArSgm,
                    double altCmdFruto,int intTempo, double volEspAr) {

        this.idCondicao = idCondicao;
        this.ur = ur;
        this.tempeFruto = tempeFruto;
        this.tempeSgm = tempeSgm;
        this.numCamadas = numCamadas;
        this.pAtm = pAtm;
        this.teorAgua =teorAgua;
        this.tAguaInl = tAguaInl;
        //this.tAguaEqui = tAguaEqui;
        this.tAguaFnl = tAguaFnl;
        this.fxoArSgm = fxoArSgm;
        this.altCmdFruto = altCmdFruto;
        this.intTempo = intTempo;
        this.volEspAr = volEspAr;


    }



    public Integer getIdCondicao() {
        return idCondicao;
    }

    public void setIdCondicao(Integer idCondicao) {
        this.idCondicao = idCondicao;
    }

    public Date getDataEhoraDaSimulacao() {
        return dataEhoraDaSimulacao;
    }

    public void setDataEhoraDaSimulacao(Date dataEhoraDaSimulacao) {
        this.dataEhoraDaSimulacao = dataEhoraDaSimulacao;
    }

    public int getTempeFruto() {
        return tempeFruto;
    }

    public void setTempeFruto(int tempeFruto) {
        this.tempeFruto = tempeFruto;
    }

    public int getTempeSgm() {
        return tempeSgm;
    }

    public void setTempeSgm(int tempeSgm) {
        this.tempeSgm = tempeSgm;
    }


    public double getpAtm() {
        return pAtm;
    }

    public void setpAtm(double pAtm) {
        this.pAtm = pAtm;
    }

    public double gettAguaInl() {
        return tAguaInl;
    }

    public void settAguaInl(double tAguaInl) {
        this.tAguaInl = tAguaInl;
    }

    public double gettAguaFnl() {
        return tAguaFnl;
    }

    public void settAguaFnl(double tAguaFnl) {
        this.tAguaFnl = tAguaFnl;
    }

    public double getFxoArSgm() {
        return fxoArSgm;
    }

    public void setFxoArSgm(double fxoArSgm) {
        this.fxoArSgm = fxoArSgm;
    }

    public double getAltCmdFruto() {
        return altCmdFruto;
    }

    public void setAltCmdFruto(double altCmdFruto) {
        this.altCmdFruto = altCmdFruto;
    }

    public int getIntTempo() {
        return intTempo;
    }

    public void setIntTempo(int intTempo) {
        this.intTempo = intTempo;
    }

    public double getVolEspAr() {
        return volEspAr;
    }

    public void setVolEspAr(double volEspAr) {
        this.volEspAr = volEspAr;
    }

    public int getNumCamadas() {
        return numCamadas;
    }

    public void setNumCamadas(int numCamadas) {
        this.numCamadas = numCamadas;
    }


    public double getUr() {
        return ur;
    }

    public void setUr(double ur) {
        this.ur = ur;
    }

    public double getteorAgua() {
        return teorAgua;
    }

    public void settAgua(double teorAgua) {
        this.teorAgua = teorAgua;
    }
//
//    public double gettAguaEqui() {
//        return tAguaEqui;
//    }
//
//    public void settAguaEqui(double tAguaEqui) {
//        this.tAguaEqui = tAguaEqui;
//    }
    
//    public double razaoTeorAqua(){//tratar com try, caso o retorno seja null
//
//        double rx;
//
////        rx = (this.teorAgua - this.tAguaEqui)/(this.tAguaInl - this.tAguaEqui);
////        return rx;
//        rx = (this.teorAgua - this.tAguaEqui)/(this.tAguaInl - this.tAguaEqui);
//        return rx;
//
//
//    }


    public double teorAqua(){
        double ta;

        ta= this.tAguaFnl - this.tAguaInl;
        return ta;

    }
    

}
