package com.learn.batch_processing_demo.config;

import com.learn.batch_processing_demo.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer customer) throws Exception {
        if (customer.getCountry().equals("United States")) {
            return customer;
        } else {
            return null;
        }
    }
}
