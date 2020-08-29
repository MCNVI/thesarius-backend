package ru.mirea.ippo.greekthesarius.database.entities

import com.fasterxml.jackson.databind.JsonNode
import com.vladmihalcea.hibernate.type.json.JsonBinaryType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import ru.mirea.ippo.greekthesarius.models.Word
import java.util.*
import javax.persistence.*


@Entity
@Table(schema = "thesarius", name = "word")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType::class)
data class DbWord(
    @Id
    val id: UUID?,
    val greek: String,
    val rus: String,
    @Type(type = "jsonb")
    val forms: JsonNode
) {
    fun toModel(): Word = Word(
        id,
        greek,
        rus,
        forms
    )

    companion object {
        fun fromTemplate(wordTemplate: Word): DbWord = DbWord(
            wordTemplate.id ?: UUID.randomUUID(),
            wordTemplate.greek,
            wordTemplate.rus,
            wordTemplate.forms
        )
    }
}