package behaviour;

import agents.SecondAgent;
import agents.FirstAgent;
import agents.ThirdAgent;
import jade.core.behaviours.OneShotBehaviour;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class CreateA extends OneShotBehaviour {
	private String numa_utilizator;
	private FirstAgent user;
	private SecondAgent user2;
	private String nume_utilizator2;
	
	public CreateA(FirstAgent a, String _nume_utilizator, SecondAgent b, String _nume_utilizator2) {
		super(a);
		numa_utilizator = _nume_utilizator;
		user = a;
		nume_utilizator2 = _nume_utilizator2;
		user2 = b;
	}

	@Override
	public void action() {
		AgentController controller;
		try {
			controller = myAgent.getContainerController().acceptNewAgent(numa_utilizator, user);
			controller.start();

			controller = myAgent.getContainerController().acceptNewAgent(nume_utilizator2, user2);
			controller.start();

		} catch (StaleProxyException e) {
			System.out.println("Create new agent Behaviour");
			e.printStackTrace();
		}
	}
}
