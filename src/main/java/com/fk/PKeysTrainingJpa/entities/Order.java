package com.fk.PKeysTrainingJpa.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "creation_date")
    @CreationTimestamp
    private LocalDateTime creationDate =LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy ="order", cascade=CascadeType.PERSIST)
    List<OrderDetail> details;

    public static enum OrderStatus {
        PENDING, IN_PROCESS, COMPLETED, CANCELLED;
    }


}
