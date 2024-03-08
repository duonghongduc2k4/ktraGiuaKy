package com.codegym.repository;

import com.codegym.model.Computer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends PagingAndSortingRepository<Computer,Long> {
}
