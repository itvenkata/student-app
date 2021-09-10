package com.tvc.student.address.entity;

import javax.persistence.Id;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String street ;
    private String city ;

}
