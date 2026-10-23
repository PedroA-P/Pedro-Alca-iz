package com.introsoftware.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.introsoftware.model.Order;
import com.introsoftware.view.OrderView;

public class OrderController {

    private static final Logger log =
            LoggerFactory.getLogger(OrderController.class);

    private OrderView view;
    private List<Order> orders;

    public OrderController(OrderView view, List<Order> orders) {

        // Initialize attributes
        this.view = view;
        this.orders = orders;

        // Al pulsar Search ejecuta searchOrder()
        this.view.getSearchButton()
                 .addActionListener(e -> searchOrder());
    }

    private void searchOrder() {

        // Cogemos lo que ha escrito el usuario
        String id = view.getSearchId();

        // Recorremos todos los pedidos
        for (Order order : orders) {

            // Comprobamos si el ID coincide
            if (order.getId().equalsIgnoreCase(id)) {

                log.debug("Order found: {}", order.getId());

                // Mostramos el pedido
                view.displayOrder(order, 1.0);

                return;
            }
        }

        // Si termina el for y no ha encontrado nada
        log.debug("Order not found: {}", id);

        view.displayMessage(
                "Order " + id + " not found."
        );
    }
}