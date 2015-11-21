package com.idaterate.domain.DateRate;

import com.idaterate.domain.DateRate.DateRate;
import org.springframework.data.jpa.domain.Specification;

/**
 * Created by Joe Deluca on 28/10/2015.
 */
public class DateRateSpecification {
    public static Specification<DateRate> hasUsername(String username) {
        return (root, query, cb) -> {
            return cb.equal(cb.trim(cb.lower(root.get("dateUsername"))), username.toLowerCase().trim());
        };
    }

    public static Specification<DateRate> hasDatingSite(String datingSiteId) {
        return (root, query, cb) -> {
            return cb.equal(cb.trim(cb.lower(root.get("datingSite"))), datingSiteId.toLowerCase().trim());
        };
    }

    public static Specification<DateRate> hasHashtags(String hashtags) {
        return (root, query, cb) -> {
            return cb.like(cb.trim(cb.lower(root.get("description"))), hashtags.toLowerCase().trim());
        };
    }

    public static Specification<DateRate> hasCity(String city) {
        return (root, query, cb) -> {
            return cb.like(cb.trim(cb.lower(root.get("city"))), city.toLowerCase().trim());
        };
    }
}
