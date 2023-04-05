package android.chat.example.ui.home

import android.chat.example.ChatListViewModel
import android.chat.example.R
import android.chat.example.databinding.FragmentHomeBinding
import android.chat.example.ui.base.BaseFragment
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels

/**
 * A fragment representing a list of Items.
 */
class HomeFragment : BaseFragment<FragmentHomeBinding>(
    layoutResId = R.layout.fragment_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}