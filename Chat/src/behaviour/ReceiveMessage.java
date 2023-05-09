package behaviour;

import Utils.ServerSingleton;
import agents.ThirdAgent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class ReceiveMessage extends CyclicBehaviour {
	public void action() {
		String message;
		String forr;
		String from;

		ACLMessage msg = myAgent.receive();
		ThirdAgent thirdAgent = (ThirdAgent) myAgent;
		if (msg != null ) {		
			forr = msg.getUserDefinedParameter("for");
			from = msg.getUserDefinedParameter("from");
			message = msg.getContent();
			thirdAgent.forwardMessage( message, forr,from);
		}
		block();
	}
}
