package com.javaprojects.journalApp.service;

import com.javaprojects.journalApp.entity.JournalEntry;
import com.javaprojects.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntries(){
        return journalEntryRepository.findAll();
    }

    public JournalEntry getEntryById(String id){
        return journalEntryRepository.findById(id).get();
    }

    public boolean deleteEntry(String id){
        journalEntryRepository.deleteById(id);
        return true;
    }

    public boolean updateEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
        return true;
    }


}
