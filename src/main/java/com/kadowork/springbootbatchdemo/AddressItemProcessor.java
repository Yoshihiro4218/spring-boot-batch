package com.kadowork.springbootbatchdemo;

import org.springframework.batch.item.*;

public class AddressItemProcessor implements ItemProcessor<Address, Address> {
    @Override
    public Address process(Address address) {
        return address;
    }
}
