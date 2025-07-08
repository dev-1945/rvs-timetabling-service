package com.rvs.schooltimetabling.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Section {

    @Id
    private Long id;
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
