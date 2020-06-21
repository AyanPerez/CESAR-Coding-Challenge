package dev.ayan.searchlist.ui.main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import dev.ayan.searchlist.R
import dev.ayan.searchlist.business.isValid
import dev.ayan.searchlist.model.WordModel
import dev.ayan.searchlist.repository.WordRepository
import kotlinx.android.synthetic.main.fragment_word.*


class WordFragment : Fragment() {

    private var repository: WordRepository = WordRepository()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_word, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = WordAdapter(repository.list, view.context)

        button.setOnClickListener{
            val items = filterList(editText.text.toString())
            recyclerView.adapter = WordAdapter(items, view.context)
        }

//        fab.setOnClickListener {
//            super.onViewCreated(view, savedInstanceState)
//
//            val layoutManager = LinearLayoutManager(context)
//
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//
//            //Adding words
//            repository.addWord(WordModel("Moon"))
//            recyclerView.adapter = WordAdapter(repository.list, view.context)
//        }
    }


    private fun filterList(value : String) : List<WordModel> {
        if (value.isBlank()) return repository.list
        return repository.list.filter {
            it.name.isValid(value)
        }
    }

}
