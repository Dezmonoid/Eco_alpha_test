package com.example.eco_alpha_test.presentation.second_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eco_alpha_test.R
import com.example.eco_alpha_test.databinding.SecondScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondScreenFragment : Fragment() {
    private var _binding: SecondScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<SecondScreenViewModel>()
    private val adapter = SecondScreenAdapter()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeLiveData()
        binding.btnFirstScreen.setOnClickListener {
            findNavController().navigate(R.id.to_first_screen)
        }
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) { binListDetail ->
            adapter.submitList(binListDetail)
        }
    }

    private fun initRecyclerView() {
        binding.secondRecycler.layoutManager = LinearLayoutManager(binding.root.context)
        binding.secondRecycler.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}