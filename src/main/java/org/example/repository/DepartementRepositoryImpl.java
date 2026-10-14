package org.example.repository;

import java.util.List;
import java.util.ArrayList;

import org.example.model.Departement;

public class DepartementRepositoryImpl implements DepartementRepository{
    public final List<Departement> departements = new ArrayList<>();

    @Override
    public Departement save(Departement departement){

        return departement;
    }

    @Override
    public List<Departement> getAll(){
        return departements;
    }

    @Override
    public boolean deleteById(Long id){
        return departements.removeIf(Departement ->
                Departement.getId() == id);
    }
}
