package unittesting.buymoreidea.cia;

import java.util.ArrayList;
import java.util.List;

public class SpyBase {
    private String location;
    private String classification;
    private String alias;
    private List<Door> doors;
    private List<Agent> agents;

    public SpyBase(String location, String classification, String alias) {
        this.location = location;
        this.classification = classification;
        this.alias = alias;
        this.doors = new ArrayList<Door>();
        this.agents = new ArrayList<Agent>();
    }
    public SpyBase() {
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public List<Agent> getAgents() {
        return agents;
    }

    public void setAgents(List<Agent> agents) {
        this.agents = agents;
    }
    // method to add a door
    public void addDoor(Door door) {
        if (door == null) {
            throw new IllegalArgumentException("Door cannot be null");
        }
        if (doors.contains(door)) {
            throw new IllegalArgumentException("Door already exists");
        }
        doors.add(door);
    }
    // method to remove a door
    public void removeDoor(Door door) {
        if (door == null) {
            throw new IllegalArgumentException("Door cannot be null");
        }
        if (!doors.contains(door)) {
            throw new IllegalArgumentException("Door does not exist");
        }
        doors.remove(door);
    }
    // method to add an agent
    public void addAgent(Agent agent) {
        if (agent == null) {
            throw new IllegalArgumentException("Agent cannot be null");
        }
        if (agents.contains(agent)) {
            throw new IllegalArgumentException("Agent already exists");
        }
        agents.add(agent);
    }
    // method to remove an agent
    public void removeAgent(Agent agent) {
        if (agent == null) {
            throw new IllegalArgumentException("Agent cannot be null");
        }
        if (!agents.contains(agent)) {
            throw new IllegalArgumentException("Agent does not exist");
        }
        agents.remove(agent);
    }
    public void closeAllDoors() {
        for (Door door : doors) {
            door.setDoorStatus("Closed");
        }
    }
    public void openAllDoors() {
        for (Door door : doors) {
            door.setDoorStatus("Open");
        }
    }
    public void generateReport() {
        System.out.println("SpyBase Report:");
        System.out.println("Location: " + location);
        System.out.println("Classification: " + classification);
        System.out.println("Alias: " + alias);
        System.out.println("Doors:"); doors.forEach(System.out::println);
        System.out.println("Agents:"); agents.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return "SpyBase{" +
                "location='" + location + '\'' +
                ", classification='" + classification + '\'' +
                ", alias='" + alias + '\'' +
                ", doors=" + doors +
                ", agents=" + agents +
                '}';
    }
}
