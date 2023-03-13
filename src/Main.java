
import Agents.AgentBuy;
import Agents.AgentSell;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

import java.util.Properties;

public class Main {
    public static void main(String[] args) throws StaleProxyException {
        Profile profile = new ProfileImpl();

        Runtime run = Runtime.instance();
        AgentContainer container = run.createAgentContainer(profile);

        AgentSell Vendendor1 = new AgentSell();
        AgentBuy Comprador1 = new AgentBuy();


        try {
            container.acceptNewAgent("Seller1",Vendendor1);
        } catch (StaleProxyException e) {
            throw new RuntimeException(e);
        }
        container.acceptNewAgent("Buyer",Comprador1);

        Vendendor1.updateCatalogue("PHP",50);
        Vendendor1.updateCatalogue("Java",150);

        Vendendor1.run();
        Comprador1.run();
    }
}