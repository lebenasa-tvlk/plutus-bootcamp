package org.plutusdev.bootcamp.link

import java.time.OffsetDateTime

data class Link(
    val id: Int,
    val link: String,
    val description: String,
    val status: STATUS = STATUS.VISIBLE,
    val createdBy: Int,
    val createdOn: OffsetDateTime = OffsetDateTime.now(),
    val updatedBy: Int,
    val updatedOn: OffsetDateTime = OffsetDateTime.now(),
) {
    enum class STATUS(val statusCode: Short) {
        REMOVED(-1),
        VISIBLE(1),
    }
}