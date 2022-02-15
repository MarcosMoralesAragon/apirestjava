package com.proyecto.portalgestion.controller;

import com.proyecto.portalgestion.model.Worker;
import com.proyecto.portalgestion.service.ExcelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ExcelController {

    ExcelService excelService = new ExcelService();

    @PostMapping("/excel")
    public String  uploadFile(@RequestParam("file") MultipartFile file ) {return excelService.loadExcelIntoMemory(file);}
}
