package wizley.android.mvp.base

// Presenter와 View는 1:1 관계
interface BasePresenter<T> {
    fun bindView(view: T);
    fun unbindView();
}