package com.example.noteapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.noteapp.R
import com.example.noteapp.ViewModel.NotesViewModel
import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.ui.adapter.NotesAdapter


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->

            binding.rcvAllNotes.layoutManager = GridLayoutManager(requireActivity(), 2)
            binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
        }



        binding.filterHigh.setOnClickListener {
            viewModel.getHighNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireActivity(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.allNotes.setOnClickListener {
            viewModel.getNotes().observe(viewLifecycleOwner) { notesList ->
                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireActivity(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }

        binding.filterMedium.setOnClickListener {
            viewModel.getMediumNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireActivity(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }
        binding.filterLow.setOnClickListener {
            viewModel.getLowNotes().observe(viewLifecycleOwner) { notesList ->

                binding.rcvAllNotes.layoutManager = GridLayoutManager(requireActivity(), 2)
                binding.rcvAllNotes.adapter = NotesAdapter(requireContext(), notesList)
            }
        }




        binding.btnAddNotes.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_homeFragment_to_createNotesFragment)
        }

        return binding.root
    }


}