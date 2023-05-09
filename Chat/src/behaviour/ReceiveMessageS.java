package behaviour;

import agents.FirstAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveMessageS extends CyclicBehaviour {

	public void action() {
		String message;
		String sender;

		ACLMessage msg = myAgent.receive();
		FirstAgent firstAgent = (FirstAgent)myAgent;
		if (msg != null) {
			sender = msg.getUserDefinedParameter("from");
			message = msg.getContent();
			firstAgent.gui.chatTextArea.append(sender + ": " + message + "\n");
		}
		block();
	}

}
