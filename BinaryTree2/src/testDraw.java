import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.*;

public class testDraw extends JComponent {

	public void paintcomponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		Rectangle rect1 = new Rectangle(5,5,100,200);
		g2.draw(rect1);
	}
}
