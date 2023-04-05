package android.chat.example.ui.chatting

import android.chat.example.ChatListViewModel
import android.chat.example.R
import android.chat.example.databinding.FragmentChatListBinding
import android.chat.example.databinding.FragmentHomeBinding
import android.chat.example.ui.base.BaseFragment
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * A fragment representing a list of Items.
 */
@AndroidEntryPoint
class ChatListFragment : BaseFragment<FragmentChatListBinding>(
    layoutResId = R.layout.fragment_chat_list
) {
    private val viewModel by viewModels<ChatListViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.reqChatList(
            myUid = "kQ81x3QrrHQOToARYRcXmMFxVYy1",
            otherUid = "sIBodRy6FjMnEdTF3pz8Xs9Q7Th2"
        )
        lifecycleScope.launch {
            viewModel.chatListStateFlow.collect {
                binding.tv.text = it.first
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ChatListFragment()
    }
}