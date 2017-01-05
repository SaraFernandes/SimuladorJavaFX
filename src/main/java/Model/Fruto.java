/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import algoritmos.ThompsonCal;
import com.sun.istack.internal.NotNull;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import Enum.EquacoesTeorUm;
import Enum.EquacoesCamadaFina;

/**
 * Tabela de identificação de produto, coeficientes e modelos a serem utilizados
 * pelo PROGRAMA COMPUTACIONAL DE SIMULAÇÃO DA TRANSFERÊNCIA DE CALOR E MASSA DE
 * FRUTOS DO CERRADO
 *
 * <p>
 * O <code>Fruto</code> é um objeto persistido no banco de dados, por isso a
 * classificamos como <strong>Entidade</strong>.</p>
 *
 * <p>
 * As funcionalidades desse sistema demonstração são concentradas no cadastro
 * (CRUD) de frutos.</p>
 *
 * @author Sara Fernandes
 */
@Entity
@Table(name = "tblFruto")
public class Fruto implements Serializable {

    /**
     * Chave primária da entidade <code>Fruto</code>. O valor gerado pelo banco
     * de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@FieldColumn(labelValue = "id", width = 50)
    @Column(name = "FRUTOID")
    private Integer idFruto;


    @OneToOne(cascade=CascadeType.ALL)
     Condicao condicao = new Condicao();
    //private Condicao condicao;

    @Column(name = "FRUTO")
    @NotNull
    private String fruto;
    @Column(name = "R1")
    @NotNull
    private double r1;// Razão de Conversão
    @Column(name = "Cp1")
    @NotNull
    private double cp1;// Calor específico
    @Column(name = "Cp2")
    @NotNull
    private double cp2;// Calor específico
    @Column(name = "HFG1")
    @NotNull
    private double hfg1;
    @Column(name = "HFG2")
    @NotNull
    private double hfg2;
    @Column(name = "HFG3")
    @NotNull
    private double hfg3;
    @Column(name = "HFG4")
    @NotNull
    private double hfg4;// Calor latente

    @Column(name = "EqUMD")
    //private String xe;
    private EquacoesTeorUm eqTeorUmi;

    @Column(name = "EqCamFina")
    private EquacoesCamadaFina eqCamFina;


    /* Coeficientes a serem utilizados pe Equação de Teor de Áqua de Equilibrio (Thompson, Cavalcanti Mata, Hederson, Oswin)*/
    private double xe1;
    private double xe2;
    private double xe3;
    private double xe4;
    private double xe5;

    /* Coeficientes a serem utilizados nas Equações encadeada utilizadas nas equaçoes de tempo equivalente e, em sequancia na equação de Camada Fina*/
    private double a1;
    private double a2;
    private double a3;
    private double a4;
    private double a5;
    private double a6;
    private double a7;
    private double a8;

    private double b1;
    private double b2;
    private double b3;
    private double b4;
    private double b5;
    private double b6;
    private double b7;
    private double b8;

//    @OneToOne
//    @JoinColumn(name = " mod_id ")
//    private Modelos modelo;
    // private Equacoes equacoes;
    public Fruto() {
    }

    //Esse método formata o nome corretamente
    private String setName(String n) {

        n = n.toLowerCase();
        n = n.substring(0, 1).toUpperCase() + n.substring(1);
        return n;
    }

    public Fruto(Integer idFruto, String fruto, double r1, double cp1, double cp2,
            double hfg1, double hfg2, double hfg3, double hfg4, String xe,
            double a1, double a2, double a3, double a4, double a5, double a6, double a7, double a8,
            double b1, double b2, double b3, double b4, double b5, double b6, double b7, double b8,
            double xe1, double xe2, double xe3, double xe4, double xe5) {

        this.idFruto = idFruto;
        this.fruto = fruto;
        this.r1 = r1;
        this.cp1 = cp1;
        this.cp2 = cp2;
        this.hfg1 = hfg1;
        this.hfg2 = hfg2;
        this.hfg3 = hfg3;
        this.hfg4 = hfg4;

        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.a5 = a5;
        this.a6 = a6;
        this.a7 = a7;
        this.a8 = a8;

        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.b5 = b5;
        this.b6 = b6;
        this.b7 = b7;
        this.b8 = b8;

        this.xe1 = xe1;
        this.xe2 = xe2;
        this.xe3 = xe3;
        this.xe4 = xe4;
        this.xe5 = xe5;

    }

    public Integer getIdFruto() {
        return idFruto;

    }

    public void setIdFruto(Integer idFruto) {
        this.idFruto = idFruto;
    }

    public String getFruto() {
        return fruto;
    }

