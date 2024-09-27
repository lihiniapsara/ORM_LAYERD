package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private String id;
    private String name;
    private String price;
    private String qty;

    public ItemDTO(String id, String name, String price, int qty) {

    }
}
