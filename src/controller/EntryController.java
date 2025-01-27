package com.example.mydiary.controller;

import com.example.mydiary.model.Entry;
import com.example.mydiary.service.EntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody Entry entry) {
        Entry createdEntry = entryService.createEntry(entry);
        return ResponseEntity.ok(createdEntry);
    }

    @GetMapping
    public ResponseEntity<?> getAllEntries(@RequestParam Long userId) {
        List<Entry> entries = entryService.getAllEntries(userId);
        return ResponseEntity.ok(entries);
    }
}
