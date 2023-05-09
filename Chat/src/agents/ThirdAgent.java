package agents;

import behaviour.CreateA;
import behaviour.ReceiveMessage;
import behaviour.SendMessage;
import gui.Start;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class ThirdAgent extends Agent {
	public Start gui;
	
	protected void setup() {
		// Registration with the DF
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType("ThirdAgent");
		sd.setName(getName());
		dfd.setName(getAID());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
			gui = new Start(this);
			
		addBehaviour(new ReceiveMessage());
			
		} catch (FIPAException e) {
			doDelete();
		}
	}

	public void createAgents(String sender, String receiver) {
		FirstAgent firstAgent = new FirstAgent();
		SecondAgent secondAgent = new SecondAgent();
		CreateA behaviour = new CreateA(firstAgent, sender, secondAgent, receiver);
		addBehaviour(behaviour);
	}
	
	public void forwardMessage(String message, String forr, String from) {
		SendMessage bhvBehaviour = new  SendMessage(message,forr,from);
		addBehaviour(bhvBehaviour);
	}
}
