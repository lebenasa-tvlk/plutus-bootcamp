/*
 * This file is generated by jOOQ.
 */
package org.plutusdev.jooq;


import java.util.Arrays;
import java.util.List;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import org.plutusdev.jooq.tables.Links;
import org.plutusdev.jooq.tables.Users;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Bootcamp extends SchemaImpl {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>bootcamp</code>
     */
    public static final Bootcamp BOOTCAMP = new Bootcamp();

    /**
     * The table <code>bootcamp.links</code>.
     */
    public final Links LINKS = Links.LINKS;

    /**
     * The table <code>bootcamp.users</code>.
     */
    public final Users USERS = Users.USERS;

    /**
     * No further instances allowed
     */
    private Bootcamp() {
        super("bootcamp", null);
    }


    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.<Table<?>>asList(
            Links.LINKS,
            Users.USERS);
    }
}
