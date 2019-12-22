/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author kana
 */
class bwm extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
public class Calculator extends Frame implements ActionListener {
   
    private TextField result;
    private Button b[]=new Button[10];
    private Button plus;
    private Button minus;
    private Button mult;
    private Button div;
    private Button clear;
    private Button equal;
    private int operand1,operand2;
    private char operator;
    public Calculator()
    {   setTitle("Calculator");
    addWindowListener(new bwm());
        Panel keypad=new Panel();
        add(keypad,BorderLayout.CENTER);
        setVisible(true);
        setSize(300,300);
        result=new TextField("0");
        add(result,BorderLayout.NORTH);
        result.addActionListener(this);
        keypad.setLayout(new GridLayout(4,4));
        int i;
        for(i=0;i<=9;i++)
        {
            b[i]=new Button(" "+i);
            keypad.add(b[i]);
            b[i].addActionListener(this);
        }
        plus=new Button("+");
        keypad.add(plus);
        plus.addActionListener(this);
        minus=new Button("-");
        keypad.add(minus);
        minus.addActionListener(this);
        mult=new Button("*");
        keypad.add(mult);
        mult.addActionListener(this);
        div=new Button("/");
        keypad.add(div);
        div.addActionListener(this);
        clear = new Button("clr");
        keypad.add(clear);
        clear.addActionListener(this);
        equal = new Button("=");
        keypad.add(equal);
        equal.addActionListener(this);
        
        
    }
public void actionPerformed(ActionEvent e)
{
  String s=e.getActionCommand();
  if(e.getSource()==plus)
  {
      String v=result.getText();
      try{
      operand1=Integer.parseInt(v);}
      catch(NumberFormatException ex)
      {}
      result.setText(" ");
      operator='+';
  }
  else if(s.equals("-"))
  {    
      String v=result.getText();
      try{operand1=Integer.parseInt(v);}
      catch(NumberFormatException ex)
      {}
      result.setText(" ");
      operator='-';
  }
  else if(s.equals("*"))
  {
      String v=result.getText();
      try{operand1=Integer.parseInt(v);}
      catch(Exception ex){}
      result.setText(" ");
      operator='*';
  }
  else if(s.equals("/"))
  {
      String v=result.getText();
      operand1=Integer.parseInt(v);
      
      result.setText(" ");
      operator='/';
  }
  else if(s.equals("="))
  {
      String v=result.getText();
     try{ operand2=Integer.parseInt(v);}
     catch(NumberFormatException ex)
     {}
      int re=operation(operand1,operand2,operator);
      result.setText(" "+re);
  }
  else if(s.equals("clr"))
  {
     result.setText("0");
     operand1=0;
     operand2=0;
     operator=' ';
  }
      else
  {
      String l=e.getActionCommand().trim();
      String r=result.getText().trim();
      if(r.equals("0"))
      {
          result.setText(l);
      }
      else
      {
          result.setText(r+l);
      }
  }
}

public int operation(int x,int y,char op)
    { int r=0;
        switch(op)
        {
            case '+':
                r=x+y;
                break;
            case '-':
                r=x-y;
                break;
            case '*':
                r=x*y;
                break;
            case '/':
                r=x/y;
                break;
        }
        return r;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Calculator f=new Calculator();
        // TODO code application logic here
    }
    
}

