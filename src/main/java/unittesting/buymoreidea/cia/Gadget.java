package unittesting.buymoreidea.cia;

public class Gadget {
    private String gadgetName;
    private String gadgetDescription;
    private String gadgetType;
    private int gadgetStockCount;
    private String gadgetClassification;

    public Gadget(String gadgetName, String gadgetDescription, String gadgetType, int gadgetStockCount, String gadgetClassification) {
        this.gadgetName = gadgetName;
        this.gadgetDescription = gadgetDescription;
        this.gadgetType = gadgetType;
        this.gadgetStockCount = gadgetStockCount;
        this.gadgetClassification = gadgetClassification;
    }

    public Gadget() {
    }

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
