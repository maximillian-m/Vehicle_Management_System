package com.Maximillian.vehicle_parking_mgt_system.repository;

import com.Maximillian.vehicle_parking_mgt_system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, String> {

  Optional<User> findByEmail(String email);

}
