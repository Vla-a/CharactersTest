package com.example.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.characters.data.Character
import com.example.characters.data.CharacterAdapter
import com.example.characters.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment() {

    private val myViewModel: MainViewModel by viewModel()
    var binding: FragmentMainBinding? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var listCharacter: MutableList<Character> = mutableListOf()
        val currencyAdapter = CharacterAdapter(listCharacter) { clickListener(it) }

        binding!!.rvCurrency.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding!!.rvCurrency?.adapter = currencyAdapter

        myViewModel.currencyLiveData.observe(this.viewLifecycleOwner, Observer {
            currencyAdapter.update(it)
        })

        binding!!.btnInfo.setOnClickListener {
            var page: Long = 1
            if (binding!!.editTextPage.text.toString().toLong() < 364) {
                page = binding!!.editTextPage.text.toString().toLong()

            }
            with(binding!!.editTextName) {
                myViewModel.addCount(text.toString(), page)
            }
        }
    }

    private fun clickListener(character: Character) {
        this.findNavController().navigate(MainFragmentDirections.toMain2Fragment())

        setFragmentResult(TEST, Bundle().apply {
            putString(KEY1, character.name)
            putString(KEY2, character.id.toString())
            putString(KEY3, character.image)
            putString(KEY4, character.status)
            putString(KEY5, character.species)
            putString(KEY6, character.type)
            putString(KEY7, character.gender)
            putString(KEY8, character.created)

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object {
        const val TEST = "TEST"
        const val KEY1 = "KEY1"
        const val KEY2 = "KEY2"
        const val KEY3 = "KEY3"
        const val KEY4 = "KEY4"
        const val KEY5 = "KEY5"
        const val KEY6 = "KEY6"
        const val KEY7 = "KEY7"
        const val KEY8 = "KEY8"
    }
}