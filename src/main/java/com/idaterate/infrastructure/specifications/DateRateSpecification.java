package com.idaterate.infrastructure.specifications;

import com.idaterate.domain.DateRate;
import com.idaterate.domain.DatingSite;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.time.LocalDate;

/**
 * Created by Joe Deluca on 28/10/2015.
 */
public class DateRateSpecification {
    public static Specification<DateRate> hasUsername(String username) {
        return (root, query, cb) -> {
            return cb.equal(root.get("dateUsername"), username);
        };
    }

    public static Specification<DateRate> hasDatingSite(String datingSiteId) {
        return (root, query, cb) -> {
            return cb.equal(root.get("datingSite"), datingSiteId);
        };
    }

    public static Specification<DateRate> hasHashtags(String hashtags) {
        return (root, query, cb) -> {
            return cb.like(root.get("description"), hashtags);
        };
    }
}
