package com.codegym.service;

import com.codegym.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IComputerService extends IGeneralService<Computer>{
    Page<Computer> findAll(Pageable pageable);
}
