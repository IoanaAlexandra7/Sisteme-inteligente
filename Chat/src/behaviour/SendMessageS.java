package behaviour;

import Utils.ServerSingleton;
import gui.Chat;
import jade.core.AID;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;

public class SendMessageS extends OneShotBehaviour {
	Chat gui;
	String myTypeString;

	public SendMessageS(Chat gui, String myType) {
		this.gui = gui;
		this.myTypeString = myType;
	}

	@Override
	public void action() {
		try {
			ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
			msg.addReceiver(new AID("server", false));
			msg.setContent(gui.messageTextArea.getText().trim());
			gui.chatTextArea.append(myAgent.getLocalName() +": "+ gui.messageTextArea.getText().trim() + "\n");
			gui.messageTextArea.setText("");
			if(myTypeString == "sender") {
				msg.addUserDefinedParameter("for", ServerSingleton.getInstance().receiverNameString);
				msg.addUserDefinedParameter("from", ServerSingleton.getInstance().senderNameString);
			}
			else {
				msg.addUserDefinedParameter("for", ServerSingleton.getInstance().senderNameString);
				msg.addUserDefinedParameter("from", ServerSingleton.getInstance().receiverNameString);
			}
			
			
			myAgent.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString() + " send");
		}
	}
}
