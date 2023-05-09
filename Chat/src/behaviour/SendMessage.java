package behaviour;

import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessage extends OneShotBehaviour {
	String msgg, forr, from;
	
	public SendMessage(String message, String forr, String from){
		this.msgg = message;
		this.forr = forr;
		this.from = from;
	}
	
	public void action() {
		try {
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.addReceiver(new AID(forr, false));
			msg.setContent(msgg);
			
			msg.addUserDefinedParameter("from", from);
			myAgent.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString() + " send");
		}
	}
}
