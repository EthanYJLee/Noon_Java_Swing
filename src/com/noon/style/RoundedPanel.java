package com.noon.style;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.BasicStroke;

public class RoundedPanel extends JPanel {

	//
	LineBorder lineBorder = new LineBorder(Color.BLACK, 3, true); // tf 라운드주기

	//
	JPanel p = new JPanel() {
//		@Override
//		protected void paintComponent(Graphics g) {
//			super.paintComponent(g);
//			Dimension arcs = new Dimension(15, 15); // Border corners arcs {width,height}, change this to whatever you
//													// want
//			int width = getWidth();
//			int height = getHeight();
//			Graphics2D graphics = (Graphics2D) g;
//			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // Draws the
//																											// rounded
//																											// panel
//																											// with
//																											// borders.
//			graphics.setColor(getBackground());
//			graphics.fillRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);// paint background
//			graphics.setColor(getForeground());
//			graphics.drawRoundRect(0, 0, width - 1, height - 1, arcs.width, arcs.height);// paint border
//		}

		// 판넬 메인에서사용 ----------
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			g2.setColor(getBackground()); 
			g2.fillRoundRect(0, 0, getWidth() , getHeight(), 15,15); 
			super.paintComponent(g); 
		}
		// ------------------
	
	};
	
	
	
	
//	  JFrame f = new JFrame();   
//	  f.setLayout(null);   
//	  f.setDefaultCloseOperation(3);   
//	  f.setSize(500, 500);   
//	  
//	  JPanel p = new JPanel() {      
//		  @Override      
//		  protected void paintComponent(Graphics g) {         
//			  super.paintComponent(g);         
//			  Dimension arcs = new Dimension(15,15);         
//			  int width = getWidth();         
//			  int height = getHeight();         
//			  Graphics2D graphics = (Graphics2D) g;         
//			  graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);           
//			  //Draws the rounded opaque panel with borders.         
//			  graphics.setColor(getBackground());         
//			  graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background         
//			  graphics.setColor(getForeground());         
//			  graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint border      
//			  }   
//		  };   
//		  p.setBounds(10,10,100,30);   
//		  p.setOpaque(false);   
//		  f.getContentPane().setBackground(Color.red);   
//		  f.add(p);   
//		  f.show(); 
//		  }
//	  }
//	  

	////
	/** Stroke size. it is recommended to set it to 1 for better view */
	protected int strokeSize = 1;
	/** Color of shadow */
	protected Color shadowColor = Color.pink;
	/** Sets if it drops shadow */
	protected boolean shady = true;
	/** Sets if it has an High Quality view */
	protected boolean highQuality = true;
	/** Double values for Horizontal and Vertical radius of corner arcs */
	protected Dimension arcs = new Dimension(20, 20);
	/** Distance between shadow border and opaque panel border */
	protected int shadowGap = 5;
	/** The offset of shadow. */
	protected int shadowOffset = 4;
	/** The transparency value of shadow. ( 0 - 255) */
	protected int shadowAlpha = 150;

	public RoundedPanel() {
		super();
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int width = getWidth();
		int height = getHeight();
		int shadowGap = this.shadowGap;
		Color shadowColorA = new Color(shadowColor.getRed(), shadowColor.getGreen(), shadowColor.getBlue(),
				shadowAlpha);
		Graphics2D graphics = (Graphics2D) g;

		// Sets antialiasing if HQ.
		if (highQuality) {
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}

		// Draws shadow borders if any.
		if (shady) {
			graphics.setColor(shadowColorA);
			graphics.fillRoundRect(shadowOffset, // X position
					shadowOffset, // Y position
					width - strokeSize - shadowOffset, // width
					height - strokeSize - shadowOffset, // height
					arcs.width, arcs.height);// arc Dimension
		} else {
			shadowGap = 1;
		}

		// Draws the rounded opaque panel with borders.
		graphics.setColor(getBackground());
		graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
		graphics.setColor(getForeground());
		graphics.setStroke(new BasicStroke(strokeSize));
		graphics.drawRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);

		// Sets strokes to default, is better.
		graphics.setStroke(new BasicStroke());
	}

	////

}
