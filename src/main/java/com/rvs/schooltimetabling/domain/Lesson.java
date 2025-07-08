package com.rvs.schooltimetabling.domain;

import ai.timefold.solver.core.api.domain.entity.PlanningEntity;
import ai.timefold.solver.core.api.domain.lookup.PlanningId;
import ai.timefold.solver.core.api.domain.variable.PlanningVariable;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@PlanningEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {

    @PlanningId
    private Long id;

    private Subject subject;
    private Section section;


    @JsonIdentityReference
    @PlanningVariable(valueRangeProviderRefs = "teacherRange")
    private Teacher teacher;

    @JsonIdentityReference
    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    private Timeslot timeslot;

    @JsonIdentityReference
    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    private Room room;

    public Lesson(Long id, Subject subject, Teacher teacher, Section studentGroup) {
        this.id = id;
        this.subject = subject;
        this.teacher = teacher;
        this.section = studentGroup;
    }

    @Override
    public String toString() {
        return subject.getName() + " - " + section.getName() + " (" + teacher.getName() + ")";
    }
}
