package com.example.mydiary.repository;

import com.example.mydiary.model.Entry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByUserIdOrderByCreatedOnDesc(Long userId);
}
