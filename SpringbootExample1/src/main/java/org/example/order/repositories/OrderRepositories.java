package org.example.order.repositories;


import org.example.cart.models.Cart;
import org.example.cart.models.CartItem;
import org.example.order.dtos.OrderDetailsDto;
import org.example.order.dtos.OrderResponseDetailsDto;
import org.example.order.model.OrderDetails;
import org.example.products.models.BrandDetails;
import org.example.products.models.ProductDetails;
import org.example.users.models.Profile;
import org.example.users.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositories {

    public OrderResponseDetailsDto checkOut(OrderDetailsDto detailsDto)
    {
        OrderResponseDetailsDto orderResponseDetailsDto = new OrderResponseDetailsDto();
        OrderDetails orderDetails = new OrderDetails();
        Cart cart = new Cart();
        cart.setId(detailsDto.getCartDetailsId());
        orderDetails.setCart(cart);

        Configuration config = new Configuration();
        config.addAnnotatedClass(OrderDetails.class);
        config.addAnnotatedClass(Cart.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Profile.class);
        config.addAnnotatedClass(CartItem.class);
        config.addAnnotatedClass(ProductDetails.class);
        config.addAnnotatedClass(BrandDetails.class);

        config.configure("Hibernate.cfg.xml");

        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(orderDetails);

        tx.commit();

        orderResponseDetailsDto.setStatus("success");
        return orderResponseDetailsDto;
    }
}
