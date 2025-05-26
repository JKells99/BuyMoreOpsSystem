package com.buymore.cia.spybase;

import com.buymore.cia.agent.Agent;
import com.buymore.cia.door.Door;
import com.buymore.cia.gadget.Gadget;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
@Entity
public class SpyBase {
    private static final Logger log = LoggerFactory.getLogger(SpyBase.class);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long spyBaseId; // Unique identifier for the SpyBase, if needed
    private String location;
    private String classification;
    private String alias;
    @OneToMany
    private List<Door> doors;
    @OneToMany
    private List<Agent> agents;
    @OneToMany
    private List<Gadget> gadgets;

    public SpyBase(long spyBaseId, String location, String classification, String alias) {
        this.spyBaseId = spyBaseId;
        this.location = location;
        this.classification = classification;
        this.alias = alias;
        this.doors = new ArrayList<>();
        this.agents = new ArrayList<>();
        this.gadgets = new ArrayList<>();
    }

    public SpyBase(String location, String classification, String alias) {
        this.location = location;
        this.classification = classification;
        this.alias = alias;
        this.doors = new ArrayList<>();
        this.agents = new ArrayList<>();
        this.gadgets = new ArrayList<>();
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

    public long getSpyBaseId() {
        return spyBaseId;
    }

    public void setSpyBaseId(long spyBaseId) {
        this.spyBaseId = spyBaseId;
    }

    public void setGadgets(List<Gadget> gadgets) {
        this.gadgets = gadgets;
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
