package home;

import javax.swing.*;

public class Inicio extends JFrame {
    public Inicio(){
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Inicio();
    }
}
