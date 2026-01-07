package com.deepbuilder.repository;

import com.deepbuilder.entities.Talent;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TalentRepository extends CrudRepository<Talent, Long>{
    @Override
    <S extends Talent> S save(S entity);

    @Override
    Iterable<Talent> findAll();

    @Override
    Optional<Talent> findById(Long aLong);

    @Override
    long count();

    @Override
    void delete(Talent entity);

    List<Talent> findByTalentNameContainingIgnoreCase(String name);
}

