package com.mysimulador;

import Controller.FrutoController;


import javafx.application.Application;
import javafx.javafxtools.FxmlLoader;
import javafx.stage.Stage;

//http://www.devx.com/Java/Article/48193/0/page/2     EXEMPLO
public class MainApp extends Application {

    @Override
    public void start(final Stage primaryStage) throws Exception {
//        System.out.println(Modelos.Thompson.calcula(10, 10));
//        System.out.println(Modelos.Sara.calcula(10, 10));
        FxmlLoader.load(FrutoController.class, null, null);
//        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Produto.fxml"));
//
//        final Scene scene = new Scene(root);
////        scene.getStylesheets().add("/styles/Styles.css");
//        primaryStage.setScene(scene);
//        primaryStage.setResizable(false);
//
//        primaryStage.setTitle("SIMULADOR DA TRANSFERÊNCIA DE CALOR E MASSA DE\n"
//                + " FRUTOS DO CERRADO");
//
//        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }

}
