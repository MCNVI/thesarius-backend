package ru.mirea.ippo.greekthesarius.services

import org.springframework.stereotype.Service
import ru.mirea.ippo.greekthesarius.database.entities.DbWord
import ru.mirea.ippo.greekthesarius.models.Word
import ru.mirea.ippo.greekthesarius.repositories.WordRepository

@Service
class WordService(
    val wordRepository: WordRepository
) {

    fun getAllWords(): List<Word> = wordRepository.findAll().map { it.toModel() }

    fun updateWords(types: List<Word>): List<Word> {
        val list = wordRepository.saveAll(types.map { DbWord.fromTemplate(it) })
        //wordRepository.refreshAll(list)
        return wordRepository.findAll().map { it.toModel() }
    }

    fun getByRusContains(rus: String) = wordRepository.findByRusContains(rus).map { it.toModel() }

}