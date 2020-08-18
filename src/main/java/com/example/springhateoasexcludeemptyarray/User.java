package com.example.springhateoasexcludeemptyarray;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

class User extends RepresentationModel<User> {

    private String username;

    User(String username) {
        this.username = username;
    }

    @JsonProperty("username")
    String getUsername() {
        return username;
    }

    @JsonProperty("links")
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = NonEmptyLinksFilter.class)
    @Override
    public Links getLinks() {
        return super.getLinks();
    }

}
