import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ColorFrame extends JFrame {
	private int x, y, z;

	@Override
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	@Override
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	private static final long serialVersionUID = 3771966842905161221L;

	public ColorFrame() {

		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("ColorFrame");

		addMouseMotionListener(new MouseMotionHandler());

		addMouseWheelListener(new MouseMotionHandler());

	}

	private class MouseMotionHandler implements MouseMotionListener, MouseWheelListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseMoved(MouseEvent e) {

			Dimension windowSize = getContentPane().getSize();

			x = (int) (240 * (e.getX() / windowSize.getWidth()));
			y = (int) (240 * (e.getY() / windowSize.getHeight()));

			System.out.println("x= " + x + " y= " + y);

			getContentPane().setBackground(new Color(x, y, z));

		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {

			if (e.getWheelRotation() == 1) {
				z += 10;
				if (z > 256)
					z = 0;
				System.out.println(z);
			} else if (e.getWheelRotation() == -1) {
				z -= 10;
				if (z < 0)
					z = 255;
				System.out.println(z);
			}

			getContentPane().setBackground(new Color(x, y, z));

		}

	}
}
