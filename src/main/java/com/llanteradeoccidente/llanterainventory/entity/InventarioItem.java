package com.llanteradeoccidente.llanterainventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Entity(name = "inventario_llantas")
public class InventarioItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "clave")
    private String clave;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "mayoreo")
    private Double mayoreo;
    @Column(name = "empresa")
    private Double empresa;
    @Column(name = "precio_lista")
    private Double precioLista;
    @Column(name = "liquidacion")
    private Double liquidacion;
    @Column(name = "vigente")
    private Double vigente;
    @Column(name = "tipo")
    private String tipo;
    @Column(name = "marca")
    private String marca;
    @Column(name = "vehiculo")
    private String vehiculo;
    @Column(name = "medida")
    private String medida;
    @Column(name = "carga")
    private String carga;
    private Boolean activo;

}
