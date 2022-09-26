package com.example.base.data

import com.example.base.model.Keytalk

interface KeytalkDataSource {

    suspend fun getKeytalks(vertical: String): List<Keytalk>
}