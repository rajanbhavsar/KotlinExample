package silvertouch.com.kotlinexample.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import silvertouch.com.kotlinexample.BR
import silvertouch.com.kotlinexample.R
import silvertouch.com.kotlinexample.response.ResultData

/**
 * Created by Your name on 4/12/2019.
 */

public class MovieAdapter(var dataitems: MutableList<ResultData>) : RecyclerView.Adapter<MovieAdapter.CustomUserViewModel>() {


    override fun onCreateViewHolder(parent: ViewGroup, position: Int): MovieAdapter.CustomUserViewModel {
        val inflater = parent?.getContext()?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val databind: ViewDataBinding = DataBindingUtil.inflate(inflater, R.layout.movie_layout_item, parent, false)
        return CustomUserViewModel(databind)
    }

    override fun getItemCount(): Int {
        return dataitems.size
    }

    class CustomUserViewModel(val dataBinding: ViewDataBinding) : RecyclerView.ViewHolder(dataBinding.root) {
        fun bind(data: Any) {
            dataBinding.setVariable(BR.data, data)
            dataBinding.executePendingBindings()
        }
    }

    override fun onBindViewHolder(viewHolder: CustomUserViewModel, position: Int) {
        (viewHolder)?.bind(dataitems[position])
    }

}