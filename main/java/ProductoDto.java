package main.java;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ProductoDto {

    private String id;
    private String name;
    private BigDecimal preco;

    public ProductoDto() {
    }

    public ProductoDto(String[] producto)
    {
        this.id = producto[0];
        this.name = producto[20];
        this.preco = BigDecimal.valueOf(Double.parseDouble(producto[1]));
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
