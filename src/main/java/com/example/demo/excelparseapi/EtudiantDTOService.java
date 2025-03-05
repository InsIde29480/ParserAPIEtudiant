package com.example.demo.excelparseapi;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class EtudiantDTOService {

    public List<EtudiantDTO> parseExcelFile(MultipartFile file) {
        List<EtudiantDTO> etudiantList = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream();
             Workbook workbook = new XSSFWorkbook(inputStream)) {

            Sheet sheet = workbook.getSheetAt(0); // Read the first sheet

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Skip header row

                String numeroEtu = row.getCell(0).getStringCellValue();
                int validation = (int) row.getCell(1).getNumericCellValue();
                String compte_id = row.getCell(2).getStringCellValue();

                EtudiantDTO etudiant = new EtudiantDTO(numeroEtu, validation, compte_id);
                etudiantList.add(etudiant);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return etudiantList;
    }
}
