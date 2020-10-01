# MVP

This is example of MVP pattern in Android using kotlin. You can see  details from below.

https://medium.com/@dlgksah/mvp-kotlin-example-2de93add4c82
https://github.com/hanmolee/MVP_Example

## Dev note

Dev details are written in Korean. 

https://bughunting.kr/dev/%EC%95%88%EB%93%9C%EB%A1%9C%EC%9D%B4%EB%93%9C-%EA%B0%9C%EB%B0%9C%EC%97%90-%EC%82%AC%EC%9A%A9%EB%90%98%EB%8A%94-MVP-MVVM-%ED%8C%A8%ED%84%B4/

## What is MVP Pattern ??

Model : is to store data
View : to render layout with model data
Presenter : communiate with model and view and process changes.

### Model

```kotlin
data class Student(
    val name: String,
    val age: Int
)
```

### View

```kotlin
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
```

### Presenter

```kotlin
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
```

### Contract

```kotlin
interface ExampleContract {

    interface View: BaseView {
        fun showStudentAge(student: Student)
        fun showStudentName(student: Student)
    }

    interface Presenter: BasePresenter<View> {
        fun getStudent()
    }

}
```

## Pros and Cons

pros : Dependency prob in MVC between View and Model is removed. 

cons : should have 1:1 connection between View and Presenter 

