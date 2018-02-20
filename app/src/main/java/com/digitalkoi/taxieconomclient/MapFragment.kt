package com.digitalkoi.taxieconomclient

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import kotlinx.android.synthetic.main.fr_map_calculator.*

/**
 * @author Taras Zhupnyk (akka DigitalKoi) on 15/02/18.
 */

class MapFragment : Fragment(), OnMapReadyCallback {

    private lateinit var googleMap: GoogleMap

    companion object {
        fun newInstance() : MapFragment {
            return MapFragment()
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fr_map_calculator, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        map.onCreate(savedInstanceState)
        map.onResume()
        map.getMapAsync(this)

    }

    override fun onMapReady(map: GoogleMap?) {
        googleMap = map as GoogleMap
    }

}