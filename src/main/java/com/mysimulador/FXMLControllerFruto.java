/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysimulador;

import Enum.CoeficienteA;
import Enum.CoeficienteB;
import Enum.EquacoesTeorUm;
import Enum.EquacoesCamadaFina;
import Model.Condicao;
import Model.Fruto;
import Service.CondicaoService;
import Service.FrutoService;
import Service.FrutoServiceInterface;
import Service.CondicaoServiceInterface;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import algoritmos.ThompsonCal;
import com.sun.org.apache.bcel.internal.generic.NEW;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.javafxtools.controller.GenericController;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import org.apache.derby.iapi.store.raw.Page;

import static java.lang.Math.log;
import static java.lang.Math.pow;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Sara Fernandes
 */
public class FXMLControllerFruto extends GenericController {

    private FrutoServiceInterface serviceFruit;
    private CondicaoServiceInterface serviceCond;
    private static final String CONST_PRODUTO_REQUER_NOME = "O nome do fruto é obrigatório";
    private static String menssagemErro;

    Fruto fruto = new Fruto();
    // Fruto fruto;

    ThompsonCal calculoThompson = new ThompsonCal(fruto);

    //Condicao condicao = new Condicao();
    Condicao condicao;
    TextField tfA1 = new TextField();
    TextField tfA2 = new TextField();
    TextField tfA3 = new TextField();
    TextField tfA4 = new TextField();
    TextField tfA5 = new TextField();
    TextField tfA6 = new TextField();
    TextField tfA7 = new TextField();
    TextField tfA8 = new TextField();

    TextField tfB1 = new TextField();
    TextField tfB2 = new TextField();
    TextField tfB3 = new TextField();
    TextField tfB4 = new TextField();
    TextField tfB5 = new TextField();
    TextField tfB6 = new TextField();
    TextField tfB7 = new TextField();
    TextField tfB8 = new TextField();

    @FXML
    private TextField tfNomeFruto, tfRconversao, tfCalorEs1, tfCalorEs2, tfCalorLat1, tfCalorLat2, tfCalorLat3, tfCalorLat4;
    @FXML
    private TextField tfTempeFruto, tfUmidRelativa, tfTAguaInl, tfPAtm, tfTempeSgm, tfTAguaFnl, tfIntTempo, tfTeorAgua, tfVolEspAr, tfFluxoArSgm, tfAltCmdFruto;
    @FXML
    private TextField tfXe1, tfXe2, tfXe3, tfXe4, tfXe5;
    private TableView tableview;

    //    @FXML
//    private TextField tfA1, tfA2, tfA3, tfA4, tfA5, tfA6, tfA7, tfA8, tfB1, tfB2, tfB3, tfB4, tfB5, tfB6, tfB7, tfB8;
    @FXML
    private Button buttonLimpar, buttonSalvar, buttonSimular;
    @FXML
    private ScrollPane sPanel, sPanelTabela;
    @FXML
    private ComboBox<EquacoesTeorUm> comboboxEqUm;
    @FXML
    private ComboBox<EquacoesCamadaFina> comboboxEqCamFina;
    @FXML
    private ComboBox<CoeficienteA> comboboxCoefA;
    @FXML
    private ComboBox<CoeficienteB> comboboxCoefB;

    @FXML
    private ComboBox<Integer> comboboxQuantCam;

    //ObservableList<String> list = FXCollections.observableArrayList();
    //    private void handleButtonAction(ActionEvent event) {
//       
//    }
    
   
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        serviceFruit = new FrutoService();
        serviceCond = new CondicaoService();
      

