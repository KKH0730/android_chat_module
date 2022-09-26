package com.example.base.di

import com.example.base.data.DefaultKeytalkDataSource
import com.example.base.data.KeytalkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataSourceModule {
    @Binds
    abstract fun bindKeytalkDataSource(defaultKeytalkDataSource: DefaultKeytalkDataSource): KeytalkDataSource
}