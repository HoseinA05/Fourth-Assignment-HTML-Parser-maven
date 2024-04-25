package org.example.fourthassignmenthtmlparser;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import javafx.util.Callback;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class mainPageController {
    @FXML
    public ChoiceBox<String> selection;
    @FXML
    public Pagination pagination;
    @FXML
    public TextField searchText;
    @FXML
    public VBox bgContainer;
    @FXML
    public Button darkModeBtn;
    private int TILES_PER_PAGE = 12;
    private boolean isDark = false;
    private List<Country> currentCountries = new ArrayList<>();
    private List<Country> sortedCountries;
    public void initialize() throws IOException {
        // Adding light-them
        bgContainer.getStylesheets().add(getClass().getResource("styles/light-theme.css").toExternalForm());

        Parser p = new Parser();
        // Read The Countries From file.
        p.setUp();

        // Making the ChoiceBox Items
        selection.getItems().setAll("Name", "Population", "Area", "Default");
        selection.getSelectionModel().select("Sort By: ");


        // Making The Pagination and The Handler for Page Change.
        currentCountries = Parser.countries;
        sortedCountries = Parser.countries;
        pagination.setPageCount((currentCountries.size() / TILES_PER_PAGE) + 1);
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("Getting into page: (default)" + pageIndex);
                return showPageTiles(currentCountries, pageIndex);
            }
        });

        // Search Box Handling
        searchText.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                currentCountries = sortedCountries.stream().filter(new Predicate<Country>() {
                    @Override
                    public boolean test(Country country) {
                        return country.getName().toLowerCase().contains(searchText.getText().toLowerCase()) || country.getCapital().toLowerCase().contains(searchText.getText().toLowerCase());
                    }
                }).toList();

                pagination.setPageCount((currentCountries.size() / TILES_PER_PAGE) + 1);
                pagination.setPageFactory(new Callback<Integer, Node>() {
                    @Override
                    public Node call(Integer pageIndex) {
                        System.out.println("Getting into page: (searched)" + pageIndex);
                        return showPageTiles(currentCountries, pageIndex);
                    }
                });
            }
        });
    }

    // Shows The Current Page Countries from the list.
    private TilePane showPageTiles(List<Country> countries, int pageIndex){
        // Creating New Countries of the page.
        TilePane container = new TilePane();
        container.getStyleClass().add("tilesContainer");

        for (int i = pageIndex * TILES_PER_PAGE ; i < (pageIndex + 1) * TILES_PER_PAGE; i++){
            if(i >= currentCountries.size()) continue;
            Country c = countries.get(i);

            VBox country = new VBox();
            country.getStyleClass().add("country");
            country.getStyleClass().addAll("bg-2");

            Label countryName =  new Label(c.getName());
            countryName.getStyleClass().add("country-name");
            countryName.getStyleClass().addAll("txt-1");
            countryName.setTooltip(new Tooltip(c.getName()));
            country.getChildren().add(countryName);

            Label capital =  new Label("Capital: " + c.getCapital());
            capital.getStyleClass().add("country-info");
            capital.getStyleClass().addAll("txt-2");
            country.getChildren().add(capital);

            Label population =  new Label("Population: " + c.getPopulation());
            population.getStyleClass().add("country-info");
            population.getStyleClass().addAll("txt-2");
            country.getChildren().add(population);

            Label area =  new Label("Area: " + c.getArea());
            area.getStyleClass().add("country-info");
            area.getStyleClass().addAll("txt-2");
            country.getChildren().add(area);

            container.getChildren().add(country);
        }
        container.setEffect(new DropShadow());
        return container;
    }

    // Handler for ChoiceBox Change.
    @FXML
    public void onSelectionChange() {
        Parser p = new Parser();
        String selected = selection.getSelectionModel().getSelectedItem();


        if(selected.equals("Name")) sortedCountries = p.sortByName();
        else if(selected.equals("Population")) sortedCountries = p.sortByPopulation();
        else if(selected.equals("Area")) sortedCountries = p.sortByArea();
        else sortedCountries = Parser.countries;

        searchText.clear();
        if(!currentCountries.isEmpty()) {
            System.out.println("Changing ");
            pagination.setPageCount((sortedCountries.size() / TILES_PER_PAGE) + 1);
        }
        pagination.setPageFactory(new Callback<Integer, Node>() {
            @Override
            public Node call(Integer pageIndex) {
                System.out.println("Getting into page: (sorted)" + pageIndex);
                return showPageTiles(sortedCountries, pageIndex);
            }
        });
    }

    // Dark Mode Button Handling
    public void toggleDarkMode() {
        if(isDark){
            // if it was dark before
            darkModeBtn.setText("DarkMode");
            bgContainer.getStylesheets().remove(getClass().getResource("styles/dark-theme.css").toExternalForm());
            bgContainer.getStylesheets().add(getClass().getResource("styles/light-theme.css").toExternalForm());
            isDark = false;
        }else{
            // if it was light before
            darkModeBtn.setText("LightMode");
            bgContainer.getStylesheets().remove(getClass().getResource("styles/light-theme.css").toExternalForm());
            bgContainer.getStylesheets().add(getClass().getResource("styles/dark-theme.css").toExternalForm());
            isDark = true;
        }
    }

}
