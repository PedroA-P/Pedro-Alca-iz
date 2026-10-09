package com.introsoftware.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.introsoftware.Calculator;

public class Article {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("quantity")
    private int cantidad;
    @JsonProperty("unitPrice")
    private double precio;
    @JsonProperty("discount")
    private double descuento;
    private Calculator calculator = new Calculator();

    public Article() {
    }

    public Article(String nombre, int cantidad, double precio, double descuento) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }
public int getCantidad() {
    return cantidad;
}
public double getPrecio() {
    return precio;
}
public double getDescuento() {
    return descuento;
}

public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}
public void setPrecio(double precio) {
    this.precio = precio;
}
public void setDescuento(double descuento) {
    this.descuento = descuento;
}
public double getGrossAmount() {
    return calculator.multiply(cantidad, precio);
}

public double getDiscountedAmount() {
    return calculator.discount(getGrossAmount(), descuento);
}

}
