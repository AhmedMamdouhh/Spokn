package com.spokn.data.repository.profile

import com.spokn.domain.model.user.UserGateway
import com.spokn.domain.model.album.AlbumsGateway

interface ProfileRepositoryGateway : UserGateway, AlbumsGateway