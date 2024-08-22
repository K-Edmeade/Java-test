package com.example.test.java.esg.kya.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty
    @CsvBindByName(column = "Customer Reference")
    private Long customerReference;

    @JsonProperty
    @CsvBindByName(column = "Customer Name")
    private String customerName;

    @JsonProperty
    @CsvBindByName(column = "Address Line 1")
    private String firstLineAddress;

    @JsonProperty
    @CsvBindByName(column = "Address Line 2")
    private String secondLineAddress;

    @JsonProperty
    @CsvBindByName(column = "Town")
    private String town;

    @JsonProperty
    @CsvBindByName(column = "County")
    private String county;

    @JsonProperty
    @CsvBindByName(column = "Country")
    private String country;

    @JsonProperty
    @CsvBindByName(column = "Postcode")
    private String postcode;

}
