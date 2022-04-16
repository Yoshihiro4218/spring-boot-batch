package com.kadowork.springbootbatchdemo;

import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

public class AddressItemWriter implements ItemWriter<Address> {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void write(List<? extends Address> list) throws Exception {
        list.forEach(addressRepository::create);
    }
}
