package Controller;

import Model.Condicao;
import javafx.javafxtools.controller.GenericController;
import Service.CondicaoService;
import Service.CondicaoServiceInterface;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.javafxtools.controller.annotations.FxmlController;
import javafx.javafxtools.tableview.annotations.TableViewBase;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
/**
 * Created by Sara Fernandes on 17/06/2015.
 */
public class CondicaoController extends GenericController {


    private CondicaoServiceInterface condicaoService = new CondicaoService();


    private ObservableList<Condicao> listaCondicoes = FXCollections.observableArrayList();
    @FXML
    @TableViewBase(classe = Condicao.class)
    TableView<Condicao> tabela;
    @FXML


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    @Override
    public void Close() {
        System.out.println("DKMDKMK");
    }
    public void limparCampos(){

    }

    public void addCondicao(Condicao condicao) {
        condicaoService.addCondicao(condicao);
    }

    public ObservableList<Condicao> getListaCondicoes() {
        if (!listaCondicoes.isEmpty()) {
            listaCondicoes.clear();
        }
        listaCondicoes = FXCollections.observableList((List<Condicao>) condicaoService.listCondicoes());
        return listaCondicoes;
    }

    public void removeCondicao(Long id) {
        condicaoService.removeCondicao(id);
    }

    public void updateCondicao(Condicao condicao) {
        condicaoService.updateCondicao(condicao);
    }

}
