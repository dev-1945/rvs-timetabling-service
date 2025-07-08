package com.rvs.schooltimetabling.service;

import com.rvs.schooltimetabling.domain.*;
import com.rvs.schooltimetabling.repository.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class TimeTableService {

    @Inject TimeslotRepository timeslotRepository;
    @Inject RoomRepository roomRepository;
    @Inject TeacherRepository teacherRepository;
    @Inject SubjectRepository subjectRepository;
    @Inject SectionRepository sectionRepository;

    public TimeTable generateProblem() {
        List<Timeslot> timeslots = timeslotRepository.listAll();
        List<Room> rooms = roomRepository.listAll();
        List<Teacher> teachers = teacherRepository.listAll();
        List<Subject> subjects = subjectRepository.listAll();
        List<Section> sections = sectionRepository.listAll();

        // Crear Lessons
        List<Lesson> lessons = new ArrayList<>();
        int counter = 1;
        for (Section section : sections) {
            for (Subject subject : subjects) {
                for (int i = 0; i < 3; i++) { // Ej: 3 sesiones por asignatura
                    lessons.add(new Lesson((long) counter++, subject, null, section));
                }
            }
        }

        TimeTable timeTable = new TimeTable();
        timeTable.setTimeslots(timeslots);
        timeTable.setRooms(rooms);
        timeTable.setTeachers(teachers);
        timeTable.setLessons(lessons);

        return timeTable;
    }
}
