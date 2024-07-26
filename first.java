package calculator;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;



@SuppressWarnings("unused")
public class first implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] numberButtons=new JButton[10];
    JButton[] functiButtons=new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;
    Font myFont=new Font("Ink Free",Font.BOLD,30);

    double num1=0,num2=0,reslt=0;
    char operator;

     first()
     {
        frame=new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);
        textField= new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);

        addButton=new JButton("+");
        subButton=new JButton("-");
        mulButton=new JButton("*");
        divButton=new JButton("/");
        decButton=new JButton(".");
        equButton=new JButton("=");
        delButton=new JButton("Delete");
        clrButton=new JButton("Clear");
        negButton=new JButton("(-)");

        functiButtons[0]=addButton;
        functiButtons[1]=subButton;
        functiButtons[2]=mulButton;
        functiButtons[3]=divButton;
        functiButtons[4]=decButton;
        functiButtons[5]=equButton;
        functiButtons[6]=delButton;
        functiButtons[7]=clrButton;
        functiButtons[8]=negButton;


        for(int i=0;i<9;i++)
        {
            functiButtons[i].addActionListener((java.awt.event.ActionListener) this);
            functiButtons[i].setFont(myFont);
            functiButtons[i].setFocusable(false);
        }
        for(int i=0;i<10;i++)
        {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener((java.awt.event.ActionListener) this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        panel =new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);


        panel.setBackground(Color.GRAY);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textField);
        frame.setVisible(true);
     }
    public static void main(String[] args) {
        first f=new first();


          
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberButtons[i])
            {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decButton)
        {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divButton)
        {
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equButton)
        {
            num2=Double.parseDouble(textField.getText());
            switch (operator) {
                case '+':
                    reslt=num1+num2;
                    break;
                case '-':
                    reslt=num1-num2;
                    break;
                case '*':
                reslt=num1*num2;
                break;
                case '/':
                reslt=num1/num2;
                break;
            }
            textField.setText(String.valueOf(reslt));
            num1=reslt;
        }
        if(e.getSource()==clrButton)
        {
           textField.setText("");
        }
        if(e.getSource()==delButton)
        {
            String string=textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++)
            {
                textField.setText(textField.getText()+string.charAt(i));
            }

        }
        if(e.getSource()==negButton)
        {
           double temp=Double.parseDouble(textField.getText());
           temp*=-1;
           textField.setText(String.valueOf(temp));

        }
    }
    
}