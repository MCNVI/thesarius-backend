package ru.mirea.ippo.greekthesarius.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.mirea.ippo.greekthesarius.database.entities.DbWord
import java.util.*

interface WordRepository : JpaRepository<DbWord, UUID> {
    fun findByRusContains(rus: String): List<DbWord>
}