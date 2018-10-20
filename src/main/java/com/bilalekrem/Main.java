package com.bilalekrem;

import com.bilalekrem.endpoints.Ad;
import com.bilalekrem.fx.AdController;
import com.bilalekrem.fx.AdFilterController;
import com.bilalekrem.fx.AdListViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

    private static Main instance;
    private Stage primaryStage;


    public static Main getInstance() {
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        instance = this;
        this.primaryStage = primaryStage;

        showFilterPage();
    }

    public void showFilterPage() throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/AdFilterView.fxml"));

        AdFilterController controller = new AdFilterController();

        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("Filter");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }


    public void showAd(Ad ad) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/AdView.fxml"));

        AdController controller = new AdController(ad);

        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("Ad");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }


    public void showListAds(List<Ad> ads) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fx/AdListView.fxml"));

        AdListViewController controller = new AdListViewController(ads);

        loader.setController(controller);

        Parent root = loader.load();

        primaryStage.setTitle("Ad list");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
