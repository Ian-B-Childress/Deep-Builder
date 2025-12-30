package com.deepbuilder.repository;
import com.deepbuilder.entities.User;
import jakarta.annotation.Nullable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    //dont need this, kind of exposes hashes
//    @Override
//    Iterable<User> findAll();

    @Override
    <S extends User> S save(S entity);

    Optional<User> findById(Long userId);

    long count();

    @Override
    void delete(User entity);

    @Override
    boolean existsById(Long userId);

    //TODO: do dis

    User findByUsername(String userName);

}
