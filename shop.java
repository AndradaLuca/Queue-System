package tema2;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class shop extends JPanel {
	public void coloreaza() {
		this.setBackground(Color.WHITE);
		
	}

	@Override
	public void paintComponent(Graphics graphics) {
		

		super.paintComponent(graphics);
		int x = 50;
		for (int i = 0; i < Market.cozi.size(); i++) {
			int y = 50;
			// desenez casele
			if(Market.cozi.get(i).size()==0)
			{
			deseneazaCasa(graphics, x, y);
			}else{
				deseneazaCasa2(graphics,x,y);
			}
			
				
			for (int j = 0; j < Market.cozi.get(i).size(); j++) {
				y += 50;
				// desenezClienti
				if(j!=0)
				{
					deseneazaClient(graphics,x,y);
				}
				if(j==0){
			
				deseneazaClient2(graphics, x, y);
			}}

			x += 100;

		}

	}
	
	private void deseneazaCasa2(Graphics colorat, int x, int y) {
		Random color = new Random();
		float R = color.nextFloat();
		float G = color.nextFloat();
		float B = color.nextFloat();

		Color randomColor = new Color(R, G, B);

		colorat.setColor(Color.GREEN);
		colorat.fill3DRect(x, y, 70, 50, true);
		repaint();
	}

	private void deseneazaCasa(Graphics color, int x, int y) {
		color.setColor(Color.GRAY);
		color.fillRect(x, y, 70, 50);
		repaint();
	}

	private void deseneazaClient(Graphics colorat, int x, int y) {
		

		colorat.setColor(Color.ORANGE);
		colorat.fillOval(x, y, 25, 25);
		repaint();
	}
	
	private void deseneazaClient2(Graphics colorat, int x, int y) {
		

		colorat.setColor(Color.red);
		colorat.fillOval(x, y, 25, 25);
		repaint();
	}

}

