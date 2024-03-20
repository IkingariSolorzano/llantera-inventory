package com.llanteradeoccidente.llanterainventory.dtos;

import com.llanteradeoccidente.llanterainventory.utils.Meta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ApiResponseDTO {

    Meta meta;
    Object data;
}
