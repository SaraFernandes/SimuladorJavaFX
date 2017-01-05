/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Fruto;
import Service.FrutoService;
import Service.FrutoServiceInterface;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.javafxtools.controller.GenericController;
import javafx.javafxtools.controller.annotations.FxmlController;
import javafx.javafxtools.tableview.annotations.TableViewBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

/**
 *
 * @author Sara Fernandes
 */
@FxmlController(fxmlPath = "/fxml/Produto.fxml", title = "TRANSFERÊNCIA DE CALOR E MASSA DE\n"
        + " FRUTOS DO CERRADO", iconPath = "/imagens/icon.png")
public class FrutoController extends GenericController {

    private FrutoServiceInterface frutoService = new FrutoService();


    private ObservableList<Fruto> listaFrutos = FXCollections.observableArrayList();
    @FXML
    @TableViewBase(classe = Fruto.class)
    TableView<Fruto> tabela;
    @FXML
    ComboBox<String> comboboxAutor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @Override
    public void Close() {
        System.out.println("DKMDKMK");
    }
    public void limparCampos(){
     
    }

    public void addFruto(Fruto fruto) {

        frutoService.addFruto(fruto);
    }

    public ObservableList<Fruto> getListaFrutos() {
        if (!listaFrutos.isEmpty()) {
            listaFrutos.clear();
        }
        listaFrutos = FXCollections.observableList((List<Fruto>) frutoService.listFrutos());
        return listaFrutos;
    }

    public void removeFruto(Long id) {
        frutoService.removeFruto(id);
    }

    public void updateFruto(Fruto fruto) {
        frutoService.updateFruto(fruto);
    }



}
