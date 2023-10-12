package com.techtroopers.connectingpeers.ui.coursedetail.adapter

simport android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.techtroopers.connectingpeers.comm.Section
import com.techtroopers.connectingpeers.databinding.FragmentCourseDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseDetailFragment : Fragment() {

    private lateinit var section: Section
    private lateinit var binding: FragmentCourseDetailBinding

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
        return binding.root
    }

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
}