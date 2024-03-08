package com.codegym.controller;

import com.codegym.model.Computer;
import com.codegym.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/computers")
public class ComputerController {

        @Autowired
        private IComputerService iComputerService;

        @GetMapping
        public ResponseEntity<Page<Computer>> findAllCustomer(@PageableDefault(value = 1)Pageable pageable) {
            Page<Computer> customers = iComputerService.findAll(pageable);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Computer> findCustomerById(@PathVariable Long id) {
            Optional<Computer> customerOptional = iComputerService.findById(id);
            if (!customerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Computer> saveCustomer(@RequestBody Computer customer) {
            return new ResponseEntity<>(iComputerService.save(customer), HttpStatus.CREATED);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Computer> updateCustomer(@PathVariable Long id, @RequestBody Computer customer) {
            Optional<Computer> customerOptional = iComputerService.findById(id);
            if (!customerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            customer.setId(customerOptional.get().getId());
            return new ResponseEntity<>(iComputerService.save(customer), HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Computer> deleteCustomer(@PathVariable Long id) {
            Optional<Computer> customerOptional = iComputerService.findById(id);
            if (!customerOptional.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            iComputerService.remove(id);
            return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
        }

}
