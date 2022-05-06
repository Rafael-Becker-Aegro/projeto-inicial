package com.projeto_inicial.projeto_inicial.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;

@Document
public class Production {

    @NotNull
    private String crop;

    @NotNull
    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal quantity;

    public Production(String crop, BigDecimal quantity) {
        this.crop = crop;
        this.quantity = quantity;
    }

    public String getCrop() {
        return crop;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
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
