package com.spokn.di

import com.spokn.data.repository.photos.PhotosRepositoryGateway
import com.spokn.data.repository.profile.ProfileRepositoryGateway
import com.spokn.domain.use_case.photo.PhotosUseCase
import com.spokn.domain.use_case.photo.PhotosUseCaseGateway
import com.spokn.domain.use_case.profile.ProfileUseCase
import com.spokn.domain.use_case.profile.ProfileUseCaseGateway
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    //Use Case
    @Provides
    fun providesProfileUseCase(profileRepository: ProfileRepositoryGateway): ProfileUseCaseGateway =
        ProfileUseCase(profileRepository)

    @Provides
    fun providesPhotosUseCase(photosRepository: PhotosRepositoryGateway): PhotosUseCaseGateway =
        PhotosUseCase(photosRepository)

}