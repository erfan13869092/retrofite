package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.ToDo
import com.example.myapplication.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(val toDoRepository: ToDoRepository) : ViewModel() {

    private val _taskMutableLivaData: MutableLiveData<List<ToDo>> by lazy {
        MutableLiveData<List<ToDo>>()
    }
    val taskLivaData: LiveData<List<ToDo>> by lazy {
        _taskMutableLivaData
    }

    init {
        getTasks()
    }

    fun addTodo(todo: ToDo) {
        viewModelScope.launch {
            toDoRepository.insert(todo)
        }
    }

    fun deleteTask(todo: ToDo) {
        viewModelScope.launch {
            toDoRepository.delete(todo)
        }
    }

    fun updateTask(todo: ToDo) {
        viewModelScope.launch {
            toDoRepository.update(todo)
        }
    }

    fun getTasks() {
        viewModelScope.launch {
            toDoRepository.getTodo().catch {

            }.collect {
                _taskMutableLivaData.value = it
            }
        }
    }
}