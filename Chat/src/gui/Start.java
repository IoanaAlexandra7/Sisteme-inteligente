package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Utils.ServerSingleton;
import agents.ThirdAgent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class Start extends JFrame {

	private JPanel contentPane;
	private JTextField senderTextField;
	private JTextField receiverTextField;
	public ThirdAgent server;
	
	
	public Start(ThirdAgent _server) {
		setTitle("Application");
		server = _server;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SENDER");
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 10, 414, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RECEIVER");
		lblNewLabel_1.setForeground(Color.GREEN);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 93, 414, 24);
		contentPane.add(lblNewLabel_1);
		
		senderTextField = new JTextField();
		senderTextField.setBackground(Color.LIGHT_GRAY);
		senderTextField.setForeground(Color.BLACK);
		senderTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		senderTextField.setBounds(10, 47, 186, 36);
		contentPane.add(senderTextField);
		senderTextField.setColumns(10);
		
		receiverTextField = new JTextField();
		receiverTextField.setBackground(Color.LIGHT_GRAY);
		receiverTextField.setForeground(Color.BLACK);
		receiverTextField.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		receiverTextField.setBounds(10, 127, 186, 34);
		contentPane.add(receiverTextField);
		receiverTextField.setColumns(10);
		
		JButton chatButton = new JButton("CHAT");
		chatButton.setForeground(Color.GREEN);
		chatButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		chatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (senderTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "Choose an username for sender");
				} else if (receiverTextField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(getContentPane(), "Choose an username for receiver");
				}
				else if (senderTextField.getText().trim().equalsIgnoreCase( receiverTextField.getText().trim())) { 
					JOptionPane.showMessageDialog(getContentPane(), "Sender and receiver should have distinct names");
				} else {
					ServerSingleton.getInstance().senderNameString = senderTextField.getText().trim();
					ServerSingleton.getInstance().receiverNameString = receiverTextField.getText().trim();
					server.createAgents(senderTextField.getText().trim(), receiverTextField.getText().trim());
				}
			}
		});
		chatButton.setBounds(165, 202, 109, 48);
		contentPane.add(chatButton);

		setVisible(true);
	}
}
