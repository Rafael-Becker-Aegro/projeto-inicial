package com.projeto_inicial.projeto_inicial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Document
public class Production {

    @Id
    private String id;
    @NotNull
    private String crop;
    @NotNull
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal quantity;
    @NotNull
    private String plot;

    public Production(String id, String crop, BigDecimal quantity, String plot) {
        this.id = id;
        this.crop = crop;
        this.quantity = quantity;
        this.plot = plot;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    @JsonIgnore
    public boolean isEmpty(){
        return ObjectUtils.isEmpty(this);
    }

    @Override
    public String toString() {
        return "Production{" +
                "id='" + crop + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
