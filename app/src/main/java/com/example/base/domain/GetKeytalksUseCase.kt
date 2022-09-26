package com.example.base.domain

import com.example.base.data.KeytalkDataSource
import com.example.base.di.IoDispatcher
import com.example.base.model.Keytalk
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetKeytalksUseCase @Inject constructor(
    private val keytalkDataSource: KeytalkDataSource,
    @IoDispatcher ioDispatcher: CoroutineDispatcher,
) : UseCase<String, List<Keytalk>>(ioDispatcher) {

    override suspend fun execute(vertical: String): List<Keytalk> {
        return keytalkDataSource.getKeytalks(vertical)
    }
}