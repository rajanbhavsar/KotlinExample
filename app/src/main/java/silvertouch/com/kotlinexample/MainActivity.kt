package silvertouch.com.kotlinexample

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import silvertouch.com.kotlinexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        label.text = "Rajan bhavsar";
    }


    override fun onResume() {
        super.onResume()
        Handler().postDelayed({ mainBinding.label.setText("Rajansinh Bhavsar") }, 5000)
    }
}
