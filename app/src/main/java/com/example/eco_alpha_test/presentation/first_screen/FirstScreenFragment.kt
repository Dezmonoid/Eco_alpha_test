package com.example.eco_alpha_test.presentation.first_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.eco_alpha_test.R
import com.example.eco_alpha_test.databinding.FirstScreenBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreenFragment : Fragment() {
    private var _binding: FirstScreenBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<FirstScreenViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()
        binding.btnGetInfo.setOnClickListener {
            viewModel.getDetail(binding.etBinNumber.text.toString())
        }
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.to_second_screen)
        }
    }

    private fun observeLiveData() {
        viewModel.liveData.observe(viewLifecycleOwner) { detail ->
            binding.tvCountryName.text =
                binding.root.context.getString(R.string.country_name, detail.townName)
            binding.tvCordName.text =
                binding.root.context.getString(
                    R.string.cord_name,
                    detail.longitude.toString(),
                    detail.latitude.toString()
                )
            binding.tvTypeCardName.text =
                binding.root.context.getString(R.string.type_card_name, detail.brand)
            binding.tvUrlName.text =
                binding.root.context.getString(R.string.url_name, detail.url)
            binding.tvPhoneNumber.text =
                binding.root.context.getString(R.string.phone_number, detail.phone)
            binding.tvSiteName.text =
                binding.root.context.getString(R.string.site_name, detail.name)
            binding.tvTownName.text =
                binding.root.context.getString(R.string.town_name, detail.city)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}