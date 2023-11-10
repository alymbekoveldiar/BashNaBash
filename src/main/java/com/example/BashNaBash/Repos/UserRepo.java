package com.example.BashNaBash.Repos;

import com.example.BashNaBash.Entity.Thing;
import com.example.BashNaBash.Entity.User;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
//    @Value(value = "select max(amount_of_deals), gmail from login_user\n" +
//            "group by gmail")
//    List<User> getUserByGmailAndAmountOfDeals();
}
