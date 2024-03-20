package com.llanteradeoccidente.llanterainventory.services;

import com.llanteradeoccidente.llanterainventory.dtos.ApiResponseDTO;
import com.llanteradeoccidente.llanterainventory.dtos.InventarioItemDTO;
import com.llanteradeoccidente.llanterainventory.entity.InventarioItem;
import com.llanteradeoccidente.llanterainventory.exceptions.InventarioException;
import com.llanteradeoccidente.llanterainventory.mappers.InventarioMapper;
import com.llanteradeoccidente.llanterainventory.repositories.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Autowired
    private InventarioMapper mapper;

    public ApiResponseDTO guardarItem(InventarioItemDTO item) {
        ApiResponseDTO response = new ApiResponseDTO();
        try {
            InventarioItem entity = inventarioRepository.save(mapper.toEntity(item));
            response.setData(mapper.toDTO(entity));
        } catch (Exception e) {
            throw new InventarioException("Error al guardar el item: " + e.getCause(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public ApiResponseDTO guardarItems(List<InventarioItemDTO> items) {
        ApiResponseDTO response = new ApiResponseDTO();
        try {
            List<InventarioItem> itemsEntity = new ArrayList<>();
            for (InventarioItemDTO item : items) {
                itemsEntity.add(mapper.toEntity(item));
            }
          inventarioRepository.saveAll(itemsEntity);
            response.setData("Items guardados correctamente");
        } catch (Exception e) {
            throw new InventarioException("Error al guardar los items", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public ApiResponseDTO obtenerInventario() {
        ApiResponseDTO response = new ApiResponseDTO();
        try {
            List<InventarioItem> items = inventarioRepository.findAll();
            List<InventarioItemDTO> itemsDTO = new ArrayList<>();
            for (InventarioItem item : items) {
                itemsDTO.add(mapper.toDTO(item));
            }
            response.setData(itemsDTO);

        } catch (Exception e) {
            throw new InventarioException("Error al obtener los items", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public ApiResponseDTO obtenerInventarioPorId() {
        return null;
    }

    public ApiResponseDTO actualizarInventario() {
        return null;
    }

    public ApiResponseDTO eliminarInventario() {
        return null;
    }


}
