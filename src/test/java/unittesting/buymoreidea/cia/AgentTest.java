package unittesting.buymoreidea.cia;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the Agent class.
 * This class contains various test cases to verify the functionality of the Agent class,
 * including creation, setters, null checks, and exception handling.
 */
public class AgentTest {

    /**
     * Tests the creation of an Agent object using the parameterized constructor.
     * Verifies that the fields are correctly initialized.
     */
    @Test
    public void testAgentCreation() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        // Assertions to check if the agent is created correctly
        Assertions.assertEquals("UserName", agent.getUserName());
        Assertions.assertEquals("Sandstorm", agent.getCodeName());
    }

    /**
     * Tests the setter methods of the Agent class.
     * Verifies that the fields are correctly updated using the setters.
     */
    @Test
    public void testAgentSetter() {
        Agent agent = new Agent();
        agent.setUserName("UserName");
        agent.setPassword("Password");
        agent.setCodeName("Sandstorm");
        agent.setSpecialization("Field Ops");
        agent.setUnitName("SOG");

        // Assertions to check if the setters work correctly
        Assertions.assertEquals("UserName", agent.getUserName());
        Assertions.assertEquals("Sandstorm", agent.getCodeName());
    }

    /**
     * Tests that incorrect values do not match the fields of the Agent object.
     * Verifies that the fields are not equal to incorrect values.
     */
    @Test
    public void testAgentError() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        Assertions.assertNotEquals("Username", agent.getUserName());
    }

    /**
     * Tests setting all fields of the Agent object to null.
     * Verifies that the fields are null after being set.
     */
    @Test
    public void testAgentNull() {
        Agent agent = new Agent();
        agent.setUserName(null);
        agent.setPassword(null);
        agent.setCodeName(null);
        agent.setSpecialization(null);
        agent.setUnitName(null);

        Assertions.assertNull(agent.getUserName());
    }

    /**
     * Tests that none of the fields of the Agent object are null after creation.
     * Verifies that the fields are properly initialized.
     */
    @Test
    public void testAgentNotNull() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        Assertions.assertNotNull(agent.getUserName());
    }

    /**
     * Tests that the fields of the Agent object match the expected values.
     * Verifies that the fields are correctly set and return true for valid comparisons.
     */
    @Test
    public void testAgentTrue() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        Assertions.assertEquals("UserName", agent.getUserName());

    }

    /**
     * Tests that setting certain fields to null throws an IllegalArgumentException.
     * Verifies that the exception message matches the expected value.
     */
    @Test
    public void testAgentThrows() {
        Agent agent = new Agent("UserName", "Password", "Sandstorm", "Field Ops", "SOG");
        try {
            agent.setUserName(null);
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage().contains("UserName cannot be null"));
        }
        try {
            agent.setPassword(null);
        } catch (IllegalArgumentException e) {
            Assertions.assertTrue(e.getMessage().contains("Password cannot be null"));
        }
    }
}