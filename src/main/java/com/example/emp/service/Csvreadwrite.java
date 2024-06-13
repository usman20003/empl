package com.example.emp.service;

import com.example.emp.entity.Empdetails;
import com.example.emp.repository.Employeerepository;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class Csvreadwrite {

    @Autowired
    private Employeerepository employeerepository;

    public void save(MultipartFile file) {
        try {
            List<Empdetails> persons = parseCSVFile(file);
            employeerepository.saveAll(persons);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store CSV data: " + e.getMessage());
        }
    }

    private List<Empdetails> parseCSVFile(MultipartFile file) throws IOException, CsvValidationException {
        List<Empdetails> persons = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new InputStreamReader(file.getInputStream()))) {
            String[] values;
            while ((values = csvReader.readNext()) != null) {
            	Empdetails person = new Empdetails();
               
            	if(values.length==2) {
            	person.setEmpMail(values[0]);
                person.setEmpName(values[1]);            
                persons.add(person);
            	}
            	
            	else {
            		 throw new RuntimeException("Failed to store CSV data: ");
            	}
            }
        }
        return persons;
    }
}
