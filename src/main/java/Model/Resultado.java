package Model;

import javax.persistence.*;
import java.io.Serializable;
import Enum.EquacoesTeorUm;
import algoritmos.ThompsonCal;

/**
 * Created by Sara Fernandes on 21/06/2015.
 */

@Entity
@Table(name = "tblSimulacao")
public class Resultado implements Serializable {
    /**
     * Chave primária da entidade <code>Fruto</code>. O valor gerado pelo banco
     * de dados.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@FieldColumn(labelValue = "id", width = 50)
    @Column(name = "SIMULACAOID")
    private Integer idSimulacao;


    @OneToOne(cascade=CascadeType.ALL)
    Fruto fruto = new Fruto();

    @Column(name = "Umidade_Equlibrio")
    private EquacoesTeorUm eqTeorUmi;// Já é o resultado em número

    @Column(name = "Camada_Fina")
    private EquacoesTeorUm cmdFina;// Já é o resultado em número




    public EquacoesTeorUm getEqTeorUmi() {
        return eqTeorUmi;
    }

    public void setEqTeorUmi(EquacoesTeorUm eqTeorUmi) {
        this.eqTeorUmi = eqTeorUmi;
    }

    public EquacoesTeorUm getCmdFina() {
        return cmdFina;
    }

    public void setCmdFina(EquacoesTeorUm cmdFina) {
        this.cmdFina = cmdFina;
    }

    public Fruto getFruto() {
        return fruto;
    }

    public void setFruto(Fruto fruto) {
        this.fruto = fruto;
    }

    public Integer getIdSimulacao() {
        return idSimulacao;
    }

    public void setIdSimulacao(Integer idSimulacao) {
        this.idSimulacao = idSimulacao;
    }
}
