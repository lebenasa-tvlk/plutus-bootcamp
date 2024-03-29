/*
 * This file is generated by jOOQ.
 */
package org.plutusdev.jooq.tables.records;


import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;
import org.plutusdev.jooq.tables.Users;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record5<Integer, String, String, String, OffsetDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>bootcamp.users.id</code>.
     */
    public UsersRecord setId(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>bootcamp.users.id</code>.
     */
    public Integer getId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bootcamp.users.name</code>.
     */
    public UsersRecord setName(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>bootcamp.users.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bootcamp.users.email</code>.
     */
    public UsersRecord setEmail(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>bootcamp.users.email</code>.
     */
    public String getEmail() {
        return (String) get(2);
    }

    /**
     * Setter for <code>bootcamp.users.access_token</code>.
     */
    public UsersRecord setAccessToken(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>bootcamp.users.access_token</code>.
     */
    public String getAccessToken() {
        return (String) get(3);
    }

    /**
     * Setter for <code>bootcamp.users.expired_on</code>.
     */
    public UsersRecord setExpiredOn(OffsetDateTime value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>bootcamp.users.expired_on</code>.
     */
    public OffsetDateTime getExpiredOn() {
        return (OffsetDateTime) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, OffsetDateTime> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<Integer, String, String, String, OffsetDateTime> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.NAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.EMAIL;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.ACCESS_TOKEN;
    }

    @Override
    public Field<OffsetDateTime> field5() {
        return Users.USERS.EXPIRED_ON;
    }

    @Override
    public Integer component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public String component3() {
        return getEmail();
    }

    @Override
    public String component4() {
        return getAccessToken();
    }

    @Override
    public OffsetDateTime component5() {
        return getExpiredOn();
    }

    @Override
    public Integer value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public String value3() {
        return getEmail();
    }

    @Override
    public String value4() {
        return getAccessToken();
    }

    @Override
    public OffsetDateTime value5() {
        return getExpiredOn();
    }

    @Override
    public UsersRecord value1(Integer value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setAccessToken(value);
        return this;
    }

    @Override
    public UsersRecord value5(OffsetDateTime value) {
        setExpiredOn(value);
        return this;
    }

    @Override
    public UsersRecord values(Integer value1, String value2, String value3, String value4, OffsetDateTime value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(Integer id, String name, String email, String accessToken, OffsetDateTime expiredOn) {
        super(Users.USERS);

        setId(id);
        setName(name);
        setEmail(email);
        setAccessToken(accessToken);
        setExpiredOn(expiredOn);
    }
}
