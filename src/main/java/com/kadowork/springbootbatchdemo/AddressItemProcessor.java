package com.kadowork.springbootbatchdemo;

import lombok.extern.slf4j.*;
import org.springframework.batch.item.*;

@Slf4j
public class AddressItemProcessor implements ItemProcessor<Address, Address> {
    @Override
    public Address process(Address address) {
        log.info("====== Address Item Process ======");
        return address;
    }
}
