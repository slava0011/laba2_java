package bsu.rfe.java.group7.lab2.Kondrashov.varC1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import static java.lang.Math.*;

public class Main_Frame extends JFrame {
    private static final int width = 1000;
    private static final int height = 800;
    private JTextField result_field;
    private JTextField x_field;
    private JTextField y_field;
    private JTextField z_field;
    private JLabel image;
    private ButtonGroup radioButtons = new ButtonGroup();
    private Box formula_type = Box.createHorizontalBox();
    private ButtonGroup radioMemoryButtons = new ButtonGroup();
    private Box hBoxMemoryType = Box.createHorizontalBox();
    private JTextField memoryTextField;
    private int formula_number = 1;
    private int memoryId= 1;

    private Double mem1 = new Double(0);
    private Double mem2 = new Double(0);
    private Double mem3 = new Double(0);

    //вычисление функций
    public Double formula1(Double x, Double y, Double z)
    {
        if (y<=0)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "y не может быть меньше нуля", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }

        return  (sin(log(y)+sin(PI*y*y)) * pow(x*x+sin(z)+pow(E,cos(z)),0.25));
    }
    public Double formula2(Double x, Double y, Double z)
    {
        if (y == -1)	{
            JOptionPane.showMessageDialog(Main_Frame.this,
                    " y не должен быть равен -1", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        if ((cos(exp(y)) + exp(y*y) + sqrt(1/x)) < 0){
            JOptionPane.showMessageDialog(Main_Frame.this,
                    "Выражение (cos(exp(y)) + exp(y*y) + sqrt(1/x) должно быть больше 0", "" +
                            "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
            return 0.0;
        }
        return pow((cos(exp(y)) + log((1+y)*(1+y)) + sqrt(exp(cos(x))+sin(PI*z)*sin(PI*z)) + sqrt(1/x) + cos(y*y)), sin(z));
    }

    // радиокнопки для запоминания значения
    private void addMemoryRadioButton (String buttonName, final int memoryId)	{
        JRadioButton button = new JRadioButton(buttonName);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event)	{
                Main_Frame.this.memoryId = memoryId;
                if (memoryId == 1)	memoryTextField.setText(mem1.toString());
                if (memoryId == 2)	memoryTextField.setText(mem2.toString());
                if (memoryId == 3)	memoryTextField.setText(mem3.toString());
            }
        });

        radioMemoryButtons.add(button);
        hBoxMemoryType.add(button);
    }
    // радиокнопки для формул 1,2
    private void addRadioButton(String name, final int formula_number)
    {
        JRadioButton button = new JRadioButton(name);
        button.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                Main_Frame.this.formula_number = formula_number;
                if (formula_number == 1)	image.setIcon(new ImageIcon(Main_Frame.class.getResource("formula_1.bmp")));
                if (formula_number == 2) image.setIcon(new ImageIcon(Main_Frame.class.getResource("formula_2.bmp")));
            }
        });
        radioButtons.add(button);
        formula_type.add(button);
    }

}
