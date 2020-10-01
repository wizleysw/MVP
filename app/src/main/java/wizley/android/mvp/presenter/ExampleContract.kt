package wizley.android.mvp.presenter

import wizley.android.mvp.base.BasePresenter
import wizley.android.mvp.base.BaseView
import wizley.android.mvp.model.Student

interface ExampleContract {

    interface View: BaseView {
        fun showStudentAge(student: Student)
        fun showStudentName(student: Student)
    }

    interface Presenter: BasePresenter<View> {
        fun getStudent()
    }

}