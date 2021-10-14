package com.example.bettingstrategies.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.bettingstrategies.databinding.FragmentInfoStrategyBinding

class InfoStrategyFragment : Fragment() {

    private var _binding: FragmentInfoStrategyBinding? = null
    private val binding get() =  _binding!!
    val args: InfoStrategyFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        _binding = FragmentInfoStrategyBinding.inflate(layoutInflater)
        val strategy = args.strategy
        binding.fragmentInfoStrategeImg.setImageResource(strategy.img_res)
        binding.fragmentInfoStrategeTvTitle.setText(strategy.title_res)
        binding.fragmentInfoStrategeChBoxIsFavorite.isChecked = strategy.isFavorite
        binding.fragmentInfoStrategeTvInfo.setText(strategy.info_res)
        binding.fragmentInfoStrategeChBoxIsFavorite.setOnCheckedChangeListener { view, ch ->
            binding.fragmentInfoStrategeChBoxIsFavorite.isChecked = ch
            strategy.isFavorite = ch
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}