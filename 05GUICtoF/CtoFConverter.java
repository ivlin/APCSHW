import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CtoFConverter extends JFrame implements ActionListener{
    private Container pane;
    private JTextField t;
    private JButton ctof, ftoc;
    private JLabel ans;

    public CtoFConverter(){
	this.setTitle("Celsius to Fahrenheit Converter");
	this.setSize(400,200);
	this.setLocation(50,50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	t = new JTextField(10);
	t.setHorizontalAlignment(JTextField.CENTER);
	ctof = new JButton("Celsius to Fahrenheit");
	ftoc = new JButton("Fahrenheit to Celsius");
	ans = new JLabel(" ");

	ctof.setActionCommand("ctof");
	ctof.addActionListener(this);
	ftoc.setActionCommand("ftoc");
	ftoc.addActionListener(this);

	pane.add(t);
	pane.add(ctof);
	pane.add(ftoc);
	pane.add(ans);
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("ctof")){
	    int temp = Integer.parseInt(t.getText());
	    temp = temp * 9 / 5 + 32;
	    ans.setText(temp + " degrees Fahrenheit");
	}
	if (action.equals("ftoc")){
	    int temp = Integer.parseInt(t.getText());
	    temp = (temp - 32) * 5 / 9;
	    ans.setText(temp + " degrees Celsius");
	}
    }

    public static void main(String[]args){
	CtoFConverter w = new CtoFConverter();
	w.setVisible(true);
    }
}
