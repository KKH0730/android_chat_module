package com.example.base.data

import com.example.base.model.Keytalk

data class KeytalkListResponse(val total: Int, val data: List<Keytalk>) {

    data class Keytalk(val category: String, val keytalk: String)
}

fun KeytalkListResponse.Keytalk.toKeytalk() = Keytalk(category = category, value = keytalk)