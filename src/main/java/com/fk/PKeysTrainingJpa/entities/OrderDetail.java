package com.fk.PKeysTrainingJpa.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;


@Entity
@Table(name="order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail implements Serializable {

    @Column (name="order_id")
    private long orderId;
    @Column (name="product_id")
    private long productId;
    private int quantity;
    @Column (name="unit_price")
    private BigDecimal unitPrice;

}
