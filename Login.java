import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;

public class Login implements ActionListener {
	
	private static JPanel panel = new JPanel();
	private static JFrame frame = new JFrame();
	private static JLabel userLabel = new JLabel("Username"), passLabel = new JLabel("Password");
	private static JTextField userText = new JTextField();
	private static JPasswordField passField = new JPasswordField();
	private static JButton loginButton = new JButton("Login"), registerButton = new JButton("Register");
	private static JButton logoutButton = new JButton("Logout");
	private static HashMap<String, String> map = new HashMap<String, String>();

	public static void main(String[] args) {
		
		frame.setSize(350, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		userLabel.setBounds(10, 20, 80, 25);
		panel.add(userLabel);
		
		userText.setBounds(130, 20, 165, 25);
		panel.add(userText);
		
		passLabel.setBounds(10, 50, 80, 25);
		panel.add(passLabel);
		
		passField.setBounds(130, 50, 165, 25);
		panel.add(passField);
		
		loginButton.setBounds(230, 100, 65, 25);
		loginButton.addActionListener(new Login());
		panel.add(loginButton);
		
		registerButton.setBounds(135, 100, 85, 25);
		registerButton.addActionListener(new Login());
		panel.add(registerButton);
		
		label.setBounds(100, 65, 200, 25);
		logoutButton.setBounds(133, 85, 75, 25);
		logoutButton.addActionListener(new Login());
		
		map.put("Ghadi", "ghadi123");
		
		panel.add(label);
		
		frame.setVisible(true);
		
	}
	
	private static JLabel label = new JLabel();
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String user = userText.getText();
		String pass = String.valueOf(passField.getPassword());
		label.setForeground(Color.black);
		
		
		if(e.getSource() == registerButton && checkRegistration(user)) {
			label.setText("User already registered");
			label.setForeground(Color.red);
			label.setBounds(160, 70, 175, 25);
			panel.add(label);
		}
		
		else if(e.getSource() == registerButton && !checkRegistration(user)) {
			label.setText("Registration successful!");
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			map.put(user, pass);
			panel.add(label);
			panel.add(logoutButton);
		}
		
		else if(e.getSource() == logoutButton) {
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			panel.add(userLabel);
			userText.setText("");
			panel.add(userText);
			panel.add(passLabel);
			passField.setText("");
			panel.add(passField);
			panel.add(loginButton);
			panel.add(registerButton);
		}
		
		else if(!checkLogin(user, pass)) {
			label.setText("Invalid username or password!");
			label.setForeground(Color.red);
			label.setBounds(120, 70, 175, 25);
		}
		
		else if(checkLogin(user, pass)) {
			label.setText("Login successful!");
			label.setBounds(118, 60, 200, 25);
			panel.removeAll();
			panel.revalidate();
			panel.repaint();
			panel.add(label);
			panel.add(logoutButton);
		}
		
	}
	
	private boolean checkRegistration(String user) {
		
		if(map.get(user) == null) {
			return false;
		}
		
		return true;
		
	}
	
	private boolean checkLogin(String user, String pass) {
		
		if(map.get(user) == null) {
			return false;
		}
		
		return map.get(user).equals(pass);
		
	}

}