    public void setFruto(String fruto) {
        this.fruto = fruto;
    }

    public double getR1() {
        return r1;
    }

    public void setR1(double r1) {
        this.r1 = r1;
    }

    public double getCp1() {return cp1;}

    public void setCp1(double cp1) {
        this.cp1 = cp1;
    }

    public double getCp2() {return cp2;}

    public void setCp2(double cp2) {
        this.cp2 = cp2;
    }

    public double getHfg1() {
        return hfg1;
    }

    public void setHfg1(double hfg1) {
        this.hfg1 = hfg1;
    }

    public double getHfg2() {
        return hfg2;
    }

    public void setHfg2(double hfg2) {
        this.hfg2 = hfg2;
    }

    public double getHfg3() {
        return hfg3;
    }

    public void setHfg3(double hfg3) {
        this.hfg3 = hfg3;
    }

    public double getHfg4() {
        return hfg4;
    }

    public void setHfg4(double hfg4) {
        this.hfg4 = hfg4;
    }

    public EquacoesTeorUm getEqTeorUmi() {
        return eqTeorUmi;
    }

    public void setEqTeorUmi(EquacoesTeorUm eqTeorUmi) {
        this.eqTeorUmi = eqTeorUmi;
    }

    public EquacoesCamadaFina getEqCamFina() {return eqCamFina;}

    public void setEqCamFina(EquacoesCamadaFina eqCamFina) {this.eqCamFina = eqCamFina;}

    //    public String getXe() {
//        return xe;
//    }
//
//    public void setXe(String xe) {
//        this.xe = xe;
//    }

//    public Modelos getModelo() {
//        return modelo;
//    }
//
//    public void setModelo(Modelos modelo) {
//        this.modelo = modelo;
//    }
    public double getA1() {
        return a1;
    }

    public void setA1(double a1) {
        this.a1 = a1;
    }

    public double getA2() {
        return a2;
    }

    public void setA2(double a2) {
        this.a2 = a2;
    }

    public double getA3() {
        return a3;
    }

    public void setA3(double a3) {
        this.a3 = a3;
    }

    public double getA4() {
        return a4;
    }

    public void setA4(double a4) {
        this.a4 = a4;
    }

    public double getA5() {
        return a5;
    }

    public void setA5(double a5) {
        this.a5 = a5;
    }

    public double getA6() {
        return a6;
    }

    public void setA6(double a6) {
        this.a6 = a6;
    }

    public double getA7() {
        return a7;
    }

    public void setA7(double a7) {
        this.a7 = a7;
    }

    public double getA8() {
        return a8;
    }

    public void setA8(double a8) {
        this.a8 = a8;
    }

    public double getB1() {
        return b1;
    }

    public void setB1(double b1) {
        this.b1 = b1;
    }

    public double getB2() {
        return b2;
    }

    public void setB2(double b2) {
        this.b2 = b2;
    }

    public double getB3() {
        return b3;
    }

    public void setB3(double b3) {
        this.b3 = b3;
    }

    public double getB4() {
        return b4;
    }

    public void setB4(double b4) {
        this.b4 = b4;
    }

    public double getB5() {
        return b5;
    }

    public void setB5(double b5) {
        this.b5 = b5;
    }

    public double getB6() {
        return b6;
    }

    public void setB6(double b6) {
        this.b6 = b6;
    }

    public double getB7() {
        return b7;
    }

    public void setB7(double b7) {
        this.b7 = b7;
    }

    public double getB8() {
        return b8;
    }

    public void setB8(double b8) {
        this.b8 = b8;
    }

    public double getXe1() {
        return xe1;
    }

    public void setXe1(double xe1) {
        this.xe1 = xe1;
    }

    public double getXe2() {
        return xe2;
    }

    public void setXe2(double xe2) {
        this.xe2 = xe2;
    }

    public double getXe3() {
        return xe3;
    }

    public void setXe3(double xe3) {
        this.xe3 = xe3;
    }

    public double getXe4() {
        return xe4;
    }

    public void setXe4(double xe4) {
        this.xe4 = xe4;
    }

    public double getXe5() {
        return xe5;
    }

    public void setXe5(double xe5) {
        this.xe5 = xe5;
    }

    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }



    public boolean eIgual(Object object) {
        //TODO: Atenção - este método não funciona no caso os campos de identificação não são definidos
        if (!(object instanceof Fruto)) {
            return false;
        }
        Fruto other = (Fruto) object;
        if ((this.idFruto == null && other.idFruto != null) || (this.idFruto != null && !this.idFruto.equals(other.idFruto))) {
            return false;
        }
        return true;
    }





}
