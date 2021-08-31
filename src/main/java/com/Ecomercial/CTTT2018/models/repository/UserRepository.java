package com.Ecomercial.CTTT2018.models.repository;

import com.Ecomercial.CTTT2018.models.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmail(String email);

	Optional<User> findOneByUsername(String username);

	List<User> findByUsername(String username);
}
