 package ddwu.com.mobileapp.week04.wordexam

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ddwu.com.mobileapp.week04.wordexam.databinding.ActivityMainBinding
import ddwu.com.mobileapp.week04.wordexam.data.Word
import ddwu.com.mobileapp.week04.wordexam.data.WordAdapter
import ddwu.com.mobileapp.week04.wordexam.ui.WordViewModel
import ddwu.com.mobileapp.week04.wordexam.ui.WordViewModelFactory

 class MainActivity : AppCompatActivity() {

    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. wordRepo 객체 생성
        val wordRepo = (application as WordApplication).wordRepo
        val viewModel : WordViewModel by viewModels {
            WordViewModelFactory((application as WordApplication).wordRepo)
        }

        val adapter = WordAdapter(ArrayList<Word>())
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        adapter.setOnWordClickListener(object: WordAdapter.OnWordClickListener {
            override fun onWordClick(view: View, pos: Int) {
                // 5. rvWords 에서 클릭한 단어로 wordDao를 사용하여 DB에서 의미 검색 후 의미 칸에 표시
                val word = adapter.words[pos].word
                binding.etWord.setText(word)
                viewModel.getWordMeaning(word).observe(this@MainActivity) { meaning ->
                    binding.etMeaning.setText(meaning)
                }
            }
        })

        binding.rvWords.layoutManager = layoutManager
        binding.rvWords.adapter = adapter


        // 2. wordDao 객체에서 전체 word 를 가져와 rvWords(RecyclerView) 에 지정
        // Flow<List<Word>> 를 사용하여 갱신 정보를 자동 반영하도록 구성
//        CoroutineScope(Dispatchers.Main).launch {
//            wordFlow.collect{ words ->
//                adapter.words = words
//                adapter.notifyDataSetChanged()
//            }
//        }
        viewModel.getWords().observe(
            this
        ) { newWord ->
            adapter.words = newWord
            adapter.notifyDataSetChanged()
        }


        // 3. 화면에 입력한 단어와 의미를 읽어와 Word 로 만든 후 wordDao 를 사용하여 DB 저장
        binding.btnSave.setOnClickListener {
            val inputWord = Word(binding.etWord.text.toString(), binding.etMeaning.text.toString())
            viewModel.addWord(inputWord)
        }

        // 4. 화면에 입력한 단어로 Word 로 만둔 후(의미는 빈문자열) wordDao 를 사용하여 DB 삭제
        binding.btnDelete.setOnClickListener {
            val removeWord = Word(binding.etWord.text.toString(), binding.etMeaning.text.toString()?:"")
            viewModel.removeWord(removeWord)
        }

        binding.btnModify.setOnClickListener {
            val currentWord = Word(binding.etWord.text.toString(), binding.etMeaning.text.toString())
            viewModel.modifyWord(currentWord)
        }


    }

}