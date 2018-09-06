package code.diegohdez.github_api.Activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import code.diegohdez.github_api.Constants.API
import code.diegohdez.github_api.R
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.android.extension.responseJson
import com.github.kittinunf.fuel.core.FuelManager
import kotlin.jvm.java

class MainActivity : AppCompatActivity() {

    companion object {
        val TAG: String = MainActivity::class.java.simpleName
    }

    var accountEditText :  EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        accountEditText = findViewById(R.id.account)

    }

    fun getAccount (v : View) {
        Toast.makeText(applicationContext, "this is my api" + FuelManager.instance.basePath, Toast.LENGTH_LONG).show()
        Fuel.Companion.get(API.ACCOUNT + accountEditText?.text.toString())
                .responseJson{ request, response, result ->
                    result.fold({
                        d ->
                        Log.i(TAG, d.content)
                    }, {err ->
                        Log.i(TAG, err.message)
                        Log.i(TAG, err.response.responseMessage)
                    })
                }
    }
}
