package br.edu.ifsp.pep.controller;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped
public class SelectOneMenuController {

    private int valor;//valor selecionado.
    private String country;//país selecionado.
    private String city;//cidade selecionada.
    private Map<String, String> countries;
    private Map<String, String> cities;
    private Map<String, Map<String, String>> data = new HashMap<>();

    public void mostrar() {
        System.out.println(valor);
    }

    public SelectOneMenuController() {
        countries = new HashMap<>();
        countries.put("USA", "USA");
        countries.put("Germany", "Germany");
        countries.put("Brazil", "Brazil");

        Map<String, String> map = new HashMap<>();
        map.put("New York", "New York");
        map.put("San Francisco", "San Francisco");
        map.put("Denver", "Denver");
        data.put("USA", map);

        map = new HashMap<>();
        map.put("Berlin", "Berlin");
        map.put("Munich", "Munich");
        map.put("Frankfurt", "Frankfurt");
        data.put("Germany", map);

        map = new HashMap<>();
        map.put("Sao Paulo", "Sao Paulo");
        map.put("Rio de Janerio", "Rio de Janerio");
        map.put("Salvador", "Salvador");
        data.put("Brazil", map);

    }

    public void onCountryChange() {
        if (country != null && !"".equals(country)) {
            cities = data.get(country);
        } else {
            cities = new HashMap<>();
        }
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Map<String, Map<String, String>> getData() {
        return data;
    }

    public void setData(Map<String, Map<String, String>> data) {
        this.data = data;
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    public Map<String, String> getCities() {
        return cities;
    }

    public void setCities(Map<String, String> cities) {
        this.cities = cities;
    }
}
