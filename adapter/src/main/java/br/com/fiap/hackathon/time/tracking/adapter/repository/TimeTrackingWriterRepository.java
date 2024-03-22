package br.com.fiap.hackathon.time.tracking.adapter.repository;

import br.com.fiap.hackathon.time.tracking.adapter.dto.TimeTrackingDTO;

public interface TimeTrackingWriterRepository {

    TimeTrackingDTO write(TimeTrackingDTO dto);

}
