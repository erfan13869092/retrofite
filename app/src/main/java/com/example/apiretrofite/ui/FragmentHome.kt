package com.example.apiretrofite.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.apiretrofite.data.model.ParentCoinItem
import com.example.apiretrofite.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        getCoins()
    }

    private fun getCoins() {
        viewModel.coins.observe(viewLifecycleOwner) {
            it?.let {
                it.enqueue(object : Callback<List<ParentCoinItem>> {
                    override fun onResponse(
                        call: Call<List<ParentCoinItem>>,
                        response: Response<List<ParentCoinItem>>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("coinsApi", "success api->${response.body()}")
                            adapterHome.coins = ArrayList(response.body()!!)
                        }else{
                            Log.d("coinsApi", "error api->${response.errorBody()}")
                        }
                    }

                    override fun onFailure(call: Call<List<ParentCoinItem>>, t: Throwable) {
                        Log.d("coinsApi", "error message->${t.message}")
                    }
                })
            }
        }
    }

    private fun onClick() {
        binding.flbtnFragmentHomeAddTask.setOnClickListener {
            Toast.makeText(requireContext(),"clicked",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setRecyclerView() {
        binding.rv.apply {
            adapter = adapterHome
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}