package silvertouch.com.kotlinexample.response

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Your name on 4/12/2019.
 */

data class MovieResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("total_results") val total_results: Int,
    @SerializedName("total_pages") val total_pages: Int,
    @SerializedName("results") var results: MutableList<ResultData>
)

@Entity(tableName = "videoList")
data class ResultData(
    @ColumnInfo(name = "vote_count") @SerializedName("vote_count") val vote_count: Int,
    @PrimaryKey(autoGenerate = false) @SerializedName("id") val id: Int,
    @ColumnInfo(name = "vote_average") @SerializedName("vote_average") val vote_average: Float,
    @ColumnInfo(name = "video") @SerializedName("video") val video: Boolean,
    @ColumnInfo(name = "title") @SerializedName("title") val title: String,
    @ColumnInfo(name = "popularity") @SerializedName("popularity") val popularity: Float,
    @ColumnInfo(name = "poster_path") @SerializedName("poster_path") val poster_path: String,
    @ColumnInfo(name = "original_language") @SerializedName("original_language") val original_language: String,
    @ColumnInfo(name = "original_title") @SerializedName("original_title") val original_title: String,
    @ColumnInfo(name = "backdrop_path") @SerializedName("backdrop_path") val backdrop_path: String,
    @ColumnInfo(name = "adult") @SerializedName("adult") val adult: Boolean,
    @ColumnInfo(name = "overview") @SerializedName("overview") val overview: String,
    @ColumnInfo(name = "release_date") @SerializedName("release_date") val release_date: String
) {
    companion object TO {
        val MASTER = 0
        val ROBOT = 1
    }
}