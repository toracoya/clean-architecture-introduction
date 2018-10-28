package com.toracoya.example.adapters.presenters.user

import com.toracoya.example.usecases.user.{CreateUserError, CreatedUser}

class UserPresenter {

  def apply(errorOrUser: Either[CreateUserError, CreatedUser]): Unit = {
    errorOrUser match {
      case Right(user) =>
        println(s"Create user id = ${user.id.value}, name = ${user.name.value}")
      case Left(error) =>
        println(s"Fail to create user name = ${error.name.value}, reason = ${error.reason}")
    }
  }

}
