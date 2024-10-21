package ddwu.com.mobileapp.week04.wordexam.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ddwu.com.mobileapp.week04.wordexam.data.WordRepository

class WordViewModelFactory(private val repo: WordRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)) {
         @Suppress("UNCHECKED CAST")
         return WordViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}