package ru.mirea.ippo.greekthesarius.errorhandling

import org.springframework.http.HttpStatus
import ru.mirea.ippo.greekthesarius.errorhandling.ApiException

class CreatingNotAllowedException(objectName: String?, reason: String)
    : ApiException(HttpStatus.FORBIDDEN, "Failed to create object \"${objectName ?: "unknown object"}\": $reason")