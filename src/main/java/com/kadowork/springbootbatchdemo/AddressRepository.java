package com.kadowork.springbootbatchdemo;

import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.*;

@Repository
@AllArgsConstructor
@Slf4j
public class AddressRepository {
    private final JdbcTemplate jdbcTemplate;

    public void create(Address address) {
        log.info("Address: {}", address.getId() + ": " + address.getPrefName() +
                                address.getCityName() + address.getTownName());
        jdbcTemplate.update("INSERT INTO address SET " +
                            "id = ?, " +
                            "prefCd = ?, " +
                            "cityCd = ?, " +
                            "townCd = ?, " +
                            "zip = ?, " +
                            "officeFlg = ?, " +
                            "deleteFlg = ?, " +
                            "prefName = ?, " +
                            "prefKana = ?, " +
                            "cityName = ?, " +
                            "cityKana = ?, " +
                            "townName = ?, " +
                            "townKana = ?, " +
                            "townMemo = ?, " +
                            "kyotoStreet = ?, " +
                            "azaName = ?, " +
                            "azaKana = ?, " +
                            "memo = ?, " +
                            "officeName = ?, " +
                            "officeKana = ?, " +
                            "officeAddress = ?, " +
                            "newId = ?;",
                            address.getId(),
                            address.getPrefCd(),
                            address.getCityCd(),
                            address.getTownCd(),
                            address.getZip(),
                            address.isOfficeFlg(),
                            address.isDeleteFlg(),
                            address.getPrefName(),
                            address.getPrefKana(),
                            address.getCityName(),
                            address.getCityKana(),
                            address.getTownName(),
                            address.getTownKana(),
                            address.getTownMemo(),
                            address.getKyotoStreet(),
                            address.getAzaName(),
                            address.getAzaKana(),
                            address.getMemo(),
                            address.getOfficeName(),
                            address.getOfficeKana(),
                            address.getOfficeAddress(),
                            address.getNewId());
    }
}
