package com.potenhoon.tododoapi.challenge.infrastructure.mission;

import com.potenhoon.tododoapi.challenge.domain.mission.model.entity.Mission;
import com.potenhoon.tododoapi.challenge.domain.mission.repository.MissionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// Adapter
@Repository
public interface JpaMissionRepository extends JpaRepository<Mission, Long>, MissionRepository {

}
