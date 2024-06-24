package com.example.yandextesttask.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.yandextesttask.dataStore.DataStoreRepository
import com.example.yandextesttask.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject


class MainScreen : Fragment() {

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val dataStoreRepository: DataStoreRepository by inject()

    companion object {
        fun newInstance() = MainScreen()
    }

    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private val viewModel: MainScreenViewModel by viewModels()
    private val Context.dataStore by preferencesDataStore(name = "app_preferences")

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        departuresText()
        return binding.root

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun departuresText() {
        val departures = scope.launch {
            val result: String = dataStoreRepository.fetchText()
            if (result != "Default Value") {
                binding.departures.setText(result)
            } else {
                binding.departures.setText("Minsk")
            }
        }

        binding.departures.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                // Do nothing
            }

            override fun afterTextChanged(s: Editable?) {

                scope.launch {  dataStoreRepository.saveText(s.toString())}
            }
        })


    }

}