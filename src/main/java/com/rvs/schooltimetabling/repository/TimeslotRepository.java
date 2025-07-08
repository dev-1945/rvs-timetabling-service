package com.rvs.schooltimetabling.repository;

import com.rvs.schooltimetabling.domain.Timeslot;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface TimeslotRepository extends PanacheRepository<Timeslot> {
}