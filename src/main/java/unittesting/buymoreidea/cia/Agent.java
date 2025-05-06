package unittesting.buymoreidea.cia;

import unittesting.buymoreidea.User;

import java.util.ArrayList;
import java.util.List;

public class Agent extends User {
    private String codeName;

    private String specialization;

    private String unitName;

    private List<Mission> missions;

    public Agent(String userName, String password, String codeName, String specialization, String unitName) {
        super(userName, password);
        this.codeName = codeName;
        this.specialization = specialization;
        this.unitName = unitName;
        this.missions = new ArrayList<>();
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

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }
    public void removeMission(Mission mission) {
        this.missions.remove(mission);
    }
    public void clearMissions() {
        this.missions.clear();
    }

    @Override
    public String toString() {
        return "Agent{" +
                "codeName='" + codeName + '\'' +
                ", specialization='" + specialization + '\'' +
                ", unitName='" + unitName + '\'' +
                ", missions=" + missions +
                '}';
    }
}

