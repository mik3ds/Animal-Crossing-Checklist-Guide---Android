package com.mikec.achnchecklistguide

import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.database.sqlite.SQLiteException
import android.os.Bundle
import android.view.*
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController

class MainActivity : AppCompatActivity() {

    private var PRIVATE_MODE = 0
    private val PREF_FIRST = "mikec.acnh.firstrun"
    private val PREF_HEM = "mikec.acnh.hemisphere"

    lateinit var dbHandler: DBHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_fossils, R.id.navigation_bugs, R.id.navigation_fish))
//        setupActionBarWithNavController(navController, appBarConfiguration)
        setSupportActionBar(findViewById(R.id.my_toolbar))
        navView.setupWithNavController(navController)

        BottomNavigationView.OnNavigationItemSelectedListener {item->
            when(item.itemId) {
                R.id.navigation_fossils -> {
                    println("home pressed")
                    replaceFragment(FossilFragment())
                    return@OnNavigationItemSelectedListener true }
                R.id.navigation_bugs -> {
                    println("map pressed")
                    replaceFragment(BugFragment())
                    return@OnNavigationItemSelectedListener true }
                R.id.navigation_fish -> {
                    println("cart pressed")
                    replaceFragment(FishFragment())
                    return@OnNavigationItemSelectedListener true }
                else -> {
                    return@OnNavigationItemSelectedListener true }
            }}

        val sharedPref: SharedPreferences = getSharedPreferences(PREF_FIRST, PRIVATE_MODE)
        if (sharedPref.getBoolean(PREF_FIRST, false)) {
        } else {
            dbHandler = DBHandler(this)
            try {
                dbHandler.createTables()
            } catch (e:SQLiteException){
                println("First time run detected but DB exists. Using existing one.")
            }
            val builder = AlertDialog.Builder(this@MainActivity)
            builder.setTitle("First Time Run")
            builder.setMessage("Are you in the North or South Hemisphere? You can change this later")
            val editor = sharedPref.edit()
            var hemChoice:Boolean = true

            builder.setPositiveButton("North"){dialog, which ->
                hemChoice = true
                dbHandler.setHemisphere(1)
                Toast.makeText(applicationContext,"North Hemisphere set. Enjoy!", Toast.LENGTH_SHORT).show()
            }
            builder.setPositiveButton("South"){dialog, which ->
                hemChoice = false
                Toast.makeText(applicationContext,"South Hemisphere set. Enjoy!", Toast.LENGTH_SHORT).show()
            }

            editor.putBoolean(PREF_FIRST, true)
            editor.putBoolean(PREF_HEM, hemChoice)
            editor.apply()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu_options, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Toast.makeText(applicationContext,"Implement popup with settings options", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment)
        fragmentTransaction.commit()
    }
}
