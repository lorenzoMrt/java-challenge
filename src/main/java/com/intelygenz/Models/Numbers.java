package com.intelygenz.Models;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Numbers {

    @Id
    int id;
    String integers;
}
