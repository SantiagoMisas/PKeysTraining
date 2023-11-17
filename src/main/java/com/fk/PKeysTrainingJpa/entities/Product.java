package com.fk.PKeysTrainingJpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;


}
