package org.example.fourthassignmenthtmlparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);

        sortedByName.sort(new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return c1.getName().compareTo(c2.getName());
            }
        });
        return  sortedByName;
    }

    public List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);

        sortedByPopulation.sort(new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return -Integer.compare(c1.getPopulation(), c2.getPopulation());
            }
        });
        return sortedByPopulation;
    }

    public List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);

        sortedByArea.sort(new Comparator<Country>() {
            @Override
            public int compare(Country c1, Country c2) {
                return -Double.compare(c1.getArea(), c2.getArea());
            }
        });
        return sortedByArea;
    }

    public void setUp() throws IOException {
        //Parse the HTML file using Jsoup
        File html = new File("src/main/resources/country-list.html");

        if(html.exists()){
            Document doc = Jsoup.parse(html, "UTF-8");

            // Extract data from the HTML
            Elements countriesDiv = doc.getElementsByClass("country");

            // Iterate through each country div to extract country data
            for (Element country: countriesDiv){
                String name = country.select(".country-name").text();
                String capital = country.select(".country-capital").text();
                int population = Integer.parseInt(country.select(".country-population").text());
                double area = Double.parseDouble(country.select(".country-area").text());

                Country c = new Country(name, capital, population, area);
                countries.add(c);
            }
            System.out.println("Done");
        }else{
            System.out.println("No Such Html file found.");
        }
    }

    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        Parser p = new Parser();
        p.setUp();
        for (int i = 0; i < 10; i++) {
            System.out.println(i+1 + ": " + p.sortByName().get(i).getName());
        }
    }
}
