package com.example.base.data

import com.example.base.model.Keytalk
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DefaultKeytalkDataSource @Inject constructor(
    private val keytalkService: KeytalkService,
) : KeytalkDataSource {

    override suspend fun getKeytalks(vertical: String): List<Keytalk> {
        val response = keytalkService.keytalkList(vertical)
        return response.data.map { it.toKeytalk() }
    }
}