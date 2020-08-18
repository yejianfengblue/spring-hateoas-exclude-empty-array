package com.example.springhateoasexcludeemptyarray;

import org.springframework.hateoas.Links;

class NonEmptyLinksFilter {

    @Override
    public boolean equals(Object obj) {

        if (obj == null || !(obj instanceof Links)) {
            return false;
        }
        Links links = (Links) obj;
        return links.isEmpty();
    }
}
