package com.bitcoin.merchant.app.model.sideshift

data class SettlementAddress(val tokenType: TokenType, val address: String) {
    val settlementAddress: String = "";
    val isEnabled: Boolean = false;

}

enum class TokenType {
    SLP
}


