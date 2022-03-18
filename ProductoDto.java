package main.java;

import java.math.BigDecimal;

public class ProductoDto {

    private String id;
    private String name;
    private BigDecimal precio;

    public ProductoDto() {
    }

    public ProductoDto(String[] producto)
    {
        this.id = producto[1];
        this.name = producto[2];
        this.precio = BigDecimal.valueOf(Long.valueOf(producto[3]));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
