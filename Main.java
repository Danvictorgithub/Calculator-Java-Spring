import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;

// Implement Calculator Logic Here
class Calculator {
	private String operandTemp = "";
	private double firstOperand = 0.0;
	private double secondOperand = 0.0;
	private double secondOperandMem = 0.0;
	private boolean secondOperandIsEmpty = true;
	private String activeOperator = "";
	private String activeOperatorMem = "";
	private String result = "0";
	private String currentOperation = "";
	// private boolean dotToggle = false;
	public String numberConverter(double number) {
		// if (dotToggle == true) {
		// 	return String.valueOf(number);
		// }
		if (number % 1 == 0) {
			return String.valueOf((int)number);
		}
		return String.valueOf(number);
	}
	public String showResult() {
		return result;
	}
	public String showCurrentOperation() {
		//List of all input user input possibilities
		if (this.result == "0" && this.firstOperand != 0.0 && this.activeOperator == "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty) {
			currentOperation = String.format("%s", numberConverter(this.firstOperand));
		}
		else if (this.result == "0" && this.firstOperand != 0.0 && this.activeOperator != "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty) {
			currentOperation = String.format("%s%s", numberConverter(this.firstOperand),this.activeOperator);
		}
		else if (this.result == "0" && this.firstOperand != 0.0 && this.activeOperator != "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty == false) {
			currentOperation = String.format("%s%s%s", numberConverter(this.firstOperand),this.activeOperator,numberConverter(this.secondOperand));
		}
		else if (this.result == "0" && this.firstOperand != 0.0 && this.activeOperator != "" && this.secondOperand != 0.0 && this.secondOperandIsEmpty == false) {
			currentOperation = String.format("%s%s%s", numberConverter(this.firstOperand),this.activeOperator,numberConverter(this.secondOperand));
		}
		else if (this.result != "0" && this.firstOperand == 0.0 && this.activeOperator == "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty) {
			currentOperation = String.format("");
		}
		else if (this.result != "0" && this.firstOperand == 0.0 && this.activeOperator != "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty) {
			currentOperation = String.format("%s%s", "Ans",this.activeOperator);
		}
		else if (this.result != "0" && this.firstOperand == 0.0 && this.activeOperator == "" && this.secondOperand == 0.0 && this.secondOperandIsEmpty == false) {
			currentOperation = String.format("%s%s", "Ans",this.activeOperatorMem);
		}
		else if (this.result != "0" && this.firstOperand == 0.0 && this.activeOperator == "" && this.secondOperand != 0.0 && this.secondOperandIsEmpty == false) {
			currentOperation = String.format("%s%s%s", "Ans",this.activeOperatorMem,numberConverter(this.secondOperand));
		}
		else if (this.result != "0" && this.firstOperand == 0.0 && this.activeOperator != "" && this.secondOperand != 0.0 && this.secondOperandIsEmpty == false) {
			currentOperation = String.format("%s%s%s", "Ans",this.activeOperator,numberConverter(this.secondOperand));
		}
		else {
			currentOperation = String.format("");
		}
		return currentOperation;
	}
	public void setOperand(double number) {
		if (this.activeOperator == "" && this.result == "0") {
			this.firstOperand = number;
		}
		else {
			this.secondOperand = number;
			this.secondOperandIsEmpty = false;
		}
	}
	public void calculateSolve(Double num1, Double num2,String operator) {
		switch (operator) {
			case "+":
				setResult(numberConverter(num1 + num2));
				break;
			case "-":
				setResult(numberConverter(num1 - num2));
				break;
			case "/":
				if (num2 == 0) {
					setResult("0");
					break;
				}
				setResult(numberConverter(num1 / num2));
				break;
			case "x":
				setResult(numberConverter(num1 * num2));
				break;
			case "%":
				setResult(numberConverter((num1 / 100 ) * num2));
				break;
		}
	}
	public void calculateOperator() {

	}
	public void calculateEqual() {
		//combokeys
		if (result != "0" && this.activeOperator == "" && this.firstOperand == 0 && this.secondOperand == 0) {
			System.out.println(Double.valueOf(result));
			System.out.println(this.secondOperandMem);
			calculateSolve(Double.valueOf(result),this.secondOperandMem,activeOperatorMem);
			System.out.println(result);
			return;
		}
		else if (this.result !="0" && this.firstOperand == 0.0 && this.secondOperandIsEmpty == false && this.activeOperator == "") {
			calculateSolve(Double.valueOf(result),this.secondOperand,activeOperatorMem);
		}
		else if (this.result !="0" && this.firstOperand == 0.0 && this.secondOperandIsEmpty == false && this.activeOperator != "") {
			calculateSolve(Double.valueOf(result),this.secondOperand,activeOperator);
		}
		else {
			calculateSolve(this.firstOperand,this.secondOperand,activeOperator);
			this.firstOperand = 0;
				setSecondOperandMem(this.secondOperand);
			this.secondOperand  = 0;
			this.operandTemp = "";
				setActiveOperatorMem(this.activeOperator);
			this.activeOperator = "";
			this.secondOperandIsEmpty = true;
		}
	}
	public void CalculatorAllClear() {
		this.operandTemp = "";
		firstOperand = 0.0;
		secondOperand = 0.0;
		secondOperandMem = 0.0;
		secondOperandIsEmpty = true;
		activeOperator = "";
		activeOperatorMem = "";
		result = "0";
		currentOperation = "";
	}
	public void CalculatorClearEntry() {
		setOperand(0);
		this.operandTemp = "";
		this.secondOperandIsEmpty = true;
	}
	public String getActiveOperatorMem() {
		return activeOperatorMem;
	}
	public void setActiveOperatorMem(String activeOperatorMem) {
		this.activeOperatorMem = activeOperatorMem;
	}
	public double getSecondOperandMem() {
		return secondOperandMem;
	}
	public void setSecondOperandMem(double SecondOperandMem) {
		this.secondOperandMem = SecondOperandMem;
	}
	public String getCurrentOperation() {
		return currentOperation;
	}
	public void setCurrentOperation(String currentOperation) {
		this.currentOperation = currentOperation;
	}
	public String getOperandTemp() {
		return operandTemp;
	}
	public void setOperandTemp(String operandTemp) {
		this.operandTemp = operandTemp;
	}
	public double getFirstOperand() {
		return firstOperand;
	}
	public void setFirstOperand(double firstOperand) {
		this.firstOperand = firstOperand;
	}
	public double getSecondOperand() {
		return secondOperand;
	}
	public void setSecondOperand(double secondOperand) {
		this.secondOperand = secondOperand;
	}
	public String getActiveOperator() {
		return activeOperator;
	}
	public void setActiveOperator(String activeOperator) {
		this.activeOperator = activeOperator;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
class CalculatorUI {
	JFrame frame;
	JPanel screen;
	JPanel screen2;
	JLabel screenOutput;
	JLabel screenOutput2;
	private Calculator calculator;
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
	private void CalculatorNumberButtonHandler(JButton button) {
		calculator.setOperandTemp(calculator.getOperandTemp()+button.getText());
		calculator.setOperand(Double.valueOf(calculator.getOperandTemp()));
		screenOutput2.setText(calculator.showCurrentOperation());
	}
	private void CalculatorOperatorButtonHandler(JButton button) {
		calculator.setActiveOperator(button.getText());
		calculator.setOperandTemp("0");
		calculator.calculateOperator();
		screenOutput2.setText(calculator.showCurrentOperation());
		screenOutput.setText(calculator.showResult());
	}
	public void go() {
		//screenOutput => Result eg. (result of 2+2) [4]
		//screenOutput2 => Operation eg. [2+2]
		frame = new JFrame("Minimalistic Calculator");
		Image icon = new ImageIcon("icon.png").getImage();
		Color themeColor = new Color(159, 95, 248);
		calculator  = new Calculator();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(335,600);
		frame.setResizable(false);
		frame.setIconImage(icon);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.WHITE);

		screen = new JPanel();
		screen.setBackground(new Color(25,25,25));
		screen.setPreferredSize(new Dimension(frame.getWidth(),200));
		BorderLayout screenLayout = new BorderLayout();
		screen.setLayout(screenLayout);
		screen.setBorder(new EmptyBorder(10,10,10,10));
		screenOutput = new JLabel("Hello");
		screenOutput.setFont(new Font(screenOutput.getFont().getFontName(),Font.BOLD,50));
		screenOutput.setForeground(Color.WHITE);
		
		screen2 = new JPanel();
		FlowLayout screenLayout2 = new FlowLayout();
		screenLayout2.setAlignment(FlowLayout.TRAILING);
		screen2.setLayout(screenLayout2);
		screen2.setBackground(screen.getBackground());
		screen2.setPreferredSize(new Dimension(frame.getWidth(),50));
		screenOutput2 = new JLabel("");
		screenOutput2.setFont(new Font(screen2.getFont().getFontName(),Font.PLAIN,25));
		screenOutput2.setForeground(themeColor);
		screen2.add(screenOutput2);

		JPanel buttonPanel = new JPanel();
		int buttonPanelPadding = 15;
		buttonPanel.setBorder(new EmptyBorder(buttonPanelPadding+5,buttonPanelPadding,buttonPanelPadding,buttonPanelPadding));
		GridLayout buttonPanelLayout = new GridLayout(5,4,buttonPanelPadding-5,buttonPanelPadding-5);
		buttonPanel.setLayout(buttonPanelLayout);
		buttonPanel.setBackground(Color.WHITE);

		JButton buttonClearEntry = new JButton("CE");
		JButton buttonAllClear = new JButton("AC");
		JButton buttonEqual = new JButton("=");

		JButton buttonPercent = new JButton("%");
		JButton buttonDivide = new JButton("/");
		JButton buttonMultiply = new JButton("x");
		JButton buttonMinus = new JButton("-");
		JButton buttonPlus = new JButton("+");
		JButton buttonNegative = new JButton("[-]");

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
		//ActionListeners: Event List
		buttonAllClear.addActionListener(e -> {
			calculator.CalculatorAllClear();
			screenOutput.setText(calculator.showResult());
			screenOutput2.setText(calculator.showCurrentOperation());
		});
		buttonClearEntry.addActionListener(e -> {
			calculator.CalculatorClearEntry();
			screenOutput2.setText(calculator.showCurrentOperation());
		});
		buttonNegative.addActionListener(e -> {
			if (calculator.getOperandTemp() != "") {
				calculator.setOperandTemp("-"+calculator.getOperandTemp());
				calculator.setOperand(Double.valueOf(calculator.getOperandTemp()));
			}
			screenOutput.setText(calculator.showResult());
			screenOutput2.setText(calculator.showCurrentOperation());
		});
		buttonDot.addActionListener(e -> {
			calculator.setOperandTemp(calculator.getOperandTemp()+".");
			calculator.setOperand(Double.valueOf(calculator.getOperandTemp()));
			screenOutput2.setText(calculator.showCurrentOperation());
		});
		buttonEqual.addActionListener(e -> {
			calculator.calculateEqual();
			screenOutput2.setText(calculator.showCurrentOperation());
			screenOutput.setText(calculator.showResult());
		});
		JButton CalculatorNumberGroups[] = {button0,button1,button2,button3,button4,button5,button6,button7,button8,button9};
		for (JButton button : CalculatorNumberGroups) {
			button.addActionListener(e -> CalculatorNumberButtonHandler(button));
		}
		JButton CalculatorOperatorGroups[] = {buttonPercent,buttonPlus,buttonMinus,buttonDivide,buttonMultiply};
		for (JButton button : CalculatorOperatorGroups) {
			button.addActionListener(e -> CalculatorOperatorButtonHandler(button));
		}
		JButton CalculatorButtonGroups[] = 
			{
				buttonPercent,buttonClearEntry,buttonAllClear,buttonDivide,
				button7,button8,button9,buttonMultiply,
				button4,button5,button6,buttonMinus,
				button1,button2,button3, buttonPlus,
				buttonNegative,button0,buttonDot,buttonEqual
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

		screenOutput.setText(String.valueOf(calculator.showResult()));
		screenOutput2.setText(calculator.showCurrentOperation());
	}	
}
public class Main {
	public static void main(String[] args) {
		CalculatorUI gui = new CalculatorUI();
		gui.go();
	}
}
