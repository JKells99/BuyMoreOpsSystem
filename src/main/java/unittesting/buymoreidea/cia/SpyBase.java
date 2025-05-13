package unittesting.buymoreidea.cia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class SpyBase {
    private static final Logger log = LoggerFactory.getLogger(SpyBase.class);
    private String location;
    private String classification;
    private String alias;
    private List<Door> doors;
    private List<Agent> agents;
    private List<Gadget> gadgets;

    public SpyBase(String location, String classification, String alias) {
        this.location = location;
        this.classification = classification;
        this.alias = alias;
        this.doors = new ArrayList<Door>();
        this.agents = new ArrayList<Agent>();
        this.gadgets = new ArrayList<Gadget>();
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

    public List<Gadget> getGadgets() {
        return gadgets;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
    }

    // method to add a door
    public void addDoor(Door door) {
        try {
            if (door == null) {
                throw new IllegalArgumentException("Door cannot be null");
            }
            if (doors.contains(door)) {
                throw new IllegalArgumentException("Door already exists");
            }
            doors.add(door);
            log.info("Added Door: {}", door);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    // method to remove a door
    public void removeDoor(Door door) {
        try {
            if (door == null) {
                throw new IllegalArgumentException("Door cannot be null");
            }
            if (!doors.contains(door)) {
                throw new IllegalArgumentException("Door does not exist");
            }
            doors.remove(door);
            log.info("Removed Door: {}", door);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    // method to add an agent
    public void addAgent(Agent agent) {
        try {
            if (agent == null) {
                throw new IllegalArgumentException("Agent cannot be null");
            }
            if (agents.contains(agent)) {
                throw new IllegalArgumentException("Agent already exists");
            }
            agents.add(agent);
            log.info("Added Agent: {}", agent);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    // method to remove an agent
    public void removeAgent(Agent agent) {
        try {
            if (agent == null) {
                throw new IllegalArgumentException("Agent cannot be null");
            }
            if (!agents.contains(agent)) {
                throw new IllegalArgumentException("Agent does not exist");
            }
            agents.remove(agent);
            log.info("Removed Agent: {}", agent);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeAllDoors() {
        try {
            for (Door door : doors) {
                log.info("Closing door #{}", door.getDoorNumber());
                door.setDoorStatus("Closed");
            }
        } catch (Exception e) {
            log.error("Error closing doors: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void openAllDoors() {
        try {
            for (Door door : doors) {
                door.setDoorStatus("Open");
            }
        } catch (Exception e) {
            log.error("Error opening doors: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public void addNewgadget(Gadget gadget) {
        try {
            if (gadget == null) {
                throw new IllegalArgumentException("Gadget cannot be null");
            }
            if (gadgets.contains(gadget)) {
                throw new IllegalArgumentException("Gadget already exists");
            }
            gadgets.add(gadget);
            log.info("Added Gadget: {}", gadget);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }
    public void printGadgetStockReport() {
        try {
            StringBuilder report = new StringBuilder();
            for (Gadget gadget : gadgets) {
                report.append("--------------------------------------\n");
                report.append("Gadget Name: ").append(gadget.getGadgetName()).append("\n");
                report.append("Gadget Type: ").append(gadget.getGadgetType()).append("\n");
                report.append("Gadget Description: ").append(gadget.getGadgetDescription()).append("\n");
                report.append("Gadget Stock Count: ").append(gadget.getGadgetStockCount()).append("\n");
                report.append("Gadget Classification: ").append(gadget.getGadgetClassification()).append("\n");
                report.append("-------------------------------------------------\n");


            }
            System.out.println(report);
        } catch (Exception e) {
            log.error("Error printing gadget stock report: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void getitemStockCountByName(String gadgetName){
        try {
            for (Gadget gadget : gadgets) {
                if (gadget.getGadgetName().equals(gadgetName)) {
                    System.out.println("Item " + gadgetName + " is in stock with quantity " + gadget.getGadgetStockCount());
                    log.info("Item {} is in stock with quantity {}", gadgetName, gadget.getGadgetStockCount());
                    return;
                }
            }
            System.out.println("Item " + gadgetName + " not found");
        } catch (Exception e) {
            log.error("Error getting item stock count: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void generateReport() {
        try {
            System.out.println("SpyBase Report:");
            System.out.println("Location: " + location);
            System.out.println("Classification: " + classification);
            System.out.println("Alias: " + alias);
            System.out.println("Doors:");
            doors.forEach(System.out::println);
            System.out.println("Agents:");
            agents.forEach(System.out::println);
        } catch (Exception e) {
            log.error("Error generating report: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void printAgentDetailsFormatted() {
        try {
            System.out.println("Agent Details:");
            for (Agent agent : agents) {
                System.out.printf("UserName: %s\nPassword: %s\nCodeName: %s\nSpecialization: %s\nUnitName: %s\n",
                        agent.getUserName(), agent.getPassword(), agent.getCodeName(), agent.getSpecialization(), agent.getUnitName());

            }
        } catch (Exception e) {
            log.error("Error printing agent details: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void printSpyBaseDetailsFormatted() {
        try {
            System.out.printf("SpyBase Details:\nLocation: %s\nClassification: %s\nAlias: %s\n", location, classification, alias);
            System.out.println("Doors:");
            for (Door door : doors) {
                System.out.println(door);
            }
            System.out.println("Agents:");
            printAgentDetailsFormatted();
        } catch (Exception e) {
            log.error("Error printing spy base details: {}", e.getMessage());
            throw new RuntimeException(e);
        }

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
