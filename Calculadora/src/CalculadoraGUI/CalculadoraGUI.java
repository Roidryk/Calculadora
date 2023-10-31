package CalculadoraGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraGUI extends JFrame implements ActionListener {

     JTextField display;
     String input = "";

    public CalculadoraGUI() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 4));

        String[] buttonLabels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        String buttonText = source.getText();

        if ("=".equals(buttonText)) {
            try {
                String resultado = evaluarExpresion();
                JOptionPane.showMessageDialog(this, "Resultado: " + resultado);
            } catch (ArithmeticException ex) {
                JOptionPane.showMessageDialog(this, "Error en la expresión", "Error", JOptionPane.ERROR_MESSAGE);
            }
            input = "";
        } else {
            input += buttonText;
        }

        display.setText(input);
    }

    private String evaluarExpresion() {
        
        return input;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraGUI calculator = new CalculadoraGUI();
            calculator.setVisible(true);
        });
    }
}
