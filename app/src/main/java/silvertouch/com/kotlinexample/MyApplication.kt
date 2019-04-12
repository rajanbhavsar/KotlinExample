package silvertouch.com.kotlinexample

import android.app.Application
import android.arch.persistence.room.Room
import silvertouch.com.kotlinexample.apiinterface.MovieApiInterface
import silvertouch.com.kotlinexample.apiinterface.MovieRepository
import silvertouch.com.kotlinexample.database.MyDatabase

/**
 * Created by Your name on 4/12/2019.
 */

class MyApplication : Application() {

    companion object {
        var myDatabase: MyDatabase? = null;
        var repository: MovieRepository? = null
    }

    override fun onCreate() {
        super.onCreate()
        MyApplication.myDatabase = Room.databaseBuilder(applicationContext, MyDatabase::class.java, "kotlindemo.db")
            .allowMainThreadQueries().build()
        repository = MovieRepository(MovieApiInterface.Factory.createMoviesRetrofit())
    }
}