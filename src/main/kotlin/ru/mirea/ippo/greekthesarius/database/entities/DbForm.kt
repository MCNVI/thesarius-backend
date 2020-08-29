package ru.mirea.ippo.greekthesarius.database.entities

import com.vladmihalcea.hibernate.type.array.StringArrayType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import ru.mirea.ippo.greekthesarius.models.Form
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(schema = "thesarius", name = "form")
@TypeDef(name = "string-array", typeClass = StringArrayType::class)
data class DbForm (
    @Id
    val number: String,
    @Type(type = "string-array")
    val formList: Array<String>
) {
    fun toModel() : Form = Form(
        number,
        formList
    )
    companion object {
        fun fromTemplate(formTemplate: Form): DbForm = DbForm(
            formTemplate.number,
            formTemplate.formList
        )
    }
}