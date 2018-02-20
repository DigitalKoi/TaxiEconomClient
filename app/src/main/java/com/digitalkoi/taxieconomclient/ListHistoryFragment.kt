package com.digitalkoi.taxieconomclient

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * @author Taras Zhupnyk (akka DigitalKoi) on 15/02/18.
 */
class ListHistoryFragment : Fragment() {

    companion object {
        fun newInstance() : ListHistoryFragment {
            return ListHistoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_list_history, container, false)
    }
}