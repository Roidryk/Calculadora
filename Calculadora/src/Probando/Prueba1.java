package Probando;

import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prueba1 extends JFrame implements ActionListener {

     JTextField display;
     double num1, num2;
     String operacion;

    public Prueba1() {
        setTitle("Calculadora");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panelCalcu = new JPanel(new GridLayout(4, 4));

        String[] botonesCalcu = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (String label : botonesCalcu) {
            JButton boton = new JButton(label);
            boton.addActionListener(this);
            panelCalcu.add(boton);
        }

        add(panelCalcu, BorderLayout.CENTER);
    }

   
    public void actionPerformed(ActionEvent e) {
        JButton fuente = (JButton) e.getSource();
        String botonTexto = fuente.getText();

        if (esOperador(botonTexto)) {
            operacion = botonTexto;
            num1 = Double.parseDouble(display.getText());
            display.setText("");
        } else if ("=".equals(botonTexto)) {
            num2 = Double.parseDouble(display.getText());
            realizarOperacion();
        } else {
            display.setText(display.getText() + botonTexto);
        }
    }

    boolean esOperador(String texto) {
        return texto.equals("+") || texto.equals("-") || texto.equals("*") || texto.equals("/");
    }

    private void realizarOperacion() {
        switch (operacion) {
            case "+":
                display.setText(String.valueOf(num1 + num2));
                String resultado=num1+" + "+num2;
                JOptionPane.showMessageDialog(this, "Resultado: " + resultado);
                break;
            case "-":
                display.setText(String.valueOf(num1 - num2));
                String resultado2=num1+" - "+num2;
                JOptionPane.showMessageDialog(this, "Resultado: " + resultado2);
                break;
            case "*":
                display.setText(String.valueOf(num1 * num2));
                String resultado3=num1+" * "+num2;
                JOptionPane.showMessageDialog(this, "Resultado: " + resultado3);
                break;
            case "/":
                if (num2 != 0) {
                    display.setText(String.valueOf(num1 / num2));
                    String resultado4=num1+" / "+num2;
                    JOptionPane.showMessageDialog(this, "Resultado: " + resultado4);
                } else {
                    display.setText("0");
                }
                break;
        }
        display.setText(String.valueOf(" "));
    }

    public static void main(String[] args) {
    	//Con el Swing hago que la interfaz se ejecute en el orden en el que ha sido escrito y asi evitar errores
        SwingUtilities.invokeLater(() -> {
            Prueba1 calculadora = new Prueba1();
            calculadora.setVisible(true);
        });
    }
}