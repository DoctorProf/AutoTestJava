package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private int sold;
    private int happyness;
    private int string;
    private int pending;
    private int available;
    private int expectation;
}
