package com.llanteradeoccidente.llanterainventory.repositories;

import com.llanteradeoccidente.llanterainventory.entity.InventarioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioItem, Long> {
}
