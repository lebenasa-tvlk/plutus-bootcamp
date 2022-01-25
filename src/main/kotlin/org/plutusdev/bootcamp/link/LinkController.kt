package org.plutusdev.bootcamp.link

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class LinkController @Autowired constructor(private val linkService: LinkService) {

    @GetMapping("/link/{id}")
    fun link(@PathVariable id: Int): Link? {
        // TODO: customize response when there's no result found
        return linkService.link(id)
    }

    @GetMapping("/links")
    fun links(
        @RequestParam("page") page: Int,
        @RequestParam("pageSize", required = false, defaultValue = "100") pageSize: Int,
        @RequestParam("orderBy", required = false, defaultValue = "created_on") orderBy: String,
        @RequestParam("descending", required = false, defaultValue = "true") descending: Boolean,
    ): List<Link> {
        return linkService.links(page, pageSize, orderField(orderBy, descending))
    }

    @PutMapping("/link")
    fun createLink(@RequestBody request: CreateLinkRequest): Link? {
        // TODO: add input validation and sanitation
        // TODO: customize response when creating new link failed
        with (request) {
            return linkService.createLink(userID, link, description)
        }
    }

    @PostMapping("/link")
    fun updateLink(
        @RequestParam("linkID") linkID: Int,
        @RequestParam("userID") userID: Int,
        @RequestParam("link") link: String,
        @RequestParam("description") description: String,
    ): Link? {
        // TODO: add input validation and sanitation
        // TODO: customize response when creating new link failed
        return linkService.updateLink(linkID, userID, link, description)
    }

    private fun orderField(orderBy: String, desc: Boolean): SortableLinkField {
        return when (orderBy) {
            SortableLinkField.LINK.field -> SortableLinkField.LINK
            SortableLinkField.CREATED_ON.field -> SortableLinkField.CREATED_ON
            SortableLinkField.UPDATED_ON.field -> SortableLinkField.UPDATED_ON
            else -> SortableLinkField.CREATED_ON
        }
            .apply {
                descending = desc
            }
    }

}

class CreateLinkRequest(val userID: Int, val link: String, val description: String)