package android.chat.example.ui

import android.chat.example.ChatListViewModel
import android.chat.example.R
import android.chat.example.databinding.ActivityMainBinding
import android.chat.example.ui.base.BaseActivity
import android.chat.example.ui.chatting.ChatListFragment
import android.chat.example.ui.home.HomeFragment
import android.os.Bundle
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(
    layoutResId = R.layout.activity_main
) {
    private val viewModel by viewModels<ChatListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setBottomNavigation()

        val homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, homeFragment, HOME_TAG)
            .commitAllowingStateLoss()
    }

    private fun setBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    showHomeFragment()
                    true
                }
                R.id.chatting -> {
                    showChatListFragment()
                    true
                }
                R.id.shopping -> {
                    true
                }
                else -> true
            }
        }
    }

    private fun showHomeFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(HOME_TAG)
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commitAllowingStateLoss()
        } else {
            val homeFragment = HomeFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, homeFragment, HOME_TAG)
                .commitAllowingStateLoss()
        }
    }

    private fun showChatListFragment() {
        val fragment = supportFragmentManager.findFragmentByTag(CHAT_LIST_TAG)
        if (fragment != null) {
            supportFragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commitAllowingStateLoss()
        } else {
            val chatListFragment = ChatListFragment.newInstance()
            supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, chatListFragment, CHAT_LIST_TAG)
                .commitAllowingStateLoss()
        }
    }

    companion object {
        const val HOME_TAG = "HomeFragmentTag"
        const val CHAT_LIST_TAG = "ChatListFragmentTag"
    }
}