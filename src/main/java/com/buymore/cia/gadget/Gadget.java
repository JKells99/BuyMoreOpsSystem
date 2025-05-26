package com.buymore.cia.gadget;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Gadget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long gadgetId;
    private String gadgetName;
    private String gadgetDescription;
    private String gadgetType;
    private int gadgetStockCount;
    private String gadgetClassification;



    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }

    public String getGadgetDescription() {
        return gadgetDescription;
    }

    public void setGadgetDescription(String gadgetDescription) {
        this.gadgetDescription = gadgetDescription;
    }

    public String getGadgetType() {
        return gadgetType;
    }

    public void setGadgetType(String gadgetType) {
        this.gadgetType = gadgetType;
    }

    public int getGadgetStockCount() {
        return gadgetStockCount;
    }

    public void setGadgetStockCount(int gadgetStockCount) {
        this.gadgetStockCount = gadgetStockCount;
    }

    public String getGadgetClassification() {
        return gadgetClassification;
    }

    public void setGadgetClassification(String gadgetClassification) {
        this.gadgetClassification = gadgetClassification;
    }
}
