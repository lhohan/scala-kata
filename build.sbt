
organization := "eu.lhoest"

name := "scala-kata"

version := "0.1-SNAPSHOT"

def KataProject(name: String): Project = (
  Project(name, file(name))
  settings(
    libraryDependencies ++= Seq(
      "org.scalatest" % "scalatest_2.10" % "2.0" % "test",
      "org.scalacheck" %% "scalacheck" % "1.10.1"
    )
  )
 )

lazy val kata01 = KataProject("kata01")

lazy val kata02 = KataProject("kata02")


