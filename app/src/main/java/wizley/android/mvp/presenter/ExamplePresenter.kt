package wizley.android.mvp.presenter

import wizley.android.mvp.model.StudentInfo

class ExamplePresenter: ExampleContract.Presenter {
    private var mView: ExampleContract.View?= null

    override fun bindView(view: ExampleContract.View) {
        mView = view
    }

    override fun unbindView() {
        mView = null
    }

    override fun getStudent() {
        val student = StudentInfo.getStudentInfo()
        mView?.showStudentName(student)
        mView?.showStudentAge(student)
    }

}