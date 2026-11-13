package com.introsoftware.view;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.introsoftware.model.Article;
import com.introsoftware.model.Order;

public class OrderView extends JFrame {

    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(12, 45);

    public OrderView() {

        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Icono de la aplicación
        try {
            setIconImage(
                new ImageIcon(
                    getClass().getResource("/app.png")
                ).getImage()
            );
        } catch (Exception e) {
            System.out.println("App icon not found.");
        }

        add(new JLabel("Order ID:"));
        add(searchField);
        add(searchButton);

        resultArea.setEditable(false);

        add(new JScrollPane(resultArea));

        pack();

        // Centrar la ventana
        setLocationRelativeTo(null);

        setVisible(true);
    }

    public String getSearchId() {
        return searchField.getText();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayOrder(Order order, double rate) {

        StringBuilder result = new StringBuilder();

        result.append("Order ")
              .append(order.getId())
              .append(":\n\n");

        for (Article article : order.getArticles()) {

            result.append(article.getNombre())
                  .append(" x")
                  .append(article.getCantidad())
                  .append(" @ ")
                  .append(String.format("%.2f", article.getPrecio()))
                  .append(" €")
                  .append(" (discount ")
                  .append(String.format("%.2f", article.getDescuento()))
                  .append("%)")
                  .append(" = ")
                  .append(String.format("%.2f", article.getDiscountedAmount()))
                  .append(" €")
                  .append("\n");
        }

        double grossTotal = order.getGrossTotal();
        double discountedTotal = order.getDiscountedTotal();

        double grossTotalUsd = grossTotal * rate;
        double discountedTotalUsd = discountedTotal * rate;

        result.append("\n");

        result.append("Gross total (EUR): ")
              .append(String.format("%.2f", grossTotal))
              .append(" €\n");

        result.append("Discounted total (EUR): ")
              .append(String.format("%.2f", discountedTotal))
              .append(" €\n");

        result.append("Gross total (USD): ")
              .append(String.format("%.2f", grossTotalUsd))
              .append(" $\n");

        result.append("Discounted total (USD): ")
              .append(String.format("%.2f", discountedTotalUsd))
              .append(" $\n");

        result.append("EUR/USD rate: ")
              .append(String.format("%.4f", rate));

        resultArea.setText(result.toString());
    }

    public void displayMessage(String message) {
        resultArea.setText(message);
    }
}