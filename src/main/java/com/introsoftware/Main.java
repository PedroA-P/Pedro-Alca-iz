package com.introsoftware;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.introsoftware.controller.OrderController;
import com.introsoftware.model.Order;
import com.introsoftware.view.OrderView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);   

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        InputStream inputStream =
                Main.class.getClassLoader().getResourceAsStream("orders.json");
   List<Order> orders;
        try {
            orders = objectMapper.readValue(
                    inputStream,
                    new TypeReference<List<Order>>() {}
            );
            for (Order order : orders) {
               logger.info("Loaded order: " + order.getId());
        }
        // Initialize MVC
        OrderView view = new OrderView();
        new OrderController(view, orders);

        } catch (Exception e) {
            
            logger.error("Error occurred while reading orders", e);
        }
   

    
    }
    

}    