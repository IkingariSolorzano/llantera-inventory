package com.llanteradeoccidente.llanterainventory.controllers;

import com.llanteradeoccidente.llanterainventory.dtos.ApiResponseDTO;
import com.llanteradeoccidente.llanterainventory.dtos.InventarioItemDTO;
import com.llanteradeoccidente.llanterainventory.exceptions.InventarioException;
import com.llanteradeoccidente.llanterainventory.services.InventarioService;
import com.llanteradeoccidente.llanterainventory.utils.AppResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventario")
@Validated
public class InventarioController extends AppResponse {

    @Autowired
    private InventarioService inventarioService;

    //Guardar un item
    @PostMapping("/item")
    public ResponseEntity<ApiResponseDTO> crearInventario(@RequestBody @Valid InventarioItemDTO item) {
        try {
            if (!item.isValid()) {
                throw new InventarioException("El objeto no es válido", HttpStatus.BAD_REQUEST);
            }
            return generateResponse(inventarioService.guardarItem(item));
        } catch (InventarioException e) {
            return generateErrorResponse(e.getHttpStatus(), e.getMessage());
        } catch (Exception e) {
            return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrio un error inesperado al guardar el item.");
        }

    }

    //Guardar varios items
    @PostMapping("/list")
    public ResponseEntity<ApiResponseDTO> crearInventario(@RequestBody List<InventarioItemDTO> items) {
        try {
            if (CollectionUtils.isEmpty(items)) {
                throw new InventarioException("La lista de items no puede estar vacia", HttpStatus.BAD_REQUEST);
            }
            for (InventarioItemDTO item : items) {
                if (!item.isValid()) {
                    throw new InventarioException("El objeto no es válido", HttpStatus.BAD_REQUEST);
                }
                // Resto de la lógica...
            }
            return generateResponse(inventarioService.guardarItems(items));
        } catch (InventarioException e) {
            return generateErrorResponse(e.getHttpStatus(), e.getMessage());
        } catch (Exception e) {
            return generateErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrio un error inesperado al guardar los items.");
        }
    }


    //Obtener todos los items
    @GetMapping
    public ResponseEntity<ApiResponseDTO> obtenerInventario() {
        try {
            return generateResponse(inventarioService.obtenerInventario());
        } catch (InventarioException e) {
            return generateErrorResponse(e.getHttpStatus(), e.getMessage());
        }
    }

    //Obtener un item por id
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> obtenerInventarioPorId() {
        return null;
    }

    //Actualizar un item
    @PostMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> actualizarInventario() {
        return null;
    }

    //Eliminar un item
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO> eliminarInventario() {
        return null;
    }

}
