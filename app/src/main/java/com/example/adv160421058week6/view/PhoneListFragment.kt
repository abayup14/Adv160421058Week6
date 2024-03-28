package com.example.adv160421058week6.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adv160421058week6.R
import com.example.adv160421058week6.databinding.FragmentPhoneListBinding
import com.example.adv160421058week6.viewmodel.ListPhoneViewModel

class PhoneListFragment : Fragment() {
    private lateinit var binding:FragmentPhoneListBinding
    private val phoneListAdapter = PhoneListAdapter(arrayListOf())
    private lateinit var viewModel:ListPhoneViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_phone_list, container, false)
        binding = FragmentPhoneListBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListPhoneViewModel::class.java)
        viewModel.refresh()

        binding.recView.layoutManager = LinearLayoutManager(context)
        binding.recView.adapter = phoneListAdapter

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.phoneLD.observe(viewLifecycleOwner, Observer {
            phoneListAdapter.updatePhoneList(it)
        })
    }
}