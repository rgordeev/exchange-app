package ru.rgordeev.httpexample.model;

import java.util.Date;
import java.util.Map;

public class Currencies {
    private Map<String, Double> rates;
    private String base;
    private Date date;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Currencies{" +
                "rates=" + rates +
                ", base='" + base + '\'' +
                ", date=" + date +
                '}';
    }
}
