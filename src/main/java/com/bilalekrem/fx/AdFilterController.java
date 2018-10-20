package com.bilalekrem.fx;

import com.bilalekrem.Main;
import com.bilalekrem.endpoints.Ad;
import com.bilalekrem.analyzer.GeneralAnalyzer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;

import java.util.ArrayList;
import java.util.Set;

public class AdFilterController {
    @FXML
    private JFXTextField tfTitle;

    @FXML
    private JFXTextField tfDesc;

    @FXML
    private JFXRadioButton rbAll;
    @FXML
    private JFXRadioButton rbImpression;
    @FXML
    private JFXRadioButton rbClick;
    private ToggleGroup toggleGroup = new ToggleGroup();

    @FXML
    private JFXButton btFilterString;
    @FXML
    private JFXButton btFilterInteract;

    @FXML
    private void initialize() {
        rbAll.setToggleGroup(toggleGroup);
        rbImpression.setToggleGroup(toggleGroup);
        rbClick.setToggleGroup(toggleGroup);


        btFilterInteract.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                    Set<Ad> ads;
                    if(rbAll.isSelected()) {
                        ads = GeneralAnalyzer.getAllAds(10);
                    }else if(rbImpression.isSelected()) {
                        ads = GeneralAnalyzer.getAdsByEventType("IMPRESSION");
                    }else {
                        ads = GeneralAnalyzer.getAdsByEventType("CLICK");
                    }
                    Main.getInstance().showListAds(new ArrayList<>(ads));

                }catch (Exception ex ){
                    ex.printStackTrace();
                }

            }
        });

        btFilterString.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Set<Ad> ads = GeneralAnalyzer.getAdsByTitleAndDesc(tfTitle.getText(), tfDesc.getText());
                    Main.getInstance().showListAds(new ArrayList<>(ads));
                }catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });



    }



}
