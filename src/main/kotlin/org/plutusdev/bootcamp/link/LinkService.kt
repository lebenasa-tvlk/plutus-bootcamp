package org.plutusdev.bootcamp.link

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LinkService @Autowired constructor(private val repository: LinkRepository) {
    fun link(linkID: Int): Link? {
        return repository.link(linkID)
    }

    fun links(page: Int = 0, pageSize: Int = 100, orderBy: SortableLinkField = SortableLinkField.CREATED_ON): List<Link> {
        return repository.links(page, pageSize, orderBy)
    }

    fun linksFromUser(userID: Int, page: Int = 0, pageSize: Int = 100, orderBy: SortableLinkField = SortableLinkField.CREATED_ON): List<Link> {
        // TODO: validate user from UserService
        return repository.linksFromUser(userID, page, pageSize, orderBy)
    }

    fun createLink(userID: Int, link: String, description: String): Link? {
        // TODO: validate user from UserService
        return repository.createLink(userID, link, description)
    }

    fun updateLink(linkID: Int, userID: Int, link: String, description: String): Link? {
        return repository.updateLink(linkID, userID, link, description)
    }

    fun removeLink(linkID: Int) {
        repository.removeLink(linkID)
    }
}