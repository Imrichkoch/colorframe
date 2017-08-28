import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;



public class ColorFrame extends JFrame{
	private int z =0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 3771966842905161221L;
	
	public ColorFrame(){
		z = 0;
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("ColorFrame");
		Toolkit tk = Toolkit.getDefaultToolkit();

		Dimension dim = tk.getScreenSize(); //objekt mi vrati udaje o mojej obrazovke z coho si neskor mozem vypocita kde je stred obrazovky
		
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		
		this.setLocation(xPos, yPos);
		
		addMouseMotionListener(new MouseMotionHandler());
		
		addMouseWheelListener(new MouseMotionHandler());

	}
	
	
	
	
	private class MouseMotionHandler implements MouseMotionListener, MouseWheelListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
			Dimension windowSize = getContentPane().getSize();
			
			int x = (int) (240*(e.getX()/windowSize.getWidth()));//ak som dal 255, tak mi to zle vypocitalo a vypisalo errory
			int y = (int) (240*(e.getY()/windowSize.getHeight()));
			
			
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension dim = tk.getScreenSize();
			

			
			System.out.println("x= "+ x + " y= " + y );
			
			getContentPane().setBackground(new Color(x, y, z));
			
			
			
	
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			
			
			if( e.getWheelRotation()==1){
				z+=10;if(z>256)z=0;
				System.out.println(z);
			}else if(e.getWheelRotation()==-1){
				z-=10;if(z<0)z=255;
				System.out.println(z);
			}
			
			
			
		}
		
		
	}
}
