package ch.fhnw.crm.crmwebservice.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ch.fhnw.crm.crmwebservice.data.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User findByEmail(String email);

    User findUserByEmail(String email);

    User findByEmailAndIdNot(String email, Long userId);
	User findByEmailAndIdAndNameNot(String email, Long userId, String name);
}
