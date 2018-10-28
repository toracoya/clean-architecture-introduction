name := "example"
organization := "com.toracoya"

scalaVersion in ThisBuild := "2.12.7"
scalacOptions in ThisBuild ++= Seq(
  "-language:_",
  "-Ypartial-unification",
  "-Xfatal-warnings",
  "-deprecation"
)

libraryDependencies ++= Seq(
)
