package com.spokn.di

import com.spokn.data.remote.Api
import com.spokn.data.repository.photos.PhotosRepository
import com.spokn.data.repository.photos.PhotosRepositoryGateway
import com.spokn.data.repository.profile.ProfileRepository
import com.spokn.data.repository.profile.ProfileRepositoryGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DataModule {

    //Repositories
    @Provides
    fun provideProfileRepository(api: Api): ProfileRepositoryGateway = ProfileRepository(api)

    @Provides
    fun providePhotoRepository(api: Api): PhotosRepositoryGateway = PhotosRepository(api)


}