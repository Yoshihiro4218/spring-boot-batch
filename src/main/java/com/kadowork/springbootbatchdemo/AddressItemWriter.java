package com.kadowork.springbootbatchdemo;

import lombok.extern.slf4j.*;
import org.springframework.batch.item.*;
import org.springframework.beans.factory.annotation.*;

import java.util.*;

@Slf4j
public class AddressItemWriter implements ItemWriter<Address> {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void write(List<? extends Address> list) throws Exception {
        log.info("====== Write Address ======");
        list.forEach(addressRepository::create);
    }
}
