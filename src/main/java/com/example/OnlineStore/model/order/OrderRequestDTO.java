package com.example.OnlineStore.model.order;

import lombok.Getter;
import java.util.List;

@Getter
public class OrderRequestDTO {
    private Long userId;
    private Integer totalPrice;
    private List<ProductInOrder> products;
}

