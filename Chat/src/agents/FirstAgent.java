package agents;

import behaviour.ReceiveMessageS;
import behaviour.SendMessageS;
import gui.Chat;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class FirstAgent extends Agent {
	public Chat gui;

	
	protected void setup() {
		// Registration with the DF
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType("FirstAgent");
		sd.setName(getName());
		dfd.setName(getAID());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
			gui = new Chat(this, null);
			gui.usernameLabel.setText("Username:"+" "+getLocalName());
			addBehaviour(new ReceiveMessageS());
		} catch (FIPAException e) {
			doDelete();
		}
	}
	
	public void sendMessage() {
		SendMessageS sendMessageS = new SendMessageS(gui,"sender");
		addBehaviour(sendMessageS);
	}
}
