package com.example.bettingstrategies.ui.strategies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bettingstrategies.databinding.FragmentStrategiesBinding
import com.example.bettingstrategies.model.Strategy
import com.example.bettingstrategies.ui.StrategiesAdapter

class StrategiesFragment : Fragment() {

    private lateinit var viewModel: StrategiesViewModel
    private var _binding: FragmentStrategiesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: StrategiesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initAdapter()
        initViewModel()
        _binding = FragmentStrategiesBinding.inflate(inflater, container, false)
        binding.fragmentStrategiesListView.adapter = adapter
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
                        StrategiesFragmentDirections.actionNavigationStrategiesToInfoStrategyFragment(strategy)
                    )
            }
        })
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(StrategiesViewModel::class.java)
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