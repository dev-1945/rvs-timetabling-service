package com.rvs.schooltimetabling.repository;

import com.rvs.schooltimetabling.domain.Section;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface SectionRepository extends PanacheRepository<Section> {
}