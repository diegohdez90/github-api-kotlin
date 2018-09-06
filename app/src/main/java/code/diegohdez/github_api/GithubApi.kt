package code.diegohdez.github_api

import android.app.Application
import com.github.kittinunf.fuel.core.FuelManager

class GithubApi : Application() {
    override fun onCreate() {
        super.onCreate()
        FuelManager.instance.basePath = "https://api.github.com"
    }
}