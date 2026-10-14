package org.example.repository;

import org.example.model.Departement;
import java.util.List;

public interface DepartementRepository {
    
    Departement save(Departement departement);
    List<Departement> getAll();
    boolean deleteById(Long id);

}
