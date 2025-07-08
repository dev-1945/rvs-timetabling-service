package com.rvs.schooltimetabling.repository;

import com.rvs.schooltimetabling.domain.Room;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public interface RoomRepository extends PanacheRepository<Room> {
}
