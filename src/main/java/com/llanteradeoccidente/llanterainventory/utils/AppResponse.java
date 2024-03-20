package com.llanteradeoccidente.llanterainventory.utils;

import com.llanteradeoccidente.llanterainventory.dtos.ApiResponseDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Slf4j
public class AppResponse {


    protected ResponseEntity<ApiResponseDTO> generateResponse(ApiResponseDTO responseDTO) {
        Meta meta = new Meta();
        meta.setTransactionID(UUID.randomUUID().toString());
        meta.setStatus("OK");
        meta.setStatusCode(HttpStatus.OK.value());
        meta.setMessage("Success");
        meta.setTimestamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(new ApiResponseDTO(meta, responseDTO.getData()), HttpStatus.OK);
    }

    public ResponseEntity<ApiResponseDTO> generateErrorResponse(HttpStatus status, String message){
        Meta meta = new Meta();
        meta.setTransactionID(UUID.randomUUID().toString());
        meta.setStatus(status.getReasonPhrase());
        meta.setStatusCode(status.value());
        meta.setMessage(message);
        meta.setTimestamp(LocalDateTime.now().toString());
        return new ResponseEntity<>(new ApiResponseDTO(meta, null), status);
    }

}
