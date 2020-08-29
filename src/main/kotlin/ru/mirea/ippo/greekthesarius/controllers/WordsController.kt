package ru.mirea.ippo.greekthesarius.controllers

import org.springframework.web.bind.annotation.*
import ru.mirea.ippo.greekthesarius.models.Word
import ru.mirea.ippo.greekthesarius.services.WordService

@RestController
@RequestMapping("words")
@CrossOrigin
class WordsController(val wordService: WordService) {

    @GetMapping
    fun getWords(): List<Word> = wordService.getAllWords()

    @PostMapping
    fun updateWords(@RequestBody wordList: List<Word>): List<Word> = wordService.updateWords(wordList)

    @GetMapping("search")
    fun getByRus(@RequestParam rus: String): List<Word> = wordService.getByRusContains(rus)

}