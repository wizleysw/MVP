package wizley.android.mvp.view

import android.os.Bundle
import android.util.Log
import wizley.android.mvp.base.BaseActivity
import wizley.android.mvp.model.Student
import wizley.android.mvp.presenter.ExampleContract
import wizley.android.mvp.presenter.ExamplePresenter

class ExampleActivity: BaseActivity(), ExampleContract.View {
    private val TAG = "MVP"
    private lateinit var mPresenter: ExamplePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.bindView(this)

        mPresenter.getStudent()

    }

    override fun onDestroy() {
        super.onDestroy()

        mPresenter.unbindView()
    }

    override fun initPresenter() {
        mPresenter = ExamplePresenter()
    }

    override fun showStudentAge(student: Student) {
        Log.e(TAG, "age : ${student.age}")
    }

    override fun showStudentName(student: Student) {
        Log.e(TAG, "name : ${student.name}")
    }

    override fun logString(log: String) {
    }

}