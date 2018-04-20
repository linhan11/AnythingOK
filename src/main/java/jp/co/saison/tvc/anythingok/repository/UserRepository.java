package jp.co.saison.tvc.anythingok.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.co.saison.tvc.anythingok.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
}