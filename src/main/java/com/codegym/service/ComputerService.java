package com.codegym.service;

import com.codegym.model.Computer;
import com.codegym.repository.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ComputerService implements IComputerService{
    @Autowired
    private IComputerRepository iComputerRepository;

    @Override
    public Iterable<Computer> findAll() {
        return iComputerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return iComputerRepository.findById(id);
    }

    @Override
    public Computer save(Computer customer) {
        return iComputerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        iComputerRepository.deleteById(id);
    }

    @Override
    public Page<Computer> findAll(Pageable pageable) {
        return iComputerRepository.findAll(pageable);
    }
}
