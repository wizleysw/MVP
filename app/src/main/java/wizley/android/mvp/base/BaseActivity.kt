package wizley.android.mvp.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import wizley.android.mvp.R

// View와 Presenter를 연결하기 위한 1:1 의존성 주입에 사용됨
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initPresenter()
    }

    abstract fun initPresenter()
}