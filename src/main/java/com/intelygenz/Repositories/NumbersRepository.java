package com.intelygenz.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.intelygenz.Models.Numbers;

public interface NumbersRepository extends CrudRepository<Numbers, Integer>{
    Numbers findById(int id);
}
