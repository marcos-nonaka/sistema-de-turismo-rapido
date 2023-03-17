package com.turismorapidobackend.turismorapidobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TurismologoRequestDTO {
    Long id_turismologo;
    String something;
    String name;
}
