package com.example.characters.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.characters.R
import com.example.characters.screen.MainFragment.Companion.KEY1
import com.example.characters.screen.MainFragment.Companion.KEY2
import com.example.characters.screen.MainFragment.Companion.KEY3
import com.example.characters.screen.MainFragment.Companion.KEY4
import com.example.characters.screen.MainFragment.Companion.KEY5
import com.example.characters.screen.MainFragment.Companion.KEY6
import com.example.characters.screen.MainFragment.Companion.KEY7
import com.example.characters.screen.MainFragment.Companion.KEY8
import com.example.characters.screen.MainFragment.Companion.TEST
import com.example.characters.databinding.FragmentMain2Binding

class Main2Fragment : Fragment() {
    private var binding: FragmentMain2Binding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMain2Binding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener(TEST) { key, bundle ->

            binding!!.tvName.text =
                "${resources.getString(R.string.name)}: ${bundle.getString(KEY1)}"
            binding!!.tvId.text = "${resources.getString(R.string.id)}: ${bundle.getString(KEY2)}"
            binding!!.tvStatus.text =
                "${resources.getString(R.string.status)}: ${bundle.getString(KEY4)}"
            binding!!.tvSpecies.text =
                "${resources.getString(R.string.species)}: ${bundle.getString(KEY5)}"
            binding!!.tvType.text =
                "${resources.getString(R.string.type)}: ${bundle.getString(KEY6)}"
            binding!!.tvGender.text =
                "${resources.getString(R.string.gender)}: ${bundle.getString(KEY7)}"
            binding!!.tvCreated.text =
                "${resources.getString(R.string.created)}: ${bundle.getString(KEY8)}"
            Glide
                .with(this)
                .load(bundle.getString(KEY3))
                .into(binding!!.ivDrow)
        }

        binding!!.btnReturn.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }
}