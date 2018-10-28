package com.toracoya.example.usecases.user

import com.toracoya.example.domain.user.{Password, UserName}

case class CreateUser(name: UserName, password: Password)

