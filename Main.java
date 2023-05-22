import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Main {
	public void go() {
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350,400);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		Main gui = new Main();	
		gui.go();
	}
}