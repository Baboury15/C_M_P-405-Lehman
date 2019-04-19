import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChatWindows extends JFrame implements ActionListener {

	JTextField texfieldName;
	DatagramSocket mSocket;
	String USER_NAME = "Ibra";

	public ChatWindows(DatagramSocket mSocket) {

		this.mSocket = mSocket;

		JFrame menu = new JFrame("Dialogue");
		menu.setPreferredSize(new Dimension(600, 150));

		JPanel top = new JPanel();

		JLabel jlName = new JLabel("Name: ");
		this.texfieldName = new JTextField("", 20);
		texfieldName.addActionListener(this);

		top.add(jlName, BorderLayout.EAST);
		top.add(texfieldName, BorderLayout.CENTER);

		JButton btnBroadcast = new JButton("Start Broadcast");
		btnBroadcast.addActionListener(this);

		menu.add(top, BorderLayout.NORTH);
		menu.add(btnBroadcast, BorderLayout.SOUTH);

		menu.pack();

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		menu.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String name = texfieldName.getText().toString();
		Driver.broadcastProtocol(mSocket, name);
		texfieldName.setText("");
	}

}