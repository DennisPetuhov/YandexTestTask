package com.example.yandextesttask.ui

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.datastore.preferences.preferencesDataStore
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.yandextesttask.R
import com.example.yandextesttask.data.dataStore.DataStoreRepository
import com.example.yandextesttask.databinding.FragmentMainScreenBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainScreen : Fragment() {

    private val viewModel: MainScreenViewModel by viewModel()

    private var _binding: FragmentMainScreenBinding? = null
    private val binding get() = _binding!!
    private val dataStoreRepository: DataStoreRepository by inject()

    companion object {
        fun newInstance() = MainScreen()
    }


    private val scope = CoroutineScope(Dispatchers.Main + Job())
    private val Context.dataStore by preferencesDataStore(name = "app_preferences")

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Fragment", "onCreate")
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        departuresText()
        arrivalsText()
        observeChanges()
        binding.buttonShowAllPlaces.setOnClickListener {
            val dialog = MainScreenDialogFragment()
            dialog.show(childFragmentManager, "dialog")
        }
        Log.d("Fragment", "onCreateView")
        viewModel.fetchData()
        return binding.root

    }

    private fun observeChanges() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.offers.collect {
                    Toast.makeText(context, "Show all places ${it}", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun departuresText() {
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
                after: Int,
            ) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int,
            ) {
            }

            override fun afterTextChanged(s: Editable?) {
                scope.launch { dataStoreRepository.saveText(s.toString()) }
            }
        })
    }

    private fun arrivalsText() {

        binding.arrivals.apply {
            setDropDownBackgroundResource(R.drawable.dropdown_shape)
            post {
                val autoCompleteTextViewHeight = height
                println("AutoCompleteTextView height: $autoCompleteTextViewHeight")

                dropDownVerticalOffset = autoCompleteTextViewHeight
            }
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int,
                ) {
//                filterSuggestions(s.toString(), binding.departures)
                }

                override fun onTextChanged(
                    s: CharSequence?,
                    start: Int,
                    before: Int,
                    count: Int,
                ) {
                }

                override fun afterTextChanged(s: Editable?) {
                    filterSuggestions(s.toString(), binding.departures)
                    binding.departures.showDropDown()

                }
            })
        }
    }

    private fun filterSuggestions(text: String, autoCompleteTextView: AutoCompleteTextView) {
        val cities = resources.getStringArray(R.array.cityes).toMutableList()
        val filteredSuggestions = cities.filter { it.startsWith(text, ignoreCase = true) }
        val adapter = ArrayAdapter(
            autoCompleteTextView.context,
            R.layout.dropdown_item,
            filteredSuggestions
        )
        autoCompleteTextView.setAdapter(adapter)
    }

    override fun onAttach(context: Context) {
        Log.d("Fragment", "onAttach")
        super.onAttach(context)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Fragment", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onStart() {
        Log.d("Fragment", "onStart")
        super.onStart()
    }

    override fun onPause() {
        Log.d("Fragment", "onPause")
        super.onPause()
    }

    override fun onResume() {
        Log.d("Fragment", "onResume")
        super.onResume()
    }

    override fun onStop() {
        Log.d("Fragment", "onStop")
        super.onStop()
    }


    override fun onDestroy() {
        Log.d("Fragment", "onDestroy")
        super.onDestroy()
    }


}