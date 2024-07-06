package com.example.managinv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.managinv.model.RolesModel;

public interface RolesJPARepository extends JpaRepository<RolesModel, Integer> {

}