        buttonSalvar.setStyle(" -fx-background-color: \n"
                + "        #c3c4c4,\n"
                + "        linear-gradient(#d6d6d6 50%, white 100%),\n" + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,1;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        buttonSimular.setStyle(" -fx-background-color: \n"
                + "        #c3c4c4,\n"
                + "        linear-gradient(#d6d6d6 50%, white 100%),\n" + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,1;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
        buttonLimpar.setStyle(" -fx-background-color: \n"
                + "        #c3c4c4,\n"
                + "        linear-gradient(#d6d6d6 50%, white 100%),\n" + "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n"
                + "    -fx-background-radius: 30;\n"
                + "    -fx-background-insets: 0,1,1;\n"
                + "    -fx-text-fill: black;\n"
                + "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        ObservableList<Integer> options
                = FXCollections.observableArrayList(1, 2, 3);
        comboboxQuantCam.setItems(options);

        comboboxEqUm.getItems().addAll(EquacoesTeorUm.values());
        comboboxEqCamFina.getItems().addAll(EquacoesCamadaFina.values());

        comboboxCoefA.getItems().addAll(CoeficienteA.values());
        comboboxCoefB.getItems().addAll(CoeficienteB.values());

        comboboxEqUm.valueProperty().addListener(this::onSelect);
        comboboxEqCamFina.valueProperty().addListener(this::onSelect);

        comboboxCoefA.valueProperty().addListener(this::onSelect);
        comboboxCoefB.valueProperty().addListener(this::onSelect);

        comboboxCoefA.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                CoeficienteA a = (CoeficienteA) newValue;
                a.Exponencial.calcular(fruto);
                System.out.println("TSTETETE" + a);
                //a.Polinomial.calcular(fruto);
            }

        });

        tfA1.setMaxWidth(60);
        tfA2.setMaxWidth(60);
        tfA3.setMaxWidth(60);
        tfA4.setMaxWidth(60);
        tfA5.setMaxWidth(60);
        tfA6.setMaxWidth(60);
        tfA7.setMaxWidth(60);
        tfA8.setMaxWidth(60);
        tfB1.setMaxWidth(60);
        tfB2.setMaxWidth(60);
        tfB3.setMaxWidth(60);
        tfB4.setMaxWidth(60);
        tfB5.setMaxWidth(60);
        tfB6.setMaxWidth(60);
        tfB7.setMaxWidth(60);
        tfB8.setMaxWidth(60);
    }

    /**
     * Aqui que acontece o evento de criar um TextField.
     *
     *
     */
    public void onSelect(ObservableValue observable, Object oldValue, Object newValue) {

        if (comboboxEqUm.getValue() != null && comboboxCoefA.getValue() != null && comboboxCoefB.getValue() != null) {
            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);

            gridPane.setPadding(new Insets(50, 50, 50, 50));
            gridPane.setHgap(10);
            gridPane.setVgap(10);

//            Text scenetitle = new Text("Welcome");
//            scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 10));
//            gridPane.add(scenetitle, 0, 0, 2, 1);
            gridPane.add(new Label("A1: "), 0, 0);
            gridPane.add(tfA1, 1, 0);
            gridPane.add(new Label("A2: "), 0, 1);
            gridPane.add(tfA2, 1, 1);
            gridPane.add(new Label("A3: "), 0, 2);
            gridPane.add(tfA3, 1, 2);
            gridPane.add(new Label("A4: "), 0, 3);
            gridPane.add(tfA4, 1, 3);
            gridPane.add(new Label("A5: "), 0, 4);
            gridPane.add(tfA5, 1, 4);
            gridPane.add(new Label("A6: "), 0, 5);
            gridPane.add(tfA6, 1, 5);
            gridPane.add(new Label("A7: "), 0, 6);
            gridPane.add(tfA7, 1, 6);
            gridPane.add(new Label("A8: "), 0, 7);
            gridPane.add(tfA8, 1, 7);

            gridPane.add(new Label(), 1, 0);
            gridPane.add(tfB1, 2, 0);
            gridPane.add(new Label(), 1, 1);
            gridPane.add(tfB2, 2, 1);
            gridPane.add(new Label(), 1, 2);
            gridPane.add(tfB3, 2, 2);
            gridPane.add(new Label(), 1, 3);
            gridPane.add(tfB4, 2, 3);
            gridPane.add(new Label(), 1, 4);
            gridPane.add(tfB5, 2, 4);
            gridPane.add(new Label(), 1, 5);
            gridPane.add(tfB6, 2, 5);
            gridPane.add(new Label(), 1, 6);
            gridPane.add(tfB7, 2, 6);
            gridPane.add(new Label(), 1, 7);
            gridPane.add(tfB8, 2, 7);

            sPanel.setContent(gridPane);
        }
    }

    //    public void tabelaDinamica() {
