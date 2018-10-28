package com.toracoya.example.usecases.user

import com.toracoya.example.domain.user.{UserId, UserName}

case class CreatedUser(id: UserId, name: UserName)
