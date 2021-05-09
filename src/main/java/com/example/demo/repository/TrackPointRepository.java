package com.example.demo.repository;

import com.example.demo.entity.TrackPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackPointRepository extends JpaRepository<TrackPoint, Long> {
}
