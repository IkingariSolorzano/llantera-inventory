package com.llanteradeoccidente.llanterainventory.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventarioItemDTO {

    private Long id;
    @NotNull(message = "La clave no puede ser nula")
    private String clave;
    private String descripcion;
    private Integer stock;
    private Double mayoreo;
    private Double empresa;
    private Double precioLista;
    private Double liquidacion;
    private Double vigente;
    private String tipo;
    private String marca;
    private String vehiculo;
    private String medida;
    private String carga;
    private Boolean activo;

    public boolean isValid() {
        return clave != null && !clave.isEmpty();
    }
}
