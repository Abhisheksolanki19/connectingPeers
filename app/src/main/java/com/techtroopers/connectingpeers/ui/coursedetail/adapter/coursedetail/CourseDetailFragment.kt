package com.techtroopers.connectingpeers.ui.coursedetail.adapter.coursedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.techtroopers.connectingpeers.comm.Section
import com.techtroopers.connectingpeers.data.model.EnrolledUsers
import com.techtroopers.connectingpeers.databinding.FragmentCourseDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailFragment : Fragment() {

    companion object {

        private const val KEY_SECTION = "KEY_SECTION"

        @JvmStatic
        fun newInstance(section: Section) =
            CourseDetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(KEY_SECTION, section)
                }
            }
    }

    private lateinit var section: Section
    private lateinit var binding: FragmentCourseDetailBinding
    private lateinit var enrolledUsersAdapter: EnrolledUsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            section = it.getParcelable<Section>(KEY_SECTION)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCourseDetailBinding.inflate(layoutInflater)

        val enrolledUsersList: ArrayList<EnrolledUsers> = ArrayList()
        enrolledUsersList.add(EnrolledUsers("1","Abhishek"))
        enrolledUsersList.add(EnrolledUsers("1","Abhishek"))
        enrolledUsersList.add(EnrolledUsers("1","Abhishek"))
        enrolledUsersList.add(EnrolledUsers("1","Abhishek"))
        enrolledUsersList.add(EnrolledUsers("1","Abhishek"))

        if(section.name == "Peers"){
            setupRecyclerView(enrolledUsersList + enrolledUsersList + enrolledUsersList + enrolledUsersList)
        } else {
            binding.tvFragmentName.isVisible = true
        }

        return binding.root
    }

    private fun setupRecyclerView(dataList: List<EnrolledUsers>) {
        binding.rvUsers.run {
            enrolledUsersAdapter = EnrolledUsersAdapter(dataList)
            adapter = enrolledUsersAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        binding.rvUsers.isVisible = true
    }
}