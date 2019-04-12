package silvertouch.com.kotlinexample.apiinterface

import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.GET
import retrofit2.http.Query
import silvertouch.com.kotlinexample.response.MovieResponse

/**
 * Created by Your name on 4/12/2019.
 */

interface MovieApiInterface{

    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Observable<MovieResponse>


    companion object Factory {

        fun createMoviesRetrofit(): MovieApiInterface {
            val logging: HttpLoggingInterceptor = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val httpClient: OkHttpClient.Builder = OkHttpClient.Builder()
            httpClient.addInterceptor(logging)
            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                .baseUrl("http://api.themoviedb.org/3/")
                .client(httpClient.build())
                .build()

            return retrofit.create(MovieApiInterface::class.java);
        }
    }
}