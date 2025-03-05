package com.example.demo.excelparseapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/excel")
public class EtudiantDTOController {

    @Autowired
    private EtudiantDTOService etudiantDTOService;

    @PostMapping("/upload")
    public ResponseEntity<List<EtudiantDTO>> uploadExcel(@RequestParam("file") MultipartFile file) {
        List<EtudiantDTO> etudiants = etudiantDTOService.parseExcelFile(file);
        return ResponseEntity.ok(etudiants);
    }
}