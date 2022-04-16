package com.kadowork.springbootbatchdemo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private int id;
    private String prefCd;
    private String cityCd;
    private String townCd;
    private String zip;
    private boolean officeFlg;
    private boolean deleteFlg;
    private String prefName;
    private String prefKana;
    private String cityName;
    private String cityKana;
    private String townName;
    private String townKana;
    private String townMemo;
    private String kyotoStreet;
    private String azaName;
    private String azaKana;
    private String memo;
    private String officeName;
    private String officeKana;
    private String officeAddress;
    private Integer newId;
}
