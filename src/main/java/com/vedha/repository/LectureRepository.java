package com.vedha.repository;

import com.vedha.entity.LectureEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<LectureEntity, Long> {
}
