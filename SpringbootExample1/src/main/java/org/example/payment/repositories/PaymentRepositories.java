package org.example.payment.repositories;


import org.example.cart.models.Cart;
import org.example.cart.models.CartItem;
import org.example.order.model.OrderDetails;
import org.example.payment.dtos.PaymentDetailsDto;
import org.example.payment.dtos.PaymentResponseDetailsDto;
import org.example.payment.models.PaymentDetailsModel;
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
public class PaymentRepositories {

    public PaymentResponseDetailsDto create(PaymentDetailsDto paymentDetails)
    {
        PaymentResponseDetailsDto paymentResponseDetailsDto = new PaymentResponseDetailsDto();

        PaymentDetailsModel paymentDetailsModel = new PaymentDetailsModel();
        User user = new User();
        user.setId(paymentDetails.getUserDetailsId());
        paymentDetailsModel.setUser(user);

        Configuration config = new Configuration();
        config.addAnnotatedClass(PaymentDetailsModel.class);
        config.addAnnotatedClass(User.class);
        config.addAnnotatedClass(Profile.class);
        config.addAnnotatedClass(OrderDetails.class);
        config.addAnnotatedClass(CartItem.class);
        config.addAnnotatedClass(ProductDetails.class);
        config.addAnnotatedClass(BrandDetails.class);
        config.addAnnotatedClass(Cart.class);
        config.configure("Hibernate.cfg.xml");

        ServiceRegistry reg = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties())
                .build();
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();

        try {
            session.persist(paymentDetailsModel);
            //session.persist(xyz);
            tx.commit();
            paymentResponseDetailsDto.setStatus("success");
        }
        catch (Exception e){
            tx.rollback();
            paymentResponseDetailsDto.setStatus("fail");
        }

        return paymentResponseDetailsDto;




    }
}
