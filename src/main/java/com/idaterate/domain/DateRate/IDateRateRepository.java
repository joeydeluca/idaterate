package com.idaterate.domain.DateRate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IDateRateRepository extends JpaRepository<DateRate, Long>, JpaSpecificationExecutor {

}
