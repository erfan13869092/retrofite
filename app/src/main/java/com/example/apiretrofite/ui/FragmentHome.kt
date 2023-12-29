package com.example.apiretrofite.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiretrofite.databinding.FragmentHomeBinding
import com.example.myapplication.ui.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapterHome = AdapterHome()

    private val viewModel: HomeViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        onClick()
        getHomeTasks()
//        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED){
//                repeat(90000000) {
//                    val todo = ToDo(name = "rahim $it")
//                    viewModel.addTodo(todo)
//                }
//            }
//        }

    }

    private fun getHomeTasks() {

    }

    private fun onClick() {
        binding.flbtnFragmentHomeAddTask.setOnClickListener {
        }
    }

    private fun setRecyclerView() {
        binding.rv.apply {
            adapter = adapterHome
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}