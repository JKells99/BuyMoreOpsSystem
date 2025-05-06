package unittesting.buymoreidea.cia;

import java.util.ArrayList;
import java.util.List;

public class Mission {
    private int missionId;
    private String missionName;
    private String missionDescription;
    private String missionStatus;
    private List<Agent> agentsInvolved;

    public Mission(int missionId, String missionName, String missionDescription, String missionStatus) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionDescription = missionDescription;
        this.missionStatus = missionStatus;
        this.agentsInvolved = new ArrayList<Agent>();
    }
    public Mission() {
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
    public void addAgent(Agent agent) {
        this.agentsInvolved.add(agent);
    }
    public void removeAgent(Agent agent) {
        this.agentsInvolved.remove(agent);
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
