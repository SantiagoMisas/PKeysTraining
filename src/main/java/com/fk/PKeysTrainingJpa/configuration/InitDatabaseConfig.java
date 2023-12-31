package com.fk.PKeysTrainingJpa.configuration;

import com.fk.PKeysTrainingJpa.entities.Order;
import com.fk.PKeysTrainingJpa.entities.OrderDetail;
import com.fk.PKeysTrainingJpa.entities.OrderDetailPK;
import com.fk.PKeysTrainingJpa.entities.Product;
import com.fk.PKeysTrainingJpa.repositories.OrderRepository;
import com.fk.PKeysTrainingJpa.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Configuration
public class InitDatabaseConfig {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Bean
    public CommandLineRunner createProductsCommand(){
        return args->{
            productRepository.save(
                    Product.builder()
                            .name("Playera para adulto")
                            .unitPrice(BigDecimal.valueOf(9.99))
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .name("Taza navideña")
                            .unitPrice(BigDecimal.valueOf(4.99))
                            .build()
            );
            productRepository.save(
                    Product.builder()
                            .name("Topitos")
                            .unitPrice(BigDecimal.valueOf(1.99))
                            .build()
            );
            System.out.println("== PRODUCTOS GUARDADOS==");
            productRepository.findAll().forEach(System.out::println);
        };
    }

    @Bean
    public CommandLineRunner createOrderCommand(){
        return args->{

            List<Product> products=productRepository.findAll(Sort.by("id"));

            Order order1=Order.builder().status(Order.OrderStatus.COMPLETED).build();

            Product shirt=products.get(0);
            Product cup=products.get(1);
            Product earring=products.get(2);
            OrderDetailPK detailPK1=OrderDetailPK.builder().productId(shirt.getId()).build();
            OrderDetailPK detailPK2=OrderDetailPK.builder().productId(cup.getId()).build();
            OrderDetailPK detailPK3=OrderDetailPK.builder().productId(earring.getId()).build();

            OrderDetail shirtDetail=OrderDetail.builder()
                    .order(order1)
                    .quantity(3)
                    .unitPrice(shirt.getUnitPrice())
                    .id(detailPK1)
                    .build();
            OrderDetail cupDetail=OrderDetail.builder()
                    .order(order1)
                    .quantity(2)
                    .unitPrice(cup.getUnitPrice())
                    .id(detailPK2)
                    .build();
            OrderDetail earringDetail=OrderDetail.builder()
                    .order(order1)
                    .quantity(3)
                    .unitPrice(earring.getUnitPrice())
                    .id(detailPK3)
                    .build();
            order1.setDetails(Arrays.asList(shirtDetail,cupDetail, earringDetail));
            orderRepository.save(order1);
            System.out.println("==ORDEN GUARDADA==");
            System.out.println(order1);
            System.out.println("El total de la orden es: "+order1.getTotal());
            System.out.println("Subtotales: ");
            order1.getDetails().forEach(detail-> System.out.println("\t ->"+detail.getSubtotal()));
        };
    }
}
