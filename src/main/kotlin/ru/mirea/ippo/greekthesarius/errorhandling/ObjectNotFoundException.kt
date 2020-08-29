package ru.mirea.ippo.greekthesarius.errorhandling

import org.springframework.http.HttpStatus
import ru.mirea.ippo.greekthesarius.errorhandling.ApiException

class ObjectNotFoundException(objectName: String, id: Any)
    : ApiException(HttpStatus.NOT_FOUND, "Object \"${objectName}\" with id \"${id}\" not found")