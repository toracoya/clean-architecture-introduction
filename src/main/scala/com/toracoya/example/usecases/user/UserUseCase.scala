package com.toracoya.example.usecases.user

import com.toracoya.example.usecases.repositories.UserRepository
import com.toracoya.example.usecases.user.CreateUserError.{AlreadyExist, SystemError}

class UserUseCase(repository: UserRepository) {

  def create(createUser: CreateUser): Either[CreateUserError, CreatedUser] = {
    // TODO: Validates name and password

    val name = createUser.name
    repository.findBy(name) match {
      case Right(None) =>
        val hashedPassword = createUser.password.hash
        repository.save(createUser.name, hashedPassword) match {
          case Right(user) =>
            Right(CreatedUser(user.id, user.name))
          case Left(error) =>
            Left(SystemError(name, error.message))
        }
      case Right(Some(_)) =>
        Left(AlreadyExist(name))
      case Left(error) =>
        Left(SystemError(name, error.message))
    }

  }
}
