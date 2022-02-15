package com.proyecto.portalgestion.service;

import com.proyecto.portalgestion.model.Worker;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;

public class ExcelService {

    public String loadExcelIntoMemory(MultipartFile file){
        return file.getName();
    }

}
