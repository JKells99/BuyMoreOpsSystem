package unittesting.buymoreidea.cia;

import org.junit.jupiter.api.Test;

public class AgentTest {
    @Test
    public void testAgentCreation() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        // Assertions to check if the agent is created correctly
        assert agent.getUserName().equals("UserName");
        assert agent.getCodeName().equals("Sandstorm");
        assert agent.getSpecialization().equals("Field Ops");
        assert agent.getUnitName().equals("SOG");

    }

    @Test
    public void testAgentSetter() {
        Agent agent = new Agent();
        agent.setUserName("UserName");
        agent.setPassword("Password");
        agent.setCodeName("Sandstorm");
        agent.setSpecialization("Field Ops");
        agent.setUnitName("SOG");

        // Assertions to check if the setters work correctly
        assert agent.getUserName().equals("UserName");
        assert agent.getCodeName().equals("Sandstorm");
        assert agent.getSpecialization().equals("Field Ops");
        assert agent.getUnitName().equals("SOG");
    }

    @Test
    public void testAgentError() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        // Assertions to check if the agent is created correctly
        assert !agent.getUserName().equals("WrongUserName");
        assert !agent.getCodeName().equals("WrongCodeName");
        assert !agent.getSpecialization().equals("WrongSpecialization");
        assert !agent.getUnitName().equals("WrongUnitName");
    }

    @Test
    public void testAgentNull() {
        Agent agent = new Agent();
        agent.setUserName(null);
        agent.setPassword(null);
        agent.setCodeName(null);
        agent.setSpecialization(null);
        agent.setUnitName(null);


        assert agent.getUserName() == null;
        assert agent.getCodeName() == null;
        assert agent.getSpecialization() == null;
        assert agent.getUnitName() == null;
    }


}
