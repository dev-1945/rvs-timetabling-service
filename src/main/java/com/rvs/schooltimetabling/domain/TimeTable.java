package com.rvs.schooltimetabling.domain;

import java.util.List;

import ai.timefold.solver.core.api.domain.solution.PlanningEntityCollectionProperty;
import ai.timefold.solver.core.api.domain.solution.PlanningScore;
import ai.timefold.solver.core.api.domain.solution.PlanningSolution;
import ai.timefold.solver.core.api.domain.solution.ProblemFactCollectionProperty;
import ai.timefold.solver.core.api.domain.valuerange.ValueRangeProvider;
import ai.timefold.solver.core.api.score.buildin.hardsoft.HardSoftScore;
import ai.timefold.solver.core.api.solver.SolverStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@PlanningSolution
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeTable {

    private String name;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "timeslotRange")
    private List<Timeslot> timeslots;

    @ProblemFactCollectionProperty
    @ValueRangeProvider(id = "roomRange")
    private List<Room> rooms;

    @ValueRangeProvider(id = "teacherRange")
    private List<Teacher> teachers;

    @PlanningEntityCollectionProperty
    private List<Lesson> lessons;

    @PlanningScore
    private HardSoftScore score;

    // Ignored by Timefold, used by the UI to display solve or stop solving button
    private SolverStatus solverStatus;

    // Constructor auxiliar para el método getStatus
    public TimeTable(String name, HardSoftScore score, SolverStatus solverStatus) {
        this.name = name;
        this.score = score;
        this.solverStatus = solverStatus;
    }
}
