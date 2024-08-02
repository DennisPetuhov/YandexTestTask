package com.example.yandextesttask.ui


import android.os.Bundle
import android.view.GestureDetector
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yandextesttask.R
import com.example.yandextesttask.databinding.MainScreenDialogFragmentLayoutBinding

class MainScreenDialogFragment : DialogFragment() {
    private var _binding: MainScreenDialogFragmentLayoutBinding? = null

    private val adapter by lazy {
        MyListAdapter(onCityClick = { setText(it.name) }, this)
    }
    private val binding get() = _binding!!
    private val cities: List<PopularDirection> = listOf(
        PopularDirection("Стамбул", R.mipmap.stambul),
        PopularDirection("Стамбул", R.mipmap.stambul), PopularDirection("Стамбул", R.mipmap.stambul)
    )

    override fun onStart() {
        super.onStart()
        dialog?.let {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            it.window?.setLayout(width, height)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = MainScreenDialogFragmentLayoutBinding.inflate(inflater, container, false)
        initRecycler()
        swipeDown()
        val a = binding.root
        return binding.root
    }

    private fun initRecycler() {
        binding.dialogFragmentRecycler.adapter = adapter
        val recycler = binding.dialogFragmentRecycler
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(MyDecoration(requireContext(), R.drawable.vector_75))
        adapter.updateAll(cities)
//        adapter.submitList(cities)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setText(text: String) {
        binding.departures.setText(text)
    }

    fun MainScreenDialogFragment.swipeDown() {
        val gestureDetector =
            GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean {
                    return true
                }

                override fun onFling(
                    e1: MotionEvent?,
                    e2: MotionEvent,
                    velocityX: Float,
                    velocityY: Float,
                ): Boolean {
                    val diffY = e2.y - e1!!.y
                    if (diffY > 0) {
                        // Swipe down detected, dismiss the dialog
                        dismiss()
                    }
                    return true
                }

            })

        binding.modalWindow.setOnTouchListener { v, event ->
            gestureDetector.onTouchEvent(event)
        }


    }


}










