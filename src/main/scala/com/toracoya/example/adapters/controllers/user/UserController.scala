package com.toracoya.example.adapters.controllers.user

import com.toracoya.example.adapters.presenters.user.UserPresenter
import com.toracoya.example.domain.user.{Password, UserName}
import com.toracoya.example.usecases.user.{CreateUser, UserUseCase}

class UserController(useCase: UserUseCase, presenter: UserPresenter) {

  def create(name: String, password: String): Unit = {
    val errorOrUser = useCase.create(CreateUser(UserName(name), Password(password)))
    presenter.apply(errorOrUser)
  }
}
