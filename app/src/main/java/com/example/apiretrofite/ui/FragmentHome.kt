package com.example.myapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapterHome = AdapterHome(delete = {
        viewModel.deleteTask(it)
    }, update = { todo ->
        with(addTaskDialog) {
            arguments = Bundle().apply {
                putParcelable("todo", todo)
            }
        }
        addTaskDialog.show(parentFragmentManager, null)
    })
    private val addTaskDialog = AddTaskDialogFragment({
        val todo = ToDo(name = it)
        viewModel.addTodo(todo)
    }, update = {
        viewModel.updateTask(it)
    })
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
        viewModel.taskLivaData.observe(viewLifecycleOwner) {
            it?.let {
                adapterHome.task = ArrayList(it)
            }
        }
    }

    private fun onClick() {
        binding.flbtnFragmentHomeAddTask.setOnClickListener {
            addTaskDialog.show(parentFragmentManager, null)

        }
    }

    private fun setRecyclerView() {
        binding.rv.apply {
            adapter = adapterHome
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}