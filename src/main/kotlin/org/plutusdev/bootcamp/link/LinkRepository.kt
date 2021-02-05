package org.plutusdev.bootcamp.link

import org.jetbrains.annotations.NotNull
import org.jooq.*
import org.jooq.impl.DSL
import org.springframework.beans.factory.annotation.Autowired

import org.plutusdev.jooq.Tables.LINKS
import org.plutusdev.jooq.tables.records.LinksRecord
import java.time.OffsetDateTime

class LinkRepository @Autowired constructor(dslContext: DSLContext) {
    private var create: DSLContext = dslContext

    fun links(
        page: Int,
        limit: Int = 100,
        orderBy: Field<*> = LINKS.CREATED_ON,
        descending: Boolean = true,
    ): List<Link> {
        return create.selectFrom(LINKS)
            .where(LINKS.STATUS.equal(Link.STATUS.VISIBLE.statusCode))
            .orderBy(orderByQuery(orderBy, descending))
            .limit(limit)
            .offset(page)
            .fetch()
            .map { record -> record.toModel() }
    }

    fun linksFromUser(
        userID: Int,
        page: Int,
        limit: Int = 100,
        orderBy: Field<*> = LINKS.CREATED_ON,
        descending: Boolean = true,
    ): List<Link> {
        return create.selectFrom(LINKS)
            .where(LINKS.CREATED_BY.equal(userID).and(LINKS.STATUS.equal(Link.STATUS.VISIBLE.statusCode)))
            .orderBy(orderByQuery(orderBy, descending))
            .limit(limit)
            .offset(page)
            .fetch()
            .map { record -> record.toModel() }
    }

    fun createLink(userID: Int, link: String, description: String): Link? {
        var result: Link? = null
        create.transaction { context ->
            result = DSL.using(context)
                .newRecord(LINKS)
                .apply {
                    setLink(link)
                    setDescription(description)
                    setCreatedBy(userID)
                    store()
                }
                .toModel()
        }
        return result
    }

    fun updateLink(linkID: Int, userID: Int, link: String, description: String): Link? {
        var result: Link? = null
        create.transaction { context ->
            result = DSL.using(context)
                .fetchOne(LINKS, LINKS.ID.equal(linkID))
                ?.apply {
                    setLink(link)
                    setDescription(description)
                    setUpdatedBy(userID)
                    setUpdatedOn(OffsetDateTime.now())
                }
                ?.toModel()

        }
        return result
    }

    fun removeLink(linkID: Int) {
        create.transaction { context ->
            DSL.using(context)
                .fetchOne(LINKS, LINKS.ID.equal(linkID))
                ?.apply {
                    status = Link.STATUS.REMOVED.statusCode
                    store()
                }
        }
    }

    private fun orderByQuery(field: Field<*> = LINKS.CREATED_ON, descending: Boolean = true): SortField<out Any> {
        if (descending) {
            return field.desc()
        }
        return field.asc()
    }
}

private fun LinksRecord.toModel(): Link {
    let { record ->
        with(LINKS) {
            val status = if (record[STATUS] == null) {
                Link.STATUS.VISIBLE
            } else {
                Link.STATUS.REMOVED
            }
            return Link(
                id = record[ID],
                link = record[LINK],
                description = record[DESCRIPTION],
                status = status,
                createdBy = record[CREATED_BY],
                createdOn = record[CREATED_ON],
                updatedBy = record[UPDATED_BY],
                updatedOn = record[UPDATED_ON],
            )
        }
    }
}
