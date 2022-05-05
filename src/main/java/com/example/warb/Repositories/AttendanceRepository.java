package com.example.warb.Repositories;

import com.example.warb.JPAEntities.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
   @Query(""+
           "SELECT CASE WHEN COUNT(A) > 0 THEN" +
           " TRUE ELSE FALSE END"+
           " FROM Attendance A" +
           " WHERE A.getIdStu() = ?1"
   )
   Boolean selectAttendanceExists(int idStu);
}