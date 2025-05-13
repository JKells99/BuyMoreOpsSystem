package unittesting.buymoreidea.cia;

import unittesting.buymoreidea.User;

import java.util.ArrayList;
import java.util.List;

public class Agent extends User {
    private String codeName;

    private String specialization;

    private String unitName;

    private List<Gadget> listOfGadgets;



    public Agent(String userName, String password, String codeName, String specialization, String unitName) {
        super(userName, password);
        this.codeName = codeName;
        this.specialization = specialization;
        this.unitName = unitName;
        this.listOfGadgets = new ArrayList<Gadget>();

    }

    public Agent() {
    }

    public List<Gadget> getListOfGadgets() {
        return listOfGadgets;
    }

    public void setListOfGadgets(List<Gadget> listOfGadgets) {
        this.listOfGadgets = listOfGadgets;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void addGadget(Gadget gadget) {
        try {
            this.listOfGadgets.add(gadget);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public String toString() {
        return "Agent{" +
                "specialization='" + specialization + '\'' +
                ", unitName='" + unitName + '\'' +
                "} " + super.toString();
    }
}

