package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.transformation.FilteredList;

import java.util.List;

public class CartController {
    private Cart cart;
    private FilteredList<Media> filteredList;

    public CartController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }
    @FXML
    private javafx.scene.control.TextField tfFilter;

    @FXML
    private javafx.scene.control.RadioButton radioBtnFilterId;

    @FXML
    private javafx.scene.control.RadioButton radioBtnFilterTitle;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private Label costLabel;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }


    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

    private void showFilteredMedia(String filter) {
        if (filter == null || filter.isEmpty()) {
            filteredList.setPredicate(media -> true); // No filter
        } else {
            String lowerFilter = filter.toLowerCase();

            filteredList.setPredicate(media -> {
                if (radioBtnFilterId.isSelected()) {
                    return String.valueOf(media.getId()).contains(lowerFilter);
                } else if (radioBtnFilterTitle.isSelected()) {
                    return media.getTitle().toLowerCase().contains(lowerFilter);
                }
                return true; // Default to showing all
            });
        }
    }

    @FXML
    public void initialize() {
        colMediaId.setCellValueFactory(
                new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null)
            filteredList = new FilteredList<>(cart.getItemsOrdered(), p -> true);
            tblMedia.setItems(filteredList);
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilteredMedia(newValue);
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }
    void updateButtonBar(Media media){
        if(media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            btnRemove.setVisible(true);
            if(media instanceof Playable){
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }

    @FXML
    void btnRemovePressed(ActionEvent event){
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }
}
