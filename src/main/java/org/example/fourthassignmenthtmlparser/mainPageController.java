package org.example.fourthassignmenthtmlparser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;

public class mainPageController {
    @FXML
    public ChoiceBox<String> selection;
    public Pagination pagination;
    public AnchorPane countriesContainer;
    public TextField searchText;
    int TILES_PER_PAGE = 12;
    private List<Country> currentCountries;

    public void initialize() throws IOException {
        Parser p = new Parser();
        // Read The Countries From file.
        p.setUp();

        // Making the ChoiceBox Items
        selection.getItems().setAll("Name", "Population", "Area", "Default");
        selection.getSelectionModel().select("Sort By: ");


        // Making The Pagination and The Handler for Page Change.
        currentCountries = Parser.countries;
        pagination.setPageCount((currentCountries.size() / TILES_PER_PAGE) + 1);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("Getting into page: " + pageIndex);
                return showPageTiles(currentCountries, pageIndex);
            }
        });


        // TODO:  Search for countries which match the text

    }

    // Shows The Current Page Countries from the list.
    private TilePane showPageTiles(List<Country> countries, int pageIndex){
        // Removing Previous Countries
        countriesContainer.getChildren().removeAll();

        // Creating New Countries of the page.
        TilePane container = new TilePane();
        container.getStyleClass().add("countriesContainer");
        container.setPrefColumns(4);
        container.setMinHeight(500);
        container.setHgap(10);
        container.setVgap(10);
        for (int i = pageIndex * TILES_PER_PAGE ; i < (pageIndex + 1) * TILES_PER_PAGE; i++){
            if(i >= currentCountries.size()) continue;
            Country c = countries.get(i);

            VBox country = new VBox();
            country.getStyleClass().add("country");
            country.setMinWidth(300);

            Label countryName =  new Label(c.getName());
            countryName.getStyleClass().add("country-name");
            country.getChildren().add(countryName);

            Label capital =  new Label("Capital: " + c.getCapital());
            capital.getStyleClass().add("country-info");
            country.getChildren().add(capital);

            Label population =  new Label("Population: " + c.getPopulation());
            population.getStyleClass().add("country-info");
            country.getChildren().add(population);

            Label area =  new Label("Area: " + c.getArea());
            area.getStyleClass().add("country-info");
            country.getChildren().add(area);

            country.setMaxWidth(300);
            container.getChildren().add(country);
        }

        return container;
    }

    // Handler for ChoiceBox Change.
    @FXML
    public void onSelectionChange(ActionEvent e) {
        Parser p = new Parser();
        String selected = selection.getSelectionModel().getSelectedItem();


        if(selected.equals("Name")) currentCountries = p.sortByName();
        else if(selected.equals("Population")) currentCountries = p.sortByPopulation();
        else if(selected.equals("Area")) currentCountries = p.sortByArea();
        else currentCountries = Parser.countries;

        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("Getting into page: " + pageIndex);
                return showPageTiles(currentCountries, pageIndex);
            }
        });
    }
}
