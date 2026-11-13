package com.introsoftware.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.introsoftware.model.Order;
import com.introsoftware.service.ExchangeRateService;
import com.introsoftware.view.OrderView;

public class OrderController {

    private static final Logger log =
            LoggerFactory.getLogger(OrderController.class);

    private OrderView view;
    private List<Order> orders;
    private ExchangeRateService exchangeRateService;

    public OrderController(OrderView view, List<Order> orders) {

        this.view = view;
        this.orders = orders;
        this.exchangeRateService = new ExchangeRateService();

        // Cuando se pulsa el botón Search, busca el pedido
        this.view.getSearchButton()
                 .addActionListener(e -> searchOrder());
    }

    private void searchOrder() {

        String id = view.getSearchId().trim();

        // Si el campo está vacío
        if (id.isEmpty()) {
            view.displayMessage("Please enter an Order ID.");
            return;
        }

        // Buscar el pedido
        for (Order order : orders) {

            if (order.getId().equalsIgnoreCase(id)) {

                log.debug("Order found: {}", order.getId());

                try {

                    // Obtener el cambio EUR/USD desde el servicio externo
                    double rate =
                            exchangeRateService.getEurUsdRate();

                    log.debug("EUR/USD exchange rate: {}", rate);

                    // Mostrar pedido y cambio en la vista
                    view.displayOrder(order, rate);

                } catch (Exception e) {

                    log.error(
                            "Error getting EUR/USD exchange rate",
                            e
                    );

                    view.displayMessage(
                            "Error getting EUR/USD exchange rate."
                    );
                }

                return;
            }
        }

        // Si no existe el pedido
        log.debug("Order not found: {}", id);

        view.displayMessage(
                "Order " + id + " not found."
        );
    }
}