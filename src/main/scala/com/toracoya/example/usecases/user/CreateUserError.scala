package com.toracoya.example.usecases.user

import com.toracoya.example.domain.user.UserName

sealed abstract class CreateUserError(val name: UserName, val reason: String)

object CreateUserError {

  case class AlreadyExist(override val name: UserName) extends CreateUserError(name, "Already exist")

  case class IllegalName(override val name: UserName, override val reason: String) extends CreateUserError(name, reason)

  case class IllegalPassword(override val name: UserName, override val reason: String) extends CreateUserError(name, reason)

  case class SystemError(override val name: UserName, override val reason: String) extends CreateUserError(name, reason)

}
