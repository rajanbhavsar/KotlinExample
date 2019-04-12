package silvertouch.com.kotlinexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import rajansinh.sttl.utils.Utils
import silvertouch.com.kotlinexample.adapter.MovieAdapter
import silvertouch.com.kotlinexample.databinding.ActivityMainBinding
import silvertouch.com.kotlinexample.response.MovieResponse


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding
    var mCompositeDisposable: CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        this.mCompositeDisposable = CompositeDisposable()
        search_results_recycler_view.layoutManager = LinearLayoutManager(this)
    }


    override fun onResume() {
        super.onResume()
        if (Utils.CheckConnectivity(this)!!) {
            getMovies()
        } else {

        }
    }

    fun getMovies() {
        mCompositeDisposable?.add(
            MyApplication.repository?.getAllDisplayMovies()?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())?.subscribeWith(object :
                    DisposableObserver<MovieResponse>() {
                    override fun onComplete() {
                        Log.e("Data Error", "Complete")
                    }

                    override fun onNext(t: MovieResponse) {
                        displayMovies(t)
                    }

                    override fun onError(e: Throwable) {
                        Log.e("Data Error", e.message)
                    }
                })!!
        )
    }


    fun displayMovies(movieResponse: MovieResponse) {
        if (movieResponse != null) {
            var dataitems = movieResponse.results;
            MyApplication.myDatabase?.beginTransaction()
            MyApplication.myDatabase?.VideoListDao()?.deleteAll()
            MyApplication.myDatabase?.endTransaction()
            MyApplication.myDatabase?.VideoListDao()?.insertAll(dataitems)
            var movieadapter = MovieAdapter(dataitems)
            search_results_recycler_view.adapter = movieadapter
        }
    }


}
