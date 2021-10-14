package com.example.bettingstrategies.ui.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bettingstrategies.databinding.FragmentFavoritesBinding
import com.example.bettingstrategies.model.Strategy
import com.example.bettingstrategies.ui.StrategiesAdapter

class FavoritesFragment : Fragment() {

    private lateinit var viewModel: FavoritesViewModel
    private var _binding: FragmentFavoritesBinding? = null
    private val binding get () = _binding!!

    private lateinit var adapter: StrategiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFavoritesBinding.inflate(layoutInflater)
        initAdapter()
        initViewModel()
        binding.fragmentFavoritesListView.adapter = adapter
        return binding.root
    }

    private fun initAdapter() {
        adapter = StrategiesAdapter(layoutInflater, object: StrategiesAdapter.CallBack {
            override fun upDate(strategy: Strategy) {
                viewModel.upDate(strategy)
            }

            override fun onClickStrategy(strategy: Strategy) {
                findNavController()
                    .navigate(
                        FavoritesFragmentDirections.actionNavigationFavoritesToInfoStrategyFragment(strategy)
                    )
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)
        viewModel.strategyList.observe(viewLifecycleOwner, {
            adapter.upDate(it)
        })
    }

    override fun onStop() {
        adapter.detach()
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}