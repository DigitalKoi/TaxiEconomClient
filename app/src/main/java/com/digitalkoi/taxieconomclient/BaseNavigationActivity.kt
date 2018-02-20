package com.digitalkoi.taxieconomclient

import android.Manifest
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_base_navigation.*

class BaseNavigationActivity : AppCompatActivity() {

    private var bundleIsNull: Boolean = true
    private lateinit var rxPermission: RxPermissions

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_calculator -> {
                rxPermission.request(Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION
                ).subscribe { granted ->
                    if (granted) {
                        supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.base_container, MapFragment.newInstance(), "mapFragment")
                                .commit()
                    } else {
                        Toast.makeText(this, "We need permissions for showing the map", Toast.LENGTH_LONG).show()
                    }
                }

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_list -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.base_container, ListHistoryFragment.newInstance(), "listFragment")
                        .commit()
                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_navigation)

        bundleIsNull = savedInstanceState == null
        rxPermission = RxPermissions(this)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        rxPermission.request(Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
        ).subscribe { granted ->
            if (granted) {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.base_container, MapFragment.newInstance(), "mapFragment")
                        .commit()
            } else {
                Toast.makeText(this, "We need permissions for showing the map", Toast.LENGTH_LONG).show()
            }
        }
    }


}
