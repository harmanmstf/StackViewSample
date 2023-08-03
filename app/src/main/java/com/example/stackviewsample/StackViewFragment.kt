package com.example.stackviewsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.stackviewsample.databinding.FragmentStackViewBinding

class StackViewFragment : Fragment() {
    private var _binding: FragmentStackViewBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentStackViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val stackView = binding.stackView
        val stackAdapter = StackAdapter(stackViewData)
        stackView.adapter = stackAdapter

        stackView.setOnItemClickListener { _, _, position, _ ->
            stackAdapter.setSelectedItem(position)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
