package com.go.springpetclinic.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "specialties")
@Getter
@Setter
public class Specialty extends BaseEntity{

    private String description;

}
