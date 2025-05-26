package com.buymore.cia.mission;

import com.buymore.cia.agent.Agent;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String missionStatus;
    @OneToMany
    private List<Agent> agentsInvolved;

    public Mission(int missionId, String missionName, String missionDescription, String missionStatus) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.missionStatus = missionStatus;
        this.agentsInvolved = new ArrayList<>();
    }

    public Mission(String missionStatus, String missionDescription, String missionName) {
        this.missionStatus = missionStatus;
        this.missionDescription = missionDescription;
        this.missionName = missionName;
        this.agentsInvolved = new ArrayList<>();
    }
    public Mission() {
        this.agentsInvolved = new ArrayList<>();
    }


    public int getMissionId() {
        return missionId;
    }

    public void setMissionId(int missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public void setMissionDescription(String missionDescription) {
        this.missionDescription = missionDescription;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public List<Agent> getAgentsInvolved() {
        return agentsInvolved;
    }

    public void setAgentsInvolved(List<Agent> agentsInvolved) {
        this.agentsInvolved = agentsInvolved;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "missionId=" + missionId +
                ", missionName='" + missionName + '\'' +
                ", missionDescription='" + missionDescription + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                ", agentsInvolved=" + agentsInvolved +
                '}';
    }
}
