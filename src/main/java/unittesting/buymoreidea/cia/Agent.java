package unittesting.buymoreidea.cia;

import unittesting.buymoreidea.User;

import java.util.ArrayList;
import java.util.List;

public class Agent extends User {
    private String codeName;

    private String specialization;

    private String unitName;



    public Agent(String userName, String password, String codeName, String specialization, String unitName) {
        super(userName, password);
        this.codeName = codeName;
        this.specialization = specialization;
        this.unitName = unitName;

    }

    public Agent() {
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





    @Override
    public String toString() {
        return "Agent{" +
                "codeName='" + codeName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", unitName='" + unitName + '\'' +
                '}';
    }
}

