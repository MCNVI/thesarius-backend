package ru.mirea.ippo.greekthesarius.errorhandling

import org.springframework.http.HttpStatus
import ru.mirea.ippo.greekthesarius.errorhandling.ApiException

class FilterException(objectName: String?, reason: String)
    : ApiException(HttpStatus.BAD_REQUEST, "Failed to filter objects \"${objectName ?: "unknown object"}\": $reason")