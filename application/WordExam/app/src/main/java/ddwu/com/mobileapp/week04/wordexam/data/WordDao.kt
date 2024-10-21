package ddwu.com.mobileapp.week04.wordexam.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWord(word: Word)

    @Delete
    suspend fun deleteWord(word: Word)

    @Update
    suspend fun updateWord(word: Word)

    // 조건 없이 전체 단어를 검색하여 Word 엔티티 반환
    @Query("SELECT * FROM word_table")
    fun showAllWords() : Flow<List<Word>>

    // 단어(word)를 입력하여 의미(meaning) 반환
    @Query("SELECT meaning FROM word_table WHERE word = :word")
    fun getWordMeaning(word: String) : Flow<String>
}