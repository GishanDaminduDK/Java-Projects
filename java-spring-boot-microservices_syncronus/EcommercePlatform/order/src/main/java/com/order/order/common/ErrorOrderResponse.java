package com.order.order.common;


import lombok.Getter;

@Getter
public class ErrorOrderResponse implements OrderResponse{
    private final String errormessage;

    public ErrorOrderResponse(String errormessage){
        this.errormessage=errormessage;

    }

}

