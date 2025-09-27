package com.javaprojects.journalApp.controller;

import com.javaprojects.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalAppController {

    private final Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping("/getall")
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    @PostMapping("/makeentry")
    public boolean createEntry(@RequestBody JournalEntry journalEntry){
        journalEntries.put(journalEntry.getId(),journalEntry);
        return true;
    }

    @GetMapping("/id/{entryId}")
    public JournalEntry getEntryById(@PathVariable Long entryId ){
        return journalEntries.get(entryId);
    }

    @DeleteMapping("/id/{entryId}")
    public String deleteEntry(@PathVariable Long entryId){
        journalEntries.remove(entryId);
        return "Entry Deleted";
    }

    @PutMapping
    public String updateEntry(@RequestBody JournalEntry journalEntry){
        journalEntries.put(journalEntry.getId(),journalEntry);
        return "Entry Updated";
    }

}
