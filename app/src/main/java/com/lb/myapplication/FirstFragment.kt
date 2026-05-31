package com.lb.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.lb.myapplication.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFirstBinding.bind(view)

        binding.buttonNavigate.setOnClickListener {
            val data = MyData(1, "Hello from First")
            val bundle = Bundle().apply {
                putParcelable("myData", data)
            }
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
