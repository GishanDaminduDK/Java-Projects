
package com.order.order.service;

import com.inventory.inventory.dto.InventoryDTO;
import com.order.order.common.ErrorOrderResponse;
import com.order.order.common.OrderResponse;
import com.order.order.common.SuccessOrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.model.Orders;
import com.order.order.repo.OrderRepo;
import com.product.product.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final WebClient webClient1;
    private final WebClient webClient2;

    private final OrderRepo orderRepo;

    private final ModelMapper modelMapper;

    @Autowired
    public OrderService(
            @Autowired @Qualifier("webClient1") WebClient webClient1,
            @Autowired @Qualifier("webClient2") WebClient webClient2,
            OrderRepo orderRepo,
            ModelMapper modelMapper
    ) {
        this.webClient1 = webClient1;
        this.webClient2 = webClient2;
        this.orderRepo = orderRepo;
        this.modelMapper = modelMapper;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders> orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>() {}.getType());
    }

    public OrderResponse saveOrder(OrderDTO orderDTO) {
        Integer itemId = orderDTO.getItemId();

        try {
            InventoryDTO inventoryResponse = webClient1.get()
                    .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();

            if (inventoryResponse == null) {
                return new ErrorOrderResponse("Inventory response is null");
            }

            Integer productId = inventoryResponse.getProductId();

            ProductDTO productResponse = webClient2.get()
                    .uri(uriBuilder -> uriBuilder.path("/product/{productId}").build(productId))
                    .retrieve()
                    .bodyToMono(ProductDTO.class)
                    .block();

            if (productResponse == null) {
                return new ErrorOrderResponse("Product response is null");
            }

            if (inventoryResponse.getQuantity() > 0 && productResponse.getForSale() == 1) {
                orderRepo.save(modelMapper.map(orderDTO, Orders.class));
                return new SuccessOrderResponse(orderDTO);
            } else {
                return new ErrorOrderResponse("Item is not available for sale");
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return new ErrorOrderResponse("An error occurred while processing the order");
        }
    }

    public OrderDTO updateOrder(OrderDTO orderDTO) {
        orderRepo.save(modelMapper.map(orderDTO, Orders.class));
        return orderDTO;
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found with ID: " + orderId));
        return modelMapper.map(order, OrderDTO.class);
    }
}
