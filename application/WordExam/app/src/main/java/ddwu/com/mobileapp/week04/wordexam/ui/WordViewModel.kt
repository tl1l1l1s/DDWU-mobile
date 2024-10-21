package ddwu.com.mobileapp.week04.wordexam.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import ddwu.com.mobileapp.week04.wordexam.data.Word
import ddwu.com.mobileapp.week04.wordexam.data.WordRepository
import kotlinx.coroutines.launch

class WordViewModel (var repo: WordRepository) : ViewModel() {
    private var allWords : LiveData<List<Word>> = repo.allWords.asLiveData()

    fun getWords() = allWords

    fun addWord(word: Word) = viewModelScope.launch {
        repo.addWord(word)
    }

    fun removeWord(word: Word) = viewModelScope.launch {
        repo.removeWord(word)
    }

    fun modifyWord(word: Word) = viewModelScope.launch {
        repo.updateWord(word)
    }

    fun getWordMeaning(meaning: String) : LiveData<String> = repo.getWordMeaning(meaning).asLiveData()
}