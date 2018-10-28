package com.toracoya.example.usecases.repositories

import com.toracoya.example.domain.user.{HashedPassword, User, UserName}

trait UserRepository {

  def findBy(name: UserName): Either[Error, Option[User]]

  def save(name: UserName, hashedPassword: HashedPassword): Either[Error, User]
}
