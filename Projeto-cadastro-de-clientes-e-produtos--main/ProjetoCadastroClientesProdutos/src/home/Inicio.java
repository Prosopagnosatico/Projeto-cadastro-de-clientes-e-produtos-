package home;

import javax.swing.*;
import java.awt.*;

public class Inicio extends JFrame {
    public Inicio() {
        this.setSize(400, 400);
        this.setLocationRelativeTo((Component)null);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Inicio();
    }
}