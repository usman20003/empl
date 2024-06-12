package com.example.emp.service;

import java.io.StringWriter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.emp.entity.Empdetails;
import com.example.emp.entity.Employee;
import com.opencsv.CSVWriter;

@Service
public class CSVService {

    public String convertToCSV(List<Empdetails> employees) {
        StringWriter writer = new StringWriter();
        CSVWriter csvWriter = new CSVWriter(writer);

        // Write header
        csvWriter.writeNext(new String[]{"ID", "Email", "EmpName"});

        // Write data
        for (Empdetails employee : employees) {
            csvWriter.writeNext(new String[]{
                employee.getEmpID().toString(),
                employee.getEmpMail(),
                employee.getEmpName()
            });
        }

        return writer.toString();
    }
}

