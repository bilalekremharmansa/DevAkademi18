package com.bilalekrem.fx;

import com.bilalekrem.Main;
import com.bilalekrem.endpoints.Ad;
import com.jfoenix.controls.JFXListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.util.List;

public class AdListViewController {
    @FXML
    private JFXListView<Ad> lvAds;

    private List<Ad> ads;
    public AdListViewController(List<Ad> ads) {
        this.ads = ads;
    }

    @FXML
    private void initialize() {
        ObservableList<Ad> observableList = FXCollections.observableList(ads);

        lvAds.setItems(observableList);

        lvAds.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try{
                    Ad selected = lvAds.getSelectionModel().getSelectedItem();
                    Main.getInstance().showAd(selected);
                }catch (Exception ex) {

                }

            }
        });
    }

}
