package ddwu.com.mobileapp.week04.wordexam.data

import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {
    val allWords : Flow<List<Word>> = wordDao.showAllWords()

    suspend fun addWord(word: Word) {
        wordDao.insertWord(word)
    }

    suspend fun removeWord(word: Word) {
        wordDao.deleteWord(word)
    }

    suspend fun updateWord(word: Word) {
        wordDao.updateWord(word)
    }

    fun getWordMeaning(word: String) : Flow<String> {
        return wordDao.getWordMeaning(word)
    }
}