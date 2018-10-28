package com.toracoya.example.gateways.repositories

import java.util.concurrent.atomic.AtomicInteger

import com.toracoya.example.domain.user.{HashedPassword, User, UserId, UserName}
import com.toracoya.example.usecases.repositories
import com.toracoya.example.usecases.repositories.UserRepository

class MemoryUserRepository extends UserRepository {

  private val idCounter = new AtomicInteger(0)

  @volatile private var userByName: Map[UserName, User] = Map.empty

  override def findBy(name: UserName): Either[repositories.Error, Option[User]] = Right(userByName.get(name))

  override def save(name: UserName, hashedPassword: HashedPassword): Either[repositories.Error, User] = {
    val user = User(UserId(generateId()), name, hashedPassword)
    userByName = userByName + (name -> user)
    Right(user)
  }

  private def generateId(): Int = idCounter.incrementAndGet()
}
