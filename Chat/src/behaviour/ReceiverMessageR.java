package behaviour;

import agents.SecondAgent;
import agents.FirstAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiverMessageR extends CyclicBehaviour {

	public void action() {
		String message;
		String sender;

		ACLMessage msg = myAgent.receive();
		SecondAgent secondAgent = (SecondAgent)myAgent;
		if (msg != null) {
			sender = msg.getUserDefinedParameter("from");
			message = msg.getContent();
			secondAgent.gui.chatTextArea.append(sender + ": " + message + "\n");
			
		}
		block();
	}

}