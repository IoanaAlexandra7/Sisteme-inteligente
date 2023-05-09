package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import FIPA.stringsHelper;
import agents.SecondAgent;
import agents.FirstAgent;
import jade.core.AID;
import jade.core.Agent;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Window.Type;

public class Chat extends JFrame {

	public JLabel usernameLabel = new JLabel("Username: \"Username\"");
	public JTextArea chatTextArea = new JTextArea();
	public JButton clearButton = new JButton("DELETE");
	public JButton sendButton = new JButton("SEND");
	public FirstAgent sender;
	public SecondAgent receiver;
	public JLabel lblNewLabel_2 = new JLabel("TextMessage:");
	public JTextArea messageTextArea = new JTextArea();

	public Chat(FirstAgent _agent,SecondAgent _agent2) {
		getContentPane().setBackground(Color.GRAY);
		setForeground(Color.GREEN);
		setTitle("Application");

		sender = _agent;
		receiver = _agent2;

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		usernameLabel.setForeground(Color.GREEN);
		usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		usernameLabel.setBounds(10, 11, 366, 18);
		getContentPane().add(usernameLabel);
		chatTextArea.setBackground(Color.LIGHT_GRAY);
		chatTextArea.setForeground(Color.BLACK);
		chatTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		chatTextArea.setBounds(10, 119, 317, 130);
		getContentPane().add(chatTextArea);
		clearButton.setForeground(Color.DARK_GRAY);
		clearButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chatTextArea.setText("");
				JOptionPane.showMessageDialog(getContentPane(), "Chat text has been cleared");
			}
		});

		clearButton.setBounds(337, 162, 89, 50);
		getContentPane().add(clearButton);
		sendButton.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		sendButton.setForeground(Color.DARK_GRAY);
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (messageTextArea.getText().trim().isEmpty()) { 
					JOptionPane.showMessageDialog(getContentPane(), "Message should not be empty");
				} else {
					if (sender != null)
					{
						sender.sendMessage();
					}
					else {
						receiver.sendMessage();
					}
				}
			}
		});

		sendButton.setBounds(337, 62, 89, 40);
		getContentPane().add(sendButton);
		lblNewLabel_2.setForeground(Color.GREEN);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		lblNewLabel_2.setBounds(10, 39, 317, 24);
		getContentPane().add(lblNewLabel_2);
		messageTextArea.setBackground(Color.LIGHT_GRAY);
		messageTextArea.setForeground(Color.BLACK);
		messageTextArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		messageTextArea.setBounds(10, 69, 317, 40);
		
		getContentPane().add(messageTextArea);
		this.setVisible(true);
	}
	
	public void setText(String from, String message) {
		chatTextArea.append("Message from " + from + ": " + message);
		chatTextArea.append("\n");
	}

	private void initListeners() {
		Chat zis = this;
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chatTextArea.getText().length() != 0) {
				} else
					JOptionPane.showMessageDialog(getContentPane(), "Please type something");
			}
		});
	}
}
