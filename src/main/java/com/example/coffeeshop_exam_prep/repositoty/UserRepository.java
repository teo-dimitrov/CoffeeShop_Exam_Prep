package com.example.coffeeshop_exam_prep.repositoty;

import com.example.coffeeshop_exam_prep.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);
    @Query("SELECT u from User as u order by size(u.orders) DESC")
    List<User> findAllByOrdersCountDescending();
}
