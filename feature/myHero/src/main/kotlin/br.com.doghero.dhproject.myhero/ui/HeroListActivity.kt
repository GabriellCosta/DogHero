package br.com.doghero.dhproject.myhero.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.doghero.dhproject.myhero.R

class HeroListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_hero_list)
        prepareLayout()
    }

    private fun prepareLayout() {
    }
}
