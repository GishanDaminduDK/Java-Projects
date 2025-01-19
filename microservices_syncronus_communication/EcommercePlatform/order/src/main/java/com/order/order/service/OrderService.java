package com.order.order.service;

import com.inventory.inventory.dto.InventoryDTO;
import com.order.order.common.ErrorOrderResponse;
import com.order.order.common.OrderResponse;
import com.order.order.common.SuccessOrderResponse;
import com.order.order.dto.OrderDTO;
import com.order.order.model.Orders;
import com.order.order.repo.OrderRepo;
import com.product.product.dto.ProductDTO;
import jakarta.persistence.criteria.Order;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@Transactional
public class OrderService {
    public final WebClient webClient;
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderService(WebClient.Builder webClientBuilder,OrderRepo orderRepo, ModelMapper modelMapper){
        this.webClient=webClientBuilder.baseUrl("http://localhost:8080/api/v1").build();
        this.orderRepo=orderRepo;
        this.modelMapper=modelMapper;
    }

    public List<OrderDTO> getAllOrders() {
        List<Orders>orderList = orderRepo.findAll();
        return modelMapper.map(orderList, new TypeToken<List<OrderDTO>>(){}.getType());
    }

    public OrderResponse saveOrder(OrderDTO OrderDTO) {
        Integer itemId = OrderDTO.getItemId();
        try {
            InventoryDTO inventoryresponse = webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/item/{itemId}").build(itemId))
                    .retrieve()
                    .bodyToMono(InventoryDTO.class)
                    .block();
            assert inventoryresponse != null;
            Integer productId=inventoryresponse.getProductId();

            ProductDTO productresponse=webClient.get()
                    .uri(uriBuilder -> uriBuilder.path("/product/{productId}").build(productId))
                    .retrieve()
                    .bodyToMono(ProductDTO.class)
                    .block();

            if (inventoryresponse.getQuantity() > 0) {
                orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
                return new SuccessOrderResponse(OrderDTO);
            }
            else{
                return new ErrorOrderResponse("Item is not available");
            }
        } catch (Exception e) {
            System.out.println("There is an error");

        }
//       orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
//        return OrderDTO;
        return null;
    }


    public OrderDTO updateOrder(OrderDTO OrderDTO) {
        orderRepo.save(modelMapper.map(OrderDTO, Orders.class));
        return OrderDTO;
    }

    public String deleteOrder(Integer orderId) {
        orderRepo.deleteById(orderId);
        return "Order deleted";
    }

    public OrderDTO getOrderById(Integer orderId) {
        Orders order = orderRepo.getOrderById(orderId);
        return modelMapper.map(order, OrderDTO.class);
    }
}
