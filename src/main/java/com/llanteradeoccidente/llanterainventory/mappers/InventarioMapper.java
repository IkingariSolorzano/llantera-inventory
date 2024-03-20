package com.llanteradeoccidente.llanterainventory.mappers;

import com.llanteradeoccidente.llanterainventory.dtos.InventarioItemDTO;
import com.llanteradeoccidente.llanterainventory.entity.InventarioItem;
import org.springframework.stereotype.Component;

@Component
public class InventarioMapper {

    public InventarioItem toEntity(InventarioItemDTO itemDTO) {
        InventarioItem item = new InventarioItem();
        item.setClave(itemDTO.getClave());
        item.setDescripcion(itemDTO.getDescripcion());
        item.setStock(itemDTO.getStock());
        item.setMayoreo(itemDTO.getMayoreo());
        item.setEmpresa(itemDTO.getEmpresa());
        item.setPrecioLista(itemDTO.getPrecioLista());
        item.setLiquidacion(itemDTO.getLiquidacion());
        item.setVigente(itemDTO.getVigente());
        item.setTipo(itemDTO.getTipo());
        item.setMarca(itemDTO.getMarca());
        item.setVehiculo(itemDTO.getVehiculo());
        item.setMedida(itemDTO.getMedida());
        item.setCarga(itemDTO.getCarga());
        item.setActivo(true);
        return item;
    }

    public InventarioItemDTO toDTO(InventarioItem item) {
        return new InventarioItemDTO(
                item.getId(),
                item.getClave(),
                item.getDescripcion(),
                item.getStock(),
                item.getMayoreo(),
                item.getEmpresa(),
                item.getPrecioLista(),
                item.getLiquidacion(),
                item.getVigente(),
                item.getTipo(),
                item.getMarca(),
                item.getVehiculo(),
                item.getMedida(),
                item.getCarga(),
                item.getActivo()
        );
    }
}
