package silvertouch.com.kotlinexample.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import silvertouch.com.kotlinexample.response.ResultData

/**
 * Created by Your name on 4/12/2019.
 */

@Database(entities = arrayOf(ResultData::class), version = 1 ,exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    abstract fun VideoListDao(): VideoDao
}