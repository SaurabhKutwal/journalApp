package com.javaprojects.journalApp.controller;


import com.javaprojects.journalApp.entity.JournalEntry;
import com.javaprojects.journalApp.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalAppController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping("/getall")
    public List<JournalEntry> getAll(){
        return journalEntryService.getAllEntries();
    }

    @PostMapping("/makeentry")
    public boolean createEntry(@RequestBody JournalEntry journalEntry){
        journalEntryService.saveEntry(journalEntry);
        return true;
    }

    @GetMapping("/id/{entryId}")
    public JournalEntry getEntryById(@PathVariable String entryId ){
        return journalEntryService.getEntryById(entryId);
    }

    @DeleteMapping("/id/{entryId}")
    public String deleteEntry(@PathVariable String entryId){
        journalEntryService.deleteEntry(entryId);
        return "Entry Deleted";
    }

    @PutMapping
    public String updateEntry(@RequestBody JournalEntry journalEntry){
        journalEntryService.updateEntry(journalEntry);
        return "Entry Updated";
    }

}
