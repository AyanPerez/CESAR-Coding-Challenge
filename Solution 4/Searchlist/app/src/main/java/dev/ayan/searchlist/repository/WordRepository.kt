package dev.ayan.searchlist.repository

import dev.ayan.searchlist.model.WordModel

class WordRepository {

    var list : MutableList<WordModel> = populate()
    private fun populate() : MutableList<WordModel>{
        val populateList : MutableList<WordModel> = arrayListOf()
        populateList.add(WordModel("you"))
        populateList.add(WordModel("probably"))
        populateList.add(WordModel("despite"))
        populateList.add(WordModel("moon"))
        populateList.add(WordModel("misspellings"))
        populateList.add(WordModel("changed"))
        populateList.add(WordModel("changer"))
        populateList.add(WordModel("change"))
        populateList.add(WordModel("maintenance"))
        populateList.add(WordModel("checking"))
        populateList.add(WordModel("results"))
        populateList.add(WordModel("available"))
        populateList.add(WordModel("laptop"))
        populateList.add(WordModel("actor"))
        populateList.add(WordModel("control"))
        populateList.add(WordModel("people"))
        populateList.add(WordModel("pales"))
        populateList.add(WordModel("pale"))
        populateList.add(WordModel("phone"))
        return populateList
    }

    fun addWord(word : WordModel){
        list.add(word)
    }

    fun clear() {
        list = arrayListOf()
    }
}