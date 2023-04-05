package android.chat.example.ui.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


abstract class BaseActivity<T: ViewDataBinding>(
    @LayoutRes private val layoutResId: Int
): AppCompatActivity() {
    private var _binding: T? = null
    protected val binding: T
        get() = checkNotNull(_binding) {
            "Activity $this binding cannot be accessed before onCreate()"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, layoutResId)
    }

    override fun onDestroy() {
        _binding?.unbind()
        _binding = null
        super.onDestroy()
    }
}