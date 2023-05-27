import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

// Implement Calculator Logic Here
class Calculator {
	public int firstOperand;
	public int secondOperand;
}
class CalculatorUI {
	private Calculator calculator;
	// protected class CalculatorButton extends JButton {
	// 	public CalculatorButton(String text) {
	// 		super(text);
	// 	}
	// 	public void paintComponent (Graphics g) {
	// 		Graphics2D g2d = (Graphics2D) g;
	// 		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	// 		g2d.setColor(new Color(159, 95, 248));
	// 	}
	// }
	protected class RoundedBorder implements Border {
          private int radius;
          private Color color;
 
          RoundedBorder(int radius, Color color) {
                 this.radius = radius;
                 this.color = color;
          }
          @Override
          public Insets getBorderInsets(Component c) {
                 return new Insets(this.radius + 1, this.radius + 1,
                              this.radius + 2, this.radius);
          }
          @Override
          public boolean isBorderOpaque() {
                 return true;
          }
          @Override
          public void paintBorder(Component c, Graphics g, int x, int y,
                       int width, int height) {
                 g.setColor(color);
                 g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
          }
   }
	private void buttonDesigner(JButton button) {
		button.setBackground(Color.white);
		button.setBorder(new RoundedBorder(10, Color.BLACK));
		button.setFont(new Font("Tahoma",Font.BOLD,20));
	}
	public void go() {
		//screenOutput => Result eg. (result of 2+2) [4]
		//screenOutput2 => Operation eg. [2+2]
		JFrame frame = new JFrame("Minimalistic Calculator");
		Image icon = new ImageIcon("icon.png").getImage();
		Color themeColor = new Color(159, 95, 248);
		calculator  = new Calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(335,600);
		frame.setResizable(false);
		frame.setIconImage(icon);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.WHITE);

		JPanel screen = new JPanel();
		screen.setBackground(new Color(25,25,25));
		screen.setPreferredSize(new Dimension(frame.getWidth(),200));
		BorderLayout screenLayout = new BorderLayout();
		screen.setLayout(screenLayout);
		screen.setBorder(new EmptyBorder(10,10,10,10));
		JLabel screenOutput = new JLabel("Hello");
		screenOutput.setFont(new Font(screenOutput.getFont().getFontName(),Font.BOLD,50));
		screenOutput.setForeground(Color.WHITE);
		
		JPanel screen2 = new JPanel();
		FlowLayout screenLayout2 = new FlowLayout();
		screenLayout2.setAlignment(FlowLayout.TRAILING);
		screen2.setLayout(screenLayout2);
		screen2.setBackground(screen.getBackground());
		JLabel screenOutput2 = new JLabel("4+4");
		screenOutput2.setFont(new Font(screen2.getFont().getFontName(),Font.PLAIN,25));
		screenOutput2.setForeground(themeColor);
		screen2.add(screenOutput2);

		JPanel buttonPanel = new JPanel();
		int buttonPanelPadding = 15;
		buttonPanel.setBorder(new EmptyBorder(buttonPanelPadding+5,buttonPanelPadding,buttonPanelPadding,buttonPanelPadding));
		GridLayout buttonPanelLayout = new GridLayout(5,4,buttonPanelPadding-5,buttonPanelPadding-5);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanel.setBackground(Color.WHITE);

		JButton buttonPercent = new JButton("%");
		JButton buttonClearEntry = new JButton("CE");
		JButton buttonAllClear = new JButton("AC");
		JButton buttonDivide = new JButton("AC");
		JButton buttonMultiply = new JButton("x");
		JButton buttonMinus = new JButton("-");
		JButton buttonPlus = new JButton("+");
		JButton buttonEqual = new JButton("=");

		JButton buttonBlank = new JButton();
		JButton buttonDot = new JButton(".");
		JButton button0 = new JButton("0");
		JButton button1 = new JButton("1");
		JButton button2 = new JButton("2");
		JButton button3 = new JButton("3");
		JButton button4 = new JButton("4");
		JButton button5 = new JButton("5");
		JButton button6 = new JButton("6");
		JButton button7 = new JButton("7");
		JButton button8 = new JButton("8");
		JButton button9 = new JButton("9");

		JButton CalculatorButtonGroups[] = 
			{
				buttonPercent,buttonClearEntry,buttonAllClear,buttonDivide,
				button7,button8,button9,buttonMultiply,
				button4,button5,button6,buttonMinus,
				button1,button2,button3, buttonPlus,
				buttonBlank,button0,buttonDot,buttonEqual
			}; 
		for (JButton button : CalculatorButtonGroups) {
			buttonPanel.add(button);
			buttonDesigner(button);
		}
		//Custom Bottom
		buttonEqual.setBorder(new RoundedBorder(10, themeColor));

		screen.add(BorderLayout.LINE_END,screenOutput);
		screen.add(BorderLayout.SOUTH,screen2);	
		frame.getContentPane().add(BorderLayout.NORTH,screen);
		frame.getContentPane().add(BorderLayout.CENTER,buttonPanel);
		frame.revalidate();
		frame.repaint();
	}
}
public class Main {
	public static void main(String[] args) {
		CalculatorUI gui = new CalculatorUI();
		gui.go();
	}
}
