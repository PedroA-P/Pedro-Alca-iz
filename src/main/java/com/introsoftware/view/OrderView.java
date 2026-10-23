package com.introsoftware.view;

import javax.swing.*;
import java.awt.*;

import com.introsoftware.model.Article;
import com.introsoftware.model.Order;

public class OrderView extends JFrame {

    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {

        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Texto "Order ID:"
        add(new JLabel("Order ID:"));

        // Campo donde escribimos O001, O002...
        add(searchField);

        // Botón Search
        add(searchButton);

        // Área donde aparecerá el resultado
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

        pack();
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
                  .append(article.getPrecio())
                  .append("€")
                  .append(" (discount ")
                  .append(article.getDescuento())
                  .append("%)")
                  .append(" = ")
                  .append(article.getDiscountedAmount())
                  .append("€")
                  .append("\n");
        }

        result.append("\nGross total: ")
              .append(order.getGrossTotal())
              .append("€");

        result.append("\nDiscounted total: ")
              .append(order.getDiscountedTotal())
              .append("€");

        resultArea.setText(result.toString());
    }

    public void displayMessage(String message) {
        resultArea.setText(message);
    }
}