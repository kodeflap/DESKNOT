package com.kodeflap.desknot.presentation.view.fragment.add

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kodeflap.desknot.R
import com.kodeflap.desknot.data.TaskInfo
import com.kodeflap.desknot.databinding.FragmentAddBinding
import com.kodeflap.desknot.presentation.viewmodel.SharedViewModel
import com.kodeflap.desknot.presentation.viewmodel.TaskViewModel

class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private val mToDoViewModel: TaskViewModel by viewModels()
    private val mSharedViewModel: SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)
        binding.prioritiesSpinner.onItemSelectedListener = mSharedViewModel.listener
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_add)
            insertDataToDB()
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDB() {
        val mTitle = binding.titleEt.text.toString()
        val mPriority = binding.prioritiesSpinner.selectedItem.toString()
        val mDescription = binding.descriptionEt.text.toString()
        val validation = mSharedViewModel.verifyDataFromUser(mTitle, mDescription)
        if(validation) {
            val newData = TaskInfo(
                0,
                mTitle,
                mSharedViewModel.parsePriorityString(mPriority),
                mDescription
            )
            mToDoViewModel.insertData(newData)
            Toast.makeText(
                requireContext(),
                "Task successfully Added!",
                Toast.LENGTH_SHORT
            ).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        } else {
            Toast.makeText(
                requireContext(),
                "Please fill out all the fields.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}