//        try {
//            /**
//             * ********************************
//             *
//             * TABLE COLUMN ADDED DYNAMICALLY *
//             *
//             *********************************
//             */
//
//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//
//                //We are using non property style for making dynamic table
//                final int j = i;
//
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//
//                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//
//                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
//
//                        return new SimpleStringProperty(param.getValue().get(j).toString());
//
//                    }
//
//                });
//                tableview.getColumns().addAll(col);
//                System.out.println("Column [" + i + "] ");
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }
//
//    }
    @FXML
    public void btLimparAction(ActionEvent evt) {

        tfNomeFruto.setText("");
        tfRconversao.setText("");
        tfCalorEs1.setText("");
        tfCalorEs2.setText("");
        tfCalorLat1.setText("");
        tfCalorLat2.setText("");
        tfCalorLat3.setText("");
        tfCalorLat4.setText("");
        tfXe1.setText("");
        tfXe2.setText("");
        tfXe3.setText("");
        tfXe4.setText("");
        tfXe5.setText("");

        tfTempeFruto.setText("");
        tfUmidRelativa.setText("");
        tfTAguaInl.setText("");
        tfPAtm.setText("");
        tfTempeSgm.setText("");
        tfTAguaFnl.setText("");
        tfIntTempo.setText("");
        // tfTAguaEqui.setText("");
        tfTeorAgua.setText("");
        tfVolEspAr.setText("");
        tfFluxoArSgm.setText("");
        tfAltCmdFruto.setText("");

        tfA1.setText("");
        tfA2.setText("");
        tfA3.setText("");
        tfA4.setText("");
        tfA5.setText("");
        tfA6.setText("");
        tfA7.setText("");
        tfA8.setText("");

        tfB1.setText("");
        tfB2.setText("");
        tfB3.setText("");
        tfB4.setText("");
        tfB5.setText("");
        tfB6.setText("");
        tfB7.setText("");
        tfB8.setText("");

    }

    public void setarCampos() {
        tfNomeFruto.setText(fruto.getFruto());
        tfRconversao.setText(Double.toString(fruto.getR1()));
        tfCalorEs1.setText(Double.toString(fruto.getCp1()));
        tfCalorEs2.setText(Double.toString(fruto.getCp2()));
        tfCalorLat1.setText(Double.toString(fruto.getHfg1()));
        tfCalorLat2.setText(Double.toString(fruto.getHfg2()));
        tfCalorLat3.setText(Double.toString(fruto.getHfg3()));
        tfCalorLat4.setText(Double.toString(fruto.getHfg4()));
        tfXe1.setText(Double.toString(fruto.getXe1()));
        tfXe2.setText(Double.toString(fruto.getXe2()));
        tfXe3.setText(Double.toString(fruto.getXe3()));
        tfXe4.setText(Double.toString(fruto.getXe4()));
        tfXe5.setText(Double.toString(fruto.getXe5()));

        tfTempeFruto.setText(Integer.toString(fruto.getCondicao().getTempeFruto()));
        tfUmidRelativa.setText(Double.toString(fruto.getCondicao().getUr()));
        tfTAguaInl.setText(Double.toString(fruto.getCondicao().gettAguaInl()));
        tfPAtm.setText(Double.toString(fruto.getCondicao().getpAtm()));
        tfTempeSgm.setText(Integer.toString(fruto.getCondicao().getTempeSgm()));
        tfTAguaFnl.setText(Double.toString(fruto.getCondicao().gettAguaFnl()));
        tfIntTempo.setText(Integer.toString(fruto.getCondicao().getIntTempo()));
        //tfTAguaEqui.setText(Double.toString(fruto.getCondicao().gettAguaEqui()));
        tfFluxoArSgm.setText(Double.toString(fruto.getCondicao().getFxoArSgm()));
        tfTeorAgua.setText(Double.toString(fruto.getCondicao().getteorAgua()));
        tfVolEspAr.setText(Double.toString(fruto.getCondicao().getVolEspAr()));
        tfAltCmdFruto.setText(Double.toString(fruto.getCondicao().getAltCmdFruto()));

        tfA1.setText(Double.toString(fruto.getA1()));
        tfA2.setText(Double.toString(fruto.getA2()));
        tfA3.setText(Double.toString(fruto.getA3()));
        tfA4.setText(Double.toString(fruto.getA4()));
        tfA5.setText(Double.toString(fruto.getA5()));
        tfA6.setText(Double.toString(fruto.getA6()));
        tfA7.setText(Double.toString(fruto.getA7()));
        tfA8.setText(Double.toString(fruto.getA8()));

        tfB1.setText(Double.toString(fruto.getB1()));
        tfB2.setText(Double.toString(fruto.getB2()));
        tfB3.setText(Double.toString(fruto.getB3()));
        tfB4.setText(Double.toString(fruto.getB4()));
        tfB5.setText(Double.toString(fruto.getB5()));
        tfB6.setText(Double.toString(fruto.getB6()));
        tfB7.setText(Double.toString(fruto.getB7()));
        tfB8.setText(Double.toString(fruto.getB8()));

//        comboboxAutor.getSelectionModel().select(fruto.getModelo());
    }

    public void getCampos() {
        //Parte pertencente ao produto
        fruto.setFruto(tfNomeFruto.getText());
        fruto.setR1(Double.parseDouble(tfRconversao.getText()));
        fruto.setCp1(Double.parseDouble(tfCalorEs1.getText()));
        fruto.setCp2(Double.parseDouble(tfCalorEs2.getText()));
        fruto.setHfg1(Double.parseDouble(tfCalorLat1.getText()));
        fruto.setHfg2(Double.parseDouble(tfCalorLat2.getText()));
        fruto.setHfg3(Double.parseDouble(tfCalorLat3.getText()));
        fruto.setHfg4(Double.parseDouble(tfCalorLat4.getText()));
        fruto.setXe1(Double.parseDouble(tfXe1.getText()));
        fruto.setXe2(Double.parseDouble(tfXe2.getText()));
        fruto.setXe3(Double.parseDouble(tfXe3.getText()));
        fruto.setXe4(Double.parseDouble(tfXe4.getText()));
        fruto.setXe5(Double.parseDouble(tfXe5.getText()));

        fruto.setEqTeorUmi(comboboxEqUm.getValue()); // Umidadde de Equilíbrio
        fruto.setEqCamFina(comboboxEqCamFina.getValue()); // Equação de Camada Fina

        // Parte das condições de secagem do produto
        System.out.println("DDDD" + tfTempeFruto.getText());
        fruto.getCondicao().setTempeFruto(Integer.parseInt(tfTempeFruto.getText()));
        fruto.getCondicao().setUr(Double.parseDouble(tfUmidRelativa.getText()));
        fruto.getCondicao().settAguaInl(Double.parseDouble(tfTAguaInl.getText()));
        fruto.getCondicao().setpAtm(Double.parseDouble(tfPAtm.getText()));
        fruto.getCondicao().setTempeSgm(Integer.parseInt(tfTempeSgm.getText()));
        fruto.getCondicao().settAguaFnl(Double.parseDouble(tfTAguaFnl.getText()));
        fruto.getCondicao().setIntTempo(Integer.parseInt(tfIntTempo.getText()));
        //fruto.getCondicao().settAguaEqui(Double.parseDouble(tfTAguaEqui.getText()));
        fruto.getCondicao().settAgua(Double.parseDouble(tfTeorAgua.getText()));
        fruto.getCondicao().setFxoArSgm(Double.parseDouble(tfFluxoArSgm.getText()));
        fruto.getCondicao().setVolEspAr(Double.parseDouble(tfVolEspAr.getText()));
        fruto.getCondicao().setNumCamadas(comboboxQuantCam.getValue());
        fruto.getCondicao().setAltCmdFruto(Double.parseDouble(tfAltCmdFruto.getText()));

        fruto.setA1(Double.parseDouble(tfA1.getText()));
        fruto.setA2(Double.parseDouble(tfA2.getText()));
        fruto.setA3(Double.parseDouble(tfA3.getText()));
        fruto.setA4(Double.parseDouble(tfA4.getText()));
        fruto.setA5(Double.parseDouble(tfA5.getText()));
        fruto.setA6(Double.parseDouble(tfA6.getText()));
        fruto.setA7(Double.parseDouble(tfA7.getText()));
        fruto.setA8(Double.parseDouble(tfA8.getText()));

        fruto.setB1(Double.parseDouble(tfB1.getText()));
        fruto.setB2(Double.parseDouble(tfB2.getText()));
        fruto.setB3(Double.parseDouble(tfB3.getText()));
        fruto.setB4(Double.parseDouble(tfB4.getText()));
        fruto.setB5(Double.parseDouble(tfB5.getText()));
        fruto.setB6(Double.parseDouble(tfB6.getText()));
        fruto.setB7(Double.parseDouble(tfB7.getText()));
        fruto.setB8(Double.parseDouble(tfB8.getText()));
        serviceCond.addCondicao(fruto.getCondicao());
        serviceFruit.addFruto(fruto);

        //liparCampos();
        // tfNomeFruto.setVisible(false);
    }

    @FXML
    public void btSalvarAction(ActionEvent evt) {

        getCampos();
    }

