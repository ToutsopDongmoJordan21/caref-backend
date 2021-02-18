package com.project.caref.repository;

import com.project.caref.models.Subscription;
import com.project.caref.models.User;
import com.project.caref.models.dto.SubscriptionDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {



    List<SubscriptionDto> findAllByUser(User user);


}
