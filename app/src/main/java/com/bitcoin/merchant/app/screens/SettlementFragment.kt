package com.bitcoin.merchant.app.screens

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Switch
import com.bitcoin.merchant.app.R
import com.bitcoin.merchant.app.screens.features.ToolbarAwareFragment
import com.bitcoin.merchant.app.util.Settings
import com.google.android.material.textfield.TextInputEditText


class SettlementFragment : ToolbarAwareFragment() {

    companion object {
        fun newInstance() = SettlementFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_settlement, container, false)
        val addressInput : TextInputEditText = rootView.findViewById(R.id.settlement_address_input)
        addressInput.isEnabled = false

        val settlementSpinnerItems : Array<String> = arrayOf("USDH", "USDT", "USDC")
        val settlementSpinnerItemsAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, settlementSpinnerItems)
        val settlementSpinner: Spinner = rootView.findViewById(R.id.settlement_spinner)
        settlementSpinner.adapter = settlementSpinnerItemsAdapter
        settlementSpinner.isEnabled = false

        val settlementSwitch : Switch = rootView.findViewById(R.id.settlement_switch)
        settlementSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
                addressInput.isEnabled = isChecked
                settlementSpinner.isEnabled = isChecked
        }

        addressInput.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                Settings.setSettlementAddress(requireContext(), (p0.toString()))
                Settings.setSettlementCoin(requireContext(), "USDH")
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
        return rootView;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
