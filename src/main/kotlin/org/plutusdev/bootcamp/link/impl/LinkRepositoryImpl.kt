package org.plutusdev.bootcamp.link.impl

import org.jooq.DSLContext
import org.jooq.SortField
import org.jooq.impl.DSL
import org.plutusdev.bootcamp.link.Link
import org.plutusdev.bootcamp.link.LinkRepository
import org.plutusdev.bootcamp.link.SortableLinkField
import org.plutusdev.jooq.Tables
import org.plutusdev.jooq.tables.records.LinksRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.time.OffsetDateTime

@Repository
class LinkRepositoryImpl @Autowired constructor(dslContext: DSLContext) : LinkRepository {
    private val create: DSLContext = dslContext

    override fun link(linkID: Int): Link? {
        return create.selectFrom(Tables.LINKS)
            .where(Tables.LINKS.ID.equal(linkID))
            .fetchOne()
            ?.toModel()
    }

    override fun links(
        page: Int,
        limit: Int,
        orderBy: org.plutusdev.bootcamp.link.SortableLinkField,
    ): List<Link> {
        return create.selectFrom(Tables.LINKS)
            .where(Tables.LINKS.STATUS.equal(Link.STATUS.VISIBLE.statusCode))
            .orderBy(orderByQuery(orderBy))
            .limit(limit)
            .offset(page)
            .fetch()
            .map { record -> record.toModel() }
    }

    override fun linksFromUser(
        userID: Int,
        page: Int,
        limit: Int,
        orderBy: org.plutusdev.bootcamp.link.SortableLinkField,
    ): List<Link> {
        return create.selectFrom(Tables.LINKS)
            .where(Tables.LINKS.CREATED_BY.equal(userID).and(Tables.LINKS.STATUS.equal(Link.STATUS.VISIBLE.statusCode)))
            .orderBy(orderByQuery(orderBy))
            .limit(limit)
            .offset(page)
            .fetch()
            .map { record -> record.toModel() }
    }

    override fun createLink(userID: Int, link: String, description: String): Link? {
        var result: Link? = null
        create.transaction { context ->
            result = DSL.using(context)
                .newRecord(Tables.LINKS)
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

    override fun updateLink(linkID: Int, userID: Int, link: String, description: String): Link? {
        var result: Link? = null
        create.transaction { context ->
            result = DSL.using(context)
                .fetchOne(Tables.LINKS, Tables.LINKS.ID.equal(linkID))
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

    override fun removeLink(linkID: Int) {
        create.transaction { context ->
            DSL.using(context)
                .fetchOne(Tables.LINKS, Tables.LINKS.ID.equal(linkID))
                ?.apply {
                    status = Link.STATUS.REMOVED.statusCode
                    store()
                }
        }
    }

    private fun orderByQuery(field: SortableLinkField): SortField<out Any> {
        val dbField = when (field.field) {
            SortableLinkField.LINK.field -> Tables.LINKS.LINK
            SortableLinkField.CREATED_ON.field -> Tables.LINKS.CREATED_ON
            SortableLinkField.UPDATED_ON.field -> Tables.LINKS.UPDATED_ON
            else -> Tables.LINKS.CREATED_ON
        }
        return when (field.descending) {
            true -> dbField.desc()
            false -> dbField.asc()
        }
    }
}

private fun LinksRecord.toModel(): Link {
    let { record ->
        with(Tables.LINKS) {
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
