package com.rvs.schooltimetabling.repository;

import com.rvs.schooltimetabling.domain.Subject;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface SubjectRepository extends PanacheRepository<Subject> {
}