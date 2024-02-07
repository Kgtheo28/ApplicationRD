package com.example.applicationrd.ui.dashboard

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.applicationrd.R
import com.example.applicationrd.databinding.FragmentDashboardBinding
import com.example.applicationrd.roomDatabase.data.Exercise
import com.example.applicationrd.roomDatabase.weekdayData.Weekday
import com.example.applicationrd.roomDatabase.repository.ExerciseViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var mExerciseViewModel : ExerciseViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mExerciseViewModel =   ViewModelProvider(this).get(ExerciseViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button.setOnClickListener {
            insertData()
        }

        return root
    }

    private fun insertData() {
        val exerciseName = binding.editTextText.text.toString()
        val bodyPart = binding.editTextText2.text.toString()
        val weekday = binding.editTextText2.text.toString()

        if(inputCheck(exerciseName, bodyPart)){
            val exercise = Exercise(exerciseName, bodyPart, 0)
            val weekday = Weekday(weekday, 8)
            mExerciseViewModel.addExercise(exercise)
            //mExerciseViewModel.addWeekday(weekday)
            Toast.makeText(requireContext(),"Successfully Added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_navigation_dashboard_to_navigation_home)
        }else{
            Toast.makeText(requireContext(),"Please fill out all the fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(exerciseName: String, bodyPart: String): Boolean{
        return !(TextUtils.isEmpty(exerciseName) && TextUtils.isEmpty(bodyPart))
    }


}