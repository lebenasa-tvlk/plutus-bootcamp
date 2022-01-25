package org.plutusdev.bootcamp.link

import org.springframework.stereotype.Repository

// TODO: Move to common utility module
interface SortableField {
    val field: String
    var descending: Boolean
    fun isValid(): Boolean
}

enum class SortableLinkField(override val field: String): SortableField {
    LINK("link"),
    CREATED_ON("created_on"),
    UPDATED_ON("updated_on");

    override var descending: Boolean = true

    override fun isValid(): Boolean {
        return when (field) {
            LINK.field -> true
            CREATED_ON.field -> true
            UPDATED_ON.field -> true
            else -> false
        }
    }
}

@Repository
interface LinkRepository {
    fun link(linkID: Int): Link?

    fun links(
        page: Int = 0,
        limit: Int = 100,
        orderBy: SortableLinkField = SortableLinkField.CREATED_ON,
    ): List<Link>

    fun linksFromUser(
        userID: Int,
        page: Int,
        limit: Int = 100,
        orderBy: SortableLinkField = SortableLinkField.CREATED_ON,
    ): List<Link>

    fun createLink(userID: Int, link: String, description: String): Link?
    fun updateLink(linkID: Int, userID: Int, link: String, description: String): Link?
    fun removeLink(linkID: Int)
}
