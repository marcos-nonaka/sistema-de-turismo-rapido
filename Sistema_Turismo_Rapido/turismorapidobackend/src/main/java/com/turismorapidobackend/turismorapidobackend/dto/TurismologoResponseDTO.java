package com.turismorapidobackend.turismorapidobackend.dto;

import com.turismorapidobackend.turismorapidobackend.model.Turismologo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TurismologoResponseDTO {
    Long id;
    Long client_id;
    String something;
    public TurismologoResponseDTO() {
    }
    public TurismologoResponseDTO(Turismologo turismologo) {
        id = turismologo.getId();
        client_id = turismologo.getClient().getId_client();
        something = turismologo.getSomething();
    }
}
