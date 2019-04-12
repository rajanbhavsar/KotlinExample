package silvertouch.com.kotlinexample.apiinterface

import io.reactivex.Observable
import silvertouch.com.kotlinexample.response.MovieResponse

/**
 * Created by Your name on 4/12/2019.
 */

class MovieRepository(val apiInterface: MovieApiInterface) {


    fun getAllDisplayMovies(): Observable<MovieResponse> {
        return apiInterface.getMovies("004cbaf19212094e32aa9ef6f6577f22")
    }

}