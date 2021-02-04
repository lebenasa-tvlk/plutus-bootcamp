/*
 * This file is generated by jOOQ.
 */
package org.plutusdev.jooq.tables.pojos;


import java.io.Serializable;
import java.time.OffsetDateTime;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Integer        id;
    private final String         name;
    private final String         email;
    private final String         accessToken;
    private final OffsetDateTime expiredOn;

    public Users(Users value) {
        this.id = value.id;
        this.name = value.name;
        this.email = value.email;
        this.accessToken = value.accessToken;
        this.expiredOn = value.expiredOn;
    }

    public Users(
        Integer        id,
        String         name,
        String         email,
        String         accessToken,
        OffsetDateTime expiredOn
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.accessToken = accessToken;
        this.expiredOn = expiredOn;
    }

    /**
     * Getter for <code>bootcamp.users.id</code>.
     */
    public Integer getId() {
        return this.id;
    }

    /**
     * Getter for <code>bootcamp.users.name</code>.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for <code>bootcamp.users.email</code>.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Getter for <code>bootcamp.users.access_token</code>.
     */
    public String getAccessToken() {
        return this.accessToken;
    }

    /**
     * Getter for <code>bootcamp.users.expired_on</code>.
     */
    public OffsetDateTime getExpiredOn() {
        return this.expiredOn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Users (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(email);
        sb.append(", ").append(accessToken);
        sb.append(", ").append(expiredOn);

        sb.append(")");
        return sb.toString();
    }
}
