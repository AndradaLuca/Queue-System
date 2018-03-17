package tema2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Gui extends JFrame {

	
	
	private JFrame frame = new JFrame("Queue Simulation");
	private JLabel label1 = new JLabel("Simulation Time");
	private JLabel label2 = new JLabel("Number of Queues");
	private JLabel label3 = new JLabel("Number Clients");
	private JLabel label4 = new JLabel("Minim Arriving Time");
	private JLabel label5 = new JLabel("Maxim Arriving Time");
	private JLabel label6 = new JLabel("Minim Serving Time");
	private JLabel label7 = new JLabel("Maxim Serving Time");
	public static JTextArea output = new JTextArea();
	
	

	private JTextField simulationt = new JTextField("");
	private JTextField numberq = new JTextField("");
	private JTextField numberc = new JTextField("");
	private JTextField maxarr = new JTextField("");
	private JTextField minarr = new JTextField("");
	private JTextField maxser = new JTextField("");
	private JTextField minser = new JTextField("");
	
	private JButton button = new JButton("Start Simulation");


	public Gui() {

		addComponents();
		jFrameSetup();

	}

	private void jFrameSetup() {
		
		frame.setBounds(100, 100, 1100, 900);

		
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		setLocationRelativeTo(null);
	
}
	public void addComponents() {

		label1.setBounds(350, 50, 100, 30);
		simulationt.setBounds(450, 50, 100, 30);
		frame.getContentPane().add(label1);
		frame.getContentPane().add(simulationt);

		label2.setBounds(335, 100, 150, 30);
		numberq.setBounds(450, 100, 100, 30);
		frame.getContentPane().add(label2);
		frame.getContentPane().add(numberq);
		
		label3.setBounds(340, 150, 150, 30);
		numberc.setBounds(450, 150, 100, 30);
		frame.getContentPane().add(label3);
		frame.getContentPane().add(numberc);

		label4.setBounds(330, 200, 150, 30);
		minarr.setBounds(450, 200, 100, 30);
		frame.getContentPane().add(label4);
		frame.getContentPane().add(minarr);

		label5.setBounds(330, 250, 150, 30);
		maxarr.setBounds(450, 250, 100, 30);
		frame.getContentPane().add(label5);
		frame.getContentPane().add(maxarr);

		label6.setBounds(330, 300, 150, 30);
		minser.setBounds(450, 300, 100, 30);
		frame.getContentPane().add(label6);
		frame.getContentPane().add(minser);

		label7.setBounds(330, 350, 150, 30);
		maxser.setBounds(450, 350, 100, 30);
		frame.getContentPane().add(label7);
		frame.getContentPane().add(maxser);
		
		output.setBounds(650, 50, 400, 550);
		frame.getContentPane().add(output);

	
		
		

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Market(int nrClienti, int nrCozi, int minArrivingTime, int maxArrivingTime, int minServingTime,
				//int maxServingTime, int timpulSimularii)
				
				Market test = new Market(Integer.parseInt(numberc.getText())-1,Integer.parseInt(numberq.getText()), Integer.parseInt(minarr.getText()),
						Integer.parseInt(maxarr.getText()), Integer.parseInt(minser.getText()),
						Integer.parseInt(maxser.getText()), Integer.parseInt(simulationt.getText()));

				test.start();
				System.out.println(Integer.parseInt(numberq.getText()));
			}
		});

		button.setBounds(350, 450, 200, 50);
		frame.getContentPane().add(button);
		
		

	}

	


	public static void main(String arg[]) {

		Gui interfata = new Gui();
		interfata.frame.setVisible(true);

	}

	
public static void setOutputText(String text) {
		output.setText(text);
	}

}
