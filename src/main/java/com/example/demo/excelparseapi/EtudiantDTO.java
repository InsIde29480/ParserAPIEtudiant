package com.example.demo.excelparseapi;

public class EtudiantDTO {
    private String numeroEtu;
    private int validation;
    private String compte_id;

    public EtudiantDTO() {}

    public EtudiantDTO(String numeroEtu, int validation, String compte_id) {
        this.numeroEtu = numeroEtu;
        this.validation = validation;
        this.compte_id = compte_id;
    }

    public String getNumeroEtu() {
        return this.numeroEtu;
    }

    public int getValidation() {
        return this.validation;
    }

    public String getCompteId() {
        return this.compte_id;
    }
}
