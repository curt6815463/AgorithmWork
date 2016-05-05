
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Test {

	public static void main(String[] args) {		
		JFrame frame = new JFrame("Algorithm");
		frame.setSize(680,450);
		JPanel panel = new JPanel();
		
		JLabel inputLab = new JLabel("Input");
		JTextField text = new JTextField(30);
		JLabel ansLab = new JLabel("ANS:");
		JTextField ansText = new JTextField(30);
		JButton btn1 = new JButton("click");
		
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(7,7,7,7);
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(inputLab, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		panel.add(text, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(ansLab, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		panel.add(ansText, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(btn1, gbc);
		frame.add(panel);
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
		
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String s = text.getText();
				ansText.setText(UserInput.dealInput(s));
			}
		});
	}
}

