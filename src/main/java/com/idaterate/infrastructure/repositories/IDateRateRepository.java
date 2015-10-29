package com.idaterate.infrastructure.repositories;

import com.idaterate.domain.DateRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

interface IDateRateRepository extends JpaRepository<DateRate, Long>, JpaSpecificationExecutor {
    List<DateRate> findByDateUsername(String dateUsername);
}
