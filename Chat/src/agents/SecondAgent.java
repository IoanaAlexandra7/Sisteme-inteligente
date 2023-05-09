package agents;


import behaviour.ReceiverMessageR;
import behaviour.SendMessageS;
import gui.Chat;
import jade.core.Agent;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

public class SecondAgent extends Agent {
	public Chat gui;
	
	protected void setup() {
		// Registration with the DF
		DFAgentDescription dfd = new DFAgentDescription();
		ServiceDescription sd = new ServiceDescription();
		sd.setType("SecondAgent");
		sd.setName(getName());
		dfd.setName(getAID());
		dfd.addServices(sd);
		try {
			DFService.register(this, dfd);
			gui = new Chat(null, this);
			gui.usernameLabel.setText("Username:"+" "+getLocalName());
			addBehaviour(new ReceiverMessageR());
		} catch (FIPAException e) {
			doDelete();
		}
	}
	public void sendMessage() {
		SendMessageS sendMessageS = new SendMessageS(gui,"receiver");
		addBehaviour(sendMessageS);
	}
}
