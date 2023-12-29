package com.example.myapplication.ui

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.databinding.AddTaskDialogFragmentBinding
import com.example.myapplication.databinding.FragmentHomeBinding

class AddTaskDialogFragment(
    val nameTask: (String) -> Unit,
    val update: (ToDo) -> Unit
) : DialogFragment() {
    private var _binding: AddTaskDialogFragmentBinding? = null
    private val binding get() = _binding!!

    private var toDo: ToDo? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        arguments?.let {
            toDo = it.getParcelable<ToDo>("todo")
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialogView = AlertDialog.Builder(requireContext()).create()
        _binding = AddTaskDialogFragmentBinding.inflate(layoutInflater, null, false)
        dialogView.setView(binding.root)
        toDo?.let{
            binding.editTextText.setText(it.name)
        }
        onClick()
        return dialogView
    }

    private fun getTaskName(): String {
        return binding.editTextText.text.toString()
    }

    private fun onClick() {
        binding.btnAddTaskDialogOk.setOnClickListener {
            toDo?.let {
                it.apply {
                    name=getTaskName()
                }
                update(it)
            } ?: run {
                nameTask(getTaskName())
            }
            dismiss()
        }
        binding.btnAddTaskDialogCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        arguments = null
        toDo = null
    }
}