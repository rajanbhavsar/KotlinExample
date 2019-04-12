package silvertouch.com.kotlinexample.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import silvertouch.com.kotlinexample.response.ResultData

/**
 * Created by Your name on 4/12/2019.
 */

@Dao
interface VideoDao {

    @Query("SELECT * from videoList")
    fun getAll(): MutableList<ResultData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(resultData: ResultData)

    @Query("DELETE from videoList")
    fun deleteAll()

    @Insert
    fun insertAll(resultData: MutableList<ResultData>)
}