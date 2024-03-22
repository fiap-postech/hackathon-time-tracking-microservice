package br.com.fiap.hackathon.time.tracking.driven.mongo.repository;

import br.com.fiap.hackathon.time.tracking.driven.mongo.model.TimeTrackingEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface TimeTrackingRepository extends MongoRepository<TimeTrackingEntity, String> {

    Optional<TimeTrackingEntity> findByEmployeeIdAndDate(String employeeId, LocalDate date);

    Optional<TimeTrackingEntity> findByUuid(String uuid);
}
