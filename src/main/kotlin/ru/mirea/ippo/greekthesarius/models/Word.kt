package ru.mirea.ippo.greekthesarius.models

import com.fasterxml.jackson.databind.JsonNode
import java.util.*

data class Word(
    val id: UUID?,
    val greek: String,
    val rus: String,
    val forms: JsonNode
)