//    public void btCompSecagemAction(ActionEvent evt) {
//        getCampos();
//        double aux = 1.0;
//        int t= 0;
//        double  k = 0.365, n=0.663;
//        System.out.println("-------Simulação de secagem--------- \n");
//        System.out.println("\n\t\t t(h)\t\t U - Teor de umidade (%%) \t\t Tempo de Secagem");
//        fruto.getCondicao().settAgua(Double.parseDouble(tfTeorAgua.getText()));
//
//        while (aux>=fruto.getCondicao().getteorAgua()){
//            aux = Math.exp(-k*(Math.pow(t,n)));
//
//            System.out.println("\n\t\t" + t + "\t\t" + (aux * 100) + "\t\t" + ((CoeficienteA.Exponencial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Exponencial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2))) + t));
//
//            //System.out.println("teste "+ t, aux * 100);
//
//            t++;
//        }
//    }
    @FXML
    public void btSimularAction(ActionEvent evt) {
        CoeficienteA coeA;
        double Teq;

        calculoThompson.setFruto(fruto); // fruto que está instanciando
        getCampos();

        System.out.println("EQUAÇÕES DE PARAMETRIZAÇÃO ABERTA DO SIMULADOR\n");
        System.out.println("Razão de Conversão: " + calculoThompson.razaoConversao());
        System.out.println("Calor Latente de Vaporização da Água no Fruto: " + calculoThompson.calorLatenteDeVaporAguaNoFruto());
        System.out.println("Calor Específico: " + calculoThompson.calorEspecifico());
        //System.out.println("Caeficiente A Exponencial: " + CoeficienteA.Exponencial.calcular(fruto));
        // System.out.println("Coeficiente A Polinomial: " + CoeficienteA.Polinomial.calcular(fruto));
        //System.out.println("Caeficiente B Exponencial: " + CoeficienteB.Exponencial.calcular(fruto));
        // System.out.println("Camada Fina THOMPSON->Tempo de Secagem " + EquacoesCamadaFina.Page.EquacaoCamadaFina(fruto));
        System.out.println("Teor de Água Thompson: " + calculoThompson.teorDeAguaThompson());
        System.out.println("Razão Teor de àgua: " + calculoThompson.razaoTeorAqua());

        System.out.println("EQUAÇÃO DE CAMADA FINA\n");
        //*******************************************VERIFICAÇÂO EQUAÇÃO DE CAMADA FINA THOMPSON A*********************************************************

        if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Thompson) && comboboxCoefA.getValue().equals(CoeficienteA.Exponencial) && comboboxCoefB.getValue().equals(CoeficienteB.Exponencial)) {

            //System.out.println("Equação de Camada Fina Page: "+EquacoesCamadaFina.Page.EquacaoCamadaFina(fruto));
            System.out.println("Equação de Camada Fina THOMPSON: " + ((CoeficienteA.Exponencial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Exponencial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2)))));

        } else {
            if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Thompson) && comboboxCoefA.getValue().equals(CoeficienteA.Exponencial) && comboboxCoefB.getValue().equals(CoeficienteB.Polinomial)) {

                System.out.println("Equação de Camada Fina THOMPSON: " + ((CoeficienteA.Exponencial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Polinomial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2)))));
            } else {

                if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Thompson) && comboboxCoefA.getValue().equals(CoeficienteA.Polinomial) && comboboxCoefB.getValue().equals(CoeficienteB.Polinomial)) {

                    System.out.println("Equação de Camada Fina THOMPSON: " + ((CoeficienteA.Polinomial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Polinomial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2)))));
                } else {
                    if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Thompson) && comboboxCoefA.getValue().equals(CoeficienteA.Polinomial) && comboboxCoefB.getValue().equals(CoeficienteB.Exponencial)) {

                        System.out.println("Equação de Camada Fina THOMPSON: " + ((CoeficienteA.Polinomial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Exponencial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2)))));
                    }
                }

            }
            //*********** AQUI COMEÇA VERIFICAÇÂO PARA PAGE
        }
        if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Page) && comboboxCoefA.getValue().equals(CoeficienteA.Exponencial) && comboboxCoefB.getValue().equals(CoeficienteB.Exponencial)) {

            //System.out.println("Equação de Camada Fina Page: "+EquacoesCamadaFina.Page.EquacaoCamadaFina(fruto));
            System.out.println("Equação de Camada Fina PAGE: " + Math.pow(Math.log(calculoThompson.razaoTeorAqua() / CoeficienteA.Exponencial.calcular(fruto)), (1 / CoeficienteB.Exponencial.calcular(fruto))));

        } else {
            if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Page) && comboboxCoefA.getValue().equals(CoeficienteA.Exponencial) && comboboxCoefB.getValue().equals(CoeficienteB.Polinomial)) {

                System.out.println("Equação de Camada Fina PAGE: " + Math.pow((Math.log(calculoThompson.razaoTeorAqua()) / CoeficienteA.Exponencial.calcular(fruto)), (1 / CoeficienteB.Polinomial.calcular(fruto))));
            } else {

                if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Page) && comboboxCoefA.getValue().equals(CoeficienteA.Polinomial) && comboboxCoefB.getValue().equals(CoeficienteB.Polinomial)) {

                    System.out.println("Equação de Camada Fina PAGE: " + Math.pow((Math.log(calculoThompson.razaoTeorAqua()) / CoeficienteA.Polinomial.calcular(fruto)), (1 / CoeficienteB.Polinomial.calcular(fruto))));
                } else {
                    if (comboboxEqCamFina.getValue().equals(EquacoesCamadaFina.Page) && comboboxCoefA.getValue().equals(CoeficienteA.Polinomial) && comboboxCoefB.getValue().equals(CoeficienteB.Exponencial)) {

                        System.out.println("Equação de Camada Fina PAGE: " + Math.pow((Math.log(calculoThompson.razaoTeorAqua()) / CoeficienteA.Polinomial.calcular(fruto)), (1 / CoeficienteB.Exponencial.calcular(fruto))));
                    }
                }

            }
        }

        //*******************************************COEFICIENTE A*********************************************************
        System.out.println("COEFICIENTE A\n");
        if (comboboxCoefA.getValue().equals(CoeficienteA.Exponencial)) {
            System.out.println("Caeficiente A Exponencial: " + CoeficienteA.Exponencial.calcular(fruto));

        } else {
            System.out.println("Caeficiente A Polinomial: " + CoeficienteA.Polinomial.calcular(fruto));
        }

        System.out.println("COEFICIENTE B\n");
        if (comboboxCoefB.getValue().equals(CoeficienteB.Exponencial)) {
            System.out.println("Caeficiente B Exponencial: " + CoeficienteB.Exponencial.calcular(fruto));

        } else {
            System.out.println("Caeficiente B Polinomial: " + CoeficienteB.Polinomial.calcular(fruto));
        }

        double aux = 1.0;
        int t = 0;
        double k = 0.365, n = 0.663;
        System.out.println("-------Simulação de secagem--------- \n");
        System.out.println("\n\t\t t(h)\t\t U - Teor de umidade (%%) \t\t Tempo de Secagem");
        fruto.getCondicao().settAgua(Double.parseDouble(tfTeorAgua.getText()));

        while (aux >= fruto.getCondicao().getteorAgua()) {
            aux = Math.exp(-k * (Math.pow(t, n)));

            System.out.println("\n\t\t" + t + "\t\t" + (aux * 100) + "\t\t" + ((CoeficienteA.Exponencial.calcular(fruto) * calculoThompson.razaoTeorAqua()) + (CoeficienteB.Exponencial.calcular(fruto) * (pow(calculoThompson.razaoTeorAqua(), 2))) + t));

            //System.out.println("teste "+ t, aux * 100);
            t++;
        }

    }

    private boolean validarFields() {

        if (this.tfNomeFruto.getText() != null && this.tfNomeFruto.getText().equals("")) {
            FXMLControllerFruto.menssagemErro = CONST_PRODUTO_REQUER_NOME;
            return false;
        }

        return true;

    }
}
