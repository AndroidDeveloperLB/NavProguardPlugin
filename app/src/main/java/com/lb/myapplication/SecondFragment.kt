package com.lb.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.lb.myapplication.databinding.FragmentSecondBinding

class SecondFragment : Fragment(R.layout.fragment_second) {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSecondBinding.bind(view)

        val myData = arguments?.getParcelable<MyData>("myData")
        binding.textviewData.text = myData?.toString() ?: "No data"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
