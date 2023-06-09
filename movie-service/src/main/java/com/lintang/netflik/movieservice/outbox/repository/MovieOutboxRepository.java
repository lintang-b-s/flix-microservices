package com.lintang.netflik.movieservice.outbox.repository;

import com.lintang.netflik.movieservice.outbox.entity.MovieOutboxEntity;
import com.lintang.netflik.movieservice.outbox.model.OutboxStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MovieOutboxRepository extends JpaRepository<MovieOutboxEntity, UUID> {


    Optional<List<MovieOutboxEntity>> findByOutboxStatusAndType(OutboxStatus outboxStatus,
                                                                String type);

    Optional<List<MovieOutboxEntity>> findByOutboxStatus(OutboxStatus outboxStatus);

    void deleteByOutboxStatus(OutboxStatus outboxStatus);
}
