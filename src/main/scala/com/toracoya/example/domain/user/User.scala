package com.toracoya.example.domain.user

case class User(id: UserId, name: UserName, password: HashedPassword)
