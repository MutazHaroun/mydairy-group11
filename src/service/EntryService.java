package com.example.mydiary.Service;

import com.example.mydiary.model.Entry;
import com.example.mydiary.repository.EntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryService {
    private final EntryRepository entryRepository;

    public EntryService(EntryRepository entryRepository) {
        this.entryRepository = entryRepository;
    }

    public Entry createEntry(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> getAllEntries(Long userId) {
        return entryRepository.findByUserIdOrderByCreatedOnDesc(userId);
    }
}
